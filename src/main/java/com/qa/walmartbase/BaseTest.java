package com.qa.walmartbase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qa.walmartutils.ConfigUtils;
import com.qa.walmartutils.Constants;
import com.qa.walmartutils.ScreenshotUtils;
import com.qa.walmartutils.WebDriverUtil;

public class BaseTest {
	
	protected WebDriver driver;
	protected static String url;
	protected static String browser;
	static Logger log;
	@BeforeSuite//(alwaysRun=true)
	public void beforeSuite(){
		 LogManager.getLogger(BaseTest.class);
		ConfigUtils configUtils = new ConfigUtils(Constants.RESOURCES_PATH+"config.properties");
		url=configUtils.getProperty("stageUrl");
		browser=configUtils.getProperty("browser");
	}
	
	@BeforeMethod//(alwaysRun=true)
	public void beforeMethod(){
		driver = WebDriverUtil.getDriver(browser);
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@AfterMethod//(alwaysRun=true)
	public void afterMethod(ITestResult rs){
		log.info("rs test case name after every method:"+ rs.getName());		
		if(ITestResult.FAILURE==rs.getStatus()){
			ScreenshotUtils.takeScreenShot(rs.getName(), driver);
		}
		driver.quit();
	}
}
