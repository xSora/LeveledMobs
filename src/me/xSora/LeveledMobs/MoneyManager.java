package me.xSora.LeveledMobs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.xSora.FileManager.FileManager;
import me.xSora.Main.Main;
import net.milkbowl.vault.economy.Economy;

public class MoneyManager {
	
    private static Economy econ;
    
    private static boolean enabled;
	
	public static void Init() {
        if (!setupEconomy()) {
            System.err.println("Disabled due to no Vault dependency found!");
            enabled = false;
            Bukkit.getPluginManager().disablePlugin(Main.plugin);
            return;
        }
        enabled = true;
	}
	
    private static boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = Main.plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public static void addMoney(Player p, double amount) {
		if(enabled) {
			econ.depositPlayer(p, amount);
		}
	}
	
	
	
	public static void givePlayerMoney(Player p,Entity et, int level) {
		//Calculate Money
		EntityType ett = et.getType();
		
		double money = Utils.GenerateReward(getMin(ett), getMax(ett), level);
		
		
		addMoney(p, money);
		p.sendMessage(Utils.sendKilledMessage(level, et, money));
	}
	
	private static double getMin(EntityType et) {
		FileConfiguration config = FileManager.config;
		
		double amount = 0;
		
		for(String key : config.getConfigurationSection("Creatures").getKeys(false)){
			
			amount = config.getDouble("Creatures."+key+".Min");
			
		}
		return amount;
			
	}
	
	private static double getMax(EntityType et) {
		FileConfiguration config = FileManager.config;
		
		double amount = 0;
		
		for(String key : config.getConfigurationSection("Creatures").getKeys(false)){
			
			amount = config.getDouble("Creatures."+key+".Max");
			
		}
		return amount;
			
	}
	

}
