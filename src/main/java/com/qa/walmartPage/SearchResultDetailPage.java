package com.qa.walmartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.walmartbase.CommonPage;

public class SearchResultDetailPage extends CommonPage {
	@FindBy(css=".prod-HeroImage-image")
	WebElement image;
	

	public SearchResultDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public boolean isImagePresent(){
	 return image.isDisplayed();
	 
 }


}
