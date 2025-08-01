package ipltesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Util.CommonFunctions;

import java.util.List;

public class Dummy {

	@Test
    public void software() {
       // Set path to your ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

		        try {
		            // Load Amazon Deals page
		            String url = "http://amazon.in/deals?ref_=nav_cs_gb";
		            
		            driver.get(url);

		            // Wait for page to load (optional: add WebDriverWait for stability)
		            Thread.sleep(5000); // Basic wait

		            // Find all product link elements
		            List<WebElement> productLinks = driver.findElements(By.xpath("//a[contains(@href, '/dp/')]"));

		            System.out.println("Found " + productLinks.size() + " product links:");
		            for (WebElement link : productLinks) {
		                String productUrl = link.getAttribute("href");
		                if (productUrl != null && productUrl.contains("/dp/")) {
		                    System.out.println(productUrl);
		                }
		                
		            }
		            CommonFunctions.scrollpage(driver,500);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		        //    driver.quit();
        }
    }
}
	
