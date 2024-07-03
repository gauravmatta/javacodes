package com.springimplant.patterns.factory;

public class Linux implements OS {

	@Override
	public void security() {
		System.out.println("Linux Security");
	}

	@Override
	public void resourceManagement() {
		System.out.println("Linux Resource Manahement");
	}

	@Override
	public void hardwareAccessibility() {

		System.out.println("Linux Accessibility");

	}

	@Override
	public void coordination() {
		System.out.println("Linux Coordination");
	}

}
