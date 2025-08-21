package Live_testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class StaleElement_Exp extends BaseBrowser{
	
@Test
public void waitExample() throws InterruptedException  {
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito");
     		WebDriver driver = new ChromeDriver(options);      
     	// Open the webpage
     	
        	driver.get("https://www.google.fr/");
        	driver.manage().window().maximize();
        try {
        	// Create an explicit wait
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         	WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name='q']")));        	
         // Perform the action on the element when page is loading 
         //	driver.navigate().refresh();
         // Enter Selenium keyword to search	
            ele.sendKeys("AL tools"+ Keys.ENTER);
            System.out.println("Search text entered successfully.");

     } catch (StaleElementReferenceException e) {
    	 
         // Element became stale, handle accordingly
            System.out.println("StaleElementException occurred. Refreshing the page.");
         // Re-locate the element after page refresh
	        WebElement refreshedEle = driver.findElement(By.cssSelector("textarea[name='q']"));
	        refreshedEle.sendKeys("Selenium"+ Keys.ENTER);
	        System.out.println("Search text entered successfully after page refresh.");	        
     }  
        
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element=driver.findElement(By.xpath("//h3[contains(text(),'Google AI')]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        
     // Get search results
        List<WebElement> results = driver.findElements(By.cssSelector("div.g"));

        // Print result titles and links
        for (WebElement result : results) {
            try {
                WebElement title = result.findElement(By.tagName("h3"));
                WebElement link = result.findElement(By.tagName("a"));
                System.out.println("Title: " + title.getText());
                System.out.println("Link: " + link.getAttribute("href"));
                System.out.println();
            } catch (Exception e) {
                // Skip non-standard results (like ads or news boxes)
            }
        	driver.quit();}
	}

}