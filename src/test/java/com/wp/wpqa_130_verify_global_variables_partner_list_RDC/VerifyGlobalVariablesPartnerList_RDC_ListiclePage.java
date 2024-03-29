package com.wp.wpqa_130_verify_global_variables_partner_list_RDC;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class VerifyGlobalVariablesPartnerList_RDC_ListiclePage extends Driver {
	//Initialize object using page factory method 
	ConfigFileReader configFileReader;
	public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

	//Test Data
	String url=Constant.RDC_ListiclePage;

	@BeforeClass
	public void navigateToRequiredURL() throws Exception{
		//Object Initialization
		GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Step:1 Navigate required URL
		globalPage.navigateToRequiredSite(url);


	}
	@Test
	public void Verify_Nativo_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify Nativo_Global_Variable_PartnerList
		gfPage.Verify_Nativo_Global_Variable_PartnerList(url);

	}

	@Test
	public void Verify_Taboola_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data
		String siteID=ExcelLibrary.getExcelData("GlobalVariablesPartnerList", 40, 3);

		//Test Step
		//Step 2 Verify Taboola_Global_Variable_PartnerList
		gfPage.Verify_Taboola_Global_Variable_PartnerList(url, siteID);


	}

	@Test
	public void Verify_BounceExchange_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify BounceExchange_Global_Variable_PartnerList
		gfPage.Verify_BounceExchnage_Global_Variable_PartnerList(url);



	}

	@Test
	public void Verify_JWPlayer_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify_JWPlayer_Global_Variable_PartnerList
		gfPage.Verify_JWPlayer_Global_Variable_PartnerList(url);


	}

	@Test
	public void Verify_JWPlayer_Ad_Partners_Spotx_EMX_Telaria_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Data
		String spotxId=ExcelLibrary.getExcelData("GlobalVariablesPartnerList", 40, 4);
		String emxId=ExcelLibrary.getExcelData("GlobalVariablesPartnerList", 40, 5);
		String telariaId=ExcelLibrary.getExcelData("GlobalVariablesPartnerList",40, 6);

		//Test Step
		//Step 2 Verify_JWPlayer_Global_Variable_PartnerList
		gfPage.Verify_JWPlayer_Ad_Partners_Spotx_EMX_Telaria(url, spotxId, emxId, telariaId);


	}

	@Test
	public void Verify_Krux_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify_Krux_Global_Variable_PartnerList
		gfPage.Verify_Krux_Global_Variable_PartnerList(url);

	}

	/*@Test
	public void Verify_AdobeDTM_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify_AdobeDTM_Global_Variable_PartnerList
		gfPage.Verify_AdobeDTM_Global_Variable_PartnerList(url);

	}

	@Test
	public void Verify_Appnexus_Global_Variable_PartnerList_RDC_ListiclePage() throws IOException{
		//Object Initialization
		GlobalFunctions gfPage=PageFactory.initElements(driver, GlobalFunctions.class);

		//Test Step
		//Step 2 Verify_Appnexus_Global_Variable_PartnerList
		gfPage.Verify_Appnexus_Global_Variable_PartnerList(url);

	}*/


}
