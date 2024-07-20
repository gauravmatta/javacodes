package javaimplant.equalshashcode;

public class Laptop {
	String model;
	int price;
	
	public String toString() {
		return model+":"+price;
	}
	
	public boolean equals(Laptop object) {
		return (this.model.equals(object.model) && this.price==object.price);
	}
}
