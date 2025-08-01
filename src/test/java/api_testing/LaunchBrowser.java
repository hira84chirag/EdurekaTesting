package api_testing;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class LaunchBrowser {
	@SuppressWarnings("deprecation")
	@Test
public void openbrowser() {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://github.com/login");
	//	driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		Wait<WebDriver> wait =
		        new FluentWait(1000)
//		        .withTimeout(Duration.ofSeconds(080))
		        .pollingEvery(Duration.ofMillis(50000))
		        .ignoring(ElementNotInteractableException.class);		
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Software");
		
	}

}
