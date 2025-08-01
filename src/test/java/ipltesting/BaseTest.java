package ipltesting;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
	
	static WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) 
			{
			
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
		
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
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
