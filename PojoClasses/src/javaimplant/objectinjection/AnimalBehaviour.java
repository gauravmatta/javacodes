package javaimplant.objectinjection;

public class AnimalBehaviour 
{
	public static void main(String args[])
	{
		AnimalSpeak as=new AnimalSpeak();
		Animal dog=new Dog();
		as.setAnimal(dog);
		as.makeAnimalSpeak();
	}
}
