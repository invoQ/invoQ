package org.thinker.web;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.actions.AAAController;
import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestPath = "/bbb";
		
		try{
			//특정 패키지를 조사해서 클래스들을 알아내야 한다. 
			List<String> classNames = PackageTest.findClassesWithPackageName("org.thinker.actions");
			
			//클래스에 @Controller라는 Annotation이 걸려 있는지를 봐야한다. 
			
			for(String className: classNames){
				
				Class clz = Class.forName(className);
				
				if(clz.isAnnotationPresent(Controller.class) == false){
					continue;
				}
				System.out.println("class : " + clz.getName());
				
				
				Object obj = clz.newInstance();
				
				Method[] methods = clz.getDeclaredMethods();
				
				
				for(Method m: methods){
					
					RequestMapping reqMappingAnno = m.getAnnotation(RequestMapping.class);
					
					if(reqMappingAnno == null){
						continue;
					}
					
					if(reqMappingAnno.value().equals(requestPath) ){
						
						String str = (String)m.invoke(obj, null);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(str);
						dispatcher.forward(request, response);
						return;
					}
					
					
				}
				
			}
			
			
			//만일 @Controller가 걸려 있다면 메소드들을 조사해서 Map에 담는다.
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}













