package java8.hashing;

public class HashNode {
	public Integer key;
	public String value;
	public HashNode next;
	
	public HashNode(Integer key,String value) {
		this.key=key;
		this.value=value;
	}
}
