package org.invoq.reflect.sample;

public class TestObj extends ParentObj {

	static{
		System.out.println("TestObj static block");
	}
	
//	public TestObj(){
//		System.out.println("�� ������");
//	}
	
	public TestObj(String str){
		System.out.println("���ڿ� ������");
	}
	
	
	public void doA(){
		System.out.println("doA.....");
	}
	
//	public static void main(String[] args) {
//		
//		System.out.println("ZZZZZZZZZZZZZZZZZZZ");
//		
//		TestObj obj = new TestObj();
//		
//		TestObj obj2 = new TestObj();
//		
//		System.out.println(obj);
//		System.out.println(obj2);
//		
//		
//		
//	}
}
