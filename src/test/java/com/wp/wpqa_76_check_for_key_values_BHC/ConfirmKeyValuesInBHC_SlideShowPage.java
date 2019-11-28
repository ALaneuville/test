/*package com.wp.wpqa_76_check_for_key_values_BHC;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValuesInBHC_SlideShowPage extends Driver {
	//Initialize object using page factory method 
		ConfigFileReader configFileReader;
		public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");
		
	      //Test Data
	      String url=Constant.BHC_SlideshowPage+"?googfc";

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
	public void confirmPosValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 3);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmContentIDValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 4);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmCategoryValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 5);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);

	}
	
	@Test 
	public void confirmTopicValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 6);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmKeywordValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 7);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	@Test 
	public void confirmURLValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 8);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmThemeValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 9);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmPtValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 10);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	
	@Test 
	public void confirmAuthorValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 12);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	@Test 
	public void confirmTax0ValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 14);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax1ValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 15);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax2ValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 16);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTax3ValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 17);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmTfValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 18);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmLocationValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 19);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmRandomValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 20);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	
	
	@Test 
	public void confirmGS_CATValueIn_BHC_Slideshow() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 23);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
	
	@Test 
	public void confirmKUIDValueIn_BHC_AboutPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 17, 24);

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
	}
}

	*/