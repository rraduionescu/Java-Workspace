package ro.ionescu.radu.q14;

class A {}

class B extends A {}

class C extends B {}

class Main
{
	public static void main(String[] args)
	{
		B b = new B();

		System.out.println(b instanceof B);
		System.out.println((b instanceof B) && (b instanceof C));
		System.out.println((b instanceof B) && (b instanceof A));
		System.out.println((b instanceof A) || (b instanceof C));
	}
}