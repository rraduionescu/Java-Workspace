package ionescu.radu.classes;

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

	public Product(String brand, String color, String size, String SKU, String composition, String name, String collection, String origin, String price, String quantity)
	{
		this.brand       = brand;
		this.color       = color;
		this.size        = size;
		this.SKU         = SKU;
		this.composition = composition;
		this.name        = name;
		this.collection  = collection;
		this.origin      = origin;
		this.price       = price;
		this.quantity    = quantity;
	}

	public Product()
	{
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
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

	public String getCollection()
	{
		return collection;
	}

	public void setCollection(String collection)
	{
		this.collection = collection;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getPriceRON()
	{
		return priceRON;
	}

	public void setPriceRON(String priceRON)
	{
		this.priceRON = priceRON;
	}

	public String getColorCode()
	{
		return colorCode;
	}

	public void setColorCode(String colorCode)
	{
		this.colorCode = colorCode;
	}

	public String getPriceTotal()
	{
		return priceTotal;
	}

	public void setPriceTotal(String priceTotal)
	{
		this.priceTotal = priceTotal;
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