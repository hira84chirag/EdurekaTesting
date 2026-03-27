package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//error aave che

public class ReadExcel extends SetupBrowser{
	
	int count=0;
		
	@Test ( priority = 1)	
	public void Facebook_login() throws Exception 
	{		
	  // Path to Excel file
	  String excelFilePath = "src/test/java/Utilities/Book1.xlsx";

      // Open the file
      FileInputStream fis = new FileInputStream(excelFilePath);
      Workbook workbook = new XSSFWorkbook(fis);

      // Access the first sheet
      Sheet sheet = workbook.getSheetAt(0);

   // Iterate through rows
      for (Row row : sheet) {
          for (Cell cell : row) {
              // Print each cell value
              System.out.print(cell.toString() + "\t");
              
          }
          
      }
      System.out.println(" ");
//	  SetupBrowser bt=new SetupBrowser();	  
	  driver.get("https://www.facebook.com/r.php"); 
      
	  String username="",lastname="",regemail="",password="";
      	int i=0;
        List<WebElement> controls = driver.findElements(By.xpath("//div[@class='x78zum5 xdt5ytf xh8yej3']"));

	      // Iterate through rows
	      for (Row row : sheet) {
	    	  
//	          for (Cell cell : row) {
	      	  username = row.getCell(0).getStringCellValue(); // Column 0
              lastname = row.getCell(1).getStringCellValue(); // Column 1
              regemail = row.getCell(3).getStringCellValue(); // Column 1
              password = row.getCell(4).getStringCellValue(); // Column 1
         	 
              controls.get(i).sendKeys(username);
              controls.get(i+1).sendKeys(lastname);
              controls.get(i+2).clear();
              controls.get(i+2)controls. .select("2");
              
              //for (int i = 0; i < controls.size(); i++) {
                  System.out.println("Element index: " + i);
                  controls.get(i).click();  // or any action
                  Thread.sleep(3000);
              //}
              i++;
              
              
	           }
	           
              
	          count++; 
	          // Close workbook
		    //  workbook.close();	 
	      
	          
	}
	
	@Test ( priority = 2)
	public void downloadfile() {		
		// Example for Chrome		
		String downloadFilepath = "C:\\Users\\Dell Enterprise\\Downloads\\Charvi";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.prompt_for_download", false);
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.close();
	}
	
	@Ignore
	@Test ( priority = 1)
	public void WriteExcel(String value,int i) throws Exception {

	        // Create a workbook and sheet
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Test Data");

	        // Add data
	        Row row = sheet.createRow(i);
	        row.createCell(i).setCellValue("Username");
	        row.createCell(1).setCellValue("Password");
	        
	        row.createCell(i).setCellValue(value);
	        
	        Row row1 = sheet.createRow(1);
	        row1.createCell(0).setCellValue("user1");
	        row1.createCell(1).setCellValue("pass1");
	        
	        // Write to file
	        FileOutputStream fos = new FileOutputStream("src/test/java/Util/Book33.xlsx");
	        workbook.write(fos);

	        // Close workbook
	        fos.close();
	        workbook.close();
	    }
		
}
	

