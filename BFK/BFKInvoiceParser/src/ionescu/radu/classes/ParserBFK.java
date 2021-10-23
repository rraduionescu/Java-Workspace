package ionescu.radu.classes;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserBFK
{
	public static ArrayList<String> getInvoiceProductsStrings(String invoiceFile) throws IOException, TikaException, SAXException
	{
		// EXTRACT PDF TEXT
		BodyContentHandler contentHandler  = new BodyContentHandler();
		File               file            = new File(invoiceFile);
		FileInputStream    fileInputStream = new FileInputStream(file);
		Metadata           metadata        = new Metadata();
		ParseContext       parseContext    = new ParseContext();
		PDFParser          pdfParser       = new PDFParser();
		pdfParser.parse(fileInputStream, contentHandler, metadata, parseContext);
		String pdfText = contentHandler.toString();

		// EXTRACT PRODUCTS TEXT
		ArrayList<String> products = new ArrayList<>();
		products.addAll(parseProducts(pdfText, "J"));
		products.addAll(parseProducts(pdfText, "D"));
		products.addAll(parseProducts(pdfText, "Z"));

		return products;
	}

	private static ArrayList<String> parseProducts(String file, String brand)
	{
		ArrayList<String> products = new ArrayList<>();
		Pattern           pattern  = Pattern.compile(brand + "[0-9]{2}[0-9A-Z][0-9]{2}");
		Matcher           match    = pattern.matcher(file);

		if(match.find())
		{
			int start = match.start();
			while(match.find())
			{
				int     end          = 0;
				Pattern innerPattern = Pattern.compile("[0-9]{2},[0-9]{2}");
				Matcher innerMatcher = innerPattern.matcher(file.substring(start, match.start()));
				while(innerMatcher.find())
				{
					end = innerMatcher.end();
				}
				products.add(file.substring(start, start + end));
				start = match.start();
			}
			Pattern innerPattern = Pattern.compile("\nBOSS\n|\nDKNY\n|\nKARL LAGERFELD KIDS\n|\nDKNY");
			Matcher innerMatcher = innerPattern.matcher(file.substring(start));
			if(innerMatcher.find())
			{
				products.add(file.substring(start, start + innerMatcher.start() - 1));
			}

			removeUnnecessary(products);
		}

		return products;
	}

	private static void removeUnnecessary(ArrayList<String> products)
	{
		for(int i = 0 ; i < products.size() ; i++)
		{
			Pattern pattern = Pattern.compile("\n[0-9]{1,2}\n");
			Matcher matcher = pattern.matcher(products.get(i));

			if(matcher.find())
			{
				Pattern otherP = Pattern.compile("\n[A-Z0-9]{3}");
				Matcher otherM = otherP.matcher(products.get(i).substring(matcher.start()));
				if(otherM.find())
				{
					String result = products.get(i).substring(0, matcher.start() - 2) + products.get(i).substring(otherM.start() + matcher.start() + 1);
					products.set(i, result);
				}
			}

			pattern = Pattern.compile("\n\n");
			matcher = pattern.matcher(products.get(i));

			while(matcher.find())
			{
				String result = products.get(i).substring(0, matcher.start()) + products.get(i).substring(matcher.end() - 1);
				products.set(i, result);
				matcher = pattern.matcher(products.get(i));
			}

			pattern = Pattern.compile("[0-9]{2},[0-9]{2}");
			matcher = pattern.matcher(products.get(i));
			int end = 0;
			while(matcher.find())
			{
				end = matcher.end();
			}
			products.set(i, products.get(i).substring(0, end));
		}
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static ArrayList<Product> getProducts(ArrayList<String> stringProducts)
	{
		ArrayList<Product> products = new ArrayList<>();
		String             brand;
		String             SKU;
		String             composition;
		String             name;
		String             color;
		String             colorCode;
		String             size;
		String             collection;
		String             origin;
		String             price;
		String             priceRON;
		String             priceTotal;
		String             quantity;

		String variations;

		for(String productString : stringProducts)
		{
			//BRAND
			switch(productString.charAt(0))
			{
				case 'J':
					brand = "BOSS";
					break;
				case 'D':
					brand = "DKNY";
					break;
				case 'Z':
					brand = "KARL LAGERFELD KIDS";
					break;
				default:
					brand = "UNKNOWN";
					break;
			}

			//SKU
			SKU = productString.substring(0, 6);

			//COMPOSITION
			Pattern pattern = Pattern.compile("[0-9]{1,3}%");
			Matcher matcher = pattern.matcher(productString);
			matcher.find();
			int start = matcher.start();
			pattern = Pattern.compile("\n");
			matcher = pattern.matcher(productString);
			matcher.find();
			int end = matcher.start();
			composition = productString.substring(start, end);
			composition = composition.trim().replaceAll(" +", " ");
			composition = composition.replaceAll("PL LINING", "captuseala poliester");
			composition = composition.replaceAll("CO LINING", "captuseala bumbac");
			composition = composition.replaceAll("CO TRIMMING", "accesorii bumbac");
			composition = composition.replaceAll("CO", "bumbac");
			composition = composition.replaceAll("PA", "poliamida");
			composition = composition.replaceAll("PL", "poliester");
			composition = composition.replaceAll("EA", "elastan");

			//NAME
			name = productString.substring(7, start - 1);

			//COLLECTIONS
			variations = productString.substring(end + 1);
			variations = variations.replaceAll(" +", " ");
			ArrayList<String> collections = new ArrayList<>();
			pattern = Pattern.compile("[0-9]{1,3},[0-9]{2} [0-9]{1,3},[0-9]{2}");
			matcher = pattern.matcher(variations);
			while(matcher.find())
			{
				collections.add(variations.substring(0, matcher.end()));
				if(variations.length() == matcher.end())
				{
					variations = variations.substring(matcher.end());
				}
				else
				{
					variations = variations.substring(matcher.end() + 1);
				}
				matcher = pattern.matcher(variations);
			}
			for(int i = 0 ; i < collections.size() ; i++)
			{
				if(i < collections.size() - 1 && !collections.get(i + 1).contains("\n"))
				{
					collections.set(i, collections.get(i) + "\n" + collections.get(i + 1));
					collections.remove(i + 1);
				}
			}

			//ORIGIN
			pattern = Pattern.compile("[0-9]{8} ");
			matcher = pattern.matcher(collections.get(0));
			matcher.find();
			start   = matcher.end();
			pattern = Pattern.compile("\n");
			matcher = pattern.matcher(collections.get(0));
			matcher.find();
			end    = matcher.start();
			origin = collections.get(0).substring(start, end);

			//VARIATIONS
			for(String sizes : collections)
			{
				pattern = Pattern.compile("[0-9]{8} ");
				matcher = pattern.matcher(sizes);
				matcher.find();
				start   = matcher.start();
				pattern = Pattern.compile(" UNQ | [0-9]{1,2}M | [0-9]{1,2}Y | [0-9]{2} ");
				matcher = pattern.matcher(sizes.substring(0, start));
				matcher.find();
				collection = sizes.substring(0, matcher.start() - 1);
				String[] sizesArray = sizes.substring(matcher.start(), start).trim().split(" ");
				for(int i = 0 ; i < sizesArray.length ; i++)
				{
					String[] rows = sizes.split("\n");
					for(int j = 1 ; j < rows.length ; j++)
					{
						pattern = Pattern.compile("[0-9]{1,3},[0-9]{2}");
						matcher = pattern.matcher(rows[j]);
						matcher.find();
						price = matcher.group();
						end   = matcher.start() - 1;
						String[] attributes = rows[j].split(" ");
						colorCode = attributes[0];
						size      = sizesArray[i];
						pattern   = Pattern.compile(" [0-9] ");
						matcher   = pattern.matcher(rows[j]);
						matcher.find();
						color = rows[j].substring(4, matcher.start());
						String[] quantities = rows[j].substring(matcher.start(), end).trim().split(" ");
						quantity   = quantities[i];
						price      = price.replace(",", ".");
						priceRON   = String.valueOf((int)(Float.parseFloat(price) * 14));
						priceTotal = String.valueOf(Float.parseFloat(price) * Integer.parseInt(quantity));

						Product product = new Product(brand, SKU, composition, name, origin, size, color, colorCode, price, priceRON, priceTotal, collection, quantity);

						products.add(product);
					}
				}
			}
		}
		return products;
	}
}