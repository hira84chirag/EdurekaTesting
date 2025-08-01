package ipltesting;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Util.GenericFun;
public class ScrollExample extends SetupBrowser {
	ScrollExample obj;
	@Test(priority = 1)
	public void amazonScrolling() {		
		String url="https://www.amazon.in/Apple-iPhone-15-128-GB/dp/"
				+ "B0CHX2F5QT/ref=sr_1_1_sspa?dib=eyJ2IjoiMSJ9.8-aKrERwPzd"
				+ "GyJWfWOa56I4wwdlI59jT8Bz9mNMoRuJhDPQn-fIYfKJxxKAv6p4v1WokuX"
				+ "VTy6CEak1Vh-NyyTAmDXkLE8-YpWVSsG52cuzHWfPGQmEHKBuZ28lHimBXoQFi"
				+ "BwUPbI-ZeU-uwbRmEyhJD5fUfpVpnDipADtkVUwmxr6VbbPQvv5LFbY1WR9N3g"
				+ "cPO9_X-kNXIO6PoI6QGW7ShecF0XyC5lFbzvZ5rcM._JVkc7BD-ArTQsO"
				+ "MOX7UqQM0g4lkYjz4Kfj0gsZeNMA&dib_tag=se&keywords=iphone+1"
				+ "5&qid=1722790570&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1";
		String techstr="//h1[text()='Technical Details']";
		obj=new ScrollExample();
		obj.browserOpen("Chrome",url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(560));
		WebElement Webtech= driver.findElement(By.xpath(techstr));
		
		JavascriptExecutor js=(JavascriptExecutor)(SetupBrowser.driver);
		js.executeScript("arguments[0].scrollIntoView();",Webtech);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(930));
	}	

	
	@Test(priority = 2)
	public void githubScrolling() throws InterruptedException {
		obj.browserOpen("Chrome","https://www.github.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		Thread.sleep(4000);
		GenericFun.ScrollingPageSize(driver, 970);
	}	
		@Test(priority = 3)
		public void youtubeScrolling() throws InterruptedException {
//			obj=new ScrollExample();
			obj.browserOpen("Chrome","https://www.youtube.com/watch?v=nIHyr_fp_yI");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1960));
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
			Thread.sleep(4000);
			GenericFun.ScrollingPageSize(driver,2500);

		}
	@AfterMethod
	public void CloseBrowser() 
	{
		 driver.quit();		
	}
}