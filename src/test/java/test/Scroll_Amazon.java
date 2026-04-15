package test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class Scroll_Amazon extends SetupBrowser{
	
	
	@Test(priority = 1) 
	public void Amazon_product_scrolling() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://www.amazon.in");
		driver.findElement(By.partialLinkText("Bestsellers")).click();
		String todaydeal= "//a[contains(text(),'Deals')]";
		String classname="//a//span[@class='a-truncate-cut']";
		String strprod="//a[contains(@href, '/dp/')]";
		CommonFunctions.waitThread(300);

// Click Today deals link

		CommonFunctions.waitForElementToClick(driver,todaydeal);
		CommonFunctions.scrollpageamazon(driver);
				
        List<WebElement> productLinks = driver.findElements(By.xpath(strprod));
        System.out.println("Found " + productLinks.size() + " product links:");
        for (WebElement link : productLinks) {
        	String linkText = link.getText() ;
            String productUrl = link.getAttribute("href");
            if (productUrl != null && productUrl.contains("/dp/")) {
                Reporter.log(linkText +"--->" +productUrl);

            }
        }
        Reporter.log("Hello this is broken line");
		CommonFunctions.BrokenLinks(driver,classname);
	}
	
}