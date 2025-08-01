package basic;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Util.CommonFunctions;
import java.net.HttpURLConnection;
import java.net.URI;
import java.time.Duration;

public class Flipkart extends BaseTest{
	@Test
	public void software() throws InterruptedException  {
		// TODO Auto-generated method stub
		String path="";
		
		//BaseTest bt = new BaseTest();
		//bt.setupBrowser("chrome", "https://www.flipkart.com/?");
		ChromeDriver driver=new ChromeDriver();

		driver.manage().deleteAllCookies();		
		driver.navigate().to("https://www.flipkart.com/?");
		CommonFunctions.waitImplicit(driver,100);
		driver.manage().window().maximize();
		CommonFunctions.waitImplicit(driver,100);

		
		String xpath= "//span[@class='_1XjE3T']";
//		String xpath= "//div[@class='_3sdu8W emupdz']/a";
		int i=0;
		List<WebElement> seeofferchild=driver.findElements(By.xpath(xpath)); 	
		
		for (WebElement element : seeofferchild) {
			WebElement pElement = element.findElement(By.tagName("span"));
			 
		//	String sp=pElement.getText();
		//	System.out.println(sp);
			
			  String linkText = pElement.getAttribute("innerText"); 
			  String href = pElement.getAttribute("href"); // element.getAttribute("value");
			 		  
			   if (!linkText.isEmpty()) { 
				   System.out.println("Text: " + linkText + " - Link: " + href); 				   
			   }			  
//			  System.out.println("Text: "+i + linkText + " - Link: " + href); 
			  
			  i++; 
			  
			  // }
			  }
	        System.out.println("Total links=" + i);
	        
	        String xpath1="//img[@class='_2puWtW _3a3qyb' and @alt='Fashion']";
	     // Locate the element you want to hover over
	        WebElement elementToHover = driver.findElement(By.xpath(xpath1)); 
	   
	        // Create an Actions object
	        Actions actions = new Actions(driver);

	        // Perform the mouse hover action
	        actions.moveToElement(elementToHover).perform();
	        CommonFunctions.ScreenShot(driver, "Flipkart");		        
			driver.quit();
	}
}



// like clicking on a submenu item that appears.
//        WebElement subMenuItem = driver.findElement(By.linkText("Men's Top Wear"));
//       actions.click(subMenuItem).perform();

//Click see offer link button
		/*
		 * path="//div[@class='_2GaeWJ']"; WebElement
		 * parent=driver.findElement(By.xpath(path));
		 */		
		
		  // Click next button 
//		path="//a[@id='a-autoid-1']//i[@class='a-icon a-icon-next']"; 
		
	//	WebElement seeofferpage=driver.findElement(By.xpath(path)); 
		
//		String path1="//div[@class='_offer-faceout-carousel-card_style_badgeContainer__1IyV0']/span[@class='a-size-small _offer-faceout-carousel-card_style_savingsBadge__1spPe']";			
		
//		$x("//span[@class='a-truncate a-size-base-plus']/span[@class='a-truncate-full a-offscreen']")	
//		String path1="//span[@class='a-truncate a-size-base-plus']/span[@class='a-truncate-full a-offscreen']";	
