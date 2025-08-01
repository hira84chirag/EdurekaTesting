package Live_testcases;

import org.testng.annotations.Test;
import Util.Common;
// import pom.ObjectRepo;

public class CountCountry extends BaseBrowser {
	
	@Test
	public void FaceBookServiceDirectory() {
		// Open  browser and pass url
		BaseBrowser obj=new BaseBrowser();	
		obj.beforetest("chrome","https://www.facebook.com/biz/directory/");
		System.out.println(driver.getCurrentUrl());
		// Create object from object Repository 
		String classpath="//div[@class='_4-u2 _80gx _4-u8']//a";
		
		Common.countLinks(driver,classpath);
		driver.quit();		
	}
		
}
