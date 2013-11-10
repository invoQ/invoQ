package org.thinker.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class PackageUtil {

	public static List<String> findClassesWithPackageName(String packageName) throws Exception{
		
		URL currentPath = PackageUtil.class.getClassLoader().getResource("");
		
		
		
		Enumeration<URL> en= PackageUtil.class.getClassLoader().getResources(packageName.replace(".", "/"));
		
		System.out.println(en);
		
		List<String> classFileNames = new ArrayList<String>();
		
		while(en.hasMoreElements()){
			URL url = en.nextElement();
			System.out.println(url);
			
			File file = new File(url.toURI());
			
			File[] files = file.listFiles();
			
			for(File f: files){
				if(f.isFile()){
					classFileNames.add(packageName+"."+f.getName().substring(0, f.getName().lastIndexOf(".")));
				}
			}
			
			
		}
		
		return classFileNames;
	}
	
	public static void main(String[] args) throws Exception{
		
		List<String> names = PackageUtil.findClassesWithPackageName("org.thinker.member");
		
		System.out.println(names);
	}
}
