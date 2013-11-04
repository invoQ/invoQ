package org.invoq.reflect.test;
import java.util.Scanner;

import org.invoq.reflect.cmd.CommandTest;


public class ReflectTest1 {

	public static void main(String[] args) throws Exception{
		
		//Scanner scanner = new Scanner(System.in);
		
		//System.out.println("�ε��ϰ� ���� Ŭ���� �̸���? ");
		
		//String className = scanner.nextLine();
		
		//System.out.println(TestObj.class);
		
		String className = "org.thinker.sample.TestObj";
		
//		TestObj obj = null;
//		
//		Thread.sleep(3000);
//		
//		obj = new TestObj();
		
		try {
			//�޸𸮿� Ŭ������ �ε��ϴ� 
			Class clazz = Class.forName(className);
			
			Class clazzd = CommandTest.class;
			
			
			System.out.println(clazz);
			
			Thread.sleep(3000);
			
			Class clazz2 = Class.forName(className);
			
			System.out.println(clazz2);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
