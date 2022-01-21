package me.xSora.FileManager;

public class GenerateConfigFile {
	
	public static void GenerateConfig() {
		//Spawn Limiter
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_0_10", 500);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_10_20", 1000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_20_30", 2000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_30_40", 3000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_40_50", 5000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_50_60", 7000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_60_70", 9000);
		FileManager.config.set("Configuration.MaxSpawnDistance.Level_70_80", 1100);
		
		
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
