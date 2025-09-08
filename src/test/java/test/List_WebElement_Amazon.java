package test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

public class List_WebElement_Amazon extends SetupBrowser{
//	List_WebElement_Amazon obj;
	@Test(priority = 1) 
	public void Amazon_locatoramazon()
	{
		driver.get("https://www.amazon.in");
		CommonFunctions.waitImplicit(driver, 100);		
		driver.findElement(By.partialLinkText("Best")).click();		
	}
	@Test(priority = 2) 
	public void Amazon_product_scrolling() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String dealpath= "//a[contains(text(),'Today')]";
		String classname="//a//span[@class='a-truncate-cut']";
		String strprod="//a[contains(@href, '/dp/')]";
		CommonFunctions.waitThread(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
// Click Today deals link		
		CommonFunctions.waitForElement(driver,dealpath);
		CommonFunctions.scrollpageamazon(driver);
				
        List<WebElement> productLinks = driver.findElements(By.xpath(strprod));
        System.out.println("Found " + productLinks.size() + " product links:");
        for (WebElement link : productLinks) {
        	String linkText = link.getText() ;
            String productUrl = link.getAttribute("href");
            if (productUrl != null && productUrl.contains("/dp/")) {
                System.out.println(linkText +"--->" +productUrl);
            }
        }
		int i=0;
		List<WebElement> products=driver.findElements(By.xpath(classname)); 			
		for (WebElement product : products) {
            String linkText = product.getText() ; //.getAttribute("value");
            String url = product.getAttribute("href"); // element.getAttribute("value"); 
            
//            if (!linkText.isEmpty()) {
               // System.out.println("Text: " + linkText ); // + " - Link: " + href
               System.out.println("Text: "+i +"--"+ linkText + " - Link: " + url);
                i++;
 //           }    		 
        }
	        System.out.println("Total links=" + i);
//	        driver.close();
	}
	

	
}