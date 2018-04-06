package com.qa.walmartPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.walmartbase.CommonPage;

public class HomePage extends CommonPage  {
	//page factory design	
	@FindBy(css ="#global-search-input" )
	WebElement searchBox;
	@FindBy(css =".header-GlobalSearch-submit.btn")
	WebElement searchButton;
	
	@FindBy(css="[id*='HomePage-contentZone12-FeaturedCategoriesCuratedV2-tileLink']")
	List<WebElement>imagesList;
	
	@FindBy(css=".ClickThroughImage")
	List<WebElement>sliderSlide;
	//Page classes are dependent on driver object and we need to inject driver to all page classes -Dependency Injection
	//Dependency injection using Constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public SearchResultPage search(String searchdata){
		searchBox.sendKeys(searchdata);
		searchButton.click();
		return new SearchResultPage(driver);
	}
	public int imagesList(){
		return imagesList.size();
	}
	

	public int sliderImages(){
		return sliderSlide.size();
	}
}

