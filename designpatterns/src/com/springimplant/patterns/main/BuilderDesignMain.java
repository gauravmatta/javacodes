package com.springimplant.patterns.main;

import com.springimplant.patterns.builderdesign.Computer;

public class BuilderDesignMain {

	public static void main(String[] args) {
		Computer comp = new Computer.ComputerBuilder()
				.setHDD("1TB")
				.setRam("8GB")
				.setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();
		
		System.out.println(comp.toString());

	}

}
