package ionescu.radu.exercise;

import java.util.Date;

public class Electronics
{
	private Cpu cpu;
	private RamMemory ramMemory;
	private String manufacturer;
	private float price;
	private Date manufacturingDate;

	public Electronics(Cpu cpu, RamMemory ramMemory, String manufacturer, float price, Date manufacturingDate)
	{
		this.cpu               = cpu;
		this.ramMemory         = ramMemory;
		this.manufacturer      = manufacturer;
		this.price             = price;
		this.manufacturingDate = manufacturingDate;
	}

	public Cpu getCpu()
	{
		return cpu;
	}

	public void setCpu(Cpu cpu)
	{
		this.cpu = cpu;
	}

	public RamMemory getRamMemory()
	{
		return ramMemory;
	}

	public void setRamMemory(RamMemory ramMemory)
	{
		this.ramMemory = ramMemory;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public Date getManufacturingDate()
	{
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate)
	{
		this.manufacturingDate = manufacturingDate;
	}

	@Override
	public String toString()
	{
		return "Electronics{" +
				"cpu=" + cpu +
				", ramMemory=" + ramMemory +
				", manufacturer='" + manufacturer + '\'' +
				", price=" + price +
				", manufacturingDate=" + manufacturingDate +
				'}';
	}
}
