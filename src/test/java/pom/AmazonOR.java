package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import Utilities.CommonFunctions;
import test.BaseTest;



public class AmazonOR extends BaseTest {

	public AmazonOR() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(how=How.XPATH, using = "//a[contains(text(),'Today')]" )
	public WebElement dealpath;
	
	String todaydeal= "//a[contains(text(),'Deals')]";
	String classname="//a//span[@class='a-truncate-cut']";
	String strprod="//a[contains(@href, '/dp/')]";
			
	@FindBy(how=How.XPATH, using = ".//*[@id='Quickitemsearch']/td[2]/a/img")
	public WebElement pfserbtnDG;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='Quickitemsearch']/td[2]/div/div/a/img")
	public WebElement pfserbtn;
		
	@FindBy(how=How.XPATH, using = ".//*[@id='Tree_Glyph_CAF204DB722146F2A825BF307C3E943A']" )
	public WebElement pfselTree;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='Tree_Node_CDE82E000C7D4E5F9C49B7DA1488E659']" )
	public WebElement pfselPage;
	
	@FindBy(how=How.ID, using = "Ribbon_Nav_InvestisStrip" )
	public WebElement pfrbInvestis;
	
	@FindBy(how=How.XPATH, using = ".//*[.='Advance Export']" )
	public WebElement pfselTool;
	
	@FindBy(how=How.ID, using = "listSiteName" )
	public WebElement pfselSitenm;
	
	@FindBy(how=How.ID, using = "rbtnExportBy_0" )
	public WebElement pfrdExportbyPgnm;
	
	@FindBy(how=How.ID, using = "rbtnExportBy_1" )
	public WebElement pfrdExportWfnm;
	
	@FindBy(how=How.ID, using = "listformname" )
	public WebElement pfselFormnm;
	
	@FindBy(how=How.ID, using = "txtStartDate" )
	public WebElement pftxtStDt;
	
	@FindBy(how=How.ID, using = "txtEndDate" )
	public WebElement pftxtEtDt;
	
	@FindBy(how=How.ID, using = "btnExport" )
	public WebElement pfbtnexport;
	
	@FindBy(how=How.ID, using = "btnDownload" )
	public WebElement pfbtnDwnAtt;
	
	@FindBy(how=How.ID, using = "btnClose" )
	public WebElement pfbtnClose;
	
	public void Openurl() throws InterruptedException {
		driver.get(pro1.getProperty("amazonin"));
		CommonFunctions.WaitExpt(driver, todaydeal);
		driver.findElement(By.partialLinkText("Bestsellers")).click();
		CommonFunctions.WaitExpt(driver, todaydeal);
// Click Today deals link
		CommonFunctions.waitForElementToClick(driver,todaydeal);
		CommonFunctions.scrollpageamazon(driver);
		CommonFunctions.BrokenLinks(driver,strprod);
		CommonFunctions.BrokenLinks(driver,classname);
	}
	public void find_hiddenEle() { //Open Amazon and click Best link 

		// Open Url browser and maximize
		driver.get(pro1.getProperty("amazonin"));
		
		String contbtn=	pro2.getProperty("contbtn");
		CommonFunctions.findHiddenElement(driver, contbtn,null);
		
		// wait page load time and select Best Sellers menu
		CommonFunctions.waitImplicit(driver, 250);
		driver.findElement(By.partialLinkText("Best")).click();
		
		// wait page load time and select new Releases menu		
		driver.findElement(By.linkText("New Releases")).click();		
	}	
	
	public void Count_Product() throws InterruptedException  {
	    // Set path to your ChromeDriver    
        driver.get(pro1.getProperty("amazonurl"));
        String xpath=pro2.getProperty("amzpro");
        List<WebElement> productLinks = driver.findElements(By.xpath(xpath));
        // Wait for page to load & Find all product link elements=
        CommonFunctions.WaitExpt(driver, xpath);	
        
        System.out.println(" product links: " + productLinks.size());
        for (WebElement link : productLinks) {
            String productUrl = link.getAttribute("href");
            if (productUrl != null && productUrl.contains("/dp/")) {
                Reporter.log(productUrl);
            }                
        }
        CommonFunctions.scrollpage(driver,1000);	        
	}

}
