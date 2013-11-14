import java.lang.reflect.Constructor;


public class ReflectTest2 {

	public static void main(String[] args) throws Exception{
		
		String className = "org.thinker.sample.TestObj";
		
		Class clz = Class.forName(className);
		
		//�����ڰ� ���ų� ( )�����ڸ� �ִ� ���� Ŭ�������� �ٷ� ��ü ���� ����
		
//		Object obj = clz.newInstance();
//		
//		System.out.println(obj);
		
		Constructor con = clz.getDeclaredConstructor(String.class);
		
		Object obj = con.newInstance("");
		
		System.out.println(obj);
		

		
		
		
	}
}
