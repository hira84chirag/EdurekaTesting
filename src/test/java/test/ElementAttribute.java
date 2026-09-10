package test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class ElementAttribute extends BaseTest {
	public ElementAttribute() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	String field="";
	@Test(description="Verify attribute of Fb elment")
	public void fb_elementAttribute() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(pro1.getProperty("fburl"));
		WebElement we = driver.findElement(By.name("email"));
		Reporter.log("is emaild displayed or not=" + we.isDisplayed());
		Reporter.log("is Email enabled or not=" + we.isEnabled());
	
		List<WebElement> hiddenEle=driver.findElements(By.name("jazoest"));
		if(hiddenEle.size() > 0) 
			{
			WebElement hidden = hiddenEle.get(0);
	        Reporter.log("Hidden element present in DOM = true");
	        Reporter.log("Is hidden element displayed = " + hidden.isDisplayed());
	        Reporter.log("Hidden value = " + hidden.getAttribute("value"));		
	        }
		else{
			Reporter.log("Hidden element NOT present in DOM");	
			}	
	}
	
	@Test(description="Get attribute of Fb elment")
	public void fb_ButtonAttribute() {
		// TODO Auto-generated method stub
		
		driver.get(pro1.getProperty("fburl"));

		WebElement we=driver.findElement(By.name("email"));
		field=we.getAttribute("placeholder");
		Reporter.log("Current URL=" + field);
				
		we=driver.findElement(By.partialLinkText("Instagram"));		
		field=we.getAttribute("title");
		Reporter.log("Tooltips of link=" + field);	
		 
		we=driver.findElement(By.xpath(pro2.getProperty("login")));	
		field=we.getText(); 
		Reporter.log("Login button name=" + field);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
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
		CommonFunctions.waitForElementToClick(driver,pro2.getProperty("createaccount"));
	}
	
	
}
