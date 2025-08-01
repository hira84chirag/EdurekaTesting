package Util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CommonFunctions {
	
	public static void ClickonElement(WebDriver driver, WebElement e){
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}
	public static void ClickWebElement(WebDriver driver, By abc){
 		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(100));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(abc));
		wait.until(ExpectedConditions.presenceOfElementLocated(abc)); 
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.findElement(abc).click();
	}
	public static void BtnClick(WebDriver driver,WebElement obj)
	{
		obj.click();
	}

	public static void waitForElement(WebDriver driver, String Webele){
		WebElement elewait=driver.findElement(By.xpath(Webele));
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(elewait));
		wait.until(ExpectedConditions.elementToBeClickable(elewait)).click();
	}

	// Wait for Element	
	public static void WaitExpt(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
		WebElement text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
	}

	public static void waitImplicit(WebDriver driver,int num){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}

	public static void CreateImage(WebDriver driver,String fileName)  {
        try {
	        // Take a screenshot and store it as a file
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        long currentTimeMillis = System.currentTimeMillis();        	        
	        // Define the destination file path like "D:/screenshot.png";
	        String filestr= "D:\\";
	        //Timeslot combination
	        LocalTime filestr1 = LocalTime.now();
	        fileName=filestr + fileName + currentTimeMillis+ ".jpg";
	        // Copy the screenshot to the destination file
	        FileUtils.copyFile(screenshot, new File(fileName));
        	System.out.println("Screenshot saved at: " + fileName );
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } finally {
            // Close the browser

        }
    }
	public static String Snap(WebDriver driver,String name)  
	{
		String path=null;			
		String fileName= "C:\\Users\\Dell Enterprise\\eclipse-workspace\\Training\\test-output\\Screenshot\\";

		try{			
		//Unique DateTimestamp code		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		long timestamp = System.currentTimeMillis();	        
        System.out.println(name+sdf.format(timestamp));
        name = name+"_"+ sdf.format(timestamp);
         path = fileName;
        
		//Screenshot code
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File(path + name + ".jpg"));
		
		}catch (Exception e) { 
			e.printStackTrace();
			//return false;
		}		
		return path+name+".jpg";
	}
	public static void waitThread(int number) throws InterruptedException {
		Thread.sleep(number);
	}
	
	public static void ScreenShot(WebDriver driver,String fileName) {
	    fileName="D:\\" +fileName + System.currentTimeMillis() +  ".jpg";
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	    FileUtils.copyFile(screenshot, new File(fileName));
	    System.out.println("Screenshot saved at: " + fileName );
	    }catch(Exception e) {
	    	e.getMessage();
	    }

	}
	// Wait for click createlink
		public static void Clickbutton(WebDriver driver,String xpath) {
			//xpath="//span[contains(text(),'Create account')]";
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
			WebElement elewait=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
			elewait.click();

		}

	public static void scrollpageamazon(WebDriver driver) throws InterruptedException {
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to a specific element (like Footer or any section)
        WebElement footer = driver.findElement(By.id("navFooter"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
        Thread.sleep(1000);
//	    Scroll up to top of the page
        for (int i = 0; i <= 10000; i += 400) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight - " + i + ");");
            Thread.sleep(400);  // Adjust speed
        }
				/*
				         js.executeScript("window.scrollBy(0, 1500)"); // Scroll down by 1000 pixels
				        js.executeScript("window.scrollBy(1500, 2500)");
				        CommonFunctions.waitImplicit(driver,1000);
				        // Scroll to Bottom of Page
				        js.executeScript("window.scrollTo(2500, document.body.scrollHeight)");
				        CommonFunctions.waitImplicit(driver,2000);
				 
				 */

	}
	public static void scrollpage(WebDriver driver, int last) throws InterruptedException {
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to a specific element (like Footer or any section)
        WebElement footer = driver.findElement(By.id("contents"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
      //  Thread.sleep(2000);
        int j=0;
       // js.executeScript("window.scrollBy(700, 1500)");

        for (int i = 600; j <= last; i += 500) {
        	j=i+600;
            js.executeScript("window.scrollBy(" +i+"," + j + ");");
            Thread.sleep(7000);  // Adjust speed
        }  
	}
	public static void getText(WebDriver driver, String str) {
		WebElement eleText=driver.findElement(By.xpath(str));
		System.out.println(eleText.getText());
	}
	public static void photo(String filename) throws AWTException {
		 
		 Robot robot = new Robot();
		 //robot = null;
	try {
		java.awt.Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		
		BufferedImage bufferedImage =robot.createScreenCapture(rect);
		// Create a file name
		String screenshotPath = System.getProperty("user.dir")+"//test-output//photo//"+filename+System.currentTimeMillis() + ".jpg";;
		
		File destinationFile = new File(screenshotPath);

	
			ImageIO.write(bufferedImage, "jpeg", destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
