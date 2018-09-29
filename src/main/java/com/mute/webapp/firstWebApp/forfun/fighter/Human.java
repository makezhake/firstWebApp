package com.mute.webapp.firstWebApp.forfun.fighter;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Human {
	
	private int x;
	private int y;
	private int sightRange;
	private int healthPoint;
	private int movePoint;
	
	
	private ArrayList<Weapon> weaponList;
	
	private String nickName;

}
