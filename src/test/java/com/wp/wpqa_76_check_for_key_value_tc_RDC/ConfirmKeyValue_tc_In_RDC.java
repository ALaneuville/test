package com.wp.wpqa_76_check_for_key_value_tc_RDC;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValue_tc_In_RDC extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	@Test
	public void confirmTCValueIn_RDC_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_HomePage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}

	@Test
	public void confirmTCValueIn_RDC_Page() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_Page+"?trkid=track0987&googfc";


		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}

	@Test
	public void confirmTCValueIn_RDC_HubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_HubPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}

	@Test
	public void confirmTCValueIn_RDC_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_ArticlePage+"?trkid=track0987&googfc";

		//Test Steps:

		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}

	@Test
	public void confirmTCValueIn_RDC_ListiclePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_ListiclePage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}

	/*@Test
	public void confirmTCValueIn_RDC_SlideshowPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_SlideshowPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}*/
	
	@Test
	public void confirmTCValueIn_RDC_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 33, 3);
		String tc_url=Constant.RDC_RecipeDetailPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(tc_url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Key Value attribute present
		globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

	}
}
