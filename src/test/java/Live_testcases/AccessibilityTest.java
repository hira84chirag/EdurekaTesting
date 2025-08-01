package Live_testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.io.File;
import com.deque.axe.AXE;
import com.deque.axe.AXE.Builder;
import com.deque.html.axecore.providers.FileAxeScriptProvider;
// import com.deque.html.axecore.AXE;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

public class AccessibilityTest extends BaseBrowser {
	@Test
    public  void AccessibilityCheck() throws FileNotFoundException {
        // Path to your ChromeDriver executable

        // Step 1: Initialize WebDriver
    	AccessibilityTest obj= new AccessibilityTest();
    	obj.beforetest("chrome", "https://www.atkinsrealis.com/en/about");
//        WebDriver driver = new ChromeDriver();

        try {
            // Step 2: Open a webpage
  //          driver.get("https://www.atkinsrealis.com/en/about");
            driver.manage().window().maximize();
            String acceptbtn="//button[contains(text(),'Accept all cookies')]";
            driver.findElement(By.xpath(acceptbtn));
            Thread.sleep(2000);
            // Step 3: Load the axe.min.js script
            URL axeScriptUrl = AccessibilityTest.class.getResource("/axe.min.js");
       //     File axeScript = new File(axeScriptUrl.toURI());
            AxeBuilder builder = new AxeBuilder();
            // Step 4: Run Axe accessibility checks
            JavascriptExecutor js = (JavascriptExecutor) driver;
        //    Results results = new AXE.Builder(driver, axeScript).analyze();
        //    Results results= new AXE.Builder(driver, axeScriptUrl);           
            String timeoutFilePath = "src/test/resources/axe.min.js";       	 
        	FileAxeScriptProvider axeScriptProvider = new FileAxeScriptProvider(timeoutFilePath);        	 
        	builder.setAxeScriptProvider(axeScriptProvider);        	 
        	Results results = builder.analyze(driver);        	 
        	List<Rule> violations = results.getViolations();
            
            // Step 5: Check for accessibility violations
            if (results.getViolations().size() == 0) {
                System.out.println("No accessibility violations found!");
            } else {
                System.out.println("Accessibility Violations:");

                // Print details of violations
            //    List<Rule> violations = results.getViolations();
                for (Rule violation : violations) {
                    System.out.println("Violation ID: " + violation.getId());
                    System.out.println("Description: " + violation.getDescription());
                    System.out.println("Impact: " + violation.getImpact());
                    System.out.println("Elements:");
                    violation.getNodes().forEach(node -> System.out.println(" - " + node.getTarget()));
                }
            }

        	} catch (Exception e) {
            e.printStackTrace();
        	} finally {
            // Step 6: Quit the WebDriver
            driver.quit();
        
        	}
        
      }
}
