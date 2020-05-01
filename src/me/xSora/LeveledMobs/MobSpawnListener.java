package me.xSora.LeveledMobs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.EnumUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import me.xSora.FileManager.FileManager;

public class MobSpawnListener implements Listener{
	
	private static boolean show_level;
	
	private static List<EntityType> leveledMobs = new ArrayList<>();
	
	public static void Init() {
		
		show_level = FileManager.config.getBoolean("Configuration.Show_Level");
		
		//Load Array
		
		ArrayList<String> mob_string = new ArrayList<>(FileManager.config.getStringList("LeveledMobs"));
		
		for(int i = 0; i < mob_string.size(); i++) {
			String MobName = mob_string.get(i);
			if (EnumUtils.isValidEnum(EntityType.class, MobName)) {
				EntityType et = EntityType.valueOf(MobName);
				leveledMobs.add(et);
			}else {
				System.err.println("Unknown Mob Type '"+MobName+"'");
			}
		}
	}
	
	@EventHandler
	public void onMobSpawn(EntitySpawnEvent ev) {
		Entity et = ev.getEntity();
		if(leveledMobs.contains(ev.getEntityType())) {
			//if Mob is on the List
			
			World w = ev.getLocation().getWorld();
			Location spawn = w.getSpawnLocation();
			
			double distance = et.getLocation().distance(spawn);
			
			int level = Utils.CalculateLevel(distance);
			
			set(et, level);
			
		}
		
	}
	
	public void set(Entity et, int level) {
		//Setter
		setLevel(et, level);
		setStats(et, level);
		setDrops(et, level);
	}
	
	private void setLevel(Entity et, int level) {
		// Zombie | Level 100
		String CustomName = et.getName() + " | Level "+level;
		
		if(level == 255) {
			CustomName = et.getName() + " | Level §c§k"+level;
		}
		
		et.setCustomName(CustomName);
		et.setCustomNameVisible(show_level);
	}
	
	@SuppressWarnings("deprecation")
	private void setStats(Entity et, int level) {
		
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
		le.setHealth(le.getMaxHealth());
		}
		
		//Set Armor Toughness
		double resistance = ((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getBaseValue();
		((Attributable) et).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(Utils.calc(resistance, level));
	}
	
	private void setDrops(Entity et, int level) {
		//Increase Loot every 10 Levels
		if(level > 0 && level <= 10) {
			//Lootlevel 1
			LootGenerator.set(1);
		}
		
		if(level > 10 && level <= 20) {
			//Lootlevel 2
			LootGenerator.set(2);
		}
		
		if(level > 20 && level <= 30) {
			//Lootlevel 3
			LootGenerator.set(3);
		}
		
		if(level > 30 && level <= 40) {
			//Lootlevel 4
			LootGenerator.set(4);
		}
		
		if(level > 40 && level <= 50) {
			//Lootlevel 5
			LootGenerator.set(5);
		}
		
		if(level > 50 && level <= 60) {
			//Lootlevel 6
			LootGenerator.set(6);
		}
		
		if(level > 60 && level <= 70) {
			//Lootlevel 7
			LootGenerator.set(7);
		}
		
		if(level > 70 && level <= 80) {
			//Lootlevel 8
			LootGenerator.set(8);
		}
		
		if(level > 80 && level <= 90) {
			//Lootlevel 9
			LootGenerator.set(9);
		}
		
		if(level > 90 && level <= 100) {
			//Lootlevel 10
			LootGenerator.set(10);
		}
		
		if(level > 100) {
			//Lootlevel X Boss
			LootGenerator.set(11);
		}
	}

}
