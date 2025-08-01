package SGrid;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	String browser="chrome";
	String url="https://www.rediff.com/";	
	String hubUrl = "http://192.168.0.116:4444";
	
	
	WebDriver driver;
	
	public void gridSetup()  {
		
		System.out.println("Calling Browser from Selenium Grid");	
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(browser);	
		try {			
			driver=new RemoteWebDriver(new URI(hubUrl).toURL(),cap);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		driver.get(url);	
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		BufferedImage bufferedImage =robot.createScreenCapture(rect);
		String screenshotPath = System.getProperty("user.dir")+"//Screenshots//robot2.png";
		
		File destinationFile = new File(screenshotPath);
		
		try {
			ImageIO.write(bufferedImage, "png", destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public void pageTitleValidation() {
		
		 System.out.println("page Title=" + driver.getTitle());	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumGrid sg=new SeleniumGrid();
		sg.gridSetup();		
		sg.pageTitleValidation();
	}

}
