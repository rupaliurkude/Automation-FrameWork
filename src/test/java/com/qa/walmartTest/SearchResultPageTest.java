package com.qa.walmartTest;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.walmartPage.HomePage;
import com.qa.walmartPage.SearchResultPage;
import com.qa.walmartbase.BaseTest;


public class SearchResultPageTest extends BaseTest {
	HomePage hm;
	SearchResultPage sp;
	
	@Test//(groups="smoke")
	public void clickSearchResultTest(){
		hm = new HomePage(driver);
		sp = hm.search("Laptop");
		Assert.assertTrue(sp.clickSearchResult(0).getTitle().contains("Laptop"));
	}
	
}
