package ionescu.radu.exercise;

import java.util.Date;

public class Phone extends Electronics
{
	Screen screen;

	public Phone(Cpu cpu, RamMemory ramMemory, String manufacturer, float price, Date manufacturingDate, Screen screen)
	{
		super(cpu, ramMemory, manufacturer, price, manufacturingDate);
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
}
