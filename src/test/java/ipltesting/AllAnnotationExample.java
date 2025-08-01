package ipltesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllAnnotationExample {
  @Test
  public void T1() {
	  System.out.println("from Method T1");
  }
  @Test
  public void T2() {
	  System.out.println("from Method T2");
  }
  
  @BeforeMethod
  public void BeforeMethod() {
	  System.out.println("from Before Method");
  }

  @AfterMethod
  public void AfterMethod() {
	  System.out.println("from After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("from Before Class ");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("from after Class ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("from Before method ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("from after method ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("from Before Suit ");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("from after Suit ");
  }

}
