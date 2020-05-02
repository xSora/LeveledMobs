package me.xSora.FileManager;

public class GenerateConfigFile {
	
	public static void GenerateConfig() {
		//Set Utils
		FileManager.config.set("Configuration.Max_Level", 100);							//Max Mob Level
		FileManager.config.set("Configuration.Magic_Number", 150);						//Used to Calculate Level Lower = Higher level
		
		//Set MobSpawnerListener
		
		FileManager.config.set("Configuration.ShowLevel", true);						//Show Custom Level
		FileManager.config.set("Configuration.Bosses", true);							//Enable Bosses Spawn
		FileManager.config.set("Configuration.BossChance", 1000);						//Spawn Boss Chance (1:1000)
		
		FileManager.config.set("Configuration.SpawnReason.Custom", true);				//If Spawned from Plugin
		FileManager.config.set("Configuration.SpawnReason.Default", true);				//Unknown Reason
		FileManager.config.set("Configuration.SpawnReason.Dispenser_Egg", true);		//If Spawned from Dispenser
		FileManager.config.set("Configuration.SpawnReason.Spawn_Egg", true);			//If Spawned by Spawn Egg
		FileManager.config.set("Configuration.SpawnReason.Natural", true);				//If Spawned Naturally
		FileManager.config.set("Configuration.SpawnReason.Raid", true);					//If Spawned by Raid
		FileManager.config.set("Configuration.SpawnReason.Spawner", false);				//If Spawned by Spawner
		
		//Money drop (REQUIRES VAULT)
		FileManager.config.set("Configuration.DropMoney.Enabled", true);				//Enable Money Drop
		FileManager.config.set("Configuration.DropMoney.Boss.Min", 50);					//Min Money drop for Bosses
		FileManager.config.set("Configuration.DropMoney.Boss.Max", 100);				//Max Money drop for Bosses
		FileManager.config.set("Configuration.DropMoney.Message", "&fYou defeated a &cLevel %level% &b%mobname% &fand got &a%amount%$ &ffor it!");					//Message for Killing
		
		FileManager.SaveConfig();
		
		CreaturesList.GenerateArray();
		
	}
}
