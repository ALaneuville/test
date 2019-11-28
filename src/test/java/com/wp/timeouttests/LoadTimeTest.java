package com.wp.timeouttests;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoadTimeTest extends AbstractTest implements ITest {
	
	private WebDriver driver;//is this necessary? cant we just use the PageObject driver?
	private PageObject page;
	private String browser;
	
	private LoadTimeItem searchItem;
	
	private boolean isFound;
	private boolean loadUnderTimeout;
	private double actualLoadTime;
	
	public LoadTimeTest(PageObject page, String browser, TimeoutFactory factory, LoadTimeItem searchItem) {
		super(factory);
		
		this.page = page;
		this.browser = browser;
		this.searchItem = searchItem;
		
		isFound = false;
		loadUnderTimeout = false;
		actualLoadTime = -1;
	}
	

	@BeforeMethod
	private void setup() {
		if(browser.equalsIgnoreCase("chrome")){
			String chromeDriverPath = Paths.get(driverDir, "chromedriver" + (isWindows ? ".exe" : "")).toString();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			
			//create chrome instance
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			String firefoxDriverPath = Paths.get(driverDir, "geckodriver" + (isWindows ? ".exe" : "")).toString();
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			
			driver = new FirefoxDriver();
		}
		
		driver.get(page.getUrl());
		
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		page.setDriver(driver);
		
	}
	
	
	@Test
	public void loadTimeTest()
	{
		System.out.println("URL: " + page.getUrl());
		System.out.println("Searching for: " + searchItem.getSearchString());
		
		try {
			page.scrollToTheEndOfPage();
		} catch (InterruptedException e) {
			System.out.println("Cannot scroll down page");
		}
		
		String durationText = "";
		try {
			durationText = driver.findElement(By.xpath("//button[contains(text(), '" + searchItem.getSearchString() + "')]/following-sibling::div")).getText();
			isFound = true;
		}
		catch (NoSuchElementException nse) {
			//Bounce exchange doesnt always run, so if it doesnt, just skip this test
			if(searchItem.getSearchString().contains("Bounce Exchange"))
				throw new SkipException("Bounce exchange did not run on " + page.getUrl());
			
			Assert.fail("Could not find " + searchItem.getSearchString() + " in URL: " + page.getUrl());
		}
		
		if (searchItem.getCheckExistence()) //if all we are doing is checking to ensure the code runs (not under any specific timeout), then we can return (since we already found it) and finish the test
			return; 
		
		String loadTimeStr = durationText.split(":")[1].trim();
		actualLoadTime = Double.parseDouble(loadTimeStr);
		
		if (actualLoadTime > searchItem.getLoadTime())
			Assert.fail(searchItem.getSearchString() + " did not run under the timeout " + searchItem.getLoadTime() + ". Loaded in " + actualLoadTime + "ms. In URL: " + page.getUrl());
		else
			loadUnderTimeout = true;
	}
	
	
	@AfterMethod
	/**
	 * Runs after each test and determines the result
	 * @param result the result of the test
	 */
	private void tearDown(ITestResult result) {
		driver.close();
		
	}
	
	public String getSearchString() {
		return searchItem.getSearchString();
	}
	
	public String getTemplate() {
		return page.getTemplate();
	}

	public String getTestName() {
		return "Load Time Test";
	}
}