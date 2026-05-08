package Utilities;

import java.awt.AWTException;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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
import org.testng.Reporter;


public class CommonFunctions {
	
   public static boolean isElementPresent(WebDriver driver, By by) {
    	
	        try {
	            driver.findElement(by).click();
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
    }
   
   public static boolean findEles(WebDriver driver,String xpath) {
   	
   	By elementLocator = By.xpath(xpath);

		List<WebElement> elements = driver.findElements(elementLocator);

		// Store the result as a boolean
		boolean isElementPresent = !elements.isEmpty();
		System.out.println("elements visilbe : "+isElementPresent);
		if (isElementPresent==true) {
		    System.out.println("The element exists! It's safe to interact with it.");
		    elements.get(0).click(); // Interact with the first element found
		    
		}
		return isElementPresent;
		
   }
    public static void findHiddenElement(WebDriver driver,String xpath,String path) {
    	String techstr=path;
    	techstr="//h1[text()='Technical Details']";
    	By elementLocator = By.xpath(xpath);

		List<WebElement> elements = driver.findElements(elementLocator);

		// Store the result as a boolean
		boolean isElementPresent = !elements.isEmpty();
		System.out.println("elements visilbe : "+isElementPresent);
		if (isElementPresent==true) {
		    System.out.println("The element exists! It's safe to interact with it.");
		    elements.get(0).click(); // Interact with the first element found
        	
		} else {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(930));		
		    System.out.println("The element is not present on the page.");
		    
		}

    }
    
	public static void BtnClick(WebDriver driver,WebElement obj)
	{
		obj.click();
	}
	// Wait for element
	public static void waitForElementToClick(WebDriver driver, String Webele){
		WebElement ele=driver.findElement(By.xpath(Webele));
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
	}

	public static void waitForid(WebDriver driver,String str) {
		WebElement ele=driver.findElement(By.id(str));
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5120));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		}

	
	public static void partiallinktext(WebDriver driver, String str){
		driver.findElement(By.partialLinkText(str)).click();
	}

	// Wait for Element	
	public static void WaitExpt(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));		  
		WebElement text=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));			
	}
	public static void waitforelement(WebDriver driver,String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

	}
	public static void waitImplicit(WebDriver driver,int num){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
	}

	public static void waitThread(int number) throws InterruptedException {
		Thread.sleep(number);
	}
	
	public static void getText(WebDriver driver, String str) {
		WebElement eleText=driver.findElement(By.xpath(str));
		System.out.println(eleText.getText());
	}

	public static void ScrollingPageSize(WebDriver driver,int i) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(driver.manage().window().getSize());
		Dimension d=new Dimension(1382, i);
		driver.manage().window().setSize(d);
	}
	public static void scrollpage(WebDriver driver, int last) throws InterruptedException {
		// Scroll by Pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("window.scrollBy(0,200)");
        // Scroll to a specific element (like Footer or any section)
        
  //      if you want to perticular element then below case.
 //        WebElement footer = driver.findElement(By.id("contents"));
 //       js.executeScript("arguments[0].scrollIntoView(true);", footer);
      //  Thread.sleep(2000);
        int j=0;
       // js.executeScript("window.scrollBy(700, 1500)");

        for (int i = 100; j <= last; i += 100) {
        	j=i+200;
            js.executeScript("window.scrollBy(" +i+"," + j + ");");
            Thread.sleep(500);  // Adjust speed
        }  
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
	
	}
	public static void ScreenShot(WebDriver driver,String fileName) {
	    fileName=System.getProperty("user.dir")+"\\test-output\\Screenshot\\" +fileName + System.currentTimeMillis() +  ".jpg";
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	    FileUtils.copyFile(screenshot, new File(fileName));
	    System.out.println("Screenshot saved at: " + fileName );
	    }catch(Exception e) {
	    	e.getMessage();
	    }

	}
	public static String Snap(WebDriver driver,String name)  
	{
		String fileName= System.getProperty("user.dir")+"\\test-output\\Screenshot\\"; 

		try{			
		//Unique DateTimestamp code		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		long timestamp = System.currentTimeMillis();	        
        System.out.println("File Name:"+name+sdf.format(timestamp));
        name = name+"_"+ sdf.format(timestamp);
        name=fileName+name+ ".jpg";
        
		//Screenshot code
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File(name));
		
		}catch (Exception e) { 
			e.printStackTrace();
			//return false;
		}		
		return name;
	}

	public static void Screenshots_ImageIO(String filename) throws AWTException {		 
		 	Robot robot = new Robot();
		 	//robot = null;
		 try {
			java.awt.Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(dimension);
		
			BufferedImage bufferedImage =robot.createScreenCapture(rect);
			// Create a file name
			String screenshotPath = System.getProperty("user.dir")+"//test-output//Screenshot//"+filename+System.currentTimeMillis() + ".jpg";;
		
			File destinationFile = new File(screenshotPath);	
			ImageIO.write(bufferedImage, "jpeg", destinationFile);
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	
	}
	public static void BrokenLinks(WebDriver driver,String xpath)  {		 
	    List<WebElement> products=driver.findElements(By.xpath(xpath)); 			
	    System.out.println("Total links=" + products.size());
	    for (WebElement product : products) {
	         String linkText = product.getText() ; //.getAttribute("value");
	         String url = product.getAttribute("href"); // element.getAttribute("value"); 
	      
	         if (url != null && !url.isEmpty()) {
	        	 try {
	 	            URL urltest = new URL(url);
	 	            HttpURLConnection httpURLConnect = (HttpURLConnection) urltest.openConnection();
	 	            httpURLConnect.setConnectTimeout(3000);
	 	            httpURLConnect.connect();
	 	            int responseCode = httpURLConnect.getResponseCode();
		             	
		             		if (httpURLConnect.getResponseCode() >= 400) {            	
			 	            	Reporter.log(" HTTP status code: "+responseCode+"=" + httpURLConnect.getResponseMessage());
			 	            	Reporter.log(url + " is a broken link.");
			 	            	 } 
							else {
		 	            		Reporter.log("URL :" + url ); }		             	
		 	        } catch (Exception e) {
		 	            // This catch block handles exceptions like MalformedURLException or IOExceptions
		 	        	Reporter.log(url + " is a broken link due to an exception: " + e.getMessage());
		 	        }
		       }          	 
			}
		
	}
	
}
	

