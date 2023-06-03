package fr.raccoongang.duoslegendaires.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAlea implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (sender instanceof Player) {
				
				Random random = new Random();
				Player player = (Player)sender;
				
				Location xyz = player.getLocation();
				Location spawn = new Location(Bukkit.getWorld("world"), xyz.getX() + random.nextInt(500), xyz.getY() + random.nextInt(50), xyz.getZ() + random.nextInt(500), 1.8f, 7.4f);
				player.teleport(spawn);
			}
		return false;
	}

}
