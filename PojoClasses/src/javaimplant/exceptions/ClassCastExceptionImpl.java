package javaimplant.exceptions;

interface Animal {}
class Dog implements Animal{}
class Cat implements Animal{}
public class ClassCastExceptionImpl {
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		Cat morphedCat = (Cat) dog;
		System.out.println("Tried creating Morphed Cat");
	}
}