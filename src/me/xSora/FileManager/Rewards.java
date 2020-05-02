package me.xSora.FileManager;

import org.bukkit.entity.EntityType;

public class Rewards{
	
	public static EntityType ET;
	public static int MIN;
	public static int MAX;
	
	public Rewards(EntityType et, int min, int max) {
		Rewards.ET = et;
		Rewards.MIN = min;
		Rewards.MAX = max;
	}
}