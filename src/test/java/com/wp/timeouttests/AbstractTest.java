package com.wp.timeouttests;

import java.nio.file.Paths;

import com.wp.timeouttests.TimeoutFactory;

public class AbstractTest {
	
	protected TimeoutFactory factory;
	
	protected static String driverDir;
	protected static boolean isWindows;
	
	
	public AbstractTest(TimeoutFactory factory) {
		this.factory = factory;
		
		driverDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "Drivers").toString();
		isWindows = System.getProperty("os.name").toLowerCase().contains("windows");
	}
}

