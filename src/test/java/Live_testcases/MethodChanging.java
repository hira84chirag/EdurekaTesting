package Live_testcases;

public class MethodChanging {
	
	public static MethodChanging m1() {
		System.out.println("This is m1 method");
		return new MethodChanging();
	}
	public  MethodChanging m2() {
		System.out.println("This is m2 method");
		return new MethodChanging();
	}
	public MethodChanging m3() {
		System.out.println("This is m3 method");
		return new MethodChanging();
	}	
	public static void main(String[] args) {		
	//	MethodChanging obj=new MethodChanging();
		m1().
		m2().
		m3();
	
		
	}
	
}
