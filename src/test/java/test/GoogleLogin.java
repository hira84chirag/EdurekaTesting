package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class GoogleLogin extends BaseTest{	
	String strcreatebtn=pro2.getProperty("createbtn");
	public GoogleLogin() throws Exception {
		super();
		
	}

	@Test(invocationCount=1) // Running looping multiple Times
	public void Google_LoginTC() throws Exception  {
		String path="";		
		driver.get(pro1.getProperty("googleurl"));
		driver.manage().window().maximize();
		
// Click Sign in button		
		driver.findElement(By.partialLinkText("Sign in")).click();	
		
// Click next button        
		WebElement parent=driver.findElement(By.xpath(pro2.getProperty("nextparent")));
		WebElement nextbtn=parent.findElement(By.xpath(pro2.getProperty("next")));	
		nextbtn.click();

// print validation message for email field
		WebElement Emailmsg=driver.findElement(By.xpath(pro2.getProperty("emailmsg")));
		System.out.println(Emailmsg.getText());
		
// Click on Create link here
		CommonFunctions.waitThread(100);
		CommonFunctions.waitForElementToClick(driver,strcreatebtn);
		//createbtn.click();	

// Wait for my personal use element 
		CommonFunctions.WaitExpt(driver,pro2.getProperty("personaluseEle"));

// click for my personal use 
		account("personalparent", "personal", strcreatebtn);
		account("childparent", "mychild", strcreatebtn);		
		account("businessparent", "business", strcreatebtn);
		CommonFunctions.ScreenShot(driver,"GoogleMenu");
		driver.quit();
		 
	}
	public void account(String s1,String s2,String btn) throws InterruptedException {
		CommonFunctions.WaitExpt(driver,pro2.getProperty("personaluseEle"));		
		// for my personal use /child /business account
			WebElement persparent=driver.findElement(By.xpath(pro2.getProperty(s1)));			
			WebElement Createpersonal=persparent.findElement(By.xpath(pro2.getProperty(s2)));
			System.out.println(Createpersonal.getText());
			Createpersonal.click(); 
			driver.navigate().back(); 
			CommonFunctions.WaitExpt(driver,pro2.getProperty("personaluseEle"));		

			CommonFunctions.waitForElementToClick(driver, strcreatebtn);
	}
}

   