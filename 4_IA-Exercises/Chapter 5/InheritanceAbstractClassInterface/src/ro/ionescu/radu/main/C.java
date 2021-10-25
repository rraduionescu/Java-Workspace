package ro.ionescu.radu.main;

import ro.ionescu.radu.classes.A;

public class C extends A
{
	public void f()
	{
		a++ ;   // public    / accessible
		// b++; // private   / not accessible
		c++;    // protected / accessible
		// d++; // default   / not accessible
	}
}
