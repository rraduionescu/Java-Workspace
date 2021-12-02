package ro.ionescu.radu.classes;

import ro.ionescu.radu.interfaces.Breakable;
import ro.ionescu.radu.interfaces.Breaker;

public class Ou implements Breakable
{
	@Override
	public void brakeWith(Breaker b)
	{
		b.breakIt();
	}
}
