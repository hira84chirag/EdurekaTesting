package test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
public class AlertExample extends BaseTest{
@Test	
	public void InternetSite_alertDemo() throws AWTException{
		String alertstr="//button[contains(text(),'Prompt')]";
		String url="https://the-internet.herokuapp.com/javascript_alerts";
		
		driver.get(url);
		WebElement alertBtn = driver.findElement(By.xpath(alertstr));
		alertBtn.click();
		
		//get the text
		driver.switchTo().alert().sendKeys("Software testing");
		String msg = driver.switchTo().alert().getText();
		System.out.println(msg);
		
		//ok or submit or accept
		driver.switchTo().alert().accept();
		CommonFunctions.WaitExpt(driver, alertstr);
		alertBtn.click();
		CommonFunctions.photo("AlertExample");
		driver.switchTo().alert().dismiss();
		driver.quit();
	}

}
