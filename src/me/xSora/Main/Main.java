package me.xSora.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

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
		String onlineversion = null;
		String localversion = this.getDescription().getVersion();
		try {
			   URL url = new URL("https://raw.githubusercontent.com/xSora/LeveledMobs/master/version.txt");
			   Scanner sc = new Scanner(url.openStream());
			   onlineversion = sc.next();
			   sc.close();
			}
			catch(IOException ex) {
				   ex.printStackTrace();
			}
		
		if(onlineversion != null) {
			if(onlineversion != localversion) {
				System.err.println("A new Version of LeveledMobs is available!");
				System.err.println("Installed Version: "+localversion+" | Latest: "+onlineversion);
			}
		}else {
			System.err.println("Update Check Failed!");
		}
		
	}
	
	

}
