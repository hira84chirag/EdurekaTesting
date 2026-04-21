package test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class Scroll_Amazon extends BaseTest{
	
	
	public Scroll_Amazon() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	String todaydeal= "//a[contains(text(),'Deals')]";
	String classname="//a//span[@class='a-truncate-cut']";
	String strprod="//a[contains(@href, '/dp/')]";

	@Test(priority = 1) 
	public void Amazon_product_scrolling() throws Exception {
		// TODO Auto-generated method stub
		driver.get(pro1.getProperty("amazonin"));
		CommonFunctions.WaitExpt(driver, todaydeal);
		driver.findElement(By.partialLinkText("Bestsellers")).click();
		CommonFunctions.WaitExpt(driver, todaydeal);
// Click Today deals link
		CommonFunctions.waitForElementToClick(driver,todaydeal);
		CommonFunctions.scrollpageamazon(driver);
		CommonFunctions.BrokenLinks(driver,strprod);
		CommonFunctions.BrokenLinks(driver,classname);
	}
	
	@Test(priority = 2)
	public void Amazon_hiddenElement() { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		driver.get(pro1.getProperty("amazonin"));
		driver.manage().window().maximize();
		
		String contbtn=	"//button[@alt='Continue shopping']";
		CommonFunctions.findHiddenElement(driver, contbtn,null);
		
		// wait page load time and select Best Sellers menu
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.partialLinkText("Best")).click();
		
		// wait page load time and select new Releases menu		
		driver.findElement(By.linkText("New Releases")).click();		
	}	
	
	@Test
	public void Count_Product()  {
	       // Set path to your ChromeDriver
	        try {
	            driver.get(pro1.getProperty("amazonurl"));
	            String path="//a[contains(@href, '/dp/')]";
	            List<WebElement> productLinks = driver.findElements(By.xpath("//a[contains(@href, '/dp/')]"));
	            // Wait for page to load & Find all product link elements=
	            CommonFunctions.WaitExpt(driver, path);	
	            
	            System.out.println("Found " + productLinks.size() + " product links:");
	            for (WebElement link : productLinks) {
	                String productUrl = link.getAttribute("href");
	                if (productUrl != null && productUrl.contains("/dp/")) {
	                    Reporter.log(productUrl);
	                }
	                
	            }
	            CommonFunctions.scrollpage(driver,1000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           // driver.quit();
	        }
	}
	
}