package me.xSora.LeveledMobs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class MobSpawnListener implements Listener{
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent ev) {
		//Delete Spawned mob, Create new
		SpawnHandler.SpawnMob(ev.getEntity());
	}

}
