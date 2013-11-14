package org.thinker.web;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class PackageTest {

	public static List<String> findClassesWithPackageName(String packageName) throws Exception{
		
		URL currentPath = PackageTest.class.getClassLoader().getResource("");
		
		System.out.println("현재 경로 : "+ currentPath);
		
		Enumeration<URL> en= PackageTest.class.getClassLoader().getResources(packageName.replace(".", "/"));
		
		System.out.println(en);
		
		List<String> classFileNames = new ArrayList<String>();
		
		while(en.hasMoreElements()){
			URL url = en.nextElement();
			System.out.println(url);
			
			File file = new File(url.toURI());
			
			File[] files = file.listFiles();
			
			for(File f: files){
				if(f.isFile()){
					System.out.println(packageName+"."+f.getName().substring(0, f.getName().lastIndexOf(".")));
					classFileNames.add(packageName+"."+f.getName().substring(0, f.getName().lastIndexOf(".")));
				}
			}
			
			
		}
		
		return classFileNames;
	}
	
	public static void main(String[] args) throws Exception{
		
		List<String> names = PackageTest.findClassesWithPackageName("org.thinker.member");
		
		System.out.println(names);
	}
}
