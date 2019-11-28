package com.wp.timeouttests;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetailPage extends PageObject {
	
	public ProjectDetailPage(String url) {
		super(url);
	}

	public ProjectDetailPage(String url, List<String> keys) {
		this(url, keys, new ArrayList<String>());
	}
	
	public ProjectDetailPage(String url, List<String> keys, List<String> pageSpecificKeys) {
		super(url, keys, pageSpecificKeys);
	}
	
	@Override
	public String getTemplate() {
		return "project detail";
	}

}
