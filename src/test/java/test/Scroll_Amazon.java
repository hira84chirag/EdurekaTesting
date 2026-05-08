package test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Utilities.CommonFunctions;
import pom.AmazonOR;

public class Scroll_Amazon extends BaseTest{

	public Scroll_Amazon() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1) 
	public void Amazon_products() throws Exception {
		// TODO Auto-generated method stub
		AmazonOR obj=new AmazonOR();
		obj.Openurl();
		obj.find_hiddenEle();
		obj.Count_Product();
	}
	
		
		
}