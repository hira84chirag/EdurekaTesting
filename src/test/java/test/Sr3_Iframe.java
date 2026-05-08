package test;

import org.testng.annotations.Test;
import Utilities.CommonFunctions;

public class Sr3_Iframe extends BaseTest{
	public Sr3_Iframe() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	String closebtn=pro2.getProperty("close");
	String str=pro2.getProperty("content");;	

	  @Test(invocationCount = 1)
	public void Internet_iframeDemo()  {
		System.out.println(closebtn);
		driver.get(pro1.getProperty("internet"));
		boolean a=CommonFunctions.findEles(driver,closebtn);
		driver.switchTo().frame("mce_0_ifr");			
		CommonFunctions.getText(driver, str);
		// driver .switch to parent frame
		driver.switchTo().defaultContent();
		str=pro2.getProperty("contentstr");
		CommonFunctions.getText(driver, str);
		closebtn=CommonFunctions.Snap(driver,"IframeExample");
	}

}