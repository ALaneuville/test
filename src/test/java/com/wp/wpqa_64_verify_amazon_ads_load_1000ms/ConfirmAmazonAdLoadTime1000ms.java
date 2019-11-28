/**
 * @author Andrew Truett
 */

package com.wp.wpqa_64_verify_amazon_ads_load_1000ms;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ConfirmAmazonAdLoadTime1000ms {
	
	@Test
	public void verifyAmazonAdsLoad1000ms() {
		
        List<String> outputLines = new ArrayList<String>();
        List<String> errorLines = new ArrayList<String>();
        
        List<String> failedUrls = new ArrayList<String>();
        
        final String SEARCH_STRING = "Got response for slots";
        final int MAX_LOAD_TIME = 1000; 
        final String SHEET_NAME = "WordpressURLs";
        final String COLUMN_NAME = "STAGING URL";
        
        //Set python path
        String pythonPath;
        if(System.getProperty("os.name").toLowerCase().contains("windows"))
        	pythonPath = "D:/Deployment/Python/python.exe";
        else
        	pythonPath = Paths.get("/usr", "local", "bin", "python3").toString();
        	
   
		try {
			Process p = Runtime.getRuntime().exec(new String[] { 
					pythonPath, "src/main/java/com/wp/pythonScripts/consoleReader.py", 
					"-DC", "-string", SEARCH_STRING, "-limit", Integer.toString(MAX_LOAD_TIME), "-sheet", SHEET_NAME, "-column", COLUMN_NAME
			});
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));


	        String s;
	        // read the output from the command
	        while ((s = stdInput.readLine()) != null) 
	            outputLines.add(s);
	        	          
	        // read any errors from the attempted command
	        while ((s = stdError.readLine()) != null) 
	            errorLines.add(s);

	        printOutput(outputLines);
	        
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Determine test results
		assertTrue(errorLines.isEmpty(), "Python exception has occured: " + errorLines);
        assertTrue(outputLines.size() % 4 == 0, "Error with Python script output");
        
        //Check for failed test cases
        for(int i = 0; i < outputLines.size(); i+=4) {
        	/*
			outputLines.get(i); //Test #
			outputLines.get(i+1); //URL: <url>
			outputLines.get(i+2); //Passed: <test result>
			outputLines.get(i+3); //Notes: <notes>
			*/
        	String testResult = outputLines.get(i+2).split(":")[1].toLowerCase();
        	
        	if(!testResult.contains("true")) 
        		failedUrls.add(outputLines.get(i+1));
        	
        }
        	
        /*
        System.out.println("====================");
        System.out.println("TEST SUMMARY");
        System.out.println("TESTS PASSED: " + passed);
        System.out.println("TESTS FAILED: " + failed);
        System.out.println("Execution time: " + elapsedTime + "s");
        System.out.println("====================");
        */
        
        assertTrue(failedUrls.isEmpty(), "Failed URLs: " + failedUrls);
		
	}
	
	private void printOutput(List<String> lines) {
		for(String line : lines) {
			System.out.println(line);
		}
	}

}
