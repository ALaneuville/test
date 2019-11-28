package com.wp.timeouttests;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.wp.genericLib.Constant;

public class TimeoutFactory {

	@Test
	@Factory
	public Object[] runTests() {

		List<PageObject> pages = getTestPages("?showads=1");
		
		//***BROWSERS
		List<String> browsers = new LinkedList<String>();
		browsers.add("chrome");

		
		//***SEARCH STRINGS
		List<LoadTimeItem> searchItems = new LinkedList<LoadTimeItem>();

		searchItems.add(new LoadTimeItem("JW Player", 1500));
		searchItems.add(new LoadTimeItem("Amazon A9", 1500));
		searchItems.add(new LoadTimeItem("Bounce Exchange", 1000));
		
		//If JW appears, SpotX doesn't, and if SpotX appears, JW doesn't. So the test will check this condition.
		searchItems.add(new LoadTimeItem("SpotX", 1500));
		
		//No longer ad partners
		searchItems.add(new LoadTimeItem("EMX", 1500));
		searchItems.add(new LoadTimeItem("Telaria", 1500));
		
		// ***TESTS***
		List<LoadTimeTest> tests = new LinkedList<LoadTimeTest>();

		// creates every combination of URLs and browsers
		for (PageObject page : pages) {
			for (String browser : browsers) {
				for (LoadTimeItem item : searchItems) {
					tests.add(new LoadTimeTest(page, browser, this, item));
				}
			}
		}
		
		//This predicate will be TRUE for every test in the resulting tests list 
		Predicate<? super LoadTimeTest> pred = test -> 
		(isVideoPage(test) || test.getSearchString().contains("Bounce Exchange"));
			
		tests = tests.stream().filter(pred).collect(Collectors.toList());

		System.out.println("Running " + tests.size() + " tests.");
		return tests.toArray();
	}
	
	/**
	 * Returns a list of PageObjects for tests to be run on, the URLs of these PageObjects end in the passed string.
	 * @param ending the string to be appended to the end of the URLs
	 * @return a list of PageObjects for tests to be run on
	 */
	private List<PageObject> getTestPages(String ending) {
		
		// ***PAGES***
		List<PageObject> pages = new LinkedList<PageObject>();
		
		//use templates with videos
		
		//Leave homepages for specific sites for redesign
		//Article and Listicle
		//TOH: Recipe
		//FHM: Project
		//CPT: Project
		//pages.add(new HomePage(Constant.TOH_HomePage));
		//pages.add(new AboutPage(Constant.TOH_Page));
		//pages.add(new HubPage(Constant.TOH_HubPage));
		pages.add(new ArticlePage(Constant.TOH_ArticlePage));
		pages.add(new ListiclePage(Constant.TOH_ListiclePage));
		//pages.add(new SlideshowPage(Constant.TOH_SlideshowPage));
		pages.add(new RecipePage(Constant.TOH_RecipeDetailPage));
		//pages.add(new VideoHubPage(Constant.TOH_VideoHubPage));
		
		//RD 
		//pages.add(new HomePage(Constant.RD_HomePage)); 
		//pages.add(new AboutPage(Constant.RD_Page)); 
		//pages.add(new HubPage(Constant.RD_HubPage));
		pages.add(new ArticlePage(Constant.RD_ArticlePage)); 
		pages.add(new ListiclePage(Constant.RD_ListiclePage)); 
		//pages.add(new SlideshowPage(Constant.RD_SlideshowPage)); 
		//pages.add(new VideoHubPage(Constant.RD_VideoHubPage)); 
		//pages.add(new JokeHubPage(Constant.RD_JokeHubPage));
				
		//FHM 
		//pages.add(new HomePage(Constant.FHM_HomePage)); 
		//pages.add(new ContactPage(Constant.FHM_Page));
		//pages.add(new HubPage(Constant.FHM_HubPage)); 
		pages.add(new ArticlePage(Constant.FHM_Page)); 
		pages.add(new ListiclePage(Constant.FHM_ListiclePage));
		pages.add(new ProjectDetailPage(Constant.FHM_ProjectDetailPage));
		//pages.add(new SlideshowPage(Constant.FHM_SlideshowPage)); 
		//pages.add(new VideoHubPage(Constant.FHM_VideoHubPage));

		
		for (PageObject page : pages)
			page.setUrl(page.getUrl() + ending);
		
		return pages;
	}
	
	/**
	 * Returns whether the passed test is on a page that includes videos from JW Player
	 * @param test the test in question
	 * @return true if this test is on a page containing a video from JW, false otherwise.
	 */
	private boolean isVideoPage(LoadTimeTest test) {
		String template = test.getTemplate();
		return template.contains("article") || template.contains("listicle") || template.contains("page") || template.contains("project detail") || template.contains("recipe");
	}
}
