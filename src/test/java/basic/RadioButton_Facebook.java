package basic;
// Need to resolve an error 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButton_Facebook extends BaseTest{
	@Test
	public void webElementCommandDemo() {

		RadioButton_Facebook obj = new RadioButton_Facebook();
		obj.setupBrowser("chrome", "https://www.facebook.com");
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement instaLink = driver.findElement(By.partialLinkText("Instagram"));
		WebElement loginBtn = driver.findElement(By.tagName("button"));
		WebElement welMsg = driver.findElement(By.xpath("//h2[@class='_8eso']"));
		WebElement hiddenElem = driver.findElement(By.name("jazoest"));
		
			
		//is selected
		driver.findElement(By.partialLinkText("Sign Up")).click();
		
		
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@class='_8esa' and @value=2]"));
		System.out.println("Before clicking - is the male radio button selected - " + maleRadioButton.isSelected());
		
		maleRadioButton.click();
		System.out.println("After clicking - is the male radio button selected - " + maleRadioButton.isSelected());		
		driver.quit();
	}


}


//fetching the values
//get attribute
//String placeholder = email.getAttribute("placeholder");
//System.out.println("placeholder value = " + placeholder);

//String toolTip = instaLink.getAttribute("title");
//System.out.println("tool tip of insta link is - " + toolTip);

//gettext
//String loginBtnTxt = loginBtn.getText();
//System.out.println("text = " + loginBtnTxt);

//String welMsgText = welMsg.getText();
//System.out.println(welMsgText);

//getTagname
//System.out.println("tagname of email field is - " + email.getTagName());

//get location
//System.out.println("Point - " + loginBtn.getLocation());
//System.out.println("Point (x)- " + loginBtn.getLocation().x);
//System.out.println("Point (y)- " + loginBtn.getLocation().y);


//get dimension
//System.out.println("Dimension - " + loginBtn.getSize());
//System.out.println("Dimension (height)- " + loginBtn.getSize().height);
//System.out.println("Dimension (width)- " + loginBtn.getSize().width);

//get css values
//System.out.println(loginBtn.getCssValue("font-size"));
//System.out.println(loginBtn.getCssValue("width"));

//actions
//type
//email.sendKeys("ramesh@gmail.com");

//clear
//email.clear();
//email.sendKeys("dan@gmail.com");

//click
//loginBtn.click();
//instaLink.click();

//status
//is displayed
//System.out.println("is email element displayed - " + email.isDisplayed());
//System.out.println("is the hidden element displayed - " + hiddenElem.isDisplayed());

//is enabled
//System.out.println("is email element editable/enabled - " + email.isEnabled());
