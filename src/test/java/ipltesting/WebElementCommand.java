package ipltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Util.CommonFunctions;

public class WebElementCommand extends SetupBrowser {

	String field,fieldx;
	@Test(priority =0)
	public void AletExample() throws InterruptedException {		
		WebElementCommand bc=new WebElementCommand();
		bc.browserOpen("chrome", "https://the-internet.herokuapp.com/javascript_alerts");
		WebElement aletbutn = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
		aletbutn.click();
		String msg=driver.switchTo().alert().getText();
		Reporter.log(msg);	
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
	}
	
	
//	@Parameters({"browser,Fb"})
	@Test(priority =1)
	public void elementAction() {
		WebElementCommand bc=new WebElementCommand();
		bc.browserOpen("chrome","");
		driver.get("https://www.facebook.com");
		WebElement we = driver.findElement(By.id("email"));
		Reporter.log("is emaild displayed or not=" + we.isDisplayed());
		Reporter.log("is Email enabled or not=" + we.isEnabled());

		WebElement hiddenElem=driver.findElement(By.name("jazoest"));		
		Reporter.log("is hidden element displayed=" + hiddenElem.isDisplayed());
		
		driver.findElement(By.partialLinkText("Sign")).click();
		WebElement malerradiobutton=driver.findElement(By.xpath("//input[@type='radio' and @value=2]"));
		Reporter.log("Before clcking- is the male radio button selected=" +malerradiobutton.isSelected());
		malerradiobutton.click();				
		Reporter.log("After clcking- is the male radio button selected=" + malerradiobutton.isSelected());
	
	}
	
	@Test(priority =2)
	public void ButtonAttribute() {
		// TODO Auto-generated method stub
		
		WebElementCommand bc=new WebElementCommand();
		bc.browserOpen("chrome","https://www.facebook.com");
	//	driver.get("https://www.facebook.com");
		WebElement we=driver.findElement(By.id("email"));
		field=we.getAttribute("placeholder");
		Reporter.log("Current URL=" + field);
				
		we=driver.findElement(By.partialLinkText("Instagram"));		
		field=we.getAttribute("title");
		Reporter.log("Tooltips of link=" + field);		
		we=driver.findElement(By.tagName("Button"));	
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
				
		we=driver.findElement(By.xpath("//h2[@class='_8eso']"));	
		field=we.getText(); 
		Reporter.log("Welcome Message: =" + field);
		field=we.getTagName(); 
		Reporter.log("TagName =" + field);
					
	}
	@AfterMethod
	public void quiteBrowser() {
		driver.quit();
	}
	
}
