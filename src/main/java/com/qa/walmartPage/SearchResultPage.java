package com.qa.walmartPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.walmartbase.CommonPage;
import com.qa.walmartutils.WebDriverWaitsUtil;

public class SearchResultPage extends CommonPage{	
 
	
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
 
 @FindBy(css= ".chooser-option-current']")
 WebElement sortBox;
	
 @FindBy (css=".SearchInfoMessage")
 List<WebElement> sortDropDown;
 
 @FindBy(css=".product-title-link>span")
 List<WebElement>imageResult;
 
 @FindBy(css =".Price-characteristic")
 List<WebElement>prices;
 
 
 @FindBy(css=".product-title-link>span")
 List<WebElement>searchTitleLinks;
 
 public String selectValueFromSortDropDown(String value){
		WebDriverWaitsUtil.explicitWait(driver, 20, sortDropDown);
		sortBox.click();	
		for(WebElement val : sortDropDown){
			if(val.getText().equals(value)){
				val.click();
				break;
			}
		}
	
		prices= driver.findElements(By.cssSelector(".Price-characteristic"));
		
		return prices.get(0).getText();
	}
	
	public SearchResultDetailPage clickSearchResult(int index){
		searchTitleLinks.get(index).click();
		return new SearchResultDetailPage(driver);
	}
	public float findMax(List<WebElement> elements){

		float max=0;
		for(WebElement elm : elements){
				float price= Float.parseFloat(elm.getText().replaceAll("[^0-9].", ""));
				if(price>max){
					max=price;
				}
			}
			return max;
	}
	
}
 
  
