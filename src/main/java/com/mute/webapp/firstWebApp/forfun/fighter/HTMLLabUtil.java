package com.mute.webapp.firstWebApp.forfun.fighter;

public class HTMLLabUtil {
	
	public static String setFont(String input,String fontSize,String hexColor)throws Exception{
		StringBuffer result = new StringBuffer();
		if(fontSize == null) {
			fontSize="3";
		}
		if(hexColor ==null) {
			hexColor = "#DC143C";
		}
		result.append(" <font size='"+fontSize+"' color='"+hexColor+"'>");
		result.append(input);
		result.append("</font>");
		return result.toString();
	}

}
