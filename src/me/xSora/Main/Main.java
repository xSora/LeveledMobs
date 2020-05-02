package me.xSora.Main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.xSora.FileManager.FileManager;
import me.xSora.LeveledMobs.MobKilledListener;
import me.xSora.LeveledMobs.MobSpawnListener;
import me.xSora.LeveledMobs.MoneyManager;
import me.xSora.LeveledMobs.Utils;

public class Main extends JavaPlugin{
	
	public static org.bukkit.plugin.Plugin plugin = null;
	
	public void onEnable() {
	    plugin = this;
		//Initialize
		FileManager.Init();
		MobSpawnListener.Init();
		Utils.Init();
		MoneyManager.Init();
		
		getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
		getServer().getPluginManager().registerEvents(new MobKilledListener(), this);
		
		checkForUpdates();
	}
	
	public static Plugin getInstance() {
	    return plugin;
	}
	
	
	private void checkForUpdates() {
		
	}
	
	

}
