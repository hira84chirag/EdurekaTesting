package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;

public class StaleElementExample extends BaseTest {
    public StaleElementExample() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
    @Test
	public void Hiddenexample() {
        // Set up WebDriver
    	driver.quit();
    	WebDriver driver=new ChromeDriver();
//    	StaleElementExample obj=new StaleElementExample();
        
        try {
            // Navigate to a web page
            driver.get(pro1.getProperty("fburl"));  

            // Locate an element
            WebElement element = driver.findElement(By.name("email")); //xpath("//a[contains(text(),'More')]"));

            // Simulate a DOM change (e.g., page refresh or JavaScript update)
            driver.navigate().refresh();
       
            // Try to interact with the element after page refresh
            try {
                // This will throw StaleElementReferenceException
                element.click();
            } catch (StaleElementReferenceException e) {
                // Handle the exception by re-locating the element and trying again
                System.out.println("Caught StaleElementReferenceException, re-locating the element.");
                Reporter.log(e.getMessage());
                // Re-locate the element
                WebElement newElement = driver.findElement(By.name("email")); //xpath("//a[contains(text(),'More')]"));
                // Interact with the newly located element
                newElement.click();
            }
        } finally {
            // Clean up and close the browser
            driver.quit();
        }
    }
}
