package com.javaimplant.readwritelock;

public class Items {
	private String name;
	private int value;
	public Items(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Items [name=" + name + ", value=" + value + "]";
	}
	
	
	
}
