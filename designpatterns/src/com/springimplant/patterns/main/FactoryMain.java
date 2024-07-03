package com.springimplant.patterns.main;

import com.springimplant.patterns.factory.OS;
import com.springimplant.patterns.factory.OpeartingSystemFactory;

public class FactoryMain {

	public static void main(String[] args) {
		OpeartingSystemFactory osf = new OpeartingSystemFactory();
		OS linuxOs =osf.getInstance("linux");
		linuxOs.resourceManagement();
		linuxOs.coordination();
		OS winOs =osf.getInstance("windows");
		winOs.resourceManagement();
		winOs.coordination();
	}

}
