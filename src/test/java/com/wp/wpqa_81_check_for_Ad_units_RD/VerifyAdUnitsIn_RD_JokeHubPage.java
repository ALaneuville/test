package com.wp.wpqa_81_check_for_Ad_units_RD;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyAdUnitsIn_RD_JokeHubPage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	//Test Data
	String url=Constant.RD_JokeHubPage+"?showads=1";
	String adStackID=ExcelLibrary.getExcelData("AdUnits", 16, 3);
	String platform=ExcelLibrary.getExcelData("AdUnits", 16, 4);
	String template=ExcelLibrary.getExcelData("AdUnits", 16, 5);


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
	public void Verify_Prearticle_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 6);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	/*@Test
	public void Verify_sponsor_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 7);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}*/

	@Test
	public void Verify_oop_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 9);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	/*@Test
	public void Verify_rail_1_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 26);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}


	@Test
	public void Verify_rail_2_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 27);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_3_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 28);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_4_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 29);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_5_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 30);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_6_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 31);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_7_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 32);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_8_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 33);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_9_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 34);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_10_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 35);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_11_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 36);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_12_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 37);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_13_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 38);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_14_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 39);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}

	@Test
	public void Verify_rail_15_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 40);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);
	}*/

	@Test
	public void Verify_content_1_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 11);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_2_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 12);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	/*@Test
	public void Verify_content_3_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 13);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_4_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 14);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_5_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 15);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_6_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 16);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_7_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 17);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_8_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 18);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_9_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 19);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_10_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 20);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_11_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 21);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_12_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 22);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_13_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 23);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}
	
	@Test
	public void Verify_content_14_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 24);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_content_15_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 16, 25);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}*/
	
	@Test
	public void Verify_Duplicate_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.Verify_Duplicate_Adunits(url);

	}
	
	@Test
	public void Verify_Incorrect_Order_AdUnit_In_RD_JokeHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verify_InCorrect_Order_AdUnits(url);

	}


}
