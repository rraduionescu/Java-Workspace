package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.StaticTest;
import ro.ionescu.radu.enums.TrafficLight;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main
{
	public static void main(String[] args)
	{
		// Static attribute
		StaticTest[] statics = new StaticTest[10];
		System.out.println(StaticTest.count + " StaticTest instances exist!");
		for(int i = 0 ; i < statics.length ; i++)
		{
			statics[i] = new StaticTest();
		}
		System.out.println(StaticTest.count + " StaticTest instances exist!");
		System.out.println("Instance access: " + statics[3].count + " instances " + " " + statics[7].count + " instances ");

		// Enum
		TrafficLight trafficLight = TrafficLight.RED;
		System.out.println("Traffic light says: " + trafficLight.getDescription());
		System.out.print("Switch lights: ");
		switch(trafficLight)
		{
			case RED:
				System.out.println("You can't go!");
				break;
			case YELLOW:
				System.out.println("You have to wait!");
				break;
			case GREEN:
				System.out.println("You can go!");
		}
		System.out.println("Enum values: " + Arrays.toString(TrafficLight.values()));
		System.out.println("Value of: " + TrafficLight.valueOf("YELLOW"));
		System.out.println("Name: " + trafficLight.name());
		System.out.println("Ordinal: " + trafficLight.ordinal());

		// Predefined classes
		// Wrapper classes
		Integer intWrapper = new Integer(3920);
		Integer integer    = 12532;
		System.out.println("Integer: " + intWrapper);
		System.out.println("Integer: " + integer);
		System.out.println("int: " + intWrapper.intValue());
		System.out.println("float: " + intWrapper.floatValue());
		System.out.println("String: " + intWrapper.toString());
		System.out.println("int: " + String.valueOf(intWrapper.intValue()));
		System.out.println("int: " + Integer.parseInt(intWrapper.toString()));
		// Math class
		System.out.println("Pi number: " + Math.PI);
		System.out.println("Euler number: " + Math.E);
		System.out.println("Absolute: " + Math.abs(-42941));
		System.out.println("Max: " + Math.max(4321, 5235));
		System.out.println("Min: " + Math.min(3490, 2492));
		System.out.println("Power: " + Math.pow(2, 15));
		System.out.println("Random: " + Math.random());
		System.out.println("Square root of 148: " + Math.sqrt(148));
		// GregorianCalendar SimpleDateFormat class
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println("Today's year: " + calendar.get(GregorianCalendar.YEAR));
		System.out.println("Today's month: " + calendar.get(GregorianCalendar.MONTH));
		System.out.println("Today's day: " + calendar.get(GregorianCalendar.DAY_OF_MONTH));
		System.out.println("Today's hour: " + calendar.get(GregorianCalendar.HOUR_OF_DAY));
		System.out.println("Today's minute: " + calendar.get(GregorianCalendar.MINUTE));
		System.out.println("Today's second: " + calendar.get(GregorianCalendar.SECOND));
		System.out.println("Today's millisecond: " + calendar.get(GregorianCalendar.MILLISECOND));
		System.out.println("Today's day of year: " + calendar.get(GregorianCalendar.DAY_OF_YEAR));
		System.out.println("Today's day of week: " + calendar.get(GregorianCalendar.DAY_OF_WEEK));
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-5"));
		System.out.println("Today's time in New York: " + calendar.get(GregorianCalendar.HOUR_OF_DAY));
		System.out.println("Today's time in New York: " + calendar.get(GregorianCalendar.MINUTE));
		System.out.println("Today's time in New York: " + calendar.get(GregorianCalendar.SECOND));
		System.out.println("Today's time in New York: " + calendar.get(GregorianCalendar.HOUR_OF_DAY));
		SimpleDateFormat format = new SimpleDateFormat("EEEE dd.MMM.yyyy hh:mm:ss:SSS a");
		Date             date   = new Date();
		System.out.println("Today : " + format.format(date));
	}
}