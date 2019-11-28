package com.wp.wpqa_65_check_for_key_values_TOH;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.WebDriverCommonLib;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmSponsorsKeyValuesInTOH_NativeAdsArticlePage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	@Test
	public void confirm_Sponsors_ValueIn_TOH_NativeAdsArticlePage() throws Exception{
		//Get the browser details
		configFileReader = new ConfigFileReader();
		String environment = configFileReader.getEnvironment();

		if(environment.equalsIgnoreCase("production")){
			//Object Initialization
			GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

			//Test Data
			String url=Constant.TOH_NativeAdsArticlePage+"?googfc";
			String expectedKey="attribute sponsors";

			//Step:1 Navigate required URL
			globalPage.navigateToRequiredSite(url);

			//Step:2 switch to iFrame
			driver.navigate().refresh();
			WebDriverCommonLib.waitForPageToBeLoad(driver);
			globalPage.switchToFrame();
			
			//Step:3 Verify Amazon Header Bidder is Running
			globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
		}
		else{
			APPLICATION_LOGS.debug("Not required to verify Sponsors_ValueIn_TOH_NativeAdsArticlePage for staging environment ");
			System.out.println("Not required to verify Sponsors_ValueIn_TOH_NativeAdsArticlePage for staging environment ");
		}
	}
}
