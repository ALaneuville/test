package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class ContactPage extends PageObject {
	
	public ContactPage(String url) {
		super(url);
	}
	
	public ContactPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public ContactPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "page";
	}
	
}