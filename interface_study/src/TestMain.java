import java.lang.reflect.Method;


public class TestMain {
	public static void main(String [] args) throws Exception{
		
		String[] strClazzs = {"TestImpl","TestImpl2"};
		String strMethod = "doB";
		
		for(String s:strClazzs){
			Class clazz = Class.forName(s);
			
			Object obj = clazz.newInstance();
			
			Method[] methods = clazz.getMethods();
			for(Method m:methods){
				if(m.getName().equalsIgnoreCase(strMethod)){
					m.invoke(obj, null);
				}
			}
		}
	}
}
