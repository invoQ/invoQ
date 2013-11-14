package org.thinker.controll;

import org.thinker.anno.Action;
import org.thinker.anno.RequestParam;

@Action(value="/aaa.do", criteria="cmd")
public class AController extends BasicController{

	
	public void login(@RequestParam("id") String userId, 
			          @RequestParam("pw") String userPw)throws Exception{
		
		System.out.println("서비스 객체를 통해서 로그인 작업을 시작한다. ");
		
		System.out.println(userId);
		System.out.println(userPw);
		
		System.out.println("서비스 객체를 통해서 로그인 작업을 끝냈다. ");

	}
	
	public void logout(@RequestParam("id") String userId)throws Exception{
	
		System.out.println("서비스 객체를 통해서 로그아웃 시작한다. ");
		
		System.out.println(userId);
		
		System.out.println("서비스 객체를 통해서 로그아웃 끝냈다. ");

	}
	

}




