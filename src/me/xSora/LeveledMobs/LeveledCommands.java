package me.xSora.LeveledMobs;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.xSora.Main.Main;

public class LeveledCommands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String arg, String[] args) {
		if(cs instanceof Player) {
			Player p = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("leveledmobs")) {
				//Player used Command
				if(args.length == 0) {
					// If Player used ex. /leveledmobs
					//TODO: Show some Informations
					p.sendMessage("/LeveledMobs Spawn <EntityName> <Level>");
				}else if(args.length > 0) {
					String comm1 = args[0];
					if(comm1.equalsIgnoreCase("spawn")) {
						if(args.length == 3) {
							//Convert string to Entity
							EntityType et = Utils.getEntityByString(args[1]);
							if(et != null) {
								int level = Utils.convertStringToInt(args[2]);
								if(level != 0) {
									//Spawn Mob if both not null
									//SpawnHandler.SpawnMob(et, p.getLocation(), level);
									p.sendMessage("TODO: Spawn mob");	//TODO: fix mob spawn
								}else {
									p.sendMessage("invalid number");
								}
							}else {
								p.sendMessage("invalid entity");
							}
						}else {
							p.sendMessage("not enough args");
						}
					}
					if(comm1.equalsIgnoreCase("distance")) {
						int dist = (int) p.getWorld().getSpawnLocation().distance(p.getLocation());
						p.sendMessage(""+dist);
					}
					
				}
			}
			
		}else {
			Main.logger.log(Level.WARNING, "This Command can only be executed as Player!");
		}
		return false;
	}

}
