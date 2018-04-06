package com.qa.walmartbase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class  CommonPage{
	protected WebDriver driver;

	

	@FindBy(css ="#global-search-input" )
		WebElement searchBox;
	@FindBy(css =".header-GlobalSearch-submit.btn")
		WebElement searchButton;
	
	@FindBy(how=How.CSS,using="[id*='header-GlobalEyebrowNav-link']")
	List<WebElement> navLinks;
	
	@FindBy(css=".footer-GlobalFooterItems")
	List<WebElement>footerLinks;

	public CommonPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, CommonPage.class);	
	}
	
	
	public String getTitle(){
		return driver.getTitle();

	}
	public int headerNavLinks(){
		return navLinks.size();
	}

	public void headerModalDropDowns(){
		List<WebElement> elements = driver.findElements(By.cssSelector("[id*='header-GlobalEyebrowNav-button']"));
			Actions action = new Actions(driver);
				for(WebElement elm:elements){
					action.moveToElement(elm).perform();
					List<WebElement> elms = driver.findElements(By.cssSelector("[id*='header-GlobalEyebrowNav-button']"));
						for(WebElement elmt:elms){
							System.out.println(elmt.getText());
						}
				}
	}

	public int footerLinks(){
		return footerLinks.size();
		}

	}
	
	
	
	

	
	


