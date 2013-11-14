package org.thinker.controll;

import org.thinker.anno.Action;
import org.thinker.anno.RequestParam;

@Action(value="/aaa.do", criteria="cmd")
public class AController extends BasicController{

	
	public void login(@RequestParam("id") String userId, 
			          @RequestParam("pw") String userPw)throws Exception{
		
		System.out.println("���� ��ü�� ���ؼ� �α��� �۾��� �����Ѵ�. ");
		
		System.out.println(userId);
		System.out.println(userPw);
		
		System.out.println("���� ��ü�� ���ؼ� �α��� �۾��� ���´�. ");

	}
	
	public void logout(@RequestParam("id") String userId)throws Exception{
	
		System.out.println("���� ��ü�� ���ؼ� �α׾ƿ� �����Ѵ�. ");
		
		System.out.println(userId);
		
		System.out.println("���� ��ü�� ���ؼ� �α׾ƿ� ���´�. ");

	}
	

}




