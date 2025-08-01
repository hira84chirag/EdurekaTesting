package ipltesting;

import org.testng.annotations.Test;
// Execute script in order of method provided by groups in Test.
public class GroupsExample {
	
	@Test 	
	public void a1() {
		
		 System.out.println("Inserting User");	
	}
	
	@Test(groups = {"Smoke","Aws.bug"})
	public void Updatepassword() {
		
		 System.out.println("Update password");	
	}
	
	@Test(groups = "Smoke")
	public void Deleteuser() {
		
		 System.out.println("Delete user");	
	}
	
	
	@Test(groups = {"Bug","Aws.bug"})
	public void Read() {
		
		 System.out.println("Read");	
	}
	
	@Test(groups = {"Bug"})
	public void Read1() {
		
		 System.out.println("Read1");	
	}
}
