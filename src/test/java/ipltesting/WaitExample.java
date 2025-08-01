package ipltesting;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitExample extends SetupBrowser{
	
	@Test 
	public void explitcitWaitExample() {
		
		WaitExample obj=new WaitExample();
		obj.browserOpen("chrome", "https://www.facebook.com");
		//	obj.explitcitWaitExample();
		WebElement email = driver.findElement(By.id("email"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		email.sendKeys("Testing of email address");				
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		WebElement pass= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pass"))));
	
		pass.sendKeys("entered passworking test");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
		WebElement hiddenEle=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("jazoest"))));
		hiddenEle.sendKeys("Chromebook");
		}
		catch(NoSuchElementException e) {
			System.out.println("------------------Customer message Print-----------");
			System.out.println(e.getMessage());
		}

		obj.fluentWaitExample();
		driver.quit();
	}	
	public void fluentWaitExample() {
		
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);		
		WebElement pass= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pass"))));
		pass.sendKeys("Testing of email address");	
		driver.quit();
	}
			
	
	
}

/*

Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))        // Maximum wait time
		  .pollingEvery(Duration.ofSeconds(5))        // Polling interval
		  .ignoring(NoSuchElementException.class);    // Ignored exceptions

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
*/
