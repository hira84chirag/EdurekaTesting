package basic;
// Find out smallest word in String

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="This is an interview";
		//output is/an and interview;
		
		if(s.length()>0) {
		String[] data= s.split(" ");
		String testdata=data[0];
		String maxstring=" ";
		
		for(String test:data) {
			
			System.out.println(test);
			  if(test.length() < testdata.length() ) { 
				  testdata=test; 				  
			  }
			  else {
				  maxstring=test; 
			  }
			 			
		}
		
		System.out.println( "Small Keyword="+testdata);
		System.out.println( "Big Keyword="+maxstring);
		}
		else
		{
			System.out.println( "String length is 0");
			
		}
		
	}

}
