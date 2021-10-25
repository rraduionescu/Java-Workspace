package ro.ionescu.radu.q16;

public class Screen
{
	private String resolution;

	public Screen(String resolution)
	{
		this.resolution = resolution;
	}

	public String getResolution()
	{
		return resolution;
	}

	public void setResolution(String resolution)
	{
		this.resolution = resolution;
	}

	@Override
	public String toString()
	{
		return "Screen{" +
				"resolution='" + resolution + '\'' +
				'}';
	}
}
