package ipltesting;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ReadExcel extends SetupBrowser{
	
	int count=0;
		
	@Test ( priority = 1)	
	public void Readfile() throws IOException {		
	  // Path to Excel file
	  String excelFilePath = "src/test/java/Util/Book1.xlsx";

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

	  SetupBrowser bt=new SetupBrowser();	  
	  bt.browserOpen("chrome","https://www.facebook.com/r.php"); 
      
	  String username="",lastname="",regemail="",password="";
      
	      // Iterate through rows
	      for (Row row : sheet) {
	    	  
//	          for (Cell cell : row) {
	      	  username = row.getCell(0).getStringCellValue(); // Column 0
              lastname = row.getCell(1).getStringCellValue(); // Column 1
              regemail = row.getCell(3).getStringCellValue(); // Column 1
              password = row.getCell(4).getStringCellValue(); // Column 1
         	 
	      
	              // Print each cell value	
	        	  if (!username.equals("usename")) {
		    	      driver.findElement(By.name("firstname")).sendKeys(username);	    	      
		    	      driver.findElement(By.name("lastname")).sendKeys(lastname);
		    	      driver.findElement(By.name("reg_email__")).sendKeys(regemail);
		    	      driver.findElement(By.name("reg_passwd__")).sendKeys(password);		    	      
		    	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		              driver.navigate().refresh();
		              	Reporter.log(username+"\t"+lastname +"\t"+ regemail+"\t"+password);
		        	  }
	        	  else {
	        		  System.out.println("sdfsd");
	        		}
	           }
	          count++;
	          // Close workbook
		      workbook.close();	 
		      driver.quit();
	      }
	
	@Test ( priority = 2)
	public void WriteExcel(String value,int i) throws IOException {

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
	

