package me.xSora.LeveledMobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import me.xSora.FileManager.CreaturesList;
import me.xSora.FileManager.FileManager;

public class MobSpawnListener implements Listener{
	
	private static boolean show_level;
	
	//Spawn Reasons
	private static boolean reason_custom;
	private static boolean reason_default;
	private static boolean reason_dispenseregg;
	private static boolean reason_egg;
	private static boolean reason_natural;
	private static boolean reason_raid;
	private static boolean reason_spawner;
	
	public static void Init() {
		
		show_level = FileManager.config.getBoolean("Configuration.ShowLevel");
		//Spawn Reasons
		
		reason_custom = FileManager.config.getBoolean("Configuration.SpawnReason.Custom");
		reason_default = FileManager.config.getBoolean("Configuration.SpawnReason.Default");
		reason_dispenseregg = FileManager.config.getBoolean("Configuration.SpawnReason.Dispenser_Egg");
		reason_egg = FileManager.config.getBoolean("Configuration.SpawnReason.Spawn_Egg");
		reason_natural = FileManager.config.getBoolean("Configuration.SpawnReason.Natural");
		reason_raid = FileManager.config.getBoolean("Configuration.SpawnReason.Raid");
		reason_spawner = FileManager.config.getBoolean("Configuration.SpawnReason.Spawner");
		
	}
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent ev) {
		//Check Spawn Reasons
		SpawnReason sr = ev.getSpawnReason();
		
		//Reason: Custom
		if(sr == SpawnReason.CUSTOM && reason_custom) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Default
		if(sr == SpawnReason.DEFAULT && reason_default) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Egg from Dispenser
		if(sr == SpawnReason.DISPENSE_EGG && reason_dispenseregg) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Spawn Egg
		if(sr == SpawnReason.EGG && reason_egg) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Natural
		if(sr == SpawnReason.NATURAL && reason_natural) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Raid
		if(sr == SpawnReason.RAID && reason_raid) {
			SpawnMob(ev.getEntity());
		}
		
		//Reason: Spawner
		if(sr == SpawnReason.SPAWNER && reason_spawner) {
			SpawnMob(ev.getEntity());
		}
	}
	
	
	private void SpawnMob(Entity et) {
		if(CreaturesList.leveledMobs.contains(et.getType())) {
			//if Mob is on the List
			
			World w = et.getLocation().getWorld();
			Location spawn = w.getSpawnLocation();
			
			double distance = et.getLocation().distance(spawn);
			
			int level = Utils.CalculateLevel(distance);
			
			setLevel(et, level);
			setStats(et, level);
		}
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

}
