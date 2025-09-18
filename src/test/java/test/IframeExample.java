package test;
import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
public class IframeExample extends SetupBrowser{

	String closebtn="//div[@class='tox-notifications-container']//div[@aria-label='Close']";
	String contentstr="//p[contains(text(),'Your content')]";	
	  	//  @Test(invocationCount=1)

	  @Test(invocationCount = 1)
	public void Internet_iframeDemo()  {
		

		driver.get("https://the-internet.herokuapp.com/iframe");
		CommonFunctions.Clickbutton(driver, closebtn);

	//	driver.manage().window().maximize();				
		driver.switchTo().frame("mce_0_ifr");	
		
		CommonFunctions.getText(driver, contentstr);
		// driver .switch to parent frame
		driver.switchTo().defaultContent();
		contentstr="//h3[contains(text(),'An')]";
		CommonFunctions.getText(driver, contentstr);
		closebtn=CommonFunctions.Snap(driver,"IframeExample");
		//System.out.println(abc);

	}

}
