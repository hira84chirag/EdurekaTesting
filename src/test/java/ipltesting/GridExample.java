package ipltesting;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {
	
	String browser="chrome";
	String url="https://www.rolls-royce.com";	
	String hubUrl = "http://192.168.79.194:4444";
	
	WebDriver driver;
	
	public void gridSetup() {
		
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
			
	}
	
	public void pageTitleValidation() {
		
		 System.out.println("page Title=" + driver.getTitle());	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridExample ge=new GridExample();
		ge.gridSetup();
		ge.pageTitleValidation();
	}

}
