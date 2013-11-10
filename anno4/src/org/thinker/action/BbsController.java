package org.thinker.action;

import java.util.List;

import org.thinker.anno.CheckSession;
import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;
import org.thinker.anno.RequestParam;
import org.thinker.anno.ResultAttr;
import org.thinker.bbs.BbsVO;

@Controller
public class BbsController {
	
	
	/*
	 * ���ʿ����� �Ķ���� �����Ǿ �Ѿ�;� �ϰ�, 
	 * ������ üũ�Ǿ�� �Ѵ�. 
	 */
	@RequestMapping("/bbs/regist")
	@CheckSession("user")
	public void regist(@RequestParam("org.thinker.bbs.BbsVO")BbsVO vo)throws Exception{
		
		System.out.println("bbs regist: " + vo);
	}
	
	public @ResultAttr("list") List<BbsVO> list() throws Exception{
		
		return null;
	}

}
