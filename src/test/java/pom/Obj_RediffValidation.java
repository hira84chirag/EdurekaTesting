package pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;


public class Obj_RediffValidation {
	
	// Define variable Findby Method
		@CacheLookup
		@FindBy(css="#login1")
		WebElement uname1;
		
		@CacheLookup
		@FindBy(css = "#password") 
		WebElement pwd1;
		
		@CacheLookup
		@FindBy(xpath  = "//button[starts-with(text(),'Log In')]") 
		WebElement signbtn1;

		
	
	By uname=By.cssSelector("#login1");
	By pwd=By.cssSelector("#password");
	By signbtn=By.name("proceed");

	public static WebDriver driver;
	
	public Obj_RediffValidation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void teardown() {
		driver.quit();
	}
	
	public void enteruname(String username) {
		driver.findElement(uname).sendKeys(username);		
	}
	public void enterpwd(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void clicksignbtn() {

		FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofMinutes(5))
	                .pollingEvery(Duration.ofMillis(500))
	                .ignoring(NoSuchElementException.class);
		  	  
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(2));
	//	WebElement pass= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Secured')]"))));
		  signbtn1.click();
		
	}
	public void getvalue() {
		
	// Get value FindBy Method.	
	 String user=uname1.getAttribute("value");
	 String pass=pwd1.getAttribute("value");
	 String sign=signbtn1.getText();
	 Reporter.log("Username = "+user);
	 Reporter.log("Password = "+pass);
	 Reporter.log("button name = "+sign);	
	}
	
}
