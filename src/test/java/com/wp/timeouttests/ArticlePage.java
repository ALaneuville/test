package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class ArticlePage extends PageObject {
	
	public ArticlePage(String url) {
		super(url);
	}
	
	public ArticlePage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public ArticlePage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "article";
	}

}