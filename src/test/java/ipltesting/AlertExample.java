package ipltesting;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Util.CommonFunctions;
public class AlertExample extends BaseTest{
@Test	
	public void alertDemo() throws AWTException{
	String alertstr="//button[contains(text(),'Prompt')]";
		AlertExample obj = new AlertExample();
		obj.setupBrowser("firefox", "https://the-internet.herokuapp.com/javascript_alerts");

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
//cancel or reset or close button or keyboard escape key
//driver.switchTo().alert().dismiss();
