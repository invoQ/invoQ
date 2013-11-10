package org.thinker.controll;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.thinker.anno.Action;
import org.thinker.anno.RequestParam;

public abstract class BasicController {

	
	public void init()throws Exception{
		System.out.println("init..............");
	}
	
	
	public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Object obj = null;
		
		//� �޼ҵ带 �����ϴ°��� ���� ������ �˾Ƴ��� �Ѵ�. 
		Action actionAnno = this.getClass().getAnnotation(Action.class);
		String cri = actionAnno.criteria();
		//cmd, method, job 
		
		
		// /aaa.do?cmd=login
		String methodName = request.getParameter(cri);
		
		Method[] methods = this.getClass().getMethods();
		
		Method targetMethod = null;
		
		for(Method m:methods){
			
			if(m.getName().equals(methodName)){
				targetMethod = m;
				break;
			}
		}
		
		
		Object[] params = null;
		//Request�� �Ķ���Ϳ� �޼ҵ��� �Ķ���͸� ��..
		Annotation[][] paramAnno = targetMethod.getParameterAnnotations();
		
		params = new Object[paramAnno.length];
		
		
		//{@org.thinker.anno.RequestParam(value=id)}
		//{@org.thinker.anno.RequestParam(value=pw)}
		
		int idx = 0; 
		
		for(Annotation[] tempArr: paramAnno){
			
			RequestParam param = (RequestParam)tempArr[0];
			
			String paramValue = request.getParameter(param.value());
			params[idx++] = paramValue;
			
		}
		
		System.out.println(Arrays.toString(params));
		
		
		//���� ���� ��� 
		
		obj = targetMethod.invoke(this, params);
		
		return obj;
	}
	
	
	public void clear()throws Exception{
		System.out.println("clear..............");
	}
	
}









