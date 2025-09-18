package test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
import pom.Obj_Rollsroyce;

public class Rollsroyce extends SetupBrowser{
	String url="https://www.rolls-royce.com";
	@Ignore // still error
	@Test
	public void Rolls_royce_mediaNavigation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		String eleInvestor= "//li[@id='nav-investors-level1' and @class='level1 haschildren']";
		driver.get(url );		
		driver.manage().window().maximize();
		// Click Accept All button
		Obj_Rollsroyce clk= new Obj_Rollsroyce(driver);
		clk.clickAcceptAll();  // CommonFunctions.Clickbutton(driver,acceptAll);
		CommonFunctions.waitImplicit(driver, 1000);		
		
		Actions action = new Actions(driver);		
		WebElement eleInv=driver.findElement(By.xpath(eleInvestor));
		action.moveToElement(eleInv).perform();
		Thread.sleep(3000);
		
		WebElement eleInv1 = driver.findElement(By.xpath("//a[contains(text(), 'Results, reports and presentations')]"));
		action.moveToElement(eleInv).click(eleInv1).click();

		Thread.sleep(3000);
	// Click presentation menu button
//		clk.clickreportpresent();
		
//		CommonFunctions.waitForElement(driver, reportpresent);

		CommonFunctions.waitImplicit(driver, 1000);
//		String fineResult="//a[@id='nav-financial-results-level3')]";
//		WebElement ele1=driver.findElement(By.xpath(fineResult));
//		ele1.click();
		
		
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 1000 pixels      
		CommonFunctions.waitImplicit(driver, 200);
  //      js.executeScript("window.scrollBy(200, 800)");
		
		// Click Year of Media
        clk.clickyear2022();
        Thread.sleep(200);
  //      clk.clickreportpresent();
        CommonFunctions.ScrollingPageSize(driver, 996);   //		CommonFunctions.Clickbutton(driver, year2022);		
//		CommonFunctions.waitForElement(driver, Presentele);
				
		// Take Screenshot of the page.
        CommonFunctions.Snap(driver, "Rollsroyce");		
			
	}
}
