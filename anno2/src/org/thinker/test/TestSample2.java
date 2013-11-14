package org.thinker.test;

import org.thinker.sample.SampleObj2;

public class TestSample2 {

	public static void main(String[] args) throws Exception{
		
//		SampleObj2 obj = new SampleObj2();
//		
//		obj.doA();
//		obj.doB();
//		obj.doC("AAAA");

		SampleProxy proxy = new SampleProxy();
		proxy.execute("org.thinker.sample.SampleObj2", "doA", null);
		proxy.execute("org.thinker.sample.SampleObj2", "doB", null);
		proxy.execute("org.thinker.sample.SampleObj2", "doC", "AAAA");
		
	}
}
