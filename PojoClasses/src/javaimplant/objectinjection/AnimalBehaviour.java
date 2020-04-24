package javaimplant.objectinjection;

public class AnimalBehaviour 
{
	public static void main(String args[])
	{
		// 	Tight Coupling
		Animal tightdog=new Dog();
		makeAnimalSpeak(tightdog);
		
		//	 Loose Coupling
		AnimalSpeak as=new AnimalSpeak();
		Animal looseDog=new Dog();
		as.setAnimal(looseDog);
		as.makeAnimalSpeak();
	}
	
	public static void makeAnimalSpeak(Animal animal)
	{
		animal.speak();
	}
}
