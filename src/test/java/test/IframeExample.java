package test;

import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class IframeExample extends BaseTest{
	public IframeExample() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	String closebtn=pro2.getProperty("close");
	String contentstr=pro2.getProperty("content");;	

	  @Test(invocationCount = 1)
	public void Internet_iframeDemo()  {

		  System.out.println(closebtn);
		driver.get(pro1.getProperty("internet"));
	//	code would be enabled if closebtn is enabled 
		CommonFunctions.Clickbutton(driver, closebtn);
		driver.manage().window().maximize();				
		driver.switchTo().frame("mce_0_ifr");	
		
		CommonFunctions.getText(driver, contentstr);
		// driver .switch to parent frame
		driver.switchTo().defaultContent();
		contentstr="//h3[contains(text(),'An')]";
		CommonFunctions.getText(driver, contentstr);
		closebtn=CommonFunctions.Snap(driver,"IframeExample");
		//System.out.println(abc);

	}

}