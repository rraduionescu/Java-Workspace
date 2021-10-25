package ro.ionescu.radu.q13;

interface Syrupable
{
	void getSugary();
}

abstract class Pancake implements Syrupable
{

}

class BlueBerryPancake extends Pancake // extends was implements
{
	public void getSugary()
	{
		;
	}
}

class SourdoughBlueBerryPancake extends BlueBerryPancake
{
	void getSugary(int s)
	{
		;
	}
}