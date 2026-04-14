package test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;
// error aave che
public class RobotExample  extends BaseTest{
	
	public RobotExample() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void tinypng_robotExample() throws Exception {
		driver.get("https://tinypng.com/");
//		driver.manage().window().maximize();
		CommonFunctions.waitThread(400);
		driver.findElement(By.xpath("//section[@class='target']")).click();
		CommonFunctions.waitThread(400);
		Robot robot = new Robot();

		//copy the file location
		String fileName = "D:\\test.jpg";
		
		 Actions actions = new Actions(driver);
	     // Type "keyword" anywhere the focus is
	     actions.sendKeys(fileName).perform();
		
		StringSelection stringSelection = new StringSelection(fileName);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		
		//Thread.sleep is used only for demonstration purpose
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		CommonFunctions.Snap(driver, "RobotExample");
		driver.quit();		
	}
}
