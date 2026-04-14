package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

import java.util.List;

public class Dummy extends BaseTest{
	public Dummy() throws Exception {
		setUp();
	}

	@Test
    public void Count_Product()  {
       // Set path to your ChromeDriver
        try {
            // Load Amazon Deals page
            String url = "http://amazon.in/deals?ref_=nav_cs_gb";   		            
            driver.get(url);
            // Wait for page to load (optional: add WebDriverWait for stability)
            Thread.sleep(5000); // Basic wait CommonFunctions.waitforelement(driver,"//input[@value='all' and @name='departments']");	
            // Find all product link elements
            
            List<WebElement> productLinks = driver.findElements(By.xpath("//a[contains(@href, '/dp/')]"));

            System.out.println("Found " + productLinks.size() + " product links:");
            for (WebElement link : productLinks) {
                String productUrl = link.getAttribute("href");
                if (productUrl != null && productUrl.contains("/dp/")) {
                    System.out.println(productUrl);
                }
                
            }
            CommonFunctions.scrollpage(driver,1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
	
