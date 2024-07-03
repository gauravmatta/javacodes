package com.springimplant.patterns.factory;

public class Windows implements OS {

	@Override
	public void security() {
		System.out.println("Windows Security");
	}

	@Override
	public void resourceManagement() {
		System.out.println("Windows Resource Manahement");
	}

	@Override
	public void hardwareAccessibility() {

		System.out.println("WindowsHardware Accessibility");

	}

	@Override
	public void coordination() {
		System.out.println("Windows Coordination");
	}

}
