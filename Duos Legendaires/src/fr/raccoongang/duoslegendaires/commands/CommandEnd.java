package fr.raccoongang.duoslegendaires.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnd implements CommandExecutor {

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				if (sender instanceof Player) {
					Player player = (Player)sender;
					Location end = new Location(Bukkit.getWorld("world_the_end"), 0, 70, 0, 1.8f, 7.4f);
					player.sendMessage("§4Attention au Dragon !");
					player.teleport(end);
				}
			return false;
		}

	}

