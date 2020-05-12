package javaimplant.inheritance;

public class CheckAnimal {

	public static void main(String[] args) {
		Dog dog1=new Dog();
		dog1.setVoice("Woof Woof");
		dog1.setLegs(4);
		dog1.giveSound();
		dog1.giveLegCount();
	}

}
