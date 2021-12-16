package ro.ionescu.radu.q16;

public class RamMemory
{
	private long frequency;
	private long capacity;

	public RamMemory(long frequency, long capacity)
	{
		this.frequency = frequency;
		this.capacity  = capacity;
	}

	public long getFrequency()
	{
		return frequency;
	}

	public void setFrequency(long frequency)
	{
		this.frequency = frequency;
	}

	public long getCapacity()
	{
		return capacity;
	}

	public void setCapacity(long capacity)
	{
		this.capacity = capacity;
	}

	@Override
	public String toString()
	{
		return "RamMemory{" +
				"frequency=" + frequency +
				", capacity=" + capacity +
				'}';
	}
}
