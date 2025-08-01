package api_testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Serlization {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Student s1=new Student();
		s1.Rollnumber=207;
		s1.Name="Patel Chirag";
		
		String data="D:\\Serlization.txt";
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream(data);
			ObjectOutputStream obj=new ObjectOutputStream(fos);
			obj.writeObject(s1); 
			obj.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		try {
			
			FileInputStream fos = new FileInputStream(data);
			ObjectInputStream ois=new ObjectInputStream(fos);
			
			Student obj=(Student)ois.readObject();
			System.out.println(obj.Name + "--------" + obj.Rollnumber);
			
			ois.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
