package com.wp.wpqa_76_check_for_key_value_tc_SRD;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValue_tc_SRD extends Driver {
    //Initialize object using page factory method 
    ConfigFileReader configFileReader;
    public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

    @Test
    public void confirmTCValueIn_SRD_HomePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_HomePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    @Test
    public void confirmTCValueIn_SRD_Page() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String tc_url =Constant.SRD_Page+"?trkid=track0987&googfc";
          String expectedKey =ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    @Test
    public void confirmTCValueIn_SRD_HubPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_HubPage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    @Test
    public void confirmTCValueIn_SRD_ArticlePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_ArticlePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    @Test
    public void confirmTCValueIn_SRD_ListiclePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_ListiclePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
   /* @Test
    public void confirmTCValueIn_SRD_SlideshowPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_SlideshowPage+"?trkid=track0987&googfc";

        
          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }*/
    
    @Test
    public void confirmTCValueIn_SRD_RecipeDetailPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 25, 3);
          String tc_url=Constant.SRD_RecipeDetailPage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
   
}
