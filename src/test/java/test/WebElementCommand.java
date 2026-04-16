package test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class WebElementCommand extends BaseTest {
	public WebElementCommand() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	String field="";
	@Test(priority =1)
	public void fb_elementAttribute() {
	
		driver.get(pro1.getProperty("fburl"));
		WebElement we = driver.findElement(By.name("email"));
		Reporter.log("is emaild displayed or not=" + we.isDisplayed());
		Reporter.log("is Email enabled or not=" + we.isEnabled());

		List<WebElement> hiddenEle=driver.findElements(By.name("jazoest"));		
		if(hiddenEle.size() > 0) 
			Reporter.log("is hidden element displayed=" + hiddenEle.get(0).isDisplayed());
		else
			Reporter.log("Hidden element NOT present in DOM");	
	}
	
	@Test(priority =2)
	public void fb_ButtonAttribute() {
		// TODO Auto-generated method stub
		
		driver.get(pro1.getProperty("fburl"));

		WebElement we=driver.findElement(By.name("email"));
		field=we.getAttribute("placeholder");
		Reporter.log("Current URL=" + field);
				
		we=driver.findElement(By.partialLinkText("Instagram"));		
		field=we.getAttribute("title");
		Reporter.log("Tooltips of link=" + field);		
		we=driver.findElement(By.xpath("//div[@aria-label='Log in']"));	
		field=we.getText(); 
		Reporter.log("Login button name=" + field);
		//Reporter.log("Button font size=" + we.getCssValue("font-size"));
		Reporter.log("Button width=" + we.getCssValue("width"));	
		
		int fieldx = we.getLocation().x;
		int fieldy = we.getLocation().y;
		Reporter.log("Current URL=" + we.getLocation());
		Reporter.log(fieldx +"Co-ordinate of controls on page=" +  fieldy);	
		Reporter.log("Login size=" + we.getSize());
		Reporter.log(we.getSize().height +"Login button =" +  we.getSize().width);					
		field=we.getTagName(); 
		Reporter.log("TagName =" + field);
		// Click on Create new button
		CommonFunctions.waitForElementToClick(driver, "//span[contains(text(),'Create new account')]");
	
		

	}
	
	
}
