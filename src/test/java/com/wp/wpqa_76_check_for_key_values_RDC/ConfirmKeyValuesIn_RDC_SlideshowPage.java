//package com.wp.wpqa_76_check_for_key_values_RDC;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import com.wp.genericLib.ConfigFileReader;
//import com.wp.genericLib.Constant;
//import com.wp.genericLib.Driver;
//import com.wp.genericLib.ExcelLibrary;
//import com.wp.genericLib.WebDriverCommonLib;
//import com.wp.pageObjectRepo.GlobalFunctions;
//
//
//public class ConfirmKeyValuesIn_RDC_SlideshowPage extends Driver {
//	//Initialize object using page factory method 
//	ConfigFileReader configFileReader;
//	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");
//
//
//	//Test Data
//	String url=Constant.RDC_SlideshowPage+"?googfc";
//
//
//	@BeforeClass
//	public void navigateToRequiredURL() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Step:1 Navigate required URL
//		globalPage.navigateToRequiredSite(url);
//
//
//		 //Step:2 switch to iFrame
//		  globalPage.switchToFrame();
//
//
//	}
//
//	@Test
//	public void confirmPosValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 3);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmContentIDValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 4);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmCategoryValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 5);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTopicValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 6);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmKeywordValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 7);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmURLValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 8);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmThemeValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 9);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmPTValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 10);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmAuthorValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 12);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTax0ValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 14);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTax1ValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 15);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTax2ValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 16);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTax3ValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 17);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmTFValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 18);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmLocationValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 19);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmRandomValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 20);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	@Test
//	public void confirmGs_CatValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 23);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}
//
//	/*@Test
//	public void confirmKuidValueIn_RDC_SlideshowPage() throws Exception{
//		//Object Initialization
//		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);
//
//		//Test Data:
//		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 9, 24);
//
//		//Test Steps:
//		//Step:3 Verify Key Value attribute present
//		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);
//
//	}*/
//}
