package ionescu.radu.exercise;

import java.util.Date;

public class Computer extends Electronics
{
	private Mouse mouse;

	public Computer(Cpu cpu, RamMemory ramMemory, String manufacturer, float price, Date manufacturingDate, Mouse mouse)
	{
		super(cpu, ramMemory, manufacturer, price, manufacturingDate);
		this.mouse = mouse;
	}

	public Mouse getMouse()
	{
		return mouse;
	}

	public void setMouse(Mouse mouse)
	{
		this.mouse = mouse;
	}
}
