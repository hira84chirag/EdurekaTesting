package basic;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dummy {
	@Test
public  void Testcheckbox() {
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://demoqa.com/registration/");
	List<WebElement> w = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<w.size();i++){	
			w.get(i).click();
		}
	}

}
