/*package com.wp.wpqa_76_check_for_key_values_SRD;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValuesInSRD_SlideShowPage extends Driver {
	//Initialize object using page factory method 
		ConfigFileReader configFileReader;
		public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");
		
	      //Test Data
	      String url=Constant.SRD_SlideshowPage+"?googfc";

	 @BeforeClass
	 public void navigateToRequiredURL() throws Exception{
	  //Object Initialization
	 GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

	  //Step:1 Navigate required URL
	  globalPage.navigateToRequiredSite(url);

	  //Step:2 switch to iFrame
	  globalPage.switchToFrame();

	 }
	 
	 
	     	
	@Test 
	public void confirmPosValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 3);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmContentIDValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 4);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmCategoryValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 5);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);

	}
	
	@Test 
	public void confirmTopicValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 6);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmKeywordValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 7);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	@Test 
	public void confirmURLValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 8);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmThemeValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 9);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmPtValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 10);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	
	@Test 
	public void confirmAuthorValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 12);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	
	@Test 
	public void confirmTax0ValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 14);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax1ValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 15);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax2ValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 16);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax3ValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 17);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTfValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 18);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmLocationValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 19);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmRandomValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 20);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	
	@Test 
	public void confirmGS_CATValueIn_SRD_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 23);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmKUIDValueIn_SRD_AboutPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 1, 24);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
}

	*/