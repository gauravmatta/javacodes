package java8.lambda;

public class GameImpl {

	public static void main(String[] args) {
		Game football = new Game() {
			@Override
			public void play() {
				System.out.println("Play Football");
			}
		};
		
		Game cricket = new Game() {	
			@Override
			public void play() {
				System.out.println("Play Football");
			}
		};
		
		Game lambdaFootball = () ->System.out.println("Playing Football");

	}

}
