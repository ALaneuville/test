package com.wp.wpqa_65_check_for_key_values_CPT;

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

public class ConfirmKeyValuesInCPT_HomePage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	//Test Data
	String url=Constant.CPT_HomePage+"?googfc";

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
	public void confirmPos_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 3);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmCategory_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 5);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);

	}

	@Test 
	public void confirmTopic_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 6);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmKeywordCPT_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 7);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}


	@Test 
	public void confirmURL_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 8);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTheme_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 9);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmPt_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 10);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}


	@Test 
	public void confirmTax0_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 13);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTax1_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 14);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTax2_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 15);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTax3_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 16);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmTf_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 17);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmLocation_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 18);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmRandom_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 19);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}


	/*@Test 
	public void confirmCampaignID_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 20);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}*/

	@Test 
	public void confirmGS_CAT_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 22);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}

	@Test 
	public void confirmKUID_ValueIn_CPT_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes", 17, 23);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
}

