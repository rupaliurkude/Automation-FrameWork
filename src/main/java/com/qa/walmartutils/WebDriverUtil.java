package com.qa.walmartutils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {
	//Factory Design Pattern	
	static Logger log = LogManager.getLogger(WebDriverUtil.class);
	public static WebDriver getDriver(String browsername){
		WebDriver driver =null;
		log.info("In get driver method - browser :"+browsername);
		try{
			
			switch(browsername){
				case "chrome":
				System.setProperty("webdriver.chrome.driver", "/Users/rupaliurkude/Software/chromedriver");
				driver =new ChromeDriver();
				break;
				
				case "firefox":
				System.setProperty("webdriver.gecko.driver", "/Users/rupaliurkude/Downloads/geckodriver");
				driver =new FirefoxDriver();
				break;		
			
				case "safari":
				driver =new SafariDriver();
				break;
				
				
				default :
				System.setProperty("webdriver.chrome.driver", "/Users/rupaliurkude/Software/chromedriver");
				driver =new ChromeDriver();
				break;
					
				}
			}catch(Exception e){
				System.out.println("There is an exception when creating WebDriver object");
				System.out.println(e.getStackTrace());
			}
			return driver;
		}
	}



