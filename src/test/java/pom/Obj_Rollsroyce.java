package pom;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Obj_Rollsroyce {
	
	private WebDriverWait wait;
	By acceptAll=By.xpath("//button[@id='cc-acceptAll-btn']");	
	By Presentele=By.xpath("//th[contains(text(),'Presentation')]");
	By year2022=By.xpath("//ul[2]//a[contains(text(),2025)]");
	By reportpresent=By.xpath("//li[@id='nav-results-reports-and-presentations-level2' and @aria-haspopup='true']");
	//	By reportpresent=By.xpath("//li[@id='nav-results-reports-and-presentations-level2' and @class='level2 haschildren' and @aria-haspopup='true']");

	public static WebDriver driver;
	
	public Obj_Rollsroyce(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
    	 this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));

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
		
}
