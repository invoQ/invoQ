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
			//Ư�� ��Ű���� �����ؼ� Ŭ�������� �˾Ƴ��� �Ѵ�. 
			List<String> classNames = PackageTest.findClassesWithPackageName("org.thinker.actions");
			
			//Ŭ������ @Controller��� Annotation�� �ɷ� �ִ����� �����Ѵ�. 
			
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
			
			
			//���� @Controller�� �ɷ� �ִٸ� �޼ҵ���� �����ؼ� Map�� ��´�.
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}













