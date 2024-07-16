package javaimplant.exceptions;

interface Animals {}
class Elephant implements Animals{}
class Cat implements Animals{}
public class ClassCastExceptionImpl {
	public static void main(String[] args) {
		Animals elephant = new Elephant();
		Animals cat = new Cat();
		Cat morphedCat = (Cat) elephant;
		System.out.println("Tried creating Morphed Cat");
	}
}