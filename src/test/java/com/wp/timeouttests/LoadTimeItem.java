package com.wp.timeouttests;

public class LoadTimeItem {
	
	private String searchString;
	private int loadTime;
	private boolean checkExistence;
	
	public LoadTimeItem(String searchString, int loadTime) {
		this.searchString = searchString;
		this.loadTime = loadTime;
		this.checkExistence = false;
	}
	
	public LoadTimeItem(String searchString) {
		this.searchString = searchString;
		this.checkExistence = true;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int getLoadTime() {
		if(checkExistence)
			throw new IllegalStateException("This LoadTimeItem is only checking for existence, cannot get the load time.");
		return loadTime;
	}

	public boolean getCheckExistence() {
		return checkExistence;
	}
}
