package ionescu.radu.exercise;

import java.util.ArrayList;
import java.util.Date;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Electronics> electronics = new ArrayList<>();
		electronics.add(new Electronics(new Cpu("INTEL", 24000000000000L, 8), new RamMemory(21000000000000L, 12000000000L), "ASUS", 3362.53f, new Date()));
		electronics.add(new Phone(new Cpu("INTEL", 270000000000L, 16), new RamMemory(240000000000L, 32000000000L), "APPLE", 8328.83f, new Date(), new Screen("FULLHD")));
		electronics.add(new Computer(new Cpu("INTEL", 470000000000L, 10), new RamMemory(2700000000000L, 5000000000000L), "TOSHIBA", 3729.82f, new Date(), new Mouse(150000)));
		electronics.add(new Electronics(new Cpu("INTEL", 24000000000000L, 8), new RamMemory(21000000000000L, 12000000000L), "MOTOROLA", 3452.53f, new Date()));
		electronics.add(new Phone(new Cpu("INTEL", 270000000000L, 16), new RamMemory(240000000000L, 32000000000L), "SAMSUNG", 7427.83f, new Date(), new Screen("FULLHD")));
		electronics.add(new Computer(new Cpu("INTEL", 470000000000L, 10), new RamMemory(2700000000000L, 5000000000000L), "ASUS", 4724.82f, new Date(), new Mouse(150000)));

		long totalPrice = 0;
		for(Electronics electronic : electronics)
		{
			totalPrice += electronic.getPrice();
			if(electronic.getManufacturer() == "ASUS" && electronic.getManufacturingDate().compareTo(new Date()) < 0)
			{
				System.out.println(electronic);
			}
		}
		System.out.println("Total price: " + totalPrice +"$");

		ArrayList<Laptop> laptops = new ArrayList<>();
		laptops.add(new Laptop(new Cpu("INTEL", 24000000000000L, 8), new RamMemory(21000000000000L, 12000000000L), "ASUS", 3362.53f, new Date(), new Mouse(14000), new Screen("FULLHD")));
		laptops.add(new Laptop(new Cpu("INTEL", 24000000000000L, 8), new RamMemory(21000000000000L, 12000000000L), "ASUS", 3362.53f, new Date(), new Mouse(14000), new Screen("4K")));
		laptops.add(new Laptop(new Cpu("AMD", 24000000000000L, 8), new RamMemory(21000000000000L, 12000000000L), "ASUS", 3362.53f, new Date(), new Mouse(14000), new Screen("8K")));

		for(Laptop laptop : laptops)
		{
			if(laptop.getScreen().getResolution() == "FULLHD" && laptop.getCpu().getManufacturer() == "INTEL")
			{
				System.out.println(laptop);
			}
		}
	}
}
