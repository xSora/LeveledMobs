package me.xSora.LeveledMobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.xSora.Main.Main;
import net.milkbowl.vault.economy.Economy;

public class MoneyManager {
	
    private static Economy econ;
    
    private static boolean enabled;
	
	public static void Init() {
        if (!setupEconomy()) {
            Main.plugin.getLogger().severe("Disabled due to no Vault dependency found!");
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
		double money = 100;
		addMoney(p, money);
		p.sendMessage(Utils.sendKilledMessage(level, et, money));
	}
	
	

}
