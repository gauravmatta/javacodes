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
		return "Hi!" + msg;
	}
}
