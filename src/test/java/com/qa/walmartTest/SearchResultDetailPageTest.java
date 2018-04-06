package com.qa.walmartTest;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.walmartPage.HomePage;
import com.qa.walmartPage.SearchResultDetailPage;
import com.qa.walmartPage.SearchResultPage;
import com.qa.walmartbase.BaseTest;


public class SearchResultDetailPageTest extends BaseTest {
	
	HomePage hm;
	SearchResultPage sp;
	SearchResultDetailPage sdp;
	
	@Test
	public void imagePresentTest(){
		hm = new HomePage(driver);
		sp = hm.search("Laptop");
		sdp = sp.clickSearchResult(0);
		Assert.assertTrue(sdp.isImagePresent());
	} 

}