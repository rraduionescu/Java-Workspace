package ionescu.radu.classes;

@SuppressWarnings("unused")
public class Product
{
	private String brand;
	private String SKU;
	private String composition;
	private String name;
	private String origin;
	private String size;
	private String color;
	private String colorCode;
	private String price;
	private String priceRON;
	private String priceTotal;
	private String collection;
	private String quantity;

	public Product(String brand, String SKU, String composition, String name, String origin, String size, String color, String colorCode, String price, String priceRON, String priceTotal, String collection, String quantity)
	{
		this.brand       = brand;
		this.SKU         = SKU;
		this.composition = composition;
		this.name        = name;
		this.origin      = origin;
		this.size        = size;
		this.color       = color;
		this.colorCode   = colorCode;
		this.price       = price;
		this.priceRON    = priceRON;
		this.priceTotal  = priceTotal;
		this.collection  = collection;
		this.quantity    = quantity;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getSKU()
	{
		return SKU;
	}

	public void setSKU(String SKU)
	{
		this.SKU = SKU;
	}

	public String getComposition()
	{
		return composition;
	}

	public void setComposition(String composition)
	{
		this.composition = composition;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getColorCode()
	{
		return colorCode;
	}

	public void setColorCode(String colorCode)
	{
		this.colorCode = colorCode;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPriceRON()
	{
		return priceRON;
	}

	public void setPriceRON(String priceRON)
	{
		this.priceRON = priceRON;
	}

	public String getPriceTotal()
	{
		return priceTotal;
	}

	public void setPriceTotal(String priceTotal)
	{
		this.priceTotal = priceTotal;
	}

	public String getCollection()
	{
		return collection;
	}

	public void setCollection(String collection)
	{
		this.collection = collection;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public String toString()
	{
		return "BR-" + brand +
				" | SK-" + SKU +
				" | NM-" + name +
				" | CR-" + color +
				" | CC-" + colorCode +
				" | SZ-" + size +
				" | QT-" + quantity +
				" | PC-" + price +
				" | PR-" + priceRON +
				" | PT-" + priceTotal +
				" | CP-" + composition +
				" | CL-" + collection +
				" | OG-" + origin;
	}
}