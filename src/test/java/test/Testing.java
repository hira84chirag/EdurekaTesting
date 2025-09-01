package test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.time.Duration;

public class Testing extends SetupBrowser {
	SetupBrowser bt;
	@Test
	public void OpenFacebook() {
		driver.get( "https://www.facebook.com/?");		
		String path = ("//input[@id='email']");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.xpath(path)).sendKeys("from Username changes");
		
	}

	@Test
	public void OpenAmazon() { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		driver.get( "https://www.amazon.in");
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		// wait page load time and select Best Sellers menu
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.partialLinkText("Best")).click();
		
		// wait page load time and select new Releases menu		
		driver.findElement(By.linkText("New Releases")).click();
		
	}	
}
