package org.thinker.test;

import org.thinker.anno.BGM;

public class BGMTest {

	public static void main(String[] args) throws Exception{
		
		String className = "org.thinker.sample.SampleObj1";
		
		Class clz = Class.forName(className);
		
		BGM bgmAnno = (BGM)clz.getAnnotation(BGM.class);
		
		System.out.println(bgmAnno);
		
		
		boolean exist = clz.isAnnotationPresent(BGM.class);
		
		System.out.println(exist);
		
		System.out.println(bgmAnno.value());
		System.out.println(bgmAnno.singer());
		System.out.println(bgmAnno.album().type());
		
		Object obj = clz.newInstance();
		
		
		
		
	}
}




