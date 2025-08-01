package ipltesting;

import org.testng.annotations.Test;

public class DependacyExample {
	
	@Test	
	public void Createuser() {
		
		 System.out.println("Inserting User");	
	}
	
	@Test(dependsOnMethods = {"Createuser"})
	public void Updatepassword() {
		
		 System.out.println("Update password");	
	}
	
	@Test(dependsOnMethods = {"Createuser","Updatepassword"})
	public void Deleteuser() {
		
		 System.out.println("Delete user");	
	}
	
	
	@Test(priority=2)
	public void Read() {
		
		 System.out.println("Read");	
	}
}
