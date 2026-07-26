package test;
import org.testng.annotations.Test;
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
		// need to resolve an error so check it
		 obj.Count_Product();
	}
	
		
		
}