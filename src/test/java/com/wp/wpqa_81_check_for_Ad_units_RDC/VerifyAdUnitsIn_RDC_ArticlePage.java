package com.wp.wpqa_81_check_for_Ad_units_RDC;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;



public class VerifyAdUnitsIn_RDC_ArticlePage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	//Test Data
	String url=Constant.RDC_ArticlePage+"?showads=1";
	String adStackID=ExcelLibrary.getExcelData("AdUnits", 43, 3);
	String platform=ExcelLibrary.getExcelData("AdUnits", 43, 4);
	String template=ExcelLibrary.getExcelData("AdUnits", 43, 5);


	@BeforeClass
	public void navigateToRequiredURL() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step: 2 Scroll to the end of page
		globalPage.scrollDownPage();

		//Step:3 switch to iFrame
		//globalPage.switchToFrame();

	}

	@Test
	public void Verify_Prearticle_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 6);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_sponsor_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 7);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_oop_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 9);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_1_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 26);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}


	@Test
	public void Verify_rail_2_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 27);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_3_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 43, 28);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}
	
	@Test
	public void Verify_Duplicate_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.Verify_Duplicate_Adunits(url);

	}
	
	@Test
	public void Verify_Incorrect_Order_AdUnit_In_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verify_InCorrect_Order_AdUnits(url);

	}


}
