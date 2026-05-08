package test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;
public class Sr8_Scroll extends BaseTest {

	public Sr8_Scroll() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(invocationCount  =1)
	public void amazonScrolling() throws Exception {		
		String url=pro1.getProperty("amazonscroll");
		String techstr=pro2.getProperty("prodlabel");
		driver.get(url);
		String contbtn=	pro2.getProperty("contbtn");
		By xpath=By.xpath(contbtn);
		
		boolean btnele=CommonFunctions.findEles(driver,contbtn);
		
		if(btnele==true)
			System.out.println("The element is present on the page.");
		else 
			System.out.println("The element is not present on the page.");
			Thread.sleep(3000);		
			WebElement Webtech= driver.findElement(By.xpath(techstr));
			JavascriptExecutor js=(JavascriptExecutor)(driver);
			js.executeScript("arguments[0].scrollIntoView();",Webtech);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(930));

	}	


	@Test(priority = 2)
	public void githubScrolling() throws InterruptedException {
		driver.get(pro1.getProperty("git"));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(pro2.getProperty("jscript"));
		Thread.sleep(1000);
		CommonFunctions.ScrollingPageSize(driver, 570);
	}	
		@Test(priority = 3)
		public void youtubeScrolling() throws InterruptedException {			
			driver.get(pro1.getProperty("tubeyou"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(pro2.getProperty("jscript"));	
			CommonFunctions.scrollpage(driver,1500);			
		}	
}


