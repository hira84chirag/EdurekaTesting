package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.edurekatesting.Base;

public class BaseTest extends Base {
		
	public static WebDriver driver;
	String browser="chrome", url="";
	
	public BaseTest() throws Exception {
		super();		
	}
	
	@BeforeClass
	public void setUp() {
		//loadPropertiesFile();	
		browser=pro1.getProperty("browser");
		driver=intilizeBrowserAndOpenApplication(browser);	
		//Thread.sleep(1000);
	}
	
	
	
	
	public void quit() {
		driver.quit();
	}

	@AfterClass
	 public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed");
	        }
	  }
}



/*
 * // object of ChromeOptions ChromeOptions opt = new ChromeOptions(); // adding
 * .crx extension
 * 
 * opt.addExtensions(new
 * File("C:\\Users\\Dell Enterprise\\eclipse-workspace\\Training\\src\\test\\Resources\\SeleniumIDE.crx"
 * )); // Initiate the Webdriver // WebDriver driver = new ChromeDriver(opt);
 * 
 * // disable information bar opt.setExperimentalOption("excludeSwitches",
 * Collections.singletonList("enable-automation"));
 * 
 */		    
