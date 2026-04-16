package test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class Scroll_Amazon extends BaseTest{
	
	
	public Scroll_Amazon() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	String todaydeal= "//a[contains(text(),'Deals')]";
	String classname="//a//span[@class='a-truncate-cut']";
	String strprod="//a[contains(@href, '/dp/')]";

	@Test(priority = 1) 
	public void Amazon_product_scrolling() throws Exception {
		// TODO Auto-generated method stub
		driver.get(pro1.getProperty("amazonin"));
		CommonFunctions.WaitExpt(driver, todaydeal);
		driver.findElement(By.partialLinkText("Bestsellers")).click();
		CommonFunctions.WaitExpt(driver, todaydeal);
// Click Today deals link
		CommonFunctions.waitForElementToClick(driver,todaydeal);
		CommonFunctions.scrollpageamazon(driver);
		CommonFunctions.BrokenLinks(driver,strprod);
		CommonFunctions.BrokenLinks(driver,classname);
	}
	
	@Test(priority = 2)
	public void Amazon_hiddenElement() { //Open Amazon and click Best link 

		// Open chrome browser and maximize
		driver.get(pro1.getProperty("amazonin"));
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