package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowser {
	
	private static WebDriver driver;
	
	public void openBrowser(String Browser,String url) {
		Browser="Chrome";
		 // Create ChromeOptions and add incognito argument
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        // Create chrome driver object
		driver=new ChromeDriver(options);
		driver.get(url);		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void QuitBrowser() {
		driver.quit();
	}

}
