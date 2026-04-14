package test;
import org.testng.annotations.Test;
import pom.BrowserCommand_page;

public class BrowserCommand extends BaseTest {
	
	public BrowserCommand() throws Exception {
		super();
	}
	@Test(priority =1)
	public void GoogleUrl() throws Exception {
		BrowserCommand_page obj= new BrowserCommand_page();
		obj.Google_Url();
		obj.googleNavigate();
	}	

}
