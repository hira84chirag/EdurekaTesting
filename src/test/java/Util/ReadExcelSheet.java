package Util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ReadExcelSheet {
	WebDriver driver;
	int count=0,col=0;
	static int s=0;
	FileOutputStream fos;
	Workbook workbook;
	Sheet sheet;
	static int abc=0;
	
public void openExcelsheet() {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Test Data");

}
	public void WriteExcel(String value) throws IOException {
	        // Create a workbook and sheet
	  
	        // Add data
	        Row row = sheet.createRow(s);
	        //row.createCell(i).setCellValue("Username");
	        //row.createCell(1).setCellValue("Password");
	        
	        row.createCell(s).setCellValue(value);
	        
	        //Row row1 = sheet.createRow(1);
	        //row1.createCell(0).setCellValue("user1");
	        //row1.createCell(1).setCellValue("pass1");
	        
	        // Write to file
	        FileOutputStream fos = new FileOutputStream("src/test/java/Util/Book2.xlsx");
	        workbook.write(fos);
	        s++;
	    }

	public WebDriver ReadExcelSheet() {
		return driver;
		
	}
	
}
	

