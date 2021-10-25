package ionescu.radu.main;

import com.bethecoder.ascii_table.ASCIITable;
import ionescu.radu.classes.ParserBFK;
import ionescu.radu.classes.Product;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	static String str;

	public Main()
	{
	}

	public static void main(String [] args) throws TikaException, IOException, SAXException
	{
		try
		{
			throw new RuntimeException();
		}
		catch(Exception e)
		{
			System.out.println("B");
		}
		finally
		{
			System.out.println("C");
		}
		System.out.println("D");

		int m = 3 & 5;
		int n = 3 | 5;
		System.out.println(m);
		System.out.println(n);

System.err.print("exception");
System.err.println("finally");
		ArrayList<String>  stringProducts = ParserBFK.getInvoiceProductsStrings("example.pdf");
		ArrayList<Product> products       = ParserBFK.getProducts(stringProducts);
		boolean a = false;
		System.out.println(str);
		if(a=true)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		Float f1 = new Float("3.0");
		int x = f1.intValue();
		byte b = f1.byteValue();
		double d = f1.doubleValue();
		System.out.println(x + b + d);

		String f = "first";
		String s = "second";
		String t = "third";
		String fo = "fourth";
		System.out.println(f==s);
		System.out.println(t==fo);
		System.out.println(f==fo);

		try
		{
			System.out.println(doStuff(args));
		}
		catch(Exception e)
		{
			System.out.println("exc");
			doStuff(args);
		}

		String[]   tableHeaders = {"Brand", "SKU", "Name", "Color", "Size", "Quantity", "Price", "RON Price", "Total Price", "Color Code", "Composition", "Collection", "Origin"};
		String[][] tableContent = new String[products.size()][13];
		for(int i = 0 ; i < products.size() ; i++)
		{
			tableContent[i] = new String[]{products.get(i).getBrand(), products.get(i).getSKU(), products.get(i).getName(), products.get(i).getColor(), products.get(i).getSize(), products.get(i).getQuantity(), products.get(i).getPrice(), products.get(i).getPriceRON(), products.get(i).getPriceTotal(), products.get(i).getColorCode(), products.get(i).getComposition(), products.get(i).getCollection(), products.get(i).getOrigin()};
		}
		ASCIITable.getInstance().printTable(tableHeaders, tableContent);

		int totalQuantity = 0;
		for(Product product : products)
		{
			totalQuantity += Integer.parseInt(product.getQuantity());
		}
		System.out.println("Total products quantity: " + totalQuantity);
	}
	static int doStuff(String[] args)
	{
		return Integer.parseInt(args[0]);
	}
}