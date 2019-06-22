package com.xyz.testengine.util;

public class CommonUtils {
	public static String getFileName(String path){
		int index = path.lastIndexOf("\\");
				//System.out.println(index);
				return path.substring(index);
	   
	}
	

}
