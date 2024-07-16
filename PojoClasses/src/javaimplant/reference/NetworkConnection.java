package javaimplant.reference;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable {
	String ip;
	String importantData;
	private List<String> domains = new ArrayList<>();
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getImportantData() {
		return importantData;
	}
	
	public void setImportantData(String importantData) {
		this.importantData = importantData;
		domains.add("springimplant.blogspot.com");
		domains.add("javaimplant.blogspot.com");
		domains.add("seimplant.blogspot.com");
		domains.add("cloudimplant.blogspot.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		NetworkConnection networkConnection = new NetworkConnection();
		networkConnection.setIp(this.getIp());
		networkConnection.setImportantData(this.getImportantData());
		for(String d:this.getDomains()) {
			networkConnection.getDomains().add(d);
		}		
		return networkConnection;
	}

	@Override
	public String toString() {
		return this.ip+" : "+this.importantData+":"+this.domains;
	}

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}
}
