package com.wp.wpqa_65_check_for_key_value_tc;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class Confirmtc_HasValueTOH extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");


	//Test Data
	String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes tc", 1, 3);



	@Test
	public void confirmtc_HasValueTOH_HomePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_HomePage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	@Test
	public void confirmtc_HasValueTOH_Page() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_Page+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	@Test
	public void confirmtc_HasValueTOH_HubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url= Constant.TOH_HubPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	@Test
	public void confirmtc_HasValueTOH_ArticlePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_ArticlePage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	@Test
	public void confirmtc_HasValueTOH_ListiclePage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_ListiclePage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	/*@Test
	public void confirmtc_HasValueTOH_SlideshowPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_SlideshowPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}*/

	@Test
	public void confirmtc_HasValueTOH_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_RecipeDetailPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

	@Test
	public void confirmtc_HasValueTOH_VideoHubPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data:
		String url=Constant.TOH_VideoHubPage+"?trkid=track0987&googfc";

		//Test Steps:
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);

		//Step:2 switch to iFrame
		globalPage.switchToFrame();

		//Step:3 Verify Amazon Header Bidder is Running
		globalPage.verifyKeyValueAttributesGoogfc(url, expectedKey);


	}

}