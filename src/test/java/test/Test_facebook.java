package test;
import org.testng.annotations.Test;
import pom.Obj_Facebook;
public class Test_facebook extends BaseTest{		
	public Test_facebook() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test 
	public void facebook_locator()
	{				
		Obj_Facebook obj=new Obj_Facebook(driver);
		obj.openFacebook();
		obj.enterEmail("from Username changes");
		obj.clickCreateNewAccount();
		obj.enterEmail("from Royal id");
	}

}
