package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class SlideshowPage extends PageObject {
	
	public SlideshowPage(String url) {
		super(url);
	}
	
	public SlideshowPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}

	public SlideshowPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "slideshow";
	}

}