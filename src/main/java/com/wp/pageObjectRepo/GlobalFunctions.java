package com.wp.pageObjectRepo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.testng.Assert;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Driver;
import com.wp.genericLib.WebDriverCommonLib;




public class GlobalFunctions {
	WebDriver driver;
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	public GlobalFunctions(WebDriver driver){ 
		this.driver=driver; 
	}




	//Common methods for RMS3.0 Home page

	public void navigateToRequiredSite(String url) throws Exception{
		//configFileReader= new ConfigFileReader();
		//String url= configFileReader.getDriverPath();	

		System.out.println("url: "+url);
		APPLICATION_LOGS.debug("url: "+url);
		try{
			driver.get(url);
			WebDriverCommonLib.waitForPageToBeLoad(driver);
		}
		catch(TimeoutException e){
			System.out.println("Handeled TimeoutException");
			APPLICATION_LOGS.debug("Handeled TimeoutException");
			driver.navigate().refresh();
			WebDriverCommonLib.waitForPageToBeLoad(driver);
			//Open google site
			driver.get("https://www.google.com/");
			Thread.sleep(2000);
			WebDriverCommonLib.waitForPageToBeLoad(driver);
			//Navigate to proper URL again
			System.out.println("Navigate URL again");
			APPLICATION_LOGS.debug("Navigate URL again");
			driver.navigate().to(url);
			WebDriverCommonLib.waitForPageToBeLoad(driver);
		}


	}

	public void verifyTmbi_ad_dataKeyValue(String url, String property, String siteId,String pageType,String template) throws IOException, InterruptedException{
		//Get page source		
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue= "tmbi_ad_data = {\"property\":\""+property+"\",\"siteId\":\""+siteId+"\",\"pageType\":\""+pageType+"\",\"template\":\""+template+"\"";
		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		System.out.println("Expected Key-Value "+ expKeyValue);

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("GPT Key values is present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("GPT Key values is present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("*************************************************************************************");
		}
		else{
			APPLICATION_LOGS.debug("GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("*************************************************************************************");
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyTmbi_ad_dataKeyValue");
			assertTrue(pageSource.contains(expKeyValue),"GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
		}
	}

	/*public void verifyTmbi_ad_dataKeyValue(String property, String siteId,String pageType,String template) throws IOException, InterruptedException{
		//Get page source		
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue= "tmbi_ad_data = {\"property\":\""+property+"\",\"siteId\":\""+siteId+"\",\"pageType\":\""+pageType+"\",\"template\":\""+template+"\"";
		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		//Verify the Expected Key-Value is present in Page Source or not		

		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("GPT Key values is present in Page Source. Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("GPT Key values is not present in Page Source. Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyTmbi_ad_dataKeyValue");
			assertTrue(pageSource.contains(expKeyValue),"GPT Key values is not present in Page Source. Expected Key Value is:  "+expKeyValue);

		}
	}*/

	public void verifyAmazonHeaderIsRunning(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/tmbi-amazon-a9/js/tmbi-amazon-a9.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"com/wp-content/plugins/tmbi-amazon-a9/js/tmbi-amazon-a9.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		}

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Amazon header bidder present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Amazon header bidder is not present in page source.Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyAmazonHeaderIsRunning");
			assertTrue(pageSource.contains(expKeyValue),"Amazon header bidder is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	//for verifying Prebid header in all brands : WPQA69
	public void verifyPrebidHeaderIsRunning(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/prebidjs/js/prebid.js";
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"com/wp-content/plugins/prebidjs/js/prebid.js";
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Prebid header bidder is  present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			System.out.println("Prebid header bidder:- " +expKeyValue+ " is present in Page Source: "+url);
			System.out.println("*************************************************************************************");
		}
		else{
			APPLICATION_LOGS.debug("Prebid header bidder is not  present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			System.out.println("Prebid header bidder is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("*************************************************************************************");
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyPrebidHeaderIsRunning");
			assertTrue(pageSource.contains(expKeyValue),"Prebid header bidder is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}

	}


	/*public void verifyPrebidHeaderIsRunning(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/prebidjs/js/prebid.js?ver=1.2.1";
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/prebidjs/js/prebid.js?ver=1.2.1";
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Prebid header bidder is  present in page source.Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Prebid header bidder is not  present in page source.Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyPrebidHeaderIsRunning");
			assertTrue(pageSource.contains(expKeyValue),"Prebid header bidder is not present in page source.Expected Key Value is:  "+expKeyValue);

		}

	}*/

	public void verifyIndexExchangeHeaderBidderIsRunning(String url) throws IOException, InterruptedException{
		//Get page source
		String pageSource=driver.getPageSource();

		//Expected key-value from test data		
		String expKeyValue= "js-sec.indexww.com\\/ht\\/p\\/184414";

		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		System.out.println("Expected Key-Value "+ expKeyValue);

		//Verify the Expected Key-Value is present in Page Source or not			
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Index Exchange header bidder is running on site :"+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("Index Exchange header bidder is running on site :"+url+" Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Index Exchange header bidder is not running on site :"+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("Index Exchange header bidder is not running on site :"+url+" Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyIndexExchangeHeaderBidderIsRunning");
			assertTrue(pageSource.contains(expKeyValue),"Index Exchange header bidder is not running on site :"+url+" Expected Key Value is: "+expKeyValue);

		}

	}


	public void switchToFrame() throws Exception{

		Thread.sleep(5000);
		try{
			driver.findElement(By.id("google_pubconsole_mbutton")).click();


		}
		catch(Exception e){
			//System.out.println("The Hide/Show console not present");
			APPLICATION_LOGS.info("The Hide/Show console not present");
		}
		Thread.sleep(5000);
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[@width='100%']"));
		//System.out.println(iframes);
		for(int i=0;i<=iframes.size()-1;i++){
			String frameID=	iframes.get(i).getAttribute("id");
			//System.out.println("text: "+ frameID);
			APPLICATION_LOGS.info("text: "+ frameID);


			driver.switchTo().frame(frameID);



			if(driver.findElements(By.xpath("//div[contains(text(),'Page Request')]")).size() != 0){
				driver.findElement(By.xpath("//div[contains(text(),'Page Request')]")).click();
				//System.out.println(" X path  found in iframe. Driver switched successfully ");
				APPLICATION_LOGS.info(" X path  found in iframe. Driver switched successfully ");
				break;


			}
			else{
				driver.switchTo().defaultContent();

			}


		}


	}



	public void verifyKeyValueAttributesGoogfc(String url, String expectedKey) throws IOException, InterruptedException{
		Thread.sleep(3000);
		//Get the actual string from UI based on Key provided
		List<WebElement> actalValues= driver.findElements(By.xpath("//td[contains(text(),'"+expectedKey+"')]"));
		if(actalValues.size()==0){
			Assert.assertEquals(false, true,"The Key: "+ expectedKey+" is not found in the URL: "+url);
		}
		for (int i=0;i<=actalValues.size()-1; i++){
			String actalValue= actalValues.get(i).getText();

			APPLICATION_LOGS.debug("actalValue: "+actalValue);
			System.out.println("actalValue: "+actalValue);

			// Fetch the value between value and for string
			Pattern pattern = Pattern.compile("value(.*?)for", Pattern.DOTALL);
			Matcher matcher = pattern.matcher(actalValue);
			matcher.find();
			String str= matcher.group(1);
			APPLICATION_LOGS.debug("Key-value fetched from UI: "+str);
			System.out.println("Key-value fetched from UI: "+str);

			//Identify the key has value or not
			//boolean text= str.matches(".*[a-z].*");
			//boolean capstext= str.matches(".*[A-Z].*");
			//	boolean number=str.matches(".*[0-9].*");
			//	boolean specialCharacter=str.matches(".*/.*");
			boolean text = str.matches(".*[a-zA-Z0-9/].*");
			//System.out.println("text1: "+text1);
			System.out.println("text: "+text);
			//	System.out.println("number: "+number);
			//	System.out.println("special Character: "+specialCharacter);


			//if(text==true || capstext==true || number==true || specialCharacter==true)
			if(text==true){
				APPLICATION_LOGS.debug("The Key :"+ expectedKey +" has a value: "+str +" in the URL: "+ url);
				System.out.println("The Key :"+ expectedKey +" has a value: "+str +" in the URL: "+ url );


			}
			else if(text==false && (actalValue.startsWith("Setting targeting attribute location")&& actalValue.endsWith("/sponsor"))==true){
				APPLICATION_LOGS.debug("Ignoring the attribute location value for sponsor");
				System.out.println("Ignoring the attribute location value for sponsor");
				break;

			}
			else{
				APPLICATION_LOGS.debug("The Key :"+ expectedKey +" doesn't have any value in the URL: "+ url +"  The actual value fetched from UI is: "+actalValue);
				System.out.println("The Key :"+ expectedKey +" doesn't have any value in the URL: "+ url +"   The actual value fetched from UI is: "+actalValue);
				WebDriverCommonLib.getScreenShot(driver, "verifyKeyValueAttributesGoogfc");
				Assert.assertEquals(false, true, "The Key :"+ expectedKey +" doesn't have any value in the URL: "+ url +"  The actual value fetched from UI is: "+actalValue);
			}
		}
	}

	public void verifyDFP_CodeIsRunning(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String tmbiGPTMain="/wp-content/plugins/tmbi-ad-stack/js/tmbi-gpt-main.js";
		APPLICATION_LOGS.debug("Expected Key-Value "+ tmbiGPTMain);
		String tmbiMediaNet="/wp-content/plugins/tmbi-ad-stack/js/tmbi-media-net-bidder.js";
		APPLICATION_LOGS.debug("Expected Key-Value "+ tmbiMediaNet);

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(tmbiGPTMain)==true){
			APPLICATION_LOGS.debug("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+tmbiGPTMain);
			System.out.println("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+tmbiGPTMain);
			System.out.println("***************************************************************************");

		}
		else if(pageSource.contains(tmbiMediaNet)==true){
			APPLICATION_LOGS.debug("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+tmbiMediaNet);
			System.out.println("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+tmbiMediaNet);
			System.out.println("***************************************************************************");
		}

		else{
			APPLICATION_LOGS.debug("DFP Code is not present in page Source: "+url+"  Expected Key Value is, tmbiGPTMain:  "+tmbiGPTMain+" OR tmbiMediaNet: "+tmbiMediaNet);
			System.out.println("DFP Code is not present in page Source: "+url+"  Expected Key Value is, tmbiGPTMain:  "+tmbiGPTMain+" OR tmbiMediaNet: "+tmbiMediaNet);
			System.out.println("***************************************************************************");
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyDFP_CodeIsRunning");
			assertTrue(pageSource.contains(tmbiGPTMain)||(pageSource.contains(tmbiMediaNet)),"DFP Code is not present in page Source: "+url+"  Expected Key Value is, tmbiGPTMain:  "+tmbiGPTMain+" OR tmbiMediaNet: "+tmbiMediaNet);

		}
	}

	public void scrollToTheEndOfPage() throws InterruptedException{
		/*//Scroll to the end of page
		WebElement lastElement = driver.findElement(By.xpath("//div[@class='footer-copyright']"));
		int y = lastElement.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+y+")");
		Thread.sleep(3000);*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
			System.out.println("lastHeight: "+ lastHeight);
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(3000);

				js.executeScript("window.scrollBy(0,-3000)", "");
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

				js.executeScript("window.scrollBy(0,-3000)", "");
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");


				long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();

				System.out.println("newHeight: "+newHeight);
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void scrollDownPage() throws InterruptedException{
		int scroll_count=0;

		//WebElement Taboola_feed = driver.findElement(By.xpath("//*[@id='taboola-below-gallery-thumbnails']"));
		//WebElement Taboola_feed = driver.findElement(By.id("toh-taboola"));
		//System.out.println("text: " +Taboola_feed.getText());

		Actions action = new Actions(driver);
		do
		{
			Thread.sleep(1000);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			action.sendKeys(Keys.ESCAPE).perform();
			scroll_count++;
		}while(scroll_count<=25);

	}

	public void scrollDown() throws InterruptedException{
		int scroll_count=0;

		//WebElement Taboola_feed = driver.findElement(By.xpath("//*[@id='taboola-below-gallery-thumbnails']"));
		//WebElement Taboola_feed = driver.findElement(By.id("toh-taboola"));
		//System.out.println("text: " +Taboola_feed.getText());

		Actions action = new Actions(driver);
		do
		{
			Thread.sleep(1000);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
			action.sendKeys(Keys.ESCAPE).perform();
			scroll_count++;
		}while(scroll_count<80);

	}
	//This code is used to verify the Ad Units in googfc console
	/*public void verifyAdUnitsInAdSlots(String url, String adStackID, String platform, String template, String adUnit) throws InterruptedException{	
		//Click on Ad Slots tab
		driver.findElement(By.xpath("//div[contains(text(),'Ad Slots')]")).click();
		//Get the required Ad unit from the Ad slots section
		String actualAdUnitValuefromUI= driver.findElement(By.xpath("//span[text()='"+adUnit+"']/preceding-sibling::span")).getText();
		APPLICATION_LOGS.debug("Actual Ad unit value fetched from UI is:  "+actualAdUnitValuefromUI);
		System.out.println("Actual Ad unit value fetched from UI is:  "+actualAdUnitValuefromUI);
		//Get the expected value from test data
		System.out.println("adStackID:"+adStackID);
		System.out.println("platform:"+platform);
		System.out.println("template:"+template);
		String expectedAdUnitValuefromTestData= adStackID+ " >  "  +platform+ " >  "  +template +" >  ";

		APPLICATION_LOGS.debug("Expected Ad unit value fetched from test data is:  "+expectedAdUnitValuefromTestData);
		System.out.println("Expected Ad unit value fetched from test data is:  "+expectedAdUnitValuefromTestData);

		//Get the browser details
		configFileReader = new ConfigFileReader();
		String browser = configFileReader.getBrowserName();
		if(browser.equalsIgnoreCase("firefox")|| browser.equalsIgnoreCase("chrome")|| browser.equalsIgnoreCase("ie")){
			Assert.assertEquals(actualAdUnitValuefromUI, expectedAdUnitValuefromTestData,"The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ expectedAdUnitValuefromTestData);
			APPLICATION_LOGS.debug("The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ expectedAdUnitValuefromTestData);
			System.out.println("The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ expectedAdUnitValuefromTestData);

		}
		else{
			String mobileAdUnitValue=expectedAdUnitValuefromTestData.replaceAll("desktop", "mobile");
			System.out.println("mobileAdUnitValue: "+ mobileAdUnitValue);
			Assert.assertEquals(actualAdUnitValuefromUI, mobileAdUnitValue,"The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ mobileAdUnitValue);
			APPLICATION_LOGS.debug("The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ mobileAdUnitValue);
			System.out.println("The actual Ad Unit value: " +actualAdUnitValuefromUI +" is not match with expected Ad Unit value: "+ mobileAdUnitValue);

		}
	}*/

	//This code is used to verify the Ad Units in showads=1 console
	public void verifyAdUnitsInAdSlots(String url, String adStackID, String platform, String template, String adUnit) throws Exception{	
		//Get the required Ad unit from the Ad slots section
		String actualAdUnitValuefromUI="";
		String expectedAdUnitValuefromTestData= "/"+adStackID+"/"+platform+"/"+template+"/"+adUnit;
		try{
			actualAdUnitValuefromUI= driver.findElement(By.xpath("//button[contains(text(),'"+adUnit+"')]")).getText();
		}
		catch(Exception e){
			assertTrue(actualAdUnitValuefromUI.equals(expectedAdUnitValuefromTestData),"The actual Ad Unit value not matched in the URL: "+url+"  Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);
		}
		APPLICATION_LOGS.debug("Actual Ad unit value fetched from UI is:  "+actualAdUnitValuefromUI);
		System.out.println("Actual Ad unit value fetched from UI is:  "+actualAdUnitValuefromUI);
		//Get the expected value from test data
		APPLICATION_LOGS.debug("Expected Ad unit value fetched from test data is:  "+expectedAdUnitValuefromTestData);
		System.out.println("Expected Ad unit value fetched from test data is:  "+expectedAdUnitValuefromTestData);

		//Get the browser details
		configFileReader = new ConfigFileReader();
		String browser = configFileReader.getBrowserName();
		if(browser.equalsIgnoreCase("firefox")|| browser.equalsIgnoreCase("chrome")|| browser.equalsIgnoreCase("ie")){
			if(actualAdUnitValuefromUI.equals(expectedAdUnitValuefromTestData)){
				APPLICATION_LOGS.debug("The actual Ad Unit value matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);
				System.out.println("The actual Ad Unit value matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);

			}
			else{
				APPLICATION_LOGS.debug("The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);
				System.out.println("The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);
				WebDriverCommonLib.getScreenShot(driver, "verifyAdUnitsInAdSlots");
				assertTrue(actualAdUnitValuefromUI.equals(expectedAdUnitValuefromTestData),"The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ expectedAdUnitValuefromTestData);
			}


		}
		else{
			String mobileAdUnitValue=expectedAdUnitValuefromTestData.replaceAll("desktop", "mobile");
			System.out.println("mobileAdUnitValue: "+ mobileAdUnitValue);
			if(actualAdUnitValuefromUI.equals(mobileAdUnitValue)){
				APPLICATION_LOGS.debug("The actual Ad Unit value matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ mobileAdUnitValue);
				System.out.println("The actual Ad Unit value matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ mobileAdUnitValue);

			}
			else{
				APPLICATION_LOGS.debug("The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ mobileAdUnitValue);
				System.out.println("The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ mobileAdUnitValue);
				WebDriverCommonLib.getScreenShot(driver, "verifyAdUnitsInAdSlots");
				assertTrue(actualAdUnitValuefromUI.equals(mobileAdUnitValue),"The actual Ad Unit value not matched in the URL: "+url+" Actual Add Unit: " +actualAdUnitValuefromUI +" Expected Add Unit: "+ mobileAdUnitValue);	
			}
		}
	}

	public void Verify_Nativo_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/tmbi-nativo/js/nativo-custom.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];

			expKeyValue=""+modifiedURL+"com/wp-content/plugins/tmbi-nativo/js/nativo-custom.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Nativo global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Nativo global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Nativo_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Nativo global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_Taboola_Global_Variable_PartnerList(String url, String siteID) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/rd-taboola/js/"+siteID+"-taboola-loader.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/rd-taboola/js/"+siteID+"-taboola-loader.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}


		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Taboola global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Taboola global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Taboola_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Taboola global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_BounceExchnage_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/tmbi-bx/js/smart-tag.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/tmbi-bx/js/smart-tag.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}


		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Bounce Exchange global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Bounce Exchange global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_BounceExchnage_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Bounce Exchange global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_JWPlayer_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/rd-video/inc/players/../js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/rd-video/inc/players/../js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}


		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("JW Player global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("JW Player global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_JWPlayer_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"JW Player global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_JWPlayer_Ad_Partners_Spotx_EMX_Telaria(String url, String spotxId, String emxId, String telariaId) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected values for Spotx, EMX and Telaria
		String expectedspotX= "{\"name\":\"SpotX\",\"id\":"+spotxId+"}";
		String expectedEMX= "{\"name\":\"EMX\",\"id\":"+emxId+"}";
		String expectedTelaria= "{\"name\":\"Telaria\",\"id\":"+telariaId+"}";

		System.out.println("The expected JW Player Ad partners found in page Source: "+url+"  are Spotx:"+ expectedspotX+" EMX: "+expectedEMX+" Telaria: "+expectedTelaria+"");
		APPLICATION_LOGS.debug("The expected JW Player Ad partners found in page Source: "+url+"   are Spotx:"+ expectedspotX+" EMX: "+expectedEMX+" Telaria: "+expectedTelaria+"");

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expectedspotX)==true && pageSource.contains(expectedEMX)==true && pageSource.contains(expectedTelaria)==true){
			APPLICATION_LOGS.debug("JW Player global partner list: Spotx,EMX and Telaria is present in page Source: "+url+"  Expected Key Value is:  "+expectedspotX);

		}
		else{
			APPLICATION_LOGS.debug("JW Player global partner list:Spotx,EMX and Telaria is not present in page Source: "+url+"  Expected Key Value is:  "+expectedspotX);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_JWPlayer_Ad_Partners_Spotx_EMX_Telaria");
			assertTrue(pageSource.contains(expectedspotX),"JW Player global partner list:Spotx,EMX and Telaria is not present in page Source: "+url+"  Expected Key Value is:  "+expectedspotX);

		}
	}

	public void Verify_Krux_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/tmbi-custom-social-share/js/krux-tracking.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/tmbi-custom-social-share/js/krux-tracking.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Krux global partner list is present in page source : "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Krux global partner list is not present in page source.Expected Key Value is: "+url+"   "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Krux_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Krux global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_AdobeDTM_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="";
		if(url.contains(".ca/")){
			String[] splitURL= url.split("ca/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"ca/wp-content/plugins/rd-adobe-dtm/js/adobe_dtm.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}
		else{
			String[] splitURL= url.split("com/");
			String modifiedURL= splitURL[0];
			expKeyValue=""+modifiedURL+"com/wp-content/plugins/rd-adobe-dtm/js/adobe_dtm.js";
			System.out.println("Expected Key-Value "+ expKeyValue);
			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		}


		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Adobe Launch global partner list is present in page source "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Adobe Launch  global partner list is not present in page source.Expected Key Value is: "+url+"  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_AdobeLaunch_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Adobe Launch  global partner list is not present in page source.Expected Key Value is: "+url+"  "+expKeyValue);

		}
	}

	public void Verify_Appnexus_Global_Variable_PartnerList(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="\"appnexus_enabled\":\"1\"";
		System.out.println("Expected Key-Value "+ expKeyValue);
		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Appnexus Launch global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Appnexus Launch  global partner list is not present in page source "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_AdobeLaunch_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Appnexus Launch  global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_Rubicon_Global_Variable_PartnerList(String rubicon_account_id , String rubicon_site_id) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected values for Spotx, EMX and Telaria
		String expected_rubicon_account_id= "rubicon_account_id\":"+rubicon_account_id+"}";
		String expected_rubicon_site_id= "rubicon_site_id\":"+rubicon_site_id+"}";

		System.out.println("The Rubicon Ad partners values are rubicon_account_id:"+ rubicon_account_id+" rubicon_site_id: "+rubicon_site_id+"");
		APPLICATION_LOGS.debug("The Rubicon Ad partners values are rubicon_account_id:"+ rubicon_account_id+" rubicon_site_id: "+rubicon_site_id+"");

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expected_rubicon_account_id)==true && pageSource.contains(expected_rubicon_site_id)==true){
			APPLICATION_LOGS.debug("The Rubicon Ad partners has values for: rubicon_account_id and rubicon_site_id in the page source");

		}
		else{
			APPLICATION_LOGS.debug("The Rubicon Ad partners doesn't have values for: rubicon_account_id and rubicon_site_id in the page source");
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Rubicon_Ad_Partners_Spotx_EMX_Telaria");
			assertTrue(pageSource.contains(expected_rubicon_account_id),"The Rubicon Ad partners doesn't have values for: rubicon_account_id and rubicon_site_id in the page source");

		}
	}

	public void Verify_Audigent_Global_Variable_PartnerList(String url) throws IOException{
		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the Adobe URL
		try{
			WebElement adobeURL= driver.findElement(By.xpath("//a[contains(text(),'//assets.adobedtm.com/')]"));
			System.out.println("The Adobe URL:"+ adobeURL+"");
			APPLICATION_LOGS.debug("The Adobe URL:"+ adobeURL+"");
			//Click on Adobe URL
			adobeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "Adobe URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains("Audigent")==true){
			APPLICATION_LOGS.debug("Audigent global partner list is present in page Source: "+url+" ");

		}
		else{
			APPLICATION_LOGS.debug("Audigent global partner list is not present in page Source: "+url+" ");
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Audigent_Global_Variable_PartnerList");
			assertTrue(pageSource.contains("Audigent"),"Audigent global partner list is not present in page Source: "+url+" ");

		}

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);

	}

	public void verifyCampaignIdInPageSource(String url) throws IOException, InterruptedException{
		//Get page source
		String pageSource=driver.getPageSource();

		//Expected key-value from test data		
		String expKeyValue= "campaign_id";

		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		System.out.println("Expected Key-Value "+ expKeyValue);

		//Verify the Expected Key-Value is present in Page Source or not			
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("campaign_id is present on site :"+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("campaign_id is present on site :"+url+" Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("campaign_id is not present on site :"+url+" Expected Key Value is:  "+expKeyValue);
			System.out.println("campaign_id is not present on site :"+url+" Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "verifyCampaignIdInPageSource");
			assertTrue(pageSource.contains(expKeyValue),"campaign_id is not present on site :"+url+" Expected Key Value is:  "+expKeyValue);

		}

	}

	public void Verify_Duplicate_Adunits(String url) throws IOException{
		//Get the list of Adunits present in a page
		List<WebElement> adUnits;
		try{
		adUnits=driver.findElements(By.xpath("//button[@class='accordian']"));
		}
		catch(StaleElementReferenceException e){
			System.out.println("Stale Element Reference Exception");
			adUnits=driver.findElements(By.xpath("//button[@class='accordian']"));
		}
		for (int i = 0; i < adUnits.size()-1; i++) { 
			for (int j = i + 1 ; j < adUnits.size()-1; j++) { 
				if ((adUnits.get(i).getText().equals(adUnits.get(j).getText())==true) && (adUnits.get(i).getText().endsWith("rail_15")==false)&& (adUnits.get(i).getText().endsWith("content_15")==false)&& (adUnits.get(i).getText().endsWith("video")==false)&& (adUnits.get(i).getText().endsWith("")==false)) { 
					// got the duplicate element
					APPLICATION_LOGS.debug("Duplicated Adunit: "+ adUnits.get(i).getText()+" found in the URL "+ url );
					WebDriverCommonLib.getScreenShot(driver, "Verify_Duplicate_Adunits");
					Assert.assertEquals(true,false,"Duplicated Adunit: "+ adUnits.get(i).getText()+" found in the URL "+ url );
				}
			}
		}

	}

	public void verify_InCorrect_Order_AdUnits(String url) throws IOException{
		//Get the list of Ad units present in a page
		List<WebElement> adUnits=driver.findElements(By.xpath("//button[@class='accordian']"));
		// verify Incorrect order in rail or Content
		ArrayList < String > al=new ArrayList < String >();
		ArrayList < String > a2=new ArrayList < String >();
		boolean rail_sorted=true;
		boolean content_sorted=true;	
		for (int i = 0; i < adUnits.size(); i++) {
			String ads=adUnits.get(i).getText();
			if(ads.contains("rail_")){
				al.add(ads);	
			}
			else if(ads.contains("content_")){
				a2.add(ads);
			}
		}		
		for(int i=1; i<al.size();i++){
			if(al.get(i-1).compareTo(al.get(i))>0){
				if(al.get(i-1).compareTo(al.get(i))!=8){
				rail_sorted= false;
				}
			}
		}

		for(int i=1; i<a2.size();i++){
			if(a2.get(i-1).compareTo(a2.get(i))>0){
				if(a2.get(i-1).compareTo(a2.get(i))!=8){
				content_sorted= false;
				}
			}
		}
		if((rail_sorted)==false){
			APPLICATION_LOGS.debug("Incorrct order of rail for the URL: "+url+" Actual rail order in UI: "+al);
			WebDriverCommonLib.getScreenShot(driver, "verify_InCorrect_Order_AdUnits");
			Assert.assertEquals(true, false, "Incorrct order of rail for the URL: "+url+" Actual rail order in UI: "+al);

		}
		else if((content_sorted)==false){
			APPLICATION_LOGS.debug("Incorrct order of Content for the URL: "+url+"Actual content order in UI:  "+a2 );
			WebDriverCommonLib.getScreenShot(driver, "verify_InCorrect_Order_AdUnits");
			Assert.assertEquals(true, false, "Incorrct order of Content for the URL: "+url+"Actual content order in UI:  "+a2 );
			
		}
		else {
			APPLICATION_LOGS.debug("Corrct order of rail/Content found in the in the URL: "+url);
			System.out.println("Corrct order of rail/Content found in the in the URL: "+url);
			
		}

	}



	// CPT theme New Implementation
	//=====================================================================================================
	//*****************************************************************************************************	
	//=====================================================================================================


	public void Verify_AmazonHeaderRunning_CPT(String url) throws IOException{
		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the autoptimize URL
		try{
			WebElement autoptimizeURL= driver.findElement(By.xpath("//a[contains(text(),'/wp-content/cache/autoptimize/js')]"));
			System.out.println("The autoptimize URL:"+ autoptimizeURL+"");
			APPLICATION_LOGS.debug("The Adoautoptimizebe URL:"+ autoptimizeURL+"");
			//Click on Adobe URL
			autoptimizeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "autoptimize URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains("c.amazon-adsystem.com/aax2/apstag.js")==true){
			System.out.println("c.amazon-adsystem.com/aax2/apstag.js is present in CPT");
			APPLICATION_LOGS.debug("Amazon header is running in CPT page Source: "+url+" ");

		}
		else{
			APPLICATION_LOGS.debug("Amazon header is not running in CPT page Source: "+url+" ");
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_AmazonHeaderRunning_CPT");
			assertTrue(pageSource.contains("Audigent"),"Amazon header is not srunning in CPT page Source: "+url+" ");

		}

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);

	}

	public void verifyDFP_CodeIsRunning_CPT(String url) throws IOException{

		//Expected key-value from test data
		String expValue="www.googletagservices.com/tag/js/gpt.js";

		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the autoptimize URL
		try{
			WebElement autoptimizeURL= driver.findElement(By.xpath("//a[contains(text(),'/wp-content/cache/autoptimize/js')]"));
			System.out.println("The autoptimize URL:"+ autoptimizeURL+"");
			APPLICATION_LOGS.debug("The Adoautoptimizebe URL:"+ autoptimizeURL+"");
			//Click on Adobe URL
			autoptimizeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "autoptimize URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not	
		if(pageSource.contains("//www.googletagservices.com/tag/js/gpt.js")==true){
			APPLICATION_LOGS.debug("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+expValue);
			System.out.println("DFP Code is present in page Source: "+url+"  Expected Key Value is:  "+expValue);
			System.out.println("***************************************************************************");
		}

		else{
			APPLICATION_LOGS.debug("DFP Code is not present in page Source: "+url+"  Expected Key Value is :  "+expValue);
			System.out.println("DFP Code is not present in page Source: "+url+"  Expected Key Value is:  "+expValue);
			System.out.println("***************************************************************************");
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyDFP_CodeIsRunning");
			assertTrue(pageSource.contains(expValue),"DFP Code is not present in page Source: "+url+"  Expected Key Value is : "+expValue);

		}
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);
	}

	public void verifyIndexExchangeHeaderBidderIsRunning_CPT(String url) throws IOException, InterruptedException
	{

		//Expected key-value from test data		
		String expKeyValue= "ix_header_bidder_data";

		//Get page source
		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the autoptimize URL
		try{
			WebElement autoptimizeURL= driver.findElement(By.xpath("//a[contains(text(),'/wp-content/cache/autoptimize/js')]"));
			System.out.println("The autoptimize URL:"+ autoptimizeURL+"");
			APPLICATION_LOGS.debug("The Adoautoptimizebe URL:"+ autoptimizeURL+"");
			//Click on Adobe URL
			autoptimizeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "autoptimize URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){



			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
			System.out.println("Expected Key-Value "+ expKeyValue);

			//Verify the Expected Key-Value is present in Page Source or not			
			if(pageSource.contains(expKeyValue)==true){
				APPLICATION_LOGS.debug("Index Exchange header bidder is running on site :"+url+" Expected Key Value is:  "+expKeyValue);
				System.out.println("Index Exchange header bidder is running on site :"+url+" Expected Key Value is:  "+expKeyValue);

			}
			else{
				APPLICATION_LOGS.debug("Index Exchange header bidder is not running on site :"+url+" Expected Key Value is:  "+expKeyValue);
				System.out.println("Index Exchange header bidder is not running on site :"+url+" Expected Key Value is:  "+expKeyValue);
				WebDriverCommonLib.getScreenShot(driver, "Error in verifyIndexExchangeHeaderBidderIsRunning");
				assertTrue(pageSource.contains(expKeyValue),"Index Exchange header bidder is not running on site :"+url+" Expected Key Value is: "+expKeyValue);

			}

		}
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);

	}

	public void Verify_BounceExchnage_Global_Variable_PartnerList_CPT(String url) throws IOException{
		//Expected key-value from test data		
		String expKeyValue= "//tag.bounceexchange.com";

		//Get page source
		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the autoptimize URL
		try{
			WebElement autoptimizeURL= driver.findElement(By.xpath("//a[contains(text(),'/wp-content/cache/autoptimize/js')]"));
			System.out.println("The autoptimize URL:"+ autoptimizeURL+"");
			APPLICATION_LOGS.debug("The Adoautoptimizebe URL:"+ autoptimizeURL+"");
			//Click on Adobe URL
			autoptimizeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "autoptimize URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){

			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
			System.out.println("Expected Key-Value "+ expKeyValue);

			//Verify the Expected Key-Value is present in Page Source or not		
			if(pageSource.contains(expKeyValue)==true){
				APPLICATION_LOGS.debug("Bounce Exchange global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

			}
			else{
				APPLICATION_LOGS.debug("Bounce Exchange global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
				WebDriverCommonLib.getScreenShot(driver, "Error in Verify_BounceExchnage_Global_Variable_PartnerList");
				assertTrue(pageSource.contains(expKeyValue),"Bounce Exchange global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

			}
		}
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);}
	}

	public void Verify_AdobeDTM_Global_Variable_PartnerList_CPT(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="digitalData";

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Adobe Launch global partner list is present in page source "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Adobe Launch  global partner list is not present in page source.Expected Key Value is: "+url+"  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_AdobeLaunch_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Adobe Launch  global partner list is not present in page source.Expected Key Value is: "+url+"  "+expKeyValue);

		}
	}


	public void Verify_Taboola_Global_Variable_PartnerList_CPT(String url, String siteID) throws IOException{
		//Expected key-value from test data		
		String expKeyValue= "window._taboola";

		//Get page source
		//Navigate to page source URL
		driver.navigate().to("view-source:"+url);
		WebDriverCommonLib.waitForPageToBeLoad(driver);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		//Find the autoptimize URL
		try{
			WebElement autoptimizeURL= driver.findElement(By.xpath("//a[contains(text(),'/wp-content/cache/autoptimize/js')]"));
			System.out.println("The autoptimize URL:"+ autoptimizeURL+"");
			APPLICATION_LOGS.debug("The Adoautoptimizebe URL:"+ autoptimizeURL+"");
			//Click on Adobe URL
			autoptimizeURL.click();
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "autoptimize URL is not present in the page source:"+url);
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		String pageSource=driver.getPageSource();
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){

			APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
			System.out.println("Expected Key-Value "+ expKeyValue);

			//Verify the Expected Key-Value is present in Page Source or not		
			if(pageSource.contains(expKeyValue)==true){
				APPLICATION_LOGS.debug("Taboola global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

			}
			else{
				APPLICATION_LOGS.debug("Taboola global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
				WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Taboola_Global_Variable_PartnerList");
				assertTrue(pageSource.contains(expKeyValue),"Taboola global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

			}
		}
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//driver.navigate().to(url);
		//WebDriverCommonLib.waitForPageToBeLoad(driver);
	}

	public void Verify_Krux_Global_Variable_PartnerList_CPT(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data		
		String expKeyValue= "window.Krux";

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Krux global partner list is present in page source : "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Krux global partner list is not present in page source.Expected Key Value is: "+url+"   "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Krux_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Krux global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_Nativo_Global_Variable_PartnerList_CPT(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="nativo";
		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("Nativo global partner list is present in page source : "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("Nativo global partner list is not present in page source.Expected Key Value is: "+url+"   "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_Nativo_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"Nativo global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void Verify_JWPlayer_Global_Variable_PartnerList_CPT(String url) throws IOException{
		//Get page source
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="jw_settings";

		//Verify the Expected Key-Value is present in Page Source or not		
		if(pageSource.contains(expKeyValue)==true){
			APPLICATION_LOGS.debug("JW Player global partner list is present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
		else{
			APPLICATION_LOGS.debug("JW Player global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);
			WebDriverCommonLib.getScreenShot(driver, "Error in Verify_JWPlayer_Global_Variable_PartnerList");
			assertTrue(pageSource.contains(expKeyValue),"JW Player global partner list is not present in page Source: "+url+"  Expected Key Value is:  "+expKeyValue);

		}
	}

	public void verifyTmbi_ad_dataKeyValue_CPT(String url, String property, String siteId,String pageType,String pt) throws IOException, InterruptedException{
		//Get page source                          
		String pageSource=driver.getPageSource();
		//APPLICATION_LOGS.debug("Page Source= "+ pageSource);

		//Expected key-value from test data
		String expKeyValue="tmbi_ad_data = {\"global_targeting\":{\"property\":\""+property+"\",\"siteId\":\""+siteId+"\",\"pageType\":\""+pageType+"\"";
		String ptValue="\"pt\":\""+pt+"\"";
		APPLICATION_LOGS.debug("Expected Key-Value "+ expKeyValue);
		System.out.println("Expected Key-Value "+ expKeyValue);
		APPLICATION_LOGS.debug("ptValue "+ ptValue);
		System.out.println("ptValue "+ ptValue);

		//Verify the Expected Key-Value is present in Page Source or not               
		if((pageSource.contains(expKeyValue) && pageSource.contains(ptValue))==true){
			APPLICATION_LOGS.debug("GPT Key values is present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue + "& pt value is: "+ptValue );
			System.out.println("GPT Key values is present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue+"& pt value is: "+ptValue);
			System.out.println("*************************************************************************************");
		}
		else{
			APPLICATION_LOGS.debug("GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue+" & pt value is: "+ptValue);
			System.out.println("GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue+ " & pt value is: "+ptValue);
			System.out.println("*************************************************************************************");
			WebDriverCommonLib.getScreenShot(driver, "Error in verifyTmbi_ad_dataKeyValue");
			assertTrue((pageSource.contains(expKeyValue)&&pageSource.contains(ptValue))==true,"GPT Key values is not present in Page Source: "+url+" Expected Key Value is:  "+expKeyValue + " & pt value is: "+ptValue);
		}
	}
}

