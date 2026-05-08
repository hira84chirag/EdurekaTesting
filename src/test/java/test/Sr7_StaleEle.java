package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.StaleElementReferenceException;

public class Sr7_StaleEle extends BaseTest {
    public Sr7_StaleEle() throws Exception {
		super();
	}
    @Test
	public void Fb_Hiddenele() {
        // Navigate to a web page
        driver.get(pro1.getProperty("fburl"));  
        // Locate an element
        WebElement element = driver.findElement(By.name("email")); //xpath("//a[contains(text(),'More')]"));
        driver.navigate().refresh();   
        // Try to interact with the element after page refresh
        // Handle the exception by re-locating the element and trying again
        try {
            // This will throw StaleElementReferenceException
            element.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Caught StaleElementReferenceException");
            Reporter.log(e.getMessage());
            // Re-locate the element
            WebElement newElement = driver.findElement(By.name("email")); 
            // Interact with the newly located element
            newElement.click();
        }
         
    }
}
