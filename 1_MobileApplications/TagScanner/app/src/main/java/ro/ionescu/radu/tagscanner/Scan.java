package ro.ionescu.radu.tagscanner;

import androidx.annotation.NonNull;

public class Scan
{
	private String barCode;
	private String SKU;
	private String colorCode;
	private String size;

	public void setBarCode(String barCode)
	{
		this.barCode = barCode;
	}

	public String getSKU()
	{
		return SKU;
	}

	public void setSKU(String SKU)
	{
		this.SKU = SKU;
	}

	public String getColorCode()
	{
		return colorCode;
	}

	public void setColorCode(String colorCode)
	{
		this.colorCode = colorCode;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	@NonNull
	@Override
	public String toString()
	{
		return " SK=" + SKU +
				" CC=" + colorCode +
				" SZ=" + size +
				"\nBC=" + barCode;
	}
}