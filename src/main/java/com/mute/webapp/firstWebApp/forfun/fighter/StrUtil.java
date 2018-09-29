package com.mute.webapp.firstWebApp.forfun.fighter;

public class StrUtil {
	public static String getCommonName()throws Exception{
		int count = Mathutil.randomINT(2, 3);
		StringBuffer result = new StringBuffer();
		for(int i=0;i<count;i++) {
			int pos = Mathutil.randomINT(0, Statics.qianziwen.length()-1);
			result.append(Statics.qianziwen.substring(pos,pos+1));
			
		}
		return result.toString();
	}
	
	public static String getRdmStrFromArray(String[] input)throws Exception{
		int pos = Mathutil.randomINT(0, input.length-1);
		return input[pos];
	}

}
