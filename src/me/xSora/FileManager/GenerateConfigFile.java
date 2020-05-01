package me.xSora.FileManager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.EntityType;

public class GenerateConfigFile {
	
	public static void GenerateConfig() {
		//Set Utils
		FileManager.config.set("Configuration.Max_Level", 100);
		FileManager.config.set("Configuration.Magic_Number", 150);
		
		//Set MobSpawnerListener
		
		FileManager.config.set("Configuration.Show_Level", true);
		FileManager.config.set("Configuration.Bosses", true);
		FileManager.config.set("Configuration.BossChance", 1000);
		
		FileManager.SaveConfig();
		
		GenerateArray();
		
	}
	
	
	//Config
	
	public static void GenerateArray() {
		
		List<EntityType> list = new ArrayList<>();
		
		//All Allowed Mobs
		list.add(EntityType.BLAZE);
		list.add(EntityType.CREEPER);
		list.add(EntityType.DROWNED);
		list.add(EntityType.ENDERMITE);
		list.add(EntityType.EVOKER);
		list.add(EntityType.HUSK);
		list.add(EntityType.PHANTOM);
		list.add(EntityType.SHULKER);
		list.add(EntityType.SILVERFISH);
		list.add(EntityType.SKELETON);
		list.add(EntityType.CAVE_SPIDER);
		list.add(EntityType.SPIDER);
		list.add(EntityType.STRAY);
		list.add(EntityType.VEX);
		list.add(EntityType.WITCH);
		list.add(EntityType.WITHER_SKELETON);
		list.add(EntityType.PIG_ZOMBIE);
		list.add(EntityType.ZOMBIE);
		list.add(EntityType.ZOMBIE_VILLAGER);
		
		
		List<String> conv = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			conv.add(list.get(i).name());
			}
		
		
		FileManager.config.set("LeveledMobs", conv);
		
		FileManager.SaveConfig();
		
	}

}
