package com.wp.wpqa_76_check_for_key_value_tc_BHC;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.ConfigFileReader;
import com.wp.genericLib.Constant;
import com.wp.genericLib.Driver;
import com.wp.genericLib.ExcelLibrary;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmKeyValue_tc_BHC extends Driver {
    //Initialize object using page factory method 
    ConfigFileReader configFileReader;
    public  Logger APPLICATION_LOGS = Logger.getLogger("AppLogger");

    @Test
    public void confirmTCValueIn_BHC_HomePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);
          String tc_url=Constant.BHC_HomePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    @Test
    public void confirmTCValueIn_BHC_Page() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String tc_url =Constant.BHC_Page+"?trkid=track0987&googfc";
          String expectedKey =ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    @Test
    public void confirmTCValueIn_BHC_HubPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String tc_url =Constant.BHC_HubPage+"?trkid=track0987&googfc";
          String expectedKey =ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    @Test
    public void confirmTCValueIn_BHC_ArticlePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);
          String tc_url=Constant.BHC_ArticlePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    @Test
    public void confirmTCValueIn_BHC_ListiclePage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);
          String tc_url=Constant.BHC_ListiclePage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
    
    /*@Test
    public void confirmTCValueIn_BHC_SlideshowPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);
          String tc_url=Constant.BHC_SlideshowPage+"?trkid=track0987&googfc";

        
          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }*/
    
    @Test
    public void confirmTCValueIn_BHC_RecipeDetailPage() throws Exception{
          //Object Initialization
          GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

          //Test Data:
          String expectedKey=ExcelLibrary.getExcelData("Key Value Attributes CA", 41, 3);
          String tc_url=Constant.BHC_RecipeDetailPage+"?trkid=track0987&googfc";

          //Test Steps:
          //Step:1 Navigate required URL
          globalPage.navigateToRequiredSite(tc_url);

          //Step:2 switch to iFrame
          globalPage.switchToFrame();

          //Step:3 Verify Key Value attribute present
          globalPage.verifyKeyValueAttributesGoogfc(tc_url, expectedKey);

    }
}
