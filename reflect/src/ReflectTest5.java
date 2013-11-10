import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ReflectTest5 {

	public static void main(String[] args) throws Exception{
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("name", "으힛");
		paramMap.put("id", "USER00");
		
		
		Class clz = Class.forName("org.thinker.sample.MemberVO");
		
		//System.out.println(clz);
		
		Object obj = clz.newInstance();
		
		BeanInfo info = Introspector.getBeanInfo(clz);
		
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		
		for(PropertyDescriptor p: props){
			
			System.out.println(p.getDisplayName());
			System.out.println(p.getPropertyType());
			
			Method setMethod = p.getWriteMethod();
			
			if(setMethod == null){
				continue;
			}
			
			setMethod.invoke(obj, paramMap.get(p.getDisplayName()));
			
		}
		
		System.out.println(obj);
		
		
	}
}










