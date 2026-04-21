package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
public class Example5_Alert extends BaseTest{
	public Example5_Alert() throws Exception{
		super();
	}
@Test	
	public void InternetURL_alertDemo() throws Exception{
		
		driver.get(pro1.getProperty("interneturl"));
		WebElement alertBtn = driver.findElement(By.xpath(pro2.getProperty("alertstr")));
		alertBtn.click();
		
		//Enter the text
		driver.switchTo().alert().sendKeys("Software testing");
		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);
		
		driver.switchTo().alert().accept();
		CommonFunctions.WaitExpt(driver, pro2.getProperty("alertstr"));
		alertBtn.click();
		CommonFunctions.Screenshots_ImageIO("AlertExample");
		driver.switchTo().alert().dismiss();
		driver.quit();
	}

}
