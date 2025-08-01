package ipltesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.StaleElementReferenceException;

public class StaleElementExample extends SetupBrowser {
    public static void main(String[] args) {
        // Set up WebDriver
    	WebDriver driver=new ChromeDriver();
//    	StaleElementExample obj=new StaleElementExample();
        
        try {
            // Navigate to a web page
            driver.get("https://www.facebook.com/");  //("https://example.com");

            // Locate an element
            WebElement element = driver.findElement(By.id("email")); //xpath("//a[contains(text(),'More')]"));

            // Simulate a DOM change (e.g., page refresh or JavaScript update)
            driver.navigate().refresh();
       
            // Try to interact with the element after page refresh
            try {
                // This will throw StaleElementReferenceException
                element.click();
            } catch (StaleElementReferenceException e) {
                // Handle the exception by re-locating the element and trying again
                System.out.println("Caught StaleElementReferenceException, re-locating the element.");
                System.out.println(e.getMessage());
                // Re-locate the element
                WebElement newElement = driver.findElement(By.id("email")); //xpath("//a[contains(text(),'More')]"));
                // Interact with the newly located element
                newElement.click();
            }
        } finally {
            // Clean up and close the browser
            driver.quit();
        }
    }
}
