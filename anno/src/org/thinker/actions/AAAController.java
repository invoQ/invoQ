package org.thinker.actions;

import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;

@Controller(value="AAA")
public class AAAController {

	@RequestMapping("/aaa")
	public String doA(){
		
		return "aaa.jsp";
	}
}
