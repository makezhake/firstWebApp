package com.mute.webapp.firstWebApp.forfun.fighter;

import java.util.ArrayList;

public class TestDataSupplier {
	
	public static ArrayList<Weapon> getTestWeaponList(int count) throws Exception{
		ArrayList<Weapon> result = new ArrayList<Weapon>();
		for(int i=0;i<count;i++) {
			Weapon weapon = new Weapon();
			int attackPoint = Mathutil.randomINT(1, 50);
			double hitRatio=Math.random();
			String nickName = Statics.WEAPON_NAME[Mathutil.randomINT(0, Statics.WEAPON_NAME.length-1)];
			//String temp = StrUtil.getCommonName();
			//nickName = nickName +" "+temp;
			weapon.setNickName(nickName);
			weapon.setAttackPoint(attackPoint);
			
			result.add(weapon);
		}
		
		return result;
	}

}
