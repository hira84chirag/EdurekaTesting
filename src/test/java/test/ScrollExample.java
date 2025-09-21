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
import Utilities.GenericFun_bkp;
public class ScrollExample extends SetupBrowser {
//	ScrollExample obj;
	@Test(invocationCount  =1)
	public void amazonScrolling() throws InterruptedException {		
		String url="https://www.amazon.in/Apple-iPhone-15-128-GB/dp/"
				+ "B0CHX2F5QT/ref=sr_1_1_sspa?dib=eyJ2IjoiMSJ9.8-aKrERwPzd"
				+ "GyJWfWOa56I4wwdlI59jT8Bz9mNMoRuJhDPQn-fIYfKJxxKAv6p4v1WokuX"
				+ "VTy6CEak1Vh-NyyTAmDXkLE8-YpWVSsG52cuzHWfPGQmEHKBuZ28lHimBXoQFi"
				+ "BwUPbI-ZeU-uwbRmEyhJD5fUfpVpnDipADtkVUwmxr6VbbPQvv5LFbY1WR9N3g"
				+ "cPO9_X-kNXIO6PoI6QGW7ShecF0XyC5lFbzvZ5rcM._JVkc7BD-ArTQsO"
				+ "MOX7UqQM0g4lkYjz4Kfj0gsZeNMA&dib_tag=se&keywords=iphone+1"
				+ "5&qid=1722790570&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1";
		String techstr="//h1[text()='Technical Details']";

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(160));
		String contbtn=	"//button[@alt='Continue shopping']";
		By xpath=By.xpath(contbtn);
		
		boolean btnele=CommonFunctions.findEles(driver,contbtn);
		
		if(btnele==true) {
			System.out.println("The element is present on the page.");
			//driver.findElement(xpath).click(); 		
		}
			else System.out.println("The element is not present on the page.");
		
			
			WebElement Webtech= driver.findElement(By.xpath(techstr));
			JavascriptExecutor js=(JavascriptExecutor)(SetupBrowser.driver);
			js.executeScript("arguments[0].scrollIntoView();",Webtech);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(930));
			//		Thread.sleep(1000);	
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
//			obj=new ScrollExample();
			driver.get("https://www.youtube.com/watch?v=nIHyr_fp_yI");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1960));
			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
			Thread.sleep(4000);
			CommonFunctions.ScrollingPageSize(driver,2500);

		}
	
}


