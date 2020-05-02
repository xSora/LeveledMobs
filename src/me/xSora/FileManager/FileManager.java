package me.xSora.FileManager;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.xSora.Main.Main;

public class FileManager {
	
	public static File configFile;
	public static FileConfiguration config;
	
	
	public static void Init() {
		configFile = new File(Main.getInstance().getDataFolder() + "/config.yml");
		config = YamlConfiguration.loadConfiguration(configFile);
		if(!configFile.exists()) {
			GenerateConfigFile.GenerateConfig();
		}else {
			CreaturesList.LoadArray();
		}
	}
	
	public static void SaveConfig() {
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
