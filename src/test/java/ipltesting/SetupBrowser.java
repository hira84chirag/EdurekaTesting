package ipltesting;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupBrowser {
	public static WebDriver driver;
	
	public void browserOpen(String browser,String url) {
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--incognito"); 
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();			
		else {
			System.out.println("valid browser no provided,hence quitting the automation");	
			System.exit(0);
		}
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
			//driver.quit();
		// implicit wait ==>  at project Level
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	
	}
	public void navigatetourl(String url) {
		driver.get(url);
	}
	public void quit() {
		driver.quit();
	}
}
// implicit wait ==>  at pom Level
//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
// Scirpt load timeout ==>either in POM or in project Level.

/*
 * // WebDriver wd=new FirefoxDriver(); WebDriver wd=new EdgeDriver();
 */
