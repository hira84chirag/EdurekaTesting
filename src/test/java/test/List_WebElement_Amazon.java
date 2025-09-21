package test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		By id= By.xpath(contbtn);
		boolean btn=CommonFunctions.isElementPresent(driver,id);
		if(btn==true) driver.findElement(id).click(); 
	//	CommonFunctions.findHiddenElement(driver, contbtn,null);
		
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