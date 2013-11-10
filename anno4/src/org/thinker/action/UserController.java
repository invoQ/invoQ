package org.thinker.action;

import javax.servlet.http.HttpSession;

import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;
import org.thinker.anno.RequestParam;
import org.thinker.anno.Result;
import org.thinker.anno.ResultAttr;
import org.thinker.user.UserVO;



@Controller("user")
public class UserController {
	
	@RequestMapping("/user/regist")
	public void regist( @RequestParam(value="org.thinker.user.UserVO") UserVO vo)throws Exception{
		
		
		System.out.println("regist: " + vo);
		
	}
	
	@RequestMapping("/user/view")
	@Result(value ="/viewUser.jsp")
	public @ResultAttr("user")UserVO view( @RequestParam(value="id") String id)throws Exception{
		
		
		System.out.println("view: " + id);
		
		UserVO vo = new UserVO();
		vo.setName("AAAA");
		
		return vo;
		
	}
	
	
	@RequestMapping("/user/login")
	public void login(
			 @RequestParam(RequestParam.SESSION) HttpSession sess, 
			 @RequestParam("id")String id, 
			 @RequestParam("pw")String pw )throws Exception{
		
		System.out.println("login: " + id);
		System.out.println("login: " + pw);
		System.out.println("login: " + sess);
		
	}

}













