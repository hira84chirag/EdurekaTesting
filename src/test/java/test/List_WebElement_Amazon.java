package test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class List_WebElement_Amazon extends SetupBrowser{
//	List_WebElement_Amazon obj;
	@Test(priority = 1) 
	public void Amazon_locatoramazon()
	{
		driver.get("https://www.amazon.in");
		CommonFunctions.waitImplicit(driver, 100);	
		String contbtn=	"//button[@alt='Continue shopping']";
		CommonFunctions.findHiddenElement(driver, contbtn,null);
		
		driver.findElement(By.partialLinkText("Best")).click();		
	}
	@Test(priority = 2) 
	public void Amazon_product_scrolling() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String todaydeal= "//a[contains(text(),'Deals')]";
		String classname="//a//span[@class='a-truncate-cut']";
		String strprod="//a[contains(@href, '/dp/')]";
		CommonFunctions.waitThread(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
// Click Today deals link

		CommonFunctions.waitForElement(driver,todaydeal);
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
		List<WebElement> products=driver.findElements(By.xpath(classname)); 			
		for (WebElement product : products) {
            String linkText = product.getText() ; //.getAttribute("value");
            String url = product.getAttribute("href"); // element.getAttribute("value"); 
            int count=0;
            if (url != null && !url.isEmpty()) {
           	 if (count <5) {
           	 try {
    	            URL urltest = new URL(url);
    	            HttpURLConnection httpURLConnect = (HttpURLConnection) urltest.openConnection();
    	            httpURLConnect.setConnectTimeout(3000);
    	            httpURLConnect.connect();
    	            int responseCode = httpURLConnect.getResponseCode();
                	
                		if (httpURLConnect.getResponseCode() >= 400) {            	
    	            	Reporter.log(" HTTP status code: "+responseCode+"=" + httpURLConnect.getResponseMessage());
    	            	Reporter.log(url + " is a broken link.");
    	            	count++;
    	            	} else {
    	            	Reporter.log("URL :" + url );
    	            	}
                	
    	        } catch (Exception e) {
    	            // This catch block handles exceptions like MalformedURLException or IOExceptions
    	        	Reporter.log(url + " is a broken link due to an exception: " + e.getMessage());
    	        }
           	 }else {
           		 break;
           	 }
           	 
            }
            
			/*
			 * if (!linkText.isEmpty()) { // System.out.println("Text: " + linkText ); // +
			 * " - Link: " + href Reporter.log("Text: "+"--"+ linkText + " - Link: " + url);
			 * 
			 * }
			 */	 
        }
	        System.out.println("Total links=" + products.size());
//	        driver.close();
	}
	
}