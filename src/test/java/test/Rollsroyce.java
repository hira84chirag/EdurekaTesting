package test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;
import pom.Obj_Rollsroyce;

public class Rollsroyce extends BaseTest{
	public Rollsroyce() throws Exception {
		super();
	}
	@Test
	public void Rolls_royce_media() throws Exception {
	
		String eleInvestor= pro2.getProperty("investor");
		driver.get(pro1.getProperty("rolls") );		
		// Click Accept All button
		Obj_Rollsroyce clk= new Obj_Rollsroyce(driver);
		clk.clickAcceptAll();  // CommonFunctions.Clickbutton(driver,acceptAll);
		CommonFunctions.waitImplicit(driver, 500);		
		
		Actions action = new Actions(driver);		
		WebElement eleInv=driver.findElement(By.xpath(eleInvestor));
		action.moveToElement(eleInv).perform();
		// Click presentation menu button
		clk.clickreportpresent();
		CommonFunctions.waitImplicit(driver, 200);
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 1000 pixels      
		CommonFunctions.waitImplicit(driver, 200);
		  Thread.sleep(200);
		// Click Year of Media
        clk.clickyear2022();
      
  //      clk.clickreportpresent();
        CommonFunctions.ScrollingPageSize(driver, 996);   //		CommonFunctions.Clickbutton(driver, year2022);		
				
		// Take Screenshot of the page.
        CommonFunctions.Snap(driver, "Rollsroyce");		
			
	}
}
