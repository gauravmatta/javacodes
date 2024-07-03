package com.springimplant.patterns.builderdesign;

public class Computer {

	//required parameters
	private String HDD;
	private String RAM;
		
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
		
	//Builder Class
	public static class ComputerBuilder{
			private String HDD;
			private String RAM;
			private boolean isGraphicsCardEnabled;
			private boolean isBluetoothEnabled;
			
			public ComputerBuilder setRam(String ram){
				this.RAM=ram;
				return this;
			}
			
			public ComputerBuilder setHDD(String hdd){
				this.HDD=hdd;
				return this;
			}

			public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
				this.isGraphicsCardEnabled = isGraphicsCardEnabled;
				return this;
			}

			public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
				this.isBluetoothEnabled = isBluetoothEnabled;
				return this;
			}
			
			public Computer build(){
				return new Computer(this);
			}
		}
}
