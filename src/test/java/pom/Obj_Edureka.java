package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Obj_Edureka {
	public static WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath ="//button[contains(text(),'Log')]")
	WebElement HomePageLogin1;
	
	@FindBy(xpath ="//button[starts-with(text(),'Log')]")
	WebElement Loginbtn1;

	@FindBy(xpath ="//input[@id='loginFormEmail']")
	WebElement enterEmail;

	@FindBy(xpath ="//input[@id='loginPassword']")
	WebElement enterPass;

	@FindBy(xpath ="//p[contains(text(),'Email address')]")
	WebElement emailmsg;

	@FindBy(xpath ="//p[contains(text(),'Enter Password')]")
	WebElement passmsg;
	
	@FindBy(xpath ="//p[contains(text(),'Sign In Failed. Invalid login credentials.')]")
	WebElement validationmsg;

	
	By HomePageLogin=By.xpath("//button[contains(text(),'Log')]");
	By Loginbtn=By.xpath("//button[starts-with(text(),'LOG')]");
	// get email message from web elements

	String path;
	public Obj_Edureka(WebDriver driver) {
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		}
	public void clickHomepageLogin() {
        //wait.until(ExpectedConditions.elementToBeClickable(HomePageLogin)).click();
        HomePageLogin1.click();
    }

	public void clickLoginbtn() {
//        wait.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();
        Loginbtn1.click();
	}

	public void getLoginValue() {
		
		System.out.println(emailmsg.getText());		
		System.out.println("|----|"+ emailmsg.getText());
		
		enterEmail.sendKeys("jsktestingraja@edureka.com");
	    wait.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();
		System.out.println("|----|"+ passmsg.getText());

		enterPass.sendKeys("edurekatesting");		
	    wait.until(ExpectedConditions.elementToBeClickable(Loginbtn)).click();								 				
		System.out.println("|Finally----|"+ validationmsg.getText());
	}
	
	public void teardown() {
		driver.quit();
	}
}

/*
//@CacheLookup


By Loginbtn1=By.xpath("//button[starts-with(text(),'LOG')]");



*/