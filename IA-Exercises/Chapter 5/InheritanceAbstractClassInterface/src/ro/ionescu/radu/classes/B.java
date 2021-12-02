package ro.ionescu.radu.classes;

public class B extends A
{
	public void f()
	{
		a++;    // public    / accessible
		// b++; // private   / not accessible
		c++;    // protected / accessible
		d++;    // default   / accessible
	}
}