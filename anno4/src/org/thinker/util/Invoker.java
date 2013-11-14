package org.thinker.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.anno.RequestParam;
import org.thinker.anno.Result;
import org.thinker.anno.ResultAttr;

public class Invoker {

	private Method method;
	private Object obj;
	
	public Invoker(Method method, Object obj) {
		super();
		this.method = method;
		this.obj = obj;
	}
	
	
	public void invoke(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		System.out.println(method);
		System.out.println(obj);
		
		
		Class[] parmeterTypes = method.getParameterTypes();
		
		Object[] parameterArr = new Object[parmeterTypes.length];
		
		
		
		Annotation[][] annos = method.getParameterAnnotations();
		
		int idx = 0; 
		
		for(Annotation[] tempArr: annos){
			
			
			//System.out.println(Arrays.toString(tempArr));
			for(Annotation tempAnno: tempArr){
				
				if(tempAnno.annotationType() == RequestParam.class){
					String value = ((RequestParam)tempAnno).value();
					System.out.println("value: " + value);
					
					if(value.startsWith("org.thinker")){
						
						parameterArr[idx] = new ParameterUtil().makeVO(request, value);
						continue;
					}
					
					
					if(value.equals(RequestParam.SESSION)){
						parameterArr[idx] = request.getSession();
					}else{
						
						parameterArr[idx] = request.getParameter(value);
					}
					
				}
				
				
			}
			
			idx++;
			
		}//end for
		
		System.out.println(Arrays.toString(parameterArr));
		
		System.out.println("RESULT : " + method.isAnnotationPresent(Result.class));
		
		
		
		Result result = method.getAnnotation(Result.class);
		
		if(result == null){

			RequestDispatcher dispatcher = request.getRequestDispatcher(method.getName()+".jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		Object resultObj = method.invoke(obj, parameterArr);
		
		if( method.isAnnotationPresent(ResultAttr.class)){
		
			ResultAttr attr = method.getAnnotation(ResultAttr.class);
			
			request.setAttribute(attr.value(), resultObj);
		}
		
		System.out.println("RESULT PAGE: " + result.value());
		
		
		if(result.redirect() == false){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(result.value());
			
			
			
			dispatcher.forward(request, response);
		}
		
	}
	
	
}
















