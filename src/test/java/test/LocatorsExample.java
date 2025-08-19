package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import  org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class LocatorsExample extends BaseTest{
	
@Test
	public void locatorDemo() throws InterruptedException {
		
		LocatorsExample obj = new LocatorsExample();
		obj.setupBrowser("chrome", "http://www.google.com/");
		
    //   ChromeDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        String str= driver.findElement(By.partialLinkText("हिन्दी")).getText();
        System.out.println(str);
        String path="//textarea[@title='Search']";
        WebElement searchbox= driver.findElement(By.xpath(path));
        searchbox.sendKeys(str);
        Thread.sleep(500);
        searchbox.sendKeys(Keys.ENTER); 
        Thread.sleep(3000);
        driver.quit();	

        
		//id
//		driver.findElement(By.id("email")).sendKeys("from id");
		
		//name
//		driver.findElement(By.name("email")).sendKeys("from name attr");
		
		//class
//		driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("from class attr");//error
//		driver.findElement(By.className("inputtext")).sendKeys("from class attr-1");
//		driver.findElement(By.className("_55r1")).sendKeys("from class attr-2");
//		driver.findElement(By.className("_6luy")).sendKeys("from class attr-3");
		
		//tagname
//		driver.findElement(By.tagName("button")).click();
		
		//linktext ==> tagname --> "a"
//		driver.findElement(By.linkText("Forgotten password?")).click();
		
		//partial link text
//		driver.findElement(By.partialLinkText("Forgotten password?")).click();
//		driver.findElement(By.partialLinkText("Forgotten")).click();
//		driver.findElement(By.partialLinkText("password?")).click();
//		driver.findElement(By.partialLinkText("F")).click();
//		driver.findElement(By.partialLinkText("?")).click();
//		driver.findElement(By.partialLinkText("For")).click();
//		driver.findElement(By.partialLinkText("ord?")).click();
//		driver.findElement(By.partialLinkText("got")).click();
//		driver.findElement(By.partialLinkText("ssw")).click();
//		driver.findElement(By.partialLinkText("ten")).click();
//		driver.findElement(By.partialLinkText("pass")).click();
//		driver.findElement(By.partialLinkText("ten pas")).click();
		
		//xpath
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("from xpath");
		
		//absolute path
//		String path = "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input";
//		driver.findElement(By.xpath(path)).sendKeys("from absolute path");
		
		//relative path
//		driver.findElement(By.xpath("//form/div[1]/div[1]/input")).sendKeys("from relative path");
//		driver.findElement(By.xpath("//body//div[2]//form//input[@id='email']")).sendKeys("from rel path-2");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("from rel path-3");
		
//		$x("//button")
//		$x("//input[@id='email']")
	//	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test");
/*		$x("//input[@name='email']")
		$x("//input[@class='inputtext _55r1 _6luy']")
		$x("//input[@type='text']")
		$x("//input[@data-testid='royal_email']")
		$x("//input[@placeholder='Email address or phone number']")
		$x("//input[@aria-label='Email address or phone number']")
		$x("//input[@autofocus='1']")
		
		//functions
		//starts-with
		$x("//input[starts-with(@id,'email')]")
		$x("//input[starts-with(@id,'emai')]")
		$x("//input[starts-with(@id,'ema')]")
		$x("//input[starts-with(@id,'em')]")
		$x("//input[starts-with(@id,'e')]")
*/		
		//contains
/*		$x("//input[contains(@id,'email')]")
		$x("//input[contains(@id,'emai')]")
		$x("//input[contains(@id,'ema')]")
		$x("//input[contains(@id,'em')]")
		$x("//input[contains(@id,'e')]")
		
		$x("//input[contains(@id,'mail')]")
		$x("//input[contains(@id,'ail')]")
		$x("//input[contains(@id,'il')]")
		$x("//input[contains(@id,'l')]")
		
		$x("//input[contains(@id,'mai')]")
		$x("//input[contains(@id,'ai')]")
		$x("//input[contains(@id,'ma')]")
		$x("//input[contains(@id,'i')]")
		$x("//input[contains(@id,'m')]")
		
		//text
		$x("//h2[text()='Facebook helps you connect and share with the people in your life.']")
		$x("//button[text()='Log in']")
		
		//text+starts-with
		$x("//button[starts-with(text(),'Log in')]")
		$x("//button[starts-with(text(),'Log i')]")
		$x("//button[starts-with(text(),'Log ')]")
		$x("//button[starts-with(text(),'Log')]")
		$x("//button[starts-with(text(),'Lo')]")
		$x("//button[starts-with(text(),'L')]")
		
		//text+contains
		$x("//button[contains(text(),'Log in')]")
		$x("//button[contains(text(),'Log i')]")
		$x("//button[contains(text(),'Log ')]")
		$x("//button[contains(text(),'Log')]")
		$x("//button[contains(text(),'Lo')]")
		$x("//button[contains(text(),'L')]")
		
		$x("//button[contains(text(),'og in')]")
		$x("//button[contains(text(),'g in')]")
		$x("//button[contains(text(),' in')]")
		$x("//button[contains(text(),'in')]")
		$x("//button[contains(text(),'n')]")
		
		$x("//button[contains(text(),'og i')]")
		$x("//button[contains(text(),'g i')]")
		$x("//button[contains(text(),'og ')]")
		$x("//button[contains(text(),' i')]")
		$x("//button[contains(text(),'og ')]")
		
		//Advanced method
		//and
		$x("//input[@id='email' and @name='email']")
		$x("//input[@id='email' and @name='email' and @type='text']")
		$x("//input[starts-with(@id,'email') and @name='email']")
		
		//or
		$x("//input[starts-with(@id,'email') or @name='email']")
		$x("//input[@id='email' or @name='email']")
		$x("//input[@id='email' or @name='email' or @autofocus='1']")
		
		//and + or
		$x("//input[@id='email' and @name='email' or @autofocus='1']")
		$x("//input[@id='email' or @name='email' and @autofocus='1']")
		
		
		//index ==> [x] ==> value should start from 1
		$x("//select[3]") //year drop down
		$x("//select[2]") //month drop down
		
		
		//chained
		$x("//form//input[@id='email']")
		$x("//form[@data-testid='royal_login_form']//input[@id='email']")
		$x("//form[@data-testid='royal_login_form']//input[starts-with(@id, 'em')]")
		
*/		
		//css
//		driver.findElement(By.cssSelector("#email")).sendKeys("from css selector");

		/*$$("#email")
		
		//css id attribute ==> #
		$$("#email")
		
		//css class attribute ==> .
		$$(".inputtext._55r1._6luy")
		$$(".inputtext")
		$$("._55r1")
		$$("._6luy")
		
		//css ==> id and class
		$$("#email.inputtext._55r1._6luy")
		$$("#email.inputtext")
		$$("#email._55r1")
		$$("#email._6luy")
		$$("#email.inputtext._55r1y")
		$$("#email._55r1._6luy")
		$$("#email.inputtext._6luy")
		$$(".inputtext#email._55r1._6luy")
		$$(".inputtext._55r1#email._6luy")
		$$(".inputtext._55r1._6luy#email")
		$$(".inputtext#email._55r1")
		$$("._55r1#email._6luy")
		$$("._55r1#email.inputtext._6luy")
		$$("#email._55r1._6luy.inputtext")
		$$("#email._6luy._55r1.inputtext")
		
		
		
		//css ==> html tagname
		$$("button")
		
		//css ==> html tagname + html attribute
		$$("input[id='email']")
		$$("input[class='inputtext _55r1 _6luy']")
		$$("input[type='text']")
		$$("input[data-testid='royal_email']")
		$$("input[placeholder='Email address or phone number']")
		$$("input[aria-label='Email address or phone number']")
		$$("input[autofocus='1']")
		
		//css (id, class attr) + html (any attribute)
		$$("input#email")
		$$("input#email.inputtext._55r1._6luy")
		$$("input#email.inputtext")
		$$("input#email._55r1")
		$$("input#email._6luy")
		$$("input.inputtext#email._55r1._6luy")
		$$("input[id='email']#email")
		$$("input[id='email'].inputtext._55r1._6luy")
		$$("input[id='email'].inputtext")
		$$("input[id='email'].inputtext#email._55r1._6luy")
		$$("input[id='email'].inputtext._55r1._6luy#email")
		
		//substring
		//starts with ==> ^
		$$("input[id^='email']")
		$$("input[id^='emai']")
		$$("input[id^='ema']")
		$$("input[id^='em']")
		$$("input[id^='e']")
		
		//ends with ==> $
		$$("input[id$='email']")
		$$("input[id$='emai']")
		$$("input[id$='ema']")
		$$("input[id$='em']")
		$$("input[id$='e']")
*/		
		//contains ==> *
		/*
		$$("input[id*='email']")
		$$("input[id*='emai']")
		$$("input[id*='ema']")
		$$("input[id*='em']")
		$$("input[id*='e']")
		
		$$("input[id*='mail']")
		$$("input[id*='ail']")
		$$("input[id*='il']")
		$$("input[id*='l']")
		
		$$("input[id*='mai']")
		$$("input[id*='ai']")
		$$("input[id*='ma']")
		$$("input[id*='i']")
		$$("input[id*='m']")
		
		*/
		
	}
		
}
