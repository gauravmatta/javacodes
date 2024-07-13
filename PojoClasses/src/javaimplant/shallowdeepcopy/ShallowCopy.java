package javaimplant.shallowdeepcopy;

public class ShallowCopy {

	public static void main(String[] args) {
		System.out.println("Creating object using Prototype design");
		NetworkConnection connection = new NetworkConnection();
		connection.setIp("192.168.4.4");
		connection.setImportantData("Important Data of Network 1");
		try {
			NetworkConnection connection2 = (NetworkConnection) connection.clone();
			NetworkConnection connection3 = (NetworkConnection) connection.clone();
			System.out.println(connection);
			connection.getDomains().remove(0);
			System.out.println(connection);
			System.out.println(connection2);
			System.out.println(connection3);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
