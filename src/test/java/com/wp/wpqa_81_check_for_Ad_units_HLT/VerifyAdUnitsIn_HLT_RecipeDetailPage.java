/*package com.wp.wpqa_81_check_for_Ad_units_HLT;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyAdUnitsIn_HLT_RecipeDetailPage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	//Test Data
	String url=Constant.HLT_RecipeDetailPage+"?showads=1";
	String adStackID=ExcelLibrary.getExcelData("AdUnits", 62, 3);
	String platform=ExcelLibrary.getExcelData("AdUnits", 62, 4);
	String template=ExcelLibrary.getExcelData("AdUnits", 62, 5);

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
	public void Verify_Prearticle_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 6);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_sponsor_AdUnit_In_HLT_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 7);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_oop_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 9);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_1_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 26);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_2_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 27);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_3_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 28);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_4_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 29);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

	@Test
	public void Verify_rail_5_AdUnit_In_HLT_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String adUnit=ExcelLibrary.getExcelData("AdUnits", 62, 30);

		//Test Steps:
		//Step:3 Verify Key Value attribute present
		globalPage.verifyAdUnitsInAdSlots(url, adStackID, platform, template, adUnit);

	}

}
*/