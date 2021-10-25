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
	public static void main(String [] args) throws TikaException, IOException, SAXException
	{
		ArrayList<String>  stringProducts = ParserBFK.getInvoiceProductsStrings("example.pdf");
		ArrayList<Product> products       = ParserBFK.getProducts(stringProducts);

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
}