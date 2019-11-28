package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {
	
	public HomePage(String url) {
		super(url);
	}
	
	public HomePage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}
	
	public HomePage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "homepage";
	}
	
}
