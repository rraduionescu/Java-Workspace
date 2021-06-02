//package ro.ionescu.radu;
//
//import java.util.concurrent.Callable;
//
//interface Reptile {
//	ReptileEgg lay();
//}
//
//class FireDragon implements Reptile {
//	public FireDragon() {
//	}
//
//	public ReptileEgg lay()
//	{
//		return new ReptileEgg();
//	}
//
//	public static void main(String[] args) throws Exception {
//		FireDragon fireDragon = new FireDragon();
//		System.out.println(fireDragon instanceof Reptile);
//	}
//}
//
//class ReptileEgg {
//	public ReptileEgg(Callable<Reptile> createReptile)
//	{
//		throw new UnsupportedOperationException("Waiting to be implemented.");
//	}
//
//	public Reptile hatch() throws Exception
//	{
//		throw new UnsupportedOperationException("Waiting to be implemented.");
//	}
//}