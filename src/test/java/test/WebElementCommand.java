package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

public class WebElementCommand extends SetupBrowser {

	// Code error needs to resolved
	
	String field,fieldx;
	//@Ignore
	//@Parameters({"browser,Fb"})
	@Test(priority =1)
	public void facebook_elementAction() {
	
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement we = driver.findElement(By.name("email"));
		Reporter.log("is emaild displayed or not=" + we.isDisplayed());
		Reporter.log("is Email enabled or not=" + we.isEnabled());

		List<WebElement> hiddenEle=driver.findElements(By.name("jazoest"));		
		if(hiddenEle.size() > 0) 
			Reporter.log("is hidden element displayed=" + hiddenEle.get(0).isDisplayed());
		else
			Reporter.log("Hidden element NOT present in DOM");	
		List<WebElement> c1= driver.findElements(By.xpath("//div[@role='none' and @data-visualcompletion='ignore']"));		
		c1.get(2).click();
		
		WebElement malerradiobutton=driver.findElement(By.xpath("//span[contains(text(),'Select your gender')]"));
		malerradiobutton.click();
		Reporter.log("Before clcking- is the male radio button selected=" +malerradiobutton.isSelected());
	}
	
	@Test(priority =1)
	public void facebook_ButtonAttribute() {
		// TODO Auto-generated method stub
		
		driver.get("https://www.facebook.com");

		WebElement we=driver.findElement(By.name("email"));
		field=we.getAttribute("placeholder");
		Reporter.log("Current URL=" + field);
				
		we=driver.findElement(By.partialLinkText("Instagram"));		
		field=we.getAttribute("title");
		Reporter.log("Tooltips of link=" + field);		
		we=driver.findElement(By.xpath("//div[@aria-label='Log in']"));	
		field=we.getText(); 
		Reporter.log("Login button name=" + field);
		Reporter.log("Button font size=" + we.getCssValue("font-size"));
		Reporter.log("Button width=" + we.getCssValue("width"));	
		
		int fieldx = we.getLocation().x;
		int fieldy = we.getLocation().y;
		Reporter.log("Current URL=" + we.getLocation());
		Reporter.log(fieldx +"Co-ordinate of controls on page=" +  fieldy);	
		Reporter.log("Login size=" + we.getSize());
		Reporter.log(we.getSize().height +"Login button =" +  we.getSize().width);	
				
		//we=driver.findElement(By.xpath("//h2[@class='_8eso']"));	
		
		//field=we.getText(); 
		//Reporter.log("Welcome Message: =" + field);
		field=we.getTagName(); 
		Reporter.log("TagName =" + field);
					
	}
	
	
}
