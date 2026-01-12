package test;

import org.testng.annotations.Test;

import Utilities.CommonFunctions;

import org.openqa.selenium.By;
import java.time.Duration;

public class Testing extends SetupBrowser {

	@Test
	public void Amazon_hiddenElement() { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		driver.get( "https://www.amazon.in");
		driver.manage().window().maximize();
		
		String contbtn=	"//button[@alt='Continue shopping']";
		CommonFunctions.findHiddenElement(driver, contbtn,null);
		
		// wait page load time and select Best Sellers menu
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.partialLinkText("Best")).click();
		
		// wait page load time and select new Releases menu		
		driver.findElement(By.linkText("New Releases")).click();
		
	}	
}
