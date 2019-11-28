package com.wp.wpqa_81_check_for_Ad_units_BHC;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyAdUnitsIn_BHC_HomePage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	//Test Data
	String url=Constant.BHC_HomePage+"?showads=1";
	String adStackID=ExcelLibrary.getExcelData("AdUnits", 48, 3);
	String platform=ExcelLibrary.getExcelData("AdUnits", 48, 4);
	String template=ExcelLibrary.getExcelData("AdUnits", 48, 5);


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
	public void Verify_Prearticle_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 6);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}
	
	@Test
	public void Verify_content_1_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 11);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_2_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 12);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}
	
	@Test
	public void Verify_Duplicate_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.Verify_Duplicate_Adunits(url);

	}
	
	@Test
	public void Verify_Incorrect_Order_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verify_InCorrect_Order_AdUnits(url);

	}
	
	/*@Test
	public void Verify_Video_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 8);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}*/

	/*@Test
	public void Verify_oop_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 9);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_1_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 26);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_2_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 27);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_3_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 28);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_4_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 29);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_5_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 30);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_6_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 31);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}*/

	
	

	/*@Test
	public void Verify_content_3_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 13);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_4_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 14);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_5_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 15);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_6_AdUnit_In_BHC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 48, 16);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}*/

}
