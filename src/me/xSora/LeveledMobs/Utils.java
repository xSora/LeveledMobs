package me.xSora.LeveledMobs;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import me.xSora.FileManager.CreaturesList;
import me.xSora.FileManager.FileManager;

public class Utils {
	
	private static double LevelMultiplier;
	
	private static String RawMessage;
	
	private static int spawn_distance_0_10;
	private static int spawn_distance_10_20;
	private static int spawn_distance_20_30;
	private static int spawn_distance_30_40;
	private static int spawn_distance_40_50;
	private static int spawn_distance_50_60;
	private static int spawn_distance_60_70;
	private static int spawn_distance_70_80;
	
	public static void Init() {
		//Load Data from Config
		
		LevelMultiplier = FileManager.config.getDouble("Configuration.DropMoney.LevelMultiplier");
		
		RawMessage = FileManager.config.getString("Configuration.DropMoney.Message");
		
		//Get Distance Limit
		spawn_distance_0_10 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_0_10");
		spawn_distance_10_20 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_10_20");
		spawn_distance_20_30 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_20_30");
		spawn_distance_30_40 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_30_40");
		spawn_distance_40_50 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_40_50");
		spawn_distance_50_60 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_50_60");
		spawn_distance_60_70 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_60_70");
		spawn_distance_70_80 = FileManager.config.getInt("Configuration.MaxSpawnDistance.Level_70_80");
		
		
	}
	
	public static String sendKilledMessage(int level, Entity et, double money) {
		String MSG_Add_Color = RawMessage.replaceAll("&", "§");
		String MSG_Replace_Level = MSG_Add_Color.replaceAll("%level%", ""+level);
		String name = et.getType().name().toLowerCase();
		String MobName = name.substring(0, 1).toUpperCase() + name.substring(1);
		String MSG_Replace_MobName = MSG_Replace_Level.replaceAll("%mobname%", MobName);
		String MSG_Replace_Amount = MSG_Replace_MobName.replaceAll("%amount%", money+"");
		String FinalMessage = MSG_Replace_Amount;
		
		return FinalMessage;
	}
	
	public static int CalculateLevel(Entity et) {
		
		int rng = generateRandom(0,100);
		int distance = (int) et.getWorld().getSpawnLocation().distance(et.getLocation());
		
		//Nested IFs of Hell
		if(distance > spawn_distance_0_10) {
			if(rng <= 10) {
				// X Percent Change
				
			}else if(rng > 10 && rng <= 20) {
				
				
			}else if(rng > 20 && rng <= 30) {
				
			}else if(rng > 30 && rng <= 40) {
				
			}else if(rng > 40 && rng <= 50) {
				
			}else if(rng > 50 && rng <= 60) {
				
			}else if(rng > 60 && rng <= 70) {
				
			}else if(rng > 70 && rng <= 80) {
				
			}else if(rng > 80 && rng <= 90) {
				
			}else if(rng > 90 && rng < 100) {
				
			}else if(rng == 100) {
				//Spawn Boss
			}
			
		}else if(distance > spawn_distance_0_10) {
			
		}else if(distance > spawn_distance_10_20) {
			
		}else if(distance > spawn_distance_20_30) {
			
		}else if(distance > spawn_distance_30_40) {
			
		}else if(distance > spawn_distance_40_50) {
			
		}else if(distance > spawn_distance_50_60) {
			
		}else if(distance > spawn_distance_60_70) {
			
		}else if(distance > spawn_distance_70_80) {
			
		}
		
		return 0;
		
		
	}
	
	public static int generateRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
    public static double calc(double base, int level) {
        return base * (level/5);
    }
    
    public static EntityType getEntityByString(String et) {
        for (EntityType type : EntityType.values()) {
            if(type.name().equalsIgnoreCase(et)) {
                if(CreaturesList.leveledMobs.contains(type)) {
                	return type;
                }else {
                	return null;
                }
            }
        }
		return null;
    }
    
    public static int convertStringToInt(String str) {
    	try {
    		return Integer.parseInt(str);
 		}
 		catch (Exception ex) {
 			return 0;
 		}
    }
    
	
    public static double GenerateReward(double min, double max, int level) {
    	Random rand = new SecureRandom();
    	double rng = min + (max - min) * rand.nextDouble();
    	double value = Math.round(rng*1e2)/1e2;
    	
    	double multiplier = Math.round(level * (LevelMultiplier / 100*1e2)/1e2);
    	
    	
    	return value + multiplier;
    }
    
}
