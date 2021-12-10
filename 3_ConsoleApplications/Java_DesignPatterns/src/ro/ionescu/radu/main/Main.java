package ro.ionescu.radu.main;

import ro.ionescu.radu.aminals.SingletonClass;

public class Main
{
	public static void main(String[] args)
	{
		SingletonClass singleton = SingletonClass.getInstance();
		System.out.println(singleton.add(5, 9));
	}
}