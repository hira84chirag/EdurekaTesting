package basic;

public class BrowserCommandExample extends BaseTest{
	
	
	public void browserCommandDemo() {
		
		//get
//		driver.get("http://www.facebook.com");
		
		//get current url
//		String url = driver.getCurrentUrl();
//		System.out.println("url = " + url);
		
		//get title
//		String title = driver.getTitle();
//		System.out.println("page title = " + title);
		
		//laymans way of writing the testcases
//		String expectedResult = "Facebook – log in or sign up";
//		String actualResult = driver.getTitle();
//		if(actualResult.equals(expectedResult))
//			System.out.println("Page title test case - passed");
//		else
//			System.out.println("Page title test case - failed");
		
		
		//get page source
//		String pageSource = driver.getPageSource();
//		System.out.println("page source = " + pageSource);
		
		
		//Thread.sleep is used for demo purpose
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close the tab
//		driver.close();
		
		//quit the browser window
		driver.quit();
		
		
	}

	public static void main(String[] args) {
		BrowserCommandExample obj = new BrowserCommandExample();
		obj.setupBrowser("chrome", "https://www.facebook.com");
		obj.browserCommandDemo();
	}

}
