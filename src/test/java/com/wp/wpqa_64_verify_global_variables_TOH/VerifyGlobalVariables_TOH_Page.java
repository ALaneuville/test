package com.wp.wpqa_64_verify_global_variables_TOH;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyGlobalVariables_TOH_Page extends Driver{
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	//Test Data
	String url=Constant.TOH_Page;
	
	@BeforeClass
	public void navigateToRequiredURL() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);
	}

	@Test
	public void verifyAmazonHeaderBidderIsRunning_TOH_Page() throws IOException{
		//Object Initialization
		GlobalFunctions tohPage=PageFactory.initElements(driver, GlobalFunctions.class);
		
		//Test Step
		//Step 2 Verify Amazon Header Bidder is Running
		tohPage.verifyAmazonHeaderIsRunning(url);
	}

	@Test
	public void verifyIndexExchangeHeaderBidderIsRunning_TOH_Page() throws IOException, InterruptedException {
		//Object Initialization
		GlobalFunctions tohPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step:2 Verify Index Exchange Header Bidder is Running in TOH
		tohPage.verifyIndexExchangeHeaderBidderIsRunning(url);

	}

	/*@Test
	public void verifyPrebidHeaderBidderIsRunning_TOH_Page() throws IOException{
		//Object Initialization
		GlobalFunctions tohPage=PageFactory.initElements(driver, GlobalFunctions.class);
		
		//Test Step
		//Step 2 Verify Amazon Header Bidder is Running
		tohPage.verifyPrebidHeaderIsRunning(url);
	}*/

	@Test
	public void verifyDFPCodeIsRunning_TOH_Page() throws IOException{
		//Object Initialization
		GlobalFunctions tohPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify DFP Code is Running
		tohPage.verifyDFP_CodeIsRunning(url);
	}

	@Test
	public void verifyTmbi_ad_dataKeyValue_TOH_Page() throws IOException, InterruptedException {
		//Object Initialization
		GlobalFunctions tohPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data		
		String property= ExcelLibrary.getExcelData("GlobalVariables", 2, 3); 
		String siteId= ExcelLibrary.getExcelData("GlobalVariables", 2, 4);
		String pageType = ExcelLibrary.getExcelData("GlobalVariables", 2, 5);
		String template= ExcelLibrary.getExcelData("GlobalVariables", 2, 6);

		//Test Step
		//Step:2 Verify Tmbi Add Data Key value in required URL
		tohPage.verifyTmbi_ad_dataKeyValue(url, property, siteId, pageType, template);


	}
}
