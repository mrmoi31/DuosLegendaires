package fr.raccoongang.duoslegendaires.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				Location spawn = new Location(Bukkit.getWorld("world"), -40, 71, -59, 1.8f, 7.4f);
				player.sendMessage("§2Bon retour dans l'overworld !");
				player.teleport(spawn);
			}
		return false;
	}

}
