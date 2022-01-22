package me.xSora.FileManager;

public class GenerateConfigFile {
	
	public static void GenerateConfig() {
		//Spawn Limiter
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_01_30", 500);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_11_40", 1000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_21_50", 2000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_31_60", 3000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_41_70", 5000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_51_80", 7000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_61_90", 9000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_71_99", 1100);
		
		
		//Set MobSpawnerListener
		
		FileManager.config.set("Configuration.ShowLevel", true);						//Show Custom Level
		FileManager.config.set("Configuration.Bosses", true);							//Enable Bosses Spawn
		FileManager.config.set("Configuration.BossChance", 1000);						//Spawn Boss Chance (1:1000)
		
		//Money drop (REQUIRES VAULT)
		FileManager.config.set("Configuration.DropMoney.Enabled", true);				//Enable Money Drop
		FileManager.config.set("Configuration.DropMoney.LevelMultiplier", 1.5);			//Increase in Percent
		FileManager.config.set("Configuration.DropMoney.Message", "&fYou defeated a &cLevel %level% &b%mobname% &fand got &a%amount%$ &ffor it!");					//Message for Killing
		
		FileManager.SaveConfig();
		
		CreaturesList.GenerateArray();
		
	}
}
