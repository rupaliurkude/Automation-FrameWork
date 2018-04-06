package com.qa.walmartTest;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import com.qa.walmartPage.HomePage;
import com.qa.walmartPage.SearchResultPage;
import com.qa.walmartbase.BaseTest;
import com.qa.walmartutils.ExcelHelper;


public class HomePageTest extends  BaseTest {
HomePage hm;
	
	/*@Test
	@DataProvider(name="searchData")
	public Object[][] testData(){
		return ExcelHelper.getExcelData("HomePage-Data.xlsx", "Sheet1");
	}
	
	@Test(dataProvider="searchData")//(groups={"smoke"})
	public void searchTest(String searchKeyWord, String expected){	
		hm = new HomePage(driver);
		SearchResultPage sp= hm.search(searchKeyWord);
		Assert.assertEquals(expected, sp.getTitle());
	}*/
	
	@Test//(groups={"smoke"})
	public void headerNavLinksTest(){
		hm = new HomePage(driver);
		Assert.assertEquals(5,hm.headerNavLinks());	
	}
	
	@Test(priority=1)//(groups={"regression"})
	public void sliderImagesTest(){
		hm = new HomePage(driver);
		Assert.assertEquals(5, hm.sliderImages());
	}
	
}

