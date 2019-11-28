/**
 * @author Andrew Truett
 */

package com.wp.wpqa_130_verify_jwplayer_loads_under_timeout;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wp.genericLib.Driver;
import com.wp.pageObjectRepo.GlobalFunctions;

public class ConfirmJWPlayerLoadTime extends Driver {
	
	@BeforeClass
    public void navigateToRequiredURL() throws Exception{
		//Object Initialization
        GlobalFunctions globalPage=PageFactory.initElements(driver, GlobalFunctions.class);

        //Step:1 Navigate required URL
        String url="";
        globalPage.navigateToRequiredSite(url);
    }
	
	@Test
	public void verifyAmazonAdsLoad1000ms() {
		
        List<String> failedUrls = new ArrayList<String>();
        
        final String SEARCH_STRING = "jw-player.js";
        final int MAX_LOAD_TIME = 1500; 
        final String SHEET_NAME = "WordpressURLs";
        final String COLUMN_NAME = "STAGING URL";
        final int PAGE_WAIT_TIME = 1;
        
        

	}
	

}
