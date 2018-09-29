package com.mute.webapp.firstWebApp.forfun.fighter;

public class MainTester {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub 
		testFight(null,null);

	}
	
	
	public static String testFight(String nameA,String nameB)throws Exception{
		StringBuffer result = new StringBuffer();
		if(nameA ==null || nameA.length()==0) {
			nameA = "本群主";
		}
		if(nameB	 ==null || nameB.length()==0) {
			nameB = "特朗普";
		}
		//String fileName = "fightrecord.html";
	//	FileUtil.createFile(fileName,true);
		Human a= new Human();
		Human b= new Human();
		a.setHealthPoint(1000);
		b.setHealthPoint(1000);
		a.setNickName(nameA);
		b.setNickName(nameB);
		a.setWeaponList(TestDataSupplier.getTestWeaponList(5));
		b.setWeaponList(TestDataSupplier.getTestWeaponList(5));
		boolean aAttckFlag =true;
		result.append("群主启动QQ特权，先行展开攻击！");
		result.append("<BR/>");
	//	FileUtil.writeALine(fileName, "群主启动QQ特权，先行展开攻击！",true);
		//FileUtil.writeALine(fileName, "<BR>",true);
		while(a.getHealthPoint()>0 && b.getHealthPoint()>0) {
			String line="";
			if(aAttckFlag) {
				aAttckFlag=false;
				line=TestAttacker.attack(a, b);
			}else {
				aAttckFlag=true;
				line=TestAttacker.attack(b, a);
			}
			
			//FileUtil.writeALine(fileName, line,true);
			result.append(line);
			result.append("<BR/>");
			
		}
		String deadName="";
		String aliveName="";
		if(a.getHealthPoint()<=0) {
			deadName = a.getNickName();
			aliveName = b.getNickName();
		}else {
			deadName = b.getNickName();
			aliveName = a.getNickName();
		}
		//FileUtil.writeALine(fileName, "<BR>",true);
		String finaLine = deadName +"血溅当场，杀死他的是"+aliveName+"和"+StrUtil.getRdmStrFromArray(Statics.KILLER);
		
		//FileUtil.writeALine(fileName, HTMLLabUtil.setFont(finaLine, "5", "#FF7F50"),true);
		//System.out.println("finished");
		result.append("<BR/>");
		result.append(finaLine);
		return result.toString();
		
		
		
		
	}

}
