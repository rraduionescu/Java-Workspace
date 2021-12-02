// @author Ionescu Radu
// @date 28.11.2021
package com.ionescu.radu.firsteeapp.model.classes;

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

	private String _1;
	private String _2;
	private String _3;
	private String _4;
	private String _5;
	private String _6;
	private String _7;
	private String _8;
	private String _9;
	private String _10;
	private String _11;
	private String _12;
	private String _13;
	private String _14;
	private String _15;
	private String _16;
	private String _17;
	private String _18;
	private String _19;

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

	public String get_1()
	{
		return _1;
	}

	public void set_1(String _1)
	{
		this._1 = _1;
	}

	public String get_2()
	{
		return _2;
	}

	public void set_2(String _2)
	{
		this._2 = _2;
	}

	public String get_3()
	{
		return _3;
	}

	public void set_3(String _3)
	{
		this._3 = _3;
	}

	public String get_4()
	{
		return _4;
	}

	public void set_4(String _4)
	{
		this._4 = _4;
	}

	public String get_5()
	{
		return _5;
	}

	public void set_5(String _5)
	{
		this._5 = _5;
	}

	public String get_6()
	{
		return _6;
	}

	public void set_6(String _6)
	{
		this._6 = _6;
	}

	public String get_7()
	{
		return _7;
	}

	public void set_7(String _7)
	{
		this._7 = _7;
	}

	public String get_8()
	{
		return _8;
	}

	public void set_8(String _8)
	{
		this._8 = _8;
	}

	public String get_9()
	{
		return _9;
	}

	public void set_9(String _9)
	{
		this._9 = _9;
	}

	public String get_10()
	{
		return _10;
	}

	public void set_10(String _10)
	{
		this._10 = _10;
	}

	public String get_11()
	{
		return _11;
	}

	public void set_11(String _11)
	{
		this._11 = _11;
	}

	public String get_12()
	{
		return _12;
	}

	public void set_12(String _12)
	{
		this._12 = _12;
	}

	public String get_13()
	{
		return _13;
	}

	public void set_13(String _13)
	{
		this._13 = _13;
	}

	public String get_14()
	{
		return _14;
	}

	public void set_14(String _14)
	{
		this._14 = _14;
	}

	public String get_15()
	{
		return _15;
	}

	public void set_15(String _15)
	{
		this._15 = _15;
	}

	public String get_16()
	{
		return _16;
	}

	public void set_16(String _16)
	{
		this._16 = _16;
	}

	public String get_17()
	{
		return _17;
	}

	public void set_17(String _17)
	{
		this._17 = _17;
	}

	public String get_18()
	{
		return _18;
	}

	public void set_18(String _18)
	{
		this._18 = _18;
	}

	public String get_19()
	{
		return _19;
	}

	public void set_19(String _19)
	{
		this._19 = _19;
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