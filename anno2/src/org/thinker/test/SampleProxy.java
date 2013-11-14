package org.thinker.test;

import java.lang.reflect.Method;

import org.thinker.anno.CheckTime;

public class SampleProxy {
	
	
	public Object execute(String className, String methodName, Object...params)throws Exception{
		Object obj = null;
		
		Class clz = Class.forName(className);
		Object target = clz.newInstance();
		
		Method[] methods = clz.getMethods();
		
		Method targetMethod = null;
		boolean check = false;
		
		for(Method method: methods){
			
			if(method.getName().equals(methodName)){
				
				if(method.isAnnotationPresent(CheckTime.class)){
					check = true;
				}
				
				targetMethod = method;
			}
		}
		
		long start = 0;
		long end = 0;
		
		if(check){
			start = System.currentTimeMillis();
		}
		obj = targetMethod.invoke(target, params);
		
		if(check){
			end = System.currentTimeMillis();
		}
		
		System.out.println("time: " + (end - start));
		
		return obj;
		
	}

}
