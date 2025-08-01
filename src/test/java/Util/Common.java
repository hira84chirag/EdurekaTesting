package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
// import org.openqa.selenium.support.PageFactory;

public class Common {
	
	WebDriver driver;
	
	public Common(WebDriver driver) {
		this.driver=driver;	
	}
		
	public static void countLinks(WebDriver driver,String xpath) {	
	
		List <WebElement> links =  driver.findElements(By.xpath(xpath));
	//	 List<WebElement> links = driver.findElements(By.xpath("//img[@class='_46-i img']")); 
       
		 int i=0;
		 for (WebElement element : links) {
             String linkText = element.getText();
             String href = element.getAttribute("href");

             if (href != null && !href.isEmpty()) {
            	 Reporter.log("Text: " + linkText + " - Link: " + href);
                 i++;
             }
    		 
         }
		 Reporter.log("Total links=" + i);
	      //  obj.quiteBrowser();
			driver.findElement(By.xpath("//a[starts-with(text(),'Sign')]")).click();
			
	}

	public void countclass(WebDriver driver,String classname) {	
		List <WebElement> links =  driver.findElements(By.className(classname));
	//	 List<WebElement> links = driver.findElements(By.xpath("//img[@class='_46-i img']")); 
       
		 int i=0;
		 for (WebElement element : links) {
             String linkText = element.getText();
             String href = element.getAttribute("href");

             if (href != null && !href.isEmpty()) {
                 Reporter.log("Text: " + linkText + " - Link: " + href);
                 i++;
             }
    		 
         }
		 Reporter.log("Total links=" + i);
	      //  obj.quiteBrowser();

	}

	
}