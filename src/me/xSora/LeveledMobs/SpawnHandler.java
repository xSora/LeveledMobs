package me.xSora.LeveledMobs;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import me.xSora.FileManager.CreaturesList;
import me.xSora.FileManager.FileManager;

public class SpawnHandler {
	
	private static boolean show_level;
	
	public static void Init() {
		
		show_level = FileManager.config.getBoolean("Configuration.ShowLevel");
		
	}
	
	public static void SpawnMob(Entity et) {
		if(CreaturesList.leveledMobs.contains(et.getType())) {
			//if Mob is on the List
			int level = Utils.CalculateLevel(et);
			setLevel(et, level);
			setStats(et, level);
		}
	}
	
	private static void setLevel(Entity et, int level) {
		// Zombie | Level 100
		String CustomName = et.getName() + " | Level "+level;
		
		if(level == 100) {
			CustomName = et.getName() + " | Level §c§k"+level;
		}
		
		et.setCustomName(CustomName);
		et.setCustomNameVisible(show_level);
	}
	
	private static void setStats(Entity et, int level) {
		
		LivingEntity le = (LivingEntity)et;
		
		//Set Damage
		double damage = ((Attributable) et).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue();
		((Attributable) et).getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(Utils.calc(damage, level));
		
		//Set Armor
		if(level > 15) {
		double armor = ((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR).getBaseValue();
		((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(Utils.calc(armor, level));
		}
		
		//Set Health
		if(level > 15) {
		double health = ((Attributable) et).getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
		if(level <= 100) {
			if(health > 100) {
				((Attributable) et).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
			}else {
				((Attributable) et).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Utils.calc(health, level));
			}
		}else {
			((Attributable) et).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Utils.calc(health, level));
			}
		le.setHealth(le.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
		}
		
		//Set Armor Toughness
		double resistance = ((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getBaseValue();
		((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(Utils.calc(resistance, level));
	}

}
