import java.lang.reflect.Method;


public class ReflectTest3 {

	public static void main(String[] args) throws Exception{
		
		String className = "org.thinker.sample.Calculator";
		String methodName = "doB";
		
		Class clz = Class.forName(className);
		
		Object obj = clz.newInstance();
		
		//�޼ҵ��� ã�� - �޼ҵ��� �̸� , �Ķ���͵�... 
		
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
