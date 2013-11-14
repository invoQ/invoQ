package org.thinker.actions;

import org.thinker.anno.Controller;
import org.thinker.anno.RequestMapping;

@Controller("sample")
public class SampleController {

	
	@RequestMapping("/bbb")
	public String execute(){
		System.out.println("exeucte............ bbb");
		return "sample.jsp";
	}
}
