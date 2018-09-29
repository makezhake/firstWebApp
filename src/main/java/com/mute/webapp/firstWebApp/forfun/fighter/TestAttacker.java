package com.mute.webapp.firstWebApp.forfun.fighter;

public class TestAttacker {
	
	public static String attack(Human a, Human b)throws Exception{
		String colorfulAname = HTMLLabUtil.setFont(a.getNickName(), null, null);
		String colorfulBname = HTMLLabUtil.setFont(b.getNickName(), null, "#0000FF");
		//句式为： A “副词着”  “向” B “动作” 武器
		StringBuffer result= new StringBuffer();
		result.append(colorfulAname);
		result.append(StrUtil.getRdmStrFromArray(Statics.ABV));
		result.append("向");
		result.append(colorfulBname);
		result.append(StrUtil.getRdmStrFromArray(Statics.ACTION));
		int rdmWeaponPos = Mathutil.randomINT(0, a.getWeaponList().size()-1);
		Weapon selectedWeapon = a.getWeaponList().get(rdmWeaponPos);
		String colorWeaponName = HTMLLabUtil.setFont(selectedWeapon.getNickName(), null, "#008000");
		result.append(colorWeaponName);
		result.append(",");
		int rdm = Mathutil.randomINT(1, 3);
		int damage = 0;
		switch(rdm) {
		case 1://miss
			result.append(colorfulBname);
			result.append(StrUtil.getRdmStrFromArray(Statics.MISS));
			result.append("，躲过了攻击！");
			break;
		case 2://hit
			damage = selectedWeapon.getAttackPoint();
			result.append("造成了"+damage+"点伤害！");
			break;
			
		case 3://critical hit
			damage = selectedWeapon.getAttackPoint()*3;
			result.append(StrUtil.getRdmStrFromArray(Statics.WTF));
			result.append("! "+colorfulAname +"对"+colorfulBname);
			result.append(StrUtil.getRdmStrFromArray(Statics.FATAL));
			result.append("造成了致命的"+damage+"点伤害！");
			break;
		}
		b.setHealthPoint(b.getHealthPoint()-damage);
		return result.toString();
	}

}
