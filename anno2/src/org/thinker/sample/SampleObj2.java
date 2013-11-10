package org.thinker.sample;

import org.thinker.anno.CheckTime;

public class SampleObj2 {
	
	@CheckTime
	public void doA()throws Exception{
		System.out.println("doA.........");
		Thread.sleep(1000);
	}
	
	@CheckTime
	public void doB()throws Exception{
		System.out.println("doB.........");
		Thread.sleep(2000);
	}
	
	@CheckTime
	public void doC(String str)throws Exception{
		System.out.println("doC.........");
		Thread.sleep(3000);
	}

}
