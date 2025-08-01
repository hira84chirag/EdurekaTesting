package ipltesting;

import org.testng.annotations.Test;

public class GroupsTesting {
	
	@Test (groups = "Regression")	
	public void a1() {
		
		 System.out.println("Inserting User");	
	}
	
	@Test(groups = {"Regression","Smoke"})
	public void Updatepassword() {
		
		 System.out.println("Update password");	
	}
	
	@Test(groups = "Smoke")
	public void Deleteuser() {
		
		 System.out.println("Delete user");	
	}
	
	
	@Test(groups = {"Regression","Smoke"})
	public void Read() {
		
		 System.out.println("Read");	
	}
}
