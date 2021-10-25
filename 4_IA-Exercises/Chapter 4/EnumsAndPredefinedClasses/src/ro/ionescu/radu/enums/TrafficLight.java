package ro.ionescu.radu.enums;

public enum TrafficLight
{
	RED("STOP!"),

	YELLOW("WAIT!"),

	GREEN("GO!");

	private final String description;

	TrafficLight(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}
}
