package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class ListiclePage extends PageObject {
	
	public ListiclePage(String url) {
		super(url);
	}
	
	public ListiclePage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public ListiclePage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "listicle";
	}

}