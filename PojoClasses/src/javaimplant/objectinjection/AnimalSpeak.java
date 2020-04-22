package javaimplant.objectinjection;

public class AnimalSpeak {
	
	// 	Tight Coupling
	// Check Animal Behaviour How we have achieved loose coupling for this class
	public static void main(String args[])
	{
		Animal dog=new Dog();
		makeAnimalSpeak(dog);
	}
	
	private Animal animal;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public static void makeAnimalSpeak(Animal animal)
	{
		animal.speak();
	}
	
	
	public void makeAnimalSpeak()
	{
		this.animal.speak();
	}
}
