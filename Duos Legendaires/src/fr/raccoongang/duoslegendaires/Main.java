package fr.raccoongang.duoslegendaires;

import org.bukkit.plugin.java.JavaPlugin;

import fr.raccoongang.duoslegendaires.commands.CommandAlea;
import fr.raccoongang.duoslegendaires.commands.CommandEnd;
import fr.raccoongang.duoslegendaires.commands.CommandSpawn;
import fr.raccoongang.duoslegendaires.commands.CommandsTest;
import fr.raccoongang.duoslegendaires.tasks.ChronoTask;

//import org.bukkit.Bukkit;
//import org.bukkit.scheduler.BukkitRunnable;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le plugin s'allume !");
		getCommand("test").setExecutor(new CommandsTest());
		getCommand("alert").setExecutor(new CommandsTest());
		getCommand("end").setExecutor(new CommandEnd());
		getCommand("spawn").setExecutor(new CommandSpawn());
		getCommand("alea").setExecutor(new CommandAlea());
		getServer().getPluginManager().registerEvents(new DuosListeners() , this);
		
		
		ChronoTask task = new ChronoTask();
		task.runTaskTimer(this,0,20);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin s'eteint...");
	}
}
