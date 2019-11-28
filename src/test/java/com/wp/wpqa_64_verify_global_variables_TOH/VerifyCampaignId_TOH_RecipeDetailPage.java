package com.wp.wpqa_64_verify_global_variables_TOH;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyCampaignId_TOH_RecipeDetailPage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	//Test Data
	String url=Constant.TOH_RecipeDetail_CampaignId;

	@Test
	public void verifyCampaignIdIsPresent_TOH_RecipeDetailPage() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);
		
		//Step 2 Verify Amazon Header Bidder is Running
		globalPage.verifyCampaignIdInPageSource(url);
	}


}
