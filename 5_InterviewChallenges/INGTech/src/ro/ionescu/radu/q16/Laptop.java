package ro.ionescu.radu.q16;

import java.util.Date;

public class Laptop extends Computer
{
	private Screen screen;

	public Laptop(Cpu cpu, RamMemory ramMemory, String manufacturer, float price, Date manufacturingDate, Mouse mouse, Screen screen)
	{
		super(cpu, ramMemory, manufacturer, price, manufacturingDate, mouse);
		this.screen = screen;
	}

	public Screen getScreen()
	{
		return screen;
	}

	public void setScreen(Screen screen)
	{
		this.screen = screen;
	}

	@Override
	public String toString()
	{
		return "Laptop{" +
				"screen=" + screen +
				"cpu manufacturer=" + getCpu().getManufacturer() +
				'}';
	}
}
