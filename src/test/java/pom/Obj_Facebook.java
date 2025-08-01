package pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Obj_Facebook {
	
	public static WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[contains(text(),'Create new account')]") 
	WebElement btnclick;
	String str="//a[contains(text(),'Create new account')]";

	
	public Obj_Facebook(WebDriver driver) {
		this.driver=driver;
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second timeout
		PageFactory.initElements(driver, this);
	}


	public void clickCreateNewAccount() {
		// TODO Auto-generated method stub
		WebElement ele= driver.findElement(By.xpath(str));
	//	ele.click();
		btnclick.click();
	}
	

	
	
}
//		WebElement LoginBtn = findElement(By.xpath("//a[contains(text(),'Create new account')]"));
