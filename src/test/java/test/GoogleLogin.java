package test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

public class GoogleLogin extends BaseTest{
	
	@Test(invocationCount=1) // Running looping multiple Times
	public void Google_LoginTC() throws Exception  {
		driver.close();
		driver=intilizeBrowserAndOpenApplication(prop.getProperty("fxbrowser"));	
		
		// TODO Auto-generated method stub
		String path="";
		String strcreatebtn="//span[contains(text(),'Create account')]";
		driver.get(prop.getProperty("googleurl"));
		driver.manage().window().maximize();
		
// Click Sign in button		
		driver.findElement(By.partialLinkText("Sign in")).click();	
		
// Click next button        
		WebElement parent=driver.findElement(By.xpath("//button/span[@jsname='V67aGc']"));
		WebElement nextbtn=parent.findElement(By.xpath("//span[contains(text(),'Next')]"));	
		nextbtn.click();

// print validation message for email field
		WebElement Emailmsg=driver.findElement(By.xpath("//div[@class='Ekjuhf Jj6Lae']"));
		System.out.println(Emailmsg.getText());
		
// Click on Create link chirag updating from here
		CommonFunctions.waitForElementToClick(driver,strcreatebtn);
		//createbtn.click();	

// Wait for my personal use element - i updated
		CommonFunctions.WaitExpt(driver,"//span[contains(text(),'For my personal use')]");

// click for my personal use 
		WebElement persparent=driver.findElement(By.xpath("//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c']"));			
		WebElement Createpersonal=persparent.findElement(By.xpath("//span[contains(text(),'For my personal use')]"));
		System.out.println(Createpersonal.getText());
		Createpersonal.click(); 
		driver.navigate().back(); 
		CommonFunctions.waitForElementToClick(driver, strcreatebtn);
		
// click for my child
		WebElement Createparent1=driver.findElement(By.xpath("//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c']"));
		WaitElement("//span[contains(text(),'For my child')]");		
		WebElement Createchild=Createparent1.findElement(By.xpath("//span[contains(text(),'For my child')]"));
		System.out.println(Createchild.getText());
		Createchild.click();
		driver.navigate().back();
		CommonFunctions.waitForElementToClick(driver, strcreatebtn);
		
// click for my business 
		path="//span[contains(text(),'For work or my business')]";	
		WebElement Createparent2=driver.findElement(By.xpath("//span[@class='VfPpkd-StrnGf-rymPhb-b9t22c']"));	
		WaitElement(path);
		WebElement Createbusiness= Createparent2.findElement(By.xpath(path));
		System.out.println(Createbusiness.getText());
		Createbusiness.click(); 
		driver.navigate().back();
		CommonFunctions.waitForElementToClick(driver, strcreatebtn);
//		CommonFunctions.Clickbutton(driver, strcreatebtn);
//		driver.close();
		CommonFunctions.ScreenShot(driver,"GoogleMenu");
		//driver.quit();
		 
	}

	// Wait for Element	
	public void WaitElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
		WebElement text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
	}
		

}

   