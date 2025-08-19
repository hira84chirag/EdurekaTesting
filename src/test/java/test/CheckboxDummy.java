package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxDummy {
	@Test
public  void Testcheckbox() throws InterruptedException {
	
	WebDriver driver=new FirefoxDriver();
	
	driver.get("https://demoqa.com/checkbox");
	String path="//button[@aria-label='Toggle']";
	WebElement chkpath=driver.findElement(By.xpath(path));
	chkpath.click();
	List<WebElement> w = chkpath.findElements(By.xpath("//span[@class='rct-checkbox']"));
	System.out.print("Total=" + w.size());
	for(int i=0;i<w.size()-1;i++){
			Thread.sleep(300);
		 if (i<1)	w.get(i).click();
			System.out.println(w.get(i));
		}
	driver.quit();
	}
	
}
