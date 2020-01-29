package javaimplant.junitTest;

public class MessageUtil {

	String msg;
	
	public MessageUtil(String message) {
		this.msg=message;
	}

	public String printMessage() {
		// TODO Auto-generated method stub
		System.out.println(msg);
		return msg;
	}

	public String salutationMessage() {
		// TODO Auto-generated method stub
		msg = "Hi!" + msg;
	    System.out.println(msg);
		return "Hi!" + msg;
	}
	
	// prints the message
   public void printArthametic(){
	      System.out.println("Arthematic "+msg);
	      int a = 0;
	      int b = 1/a;
	   }   
	
	
}
