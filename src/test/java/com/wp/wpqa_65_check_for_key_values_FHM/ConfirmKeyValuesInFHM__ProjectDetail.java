package com.wp.wpqa_65_check_for_key_values_FHM;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.genericLib.WebDriverCommonLib;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValuesInFHM__ProjectDetail extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	//Test Data
	String url=Constant.FHM_ProjectDetailPage+"?googfc";

	@BeforeClass
	public void navigateToRequiredURL() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		//Handled the KUID attribute issue by bellow 2 lines
		driver.navigate().refresh();
		WebDriverCommonLib.waitForPageToBeLoad(driver);
		globalPage.switchToFrame();

	}


	@Test 
	public void confirmClass_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 24);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmProjectTime_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 25);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmProjectComplexity_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 26);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmProjectCost_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 27);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTool_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 28);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmMaterial_ValueIn_FHM_ProjectDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 24, 29);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
}

