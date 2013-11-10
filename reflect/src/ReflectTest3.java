import java.lang.reflect.Method;


public class ReflectTest3 {

	public static void main(String[] args) throws Exception{
		
		String className = "org.thinker.sample.Calculator";
		String methodName = "doB";
		
		Class clz = Class.forName(className);
		
		Object obj = clz.newInstance();
		
		//메소드의 찾기 - 메소드의 이름 , 파라미터들... 
		
		Method[] methods = clz.getMethods();
		
		
		
		for(Method m: methods){
			
			String mName = m.getName();
			
			
			
			if(methodName.equals(mName)) {
				System.out.println("find: " + m);
				
				m.invoke(obj, null);
			}
			
		}
		
	}
}
