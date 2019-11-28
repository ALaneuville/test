package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class HubPage extends PageObject {
	
	public HubPage(String url) {
		super(url);
	}
	
	public HubPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public HubPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "hub";
	}

}