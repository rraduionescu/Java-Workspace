package ionescu.radu.exercise;

public class Cpu
{
	private String manufacturer;
	private long frequency;
	private int numberOfCores;

	public Cpu(String manufacturer, long frequency, int numberOfCores)
	{
		this.manufacturer  = manufacturer;
		this.frequency     = frequency;
		this.numberOfCores = numberOfCores;
	}

	public long getFrequency()
	{
		return frequency;
	}

	public void setFrequency(long frequency)
	{
		this.frequency = frequency;
	}

	public int getNumberOfCores()
	{
		return numberOfCores;
	}

	public void setNumberOfCores(int numberOfCores)
	{
		this.numberOfCores = numberOfCores;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString()
	{
		return "Cpu{" +
				"frequency=" + frequency +
				", numberOfCores=" + numberOfCores +
				'}';
	}
}
