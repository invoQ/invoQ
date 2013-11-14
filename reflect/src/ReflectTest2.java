import java.lang.reflect.Constructor;


public class ReflectTest2 {

	public static void main(String[] args) throws Exception{
		
		String className = "org.thinker.sample.TestObj";
		
		Class clz = Class.forName(className);
		
		//생성자가 없거나 ( )생성자만 있는 경우는 클래스에서 바로 객체 생성 가능
		
//		Object obj = clz.newInstance();
//		
//		System.out.println(obj);
		
		Constructor con = clz.getDeclaredConstructor(String.class);
		
		Object obj = con.newInstance("");
		
		System.out.println(obj);
		

		
		
		
	}
}
