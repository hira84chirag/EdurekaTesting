package Util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFun {
	
	public static void ScreenShot(String Name, WebDriver ldriver)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss"); // old format: yyyy-MM-dd_HH-mm-ss
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try 
		{
			// now copy the  screenshot to desired location using copyFile method
	 
			FileUtils.copyFile(src, new File("D:/Testing/Selenium/MIS/"+Name+"_"+(sdf.format(System.currentTimeMillis()))+".png"));                              
			
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage()); 
		}
	}

	public static void EnterText(WebElement e, String txt)
	{
		e.click();
		e.clear();
		e.sendKeys(txt);
	}
	
	public static void EnterText(WebElement e, String txt, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
		e.clear();
		e.sendKeys(txt);
	}

	public static void BtnClick(WebElement e)
	{
		e.click();
	}
	
	public static void BtnClick(WebElement e, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}
	
	public static void SwitchToFrame(String e, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(e));
	}
	
	public static void SwitchToFrame(WebElement e, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(e));
	}
	
	public static Alert SwitchToAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	public static void SelboxClick(WebElement e, String str1)
	{
		e.click();
		Select se = new Select(e);
		se.selectByVisibleText(str1);
	}
	
	public static void SelboxClick(WebElement e, String str1, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
		Select se = new Select(e);
		se.selectByVisibleText(str1);
	}
		
	public static String GetText(WebElement e)
	{
		return e.getText();
	}
	
	public static String GetTextValue(WebElement e)
	{
		return e.getAttribute("value");
	}
	
	public static void FileUpload(String FilePath) throws AWTException
	{
		//StringSelection ss = new StringSelection("C:\\TestImage\\testimage1.JPG");
		StringSelection ss = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//Perform KeyStorkes for CTRL+V and Enter Key
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static String TimeStamp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss"); // Old Format: yyyy-MM-dd_HH-mm-ss
		String sTimeStamp = sdf.format(System.currentTimeMillis());
		return sTimeStamp;
	}
	
	public static void WriteForSuccessHFR(String s3i, String[] HRowData, String ENm, String SNm, int Rid) throws IOException
	{
	/*	WriteExcelFile objExcel= new WriteExcelFile();
		String filepath1 = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		String s1 = "Passed";
		String s3 = s3i;
		String[] HFR = HRowData;
		
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s1, Rid, 2);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s3, Rid, 3);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, HFR[0], Rid, 4);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, HFR[1], Rid, 5);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, HFR[2], Rid, 6);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, HFR[3], Rid, 7);	
		*/
	}
	
	public static void WriteForSuccessSFR(String s3i, String[] SRowData, String ENm, String SNm, int Rid) throws IOException
	{
	/*	WriteExcelFile objExcel= new WriteExcelFile();
		String filepath1 = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		String s1 = "Passed";
		String s3 = s3i;
		String[] SFR = SRowData;
		
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s1, Rid, 2);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s3, Rid, 3);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, SFR[0], Rid, 4);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, SFR[1], Rid, 5);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, SFR[2], Rid, 6);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, SFR[3], Rid, 7);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, SFR[4], Rid, 8);
		*/
	}
	
	public static void WriteForFailure(String PName, WebDriver pdriver, String s4i, String ENm, String SNm, int Rid) throws IOException
	{
	/*	WriteExcelFile objExcel= new WriteExcelFile();
		String filepath1 = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		String s2 = "Failed";
		String s4 = s4i;
		String s5 = GenericFun.TimeStamp();
		
		GenericFun.ScreenShot(PName, pdriver);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s2, Rid, 2);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s4, Rid, 3);	
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s5, Rid, 4);
		*/
	}
	
	public static void ExplicitWait(WebElement e, WebDriver driver)
	{
		//Explicit Wait logic
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOf(e));
		//ExpectedConditions.visibilityOfElementLocated((By) e);
		//wait.until(ExpectedConditions.presenceOfElementLocated(abc));
		//delsub = wait.until(ExpectedConditions.visibilityOfElementLocated(e));
	}
	
	//this is not generic fun due to classname variable define here only
	public static void LoaderWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
		By loader = By.className("LockOn");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader)); 
	}
	
	public static void LoaderWait(WebElement e, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
		wait.until(ExpectedConditions.invisibilityOf(e));
	}
		
	public static void ActionContextClick(WebElement e, WebDriver driver)
	{
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOf(e));
		wait.until(ExpectedConditions.elementToBeClickable(e));
		action.contextClick(e).build().perform();
	}
	
	public static void PressEnterKey() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void PressEnterKey(WebElement e)
	{
		e.sendKeys(Keys.RETURN);
	}
	
	public static void CheckboxTick(WebElement e, WebDriver driver)
	{
		try
		{
			if(!e.isSelected())
			{
				GenericFun.BtnClick(e, driver);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Something wrong in Checkbox function");
		}
	}
	
	public static void CheckboxUntick(WebElement e, WebDriver driver)
	{
		GenericFun.BtnClick(e, driver);
	}
	public static void ScrollingPageSize(WebDriver driver,int i) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(driver.manage().window().getSize());
		Dimension d=new Dimension(1382, i);
		driver.manage().window().setSize(d);
	}
	public static void WriteForSuccess(String s3i, String ENm, String SNm, int Rid) throws IOException
	{
/*		WriteExcelFile objExcel= new WriteExcelFile();
		String filepath1 = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		String s1 = "Passed";
		String s3 = s3i;
		String s5 = GenericFun.TimeStamp();
		
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s1, Rid, 2);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s3, Rid, 3);
		objExcel.writeExcelParCell(filepath1, ENm, SNm, s5, Rid, 4);
		*/
	}
}
