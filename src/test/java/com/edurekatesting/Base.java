package com.edurekatesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {

	WebDriver driver;
	public String url="";
	public Properties pro1;
	public Properties pro2;
	
	public Base() throws Exception {
		
        String path = ".\\src\\test\\java\\Utilities\\config.properties";
        pro1 = new Properties();
        File propFile = new File(".\\src\\test\\java\\Utilities\\config.properties"); // Corrected line

        try (FileInputStream fis = new FileInputStream(propFile)) {
            pro1.load(fis);
          //  System.out.println("Defult url=" + prop.getProperty("url"));
        } catch (IOException e) { // Catching a more specific exception
            e.printStackTrace();
            System.err.println("Error loading properties file: " + e.getMessage());
        }
        
		
		// locators properties file		
		FileInputStream fis2=new FileInputStream(".\\src\\test\\java\\Utilities\\locators.properties");
		pro2=new Properties();
		pro2.load(fis2);
    }
	public WebDriver intilizeBrowserAndOpenApplication(String browser) {
		if(browser.equalsIgnoreCase("chrome")) 
			{
	//		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chrome.exe");
			 // Create ChromeOptions and add incognito argument
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-extensions");
	        options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			
			}
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else {
			System.out.println("valid browser is not provided, hence quitting the automation run");
			System.exit(0);
		}
//		url=prop.getProperty("url");
		System.out.println("Browser launched and navigated to site=");	


		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
		return driver;
	}
	
	@AfterSuite
	public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("All Browser closed");
        }
	}   
	
}
