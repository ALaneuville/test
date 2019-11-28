package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class JokeHubPage extends PageObject {
	
	public JokeHubPage(String url) {
		super(url);
	}
	
	public JokeHubPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public JokeHubPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "hub";
	}

}