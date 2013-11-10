package org.thinker.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;
import org.thinker.util.Invoker;
import org.thinker.util.PackageUtil;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(value="/app/*", initParams={@WebInitParam(name="scan-package", value="org.thinker.action")})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String,Invoker> urlMap = new HashMap<String, Invoker>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String targetPackage  = config.getInitParameter("scan-package");
		
		System.out.println("targetPackage:"+targetPackage);
		try{ 
			
			List<String> classNameList = PackageUtil.findClassesWithPackageName(targetPackage);
			
			for(String className: classNameList){
				
				Class clazz = Class.forName(className);
				
				if(clazz.isAnnotationPresent(Controller.class) == false){
					continue;
				}
				
				//컨트롤러 객체를 생성해 두었음 
				Object obj = clazz.newInstance();
				
				makeURLMap(clazz,obj);
				
				
			}
			
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		
	}



	private void makeURLMap(Class clazz, Object obj) {
		
		Method[] methods = clazz.getMethods();
		
		for(Method m:methods){
			
			if(m.isAnnotationPresent(RequestMapping.class) == false){
				continue;
			}
			
			RequestMapping mappingInfo = m.getAnnotation(RequestMapping.class);
			
			System.out.println(mappingInfo.value());
			
			urlMap.put(mappingInfo.value(), new Invoker(m,obj));
			
		}
		
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service.............");

		String requestURI = request.getPathInfo();
		
		Invoker invoker = urlMap.get(requestURI);
		
		try {
			invoker.invoke(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


















