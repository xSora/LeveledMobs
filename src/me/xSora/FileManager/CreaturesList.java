package me.xSora.FileManager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

public class CreaturesList {
	
	public static List<EntityType> leveledMobs = new ArrayList<>();
	
	public static void GenerateArray() {
		//Get Every Mob in Minecraft
		
		//All Mobs
		leveledMobs.add(EntityType.BLAZE);
		leveledMobs.add(EntityType.CAVE_SPIDER);
		leveledMobs.add(EntityType.CREEPER);
		leveledMobs.add(EntityType.DROWNED);
		leveledMobs.add(EntityType.ELDER_GUARDIAN);
		leveledMobs.add(EntityType.ENDER_DRAGON);
		leveledMobs.add(EntityType.ENDERMAN);
		leveledMobs.add(EntityType.ENDERMITE);
		leveledMobs.add(EntityType.EVOKER);
		leveledMobs.add(EntityType.GHAST);
		leveledMobs.add(EntityType.GIANT);
		leveledMobs.add(EntityType.GUARDIAN);
		leveledMobs.add(EntityType.HUSK);
		leveledMobs.add(EntityType.ILLUSIONER);
		leveledMobs.add(EntityType.IRON_GOLEM);
		leveledMobs.add(EntityType.MAGMA_CUBE);
		leveledMobs.add(EntityType.PHANTOM);
		leveledMobs.add(EntityType.PIG_ZOMBIE);
		leveledMobs.add(EntityType.PILLAGER);
		leveledMobs.add(EntityType.RAVAGER);
		leveledMobs.add(EntityType.SHULKER);
		leveledMobs.add(EntityType.SILVERFISH);
		leveledMobs.add(EntityType.SKELETON);
		leveledMobs.add(EntityType.SLIME);
		leveledMobs.add(EntityType.SPIDER);
		leveledMobs.add(EntityType.STRAY);
		leveledMobs.add(EntityType.VEX);
		leveledMobs.add(EntityType.VINDICATOR);
		leveledMobs.add(EntityType.WITCH);
		leveledMobs.add(EntityType.WITHER_SKELETON);
		leveledMobs.add(EntityType.ZOMBIE);
		leveledMobs.add(EntityType.ZOMBIE_VILLAGER);
		
		for(int i = 0; i < leveledMobs.size(); i++) {
			EntityType et = leveledMobs.get(i);
			String Name = et.name().toUpperCase();
			FileManager.config.set("Creatures."+Name+".Enabled", true);
			FileManager.config.set("Creatures."+Name+".Min", 0.1);
			FileManager.config.set("Creatures."+Name+".Max", 10);
			
		}
		
		FileManager.SaveConfig();
		CreaturesList.LoadArray();
	}
	
	public static void LoadArray() {
		FileConfiguration config = FileManager.config;
		for(String key : config.getConfigurationSection("Creatures").getKeys(false)){
			
			EntityType et = EntityType.valueOf(key);
			boolean enabled = config.getBoolean("Creatures."+key+".Enabled");
			
			if(enabled) {
				leveledMobs.add(et);
			}
			
		}
	}
}
