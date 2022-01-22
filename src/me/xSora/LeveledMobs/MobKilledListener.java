package me.xSora.LeveledMobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.xSora.FileManager.CreaturesList;

public class MobKilledListener implements Listener{
	
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent ev) {
		LivingEntity target = ev.getEntity();
		LivingEntity killer = ev.getEntity().getKiller();
		
		if(killer instanceof Player) {
			Player p = (Player) killer;
			EntityType et = target.getType();
			if(CreaturesList.leveledMobs.contains(et)) {
				if(target.getCustomName().contains("Level")) {
					String str_level = target.getCustomName().substring(target.getCustomName().indexOf("Level")).replaceAll("Level ", "");
					if(str_level == "§c§k100") {
						//Boss Mob
						MoneyManager.givePlayerMoney(p, ev.getEntity(), 100);
						Bukkit.broadcastMessage("§c"+p.getName()+ " §bdefeated a boss!");
					}else {
						int level = Integer.parseInt(str_level);
						MoneyManager.givePlayerMoney(p, ev.getEntity(), level);
					}
				}
			}
		}
	}

}
