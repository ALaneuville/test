/**
 * A PageObject represents an abstraction of a web page.
 * @author Andrew Truett
 * 
 */
package com.wp.timeouttests;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class PageObject {
	
	protected WebDriver driver;
	protected String url;
	protected List<String> keys;
	protected List<String> pageSpecificKeys;
	
	public PageObject(String url, List<String> keys, List<String> pageSpecificKeys) {
		this.url = url;
		this.keys = keys;
		this.pageSpecificKeys = pageSpecificKeys;

	}
	
	public PageObject(String url) {
		this.url = url;
	}
	
	//A method to return the type of page each page is, not sure if we should use an abstract method, or just getClass()
	public abstract String getTemplate();
	
	/**
	 * Scrolls down the page
	 * @throws InterruptedException
	 */
	public void scrollDownPage() throws InterruptedException{
		int scroll_count=0;

		Actions action = new Actions(driver);
		do
		{
			Thread.sleep(1000);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			action.sendKeys(Keys.ESCAPE).perform();
			scroll_count++;
		} while(scroll_count<=5);
	}
	
	public void scrollToTheEndOfPage() throws InterruptedException{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	/**
	 * Gets the current WebDriver.
	 * @return the current WebDriver.
	 */
	public WebDriver getDriver() {
		return driver;
	}


	/**
	 * Changes the current WebDriver to the passed driver.
	 * @param driver the driver to be set.
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * Gets the URL of this PageObject.
	 * @return the URL of this PageObject.
	 */
	public String getUrl() {
		return url;
	}

	
	/**
	 * Sets the URL of this PageObject with the passed URL.
	 * @param url the URL to be set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	/**
	 * Gets the keys that are specific to this page.
	 * @return the page specific keys.
	 */
	public List<String> getPageSpecificKeys() {
		return pageSpecificKeys;
	}

	
	/**
	 * Sets the page specific keys.
	 * @param pageSpecificKeys The new page specific keys to be set.
	 */
	public void setPageSpecificKeys(List<String> pageSpecificKeys) {
		this.pageSpecificKeys = pageSpecificKeys;
	}
	
	
	/**
	 * Returns keys.
	 * @return keys.
	 */
	public List<String> getKeys() {
		return keys;
	}


	/**
	 * Sets the current keys of this PageObject to the keys that are passed.
	 * @param keys the keys to be set.
	 */
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}
