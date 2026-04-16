package test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
import Utilities.Z_genericFun_bkp;
public class ScrollExample extends BaseTest {

	public ScrollExample() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(invocationCount  =1)
	public void amazonScrolling() throws Exception {		
		String url=pro1.getProperty("amazonscroll");
		String techstr="//div[@id='prodDetails']";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(160));
		String contbtn=	"//button[@alt='Continue shopping']";
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
		driver.get("https://www.github.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		Thread.sleep(4000);
		CommonFunctions.ScrollingPageSize(driver, 970);
	}	

		@Test(priority = 3)
		public void youtubeScrolling() throws InterruptedException {
			driver.get("https://www.youtube.com/watch?v=nIHyr_fp_yI");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1960));
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
			Thread.sleep(4000);
			CommonFunctions.ScrollingPageSize(driver,2500);

		}
	
}


