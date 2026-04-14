package test;
import org.testng.annotations.Test;
import com.github.dockerjava.api.model.SELContext;
import org.openqa.selenium.support.ui.Select;
import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class Testing extends SetupBrowser {
	
	@Test
	public void Amazon_hiddenElement() { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		driver.get( "https://www.amazon.in");
		driver.manage().window().maximize();
		
		String contbtn=	"//button[@alt='Continue shopping']";
		CommonFunctions.findHiddenElement(driver, contbtn,null);
		
		// wait page load time and select Best Sellers menu
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(260));
		driver.findElement(By.partialLinkText("Best")).click();
		
		// wait page load time and select new Releases menu		
		driver.findElement(By.linkText("New Releases")).click();		
	}	
}
