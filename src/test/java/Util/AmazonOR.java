package Util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class AmazonOR  {

	@FindBy(how=How.XPATH, using = "//a[contains(text(),'Today')]" )
	public WebElement dealpath;
	
	
			
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
	
}
