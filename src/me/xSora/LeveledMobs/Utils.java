package me.xSora.LeveledMobs;

import java.security.SecureRandom;
import java.util.Random;

import org.bukkit.entity.Entity;

import me.xSora.FileManager.FileManager;

public class Utils {
	
	private static boolean bosses;
	private static int bosschance;
	
	private static int MAX_LEVEL;
	private static int MAGIC_NUMBER;
	
	private static String RawMessage;
	
	public static void Init() {
		//Load Data from Config
		
		bosses = FileManager.config.getBoolean("Configuration.Bosses");
		bosschance = FileManager.config.getInt("Configuration.BossChance");
		
		MAX_LEVEL = FileManager.config.getInt("Configuration.Max_Level");			//DEF = 100
		MAGIC_NUMBER = FileManager.config.getInt("Configuration.Magic_Number");		//DEF = 150
		
		RawMessage = FileManager.config.getString("Configuration.DropMoney.Message");
	}
	
	@SuppressWarnings("deprecation")
	public static String sendKilledMessage(int level, Entity et, double money) {
		String MSG_Add_Color = RawMessage.replaceAll("&", "§");
		String MSG_Replace_Level = MSG_Add_Color.replaceAll("%level%", ""+level);
		String MSG_Replace_MobName = MSG_Replace_Level.replaceAll("%mobname%", ""+et.getType().getName());
		String MSG_Replace_Amount = MSG_Replace_MobName.replaceAll("%amount%", money+"");
		String FinalMessage = MSG_Replace_Amount;
		
		return FinalMessage;
	}
	
	public static int CalculateLevel(double distance) {
		
		int dist = (int) Math.round(distance);
		
		int max = 5;
		int min = 1;
		
		boolean randomizer = false;
		
		Random rand = new SecureRandom();
		int rng = rand.nextInt(max - min + 1) + min;
		
		int calc_level = 0;
		
		if(randomizer) {
			calc_level = (dist / MAGIC_NUMBER) + rng;
		}else {
			calc_level = (dist / MAGIC_NUMBER) - rng;
		}
		
		if(calc_level <= 0) {
			calc_level = 1;
		}
		
		if(calc_level > MAX_LEVEL) {
			calc_level = MAX_LEVEL;
		}
		if(bosses){
			Random brand = new SecureRandom();
			int bng = brand.nextInt(bosschance - 1 + 1) + min;
			
			if(bng == (bosschance / 2)) {
				calc_level = 255;
			}
			
		}
		return calc_level;
		
	}
	
    public static double calc(double base, int level) {
        return base * (level/5);
    }
	
}
