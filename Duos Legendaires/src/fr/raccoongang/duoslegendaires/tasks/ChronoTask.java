package fr.raccoongang.duoslegendaires.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ChronoTask extends BukkitRunnable {
	private int timer = 10;
	@Override
	public void run() {
		
		Bukkit.broadcastMessage("Start dans " + timer + " secondes");
		if(timer == 0) {
			
			Bukkit.broadcastMessage("START !!!");
			cancel();
			
		}
		timer--;
	}

}
