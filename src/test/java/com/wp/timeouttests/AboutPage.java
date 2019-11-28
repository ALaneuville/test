package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class AboutPage extends PageObject {
	
	public AboutPage(String url) {
		super(url);
	}

	public AboutPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}
	
	public AboutPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "page";
	}

}
