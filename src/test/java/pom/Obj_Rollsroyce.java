package pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class Obj_Rollsroyce {
	
	private WebDriverWait wait;
/*
		@CacheLookup
		@FindBy(xpath ="//button[d='cc-acceptAll-btn']")
		WebElement acceptAll;				
		@FindBy(xpath  = "//li[@id='nav-results-reports-and-presentations-level2' and @class='level2 haschildren' and @aria-haspopup='true']") 
		WebElement reportpresent;
*/
		By acceptAll=By.xpath("//button[@id='cc-acceptAll-btn']");	
		By reportpresent=By.xpath("//li[@id='nav-results-reports-and-presentations-level2' and @class='level2 haschildren' and @aria-haspopup='true']");
		By Presentele=By.xpath("//th[contains(text(),'Presentation')]");
		By year2022=By.xpath("//ul[2]//a[contains(text(),2022)]");
		
		
		
//		String reportpresent="//li[@id='nav-results-reports-and-presentations-level2' and @class='level2 haschildren' and @aria-haspopup='true']";	
//	String acceptAll="//button[@id='cc-acceptAll-btn']";


	public static WebDriver driver;
	
	public Obj_Rollsroyce(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		PageFactory.initElements(driver, this);		
	}	
	
	public void clickAcceptAll() {
	     wait.until(ExpectedConditions.elementToBeClickable(acceptAll)).click();     
	}

	public void clickreportpresent() {
	     wait.until(ExpectedConditions.elementToBeClickable(reportpresent)).click();     
	}
	public void clickyear2022() {
	     wait.until(ExpectedConditions.elementToBeClickable(year2022)).click();     
	}

	
	public void clickPresentele() {
	     wait.until(ExpectedConditions.elementToBeClickable(Presentele)).click();     
	}
	
	public void teardown() {
		driver.quit();
	}
		
}
