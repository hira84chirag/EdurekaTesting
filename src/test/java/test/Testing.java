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
	public void facebook_register() throws Exception { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		   driver.get( "https://www.facebook.com/reg/?entry_point=login&next=");
		   driver.manage().window().maximize();
		   int i=0;

	       List<WebElement> controls = driver.findElements(By.xpath("//input[@inputmode='text']"));
	       controls.get(i).sendKeys("chirag");
	       controls.get(i+1).sendKeys("chiragpatel");
	//     controls.get(i+2).sendKeys("chiragsoftware");
	//     controls.get(i+3).sendKeys("chiragtesting");
	
	       Thread.sleep(3000);	       
	       
	       String path="//span[normalize-space()='Select your gender']";
	       WebElement sel = driver.findElement(By.xpath(path)); 
	       sel.click();
	       
	    //   Select selectMonth = new Select(sel);
	    //   selectMonth.selectByVisibleText("May");
	    //	 sel.click();
	       Thread.sleep(3000);	
	}	

	
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
