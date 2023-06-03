package fr.raccoongang.duoslegendaires;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
//import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DuosListeners implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		ItemStack dsword = new ItemStack(Material.NETHER_STAR);
		ItemMeta dswordM = dsword.getItemMeta();
		dswordM.setDisplayName("§ctest");
		dswordM.setLore(Arrays.asList("nether star" , "pour test", "les clics"));
		dsword.setItemMeta(dswordM);
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
		player.getInventory().addItem(dsword);
		player.updateInventory();		
	}
	public ItemStack getItem(Material material, String name, String lore, Enchantment enchant, Integer lvl) {
		
		ItemStack it = new ItemStack(material, 1);
		ItemMeta itM = it.getItemMeta();
		itM.setDisplayName(name);
		itM.setLore(Arrays.asList(lore));
		itM.addEnchant(enchant, lvl, false);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		it.setItemMeta(itM);
		
		return it;
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action action = e.getAction();
		ItemStack item = e.getItem();
		
		if(item == null) return;
		
		if(item.getType() == Material.DIAMOND && action == Action.RIGHT_CLICK_AIR) {
			
			Inventory inv = Bukkit.createInventory(null, 45,"§7Menu");
			
			inv.setItem(11, getItem(Material.DIAMOND_SWORD, "§bT8", "test de lore", Enchantment.DAMAGE_ALL, 5));
			inv.setItem(15, getItem(Material.DIAMOND, "TrukKiBrill", ":D", Enchantment.DURABILITY, 1));
			//						item	         nom custom   description custom	enchant custom   niveau de l'enchant (0 pour non enchant, valeur max = lvl max de l'enchant)
			player.openInventory(inv);
			
		}
		if(item.getType() == Material.NETHER_STAR && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§ctest")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20, 0));
			
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent ev) {
		
		Inventory inv = ev.getInventory();
		Player player = (Player) ev.getWhoClicked();
		ItemStack current = ev.getCurrentItem();
		
		if(current==null) return;
		if(inv.getSize() == 45) {
		switch (current.getType()) {
			case DIAMOND:
				ev.setCancelled(true);
				player.chat("/test");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give @a minecraft:cooked_beef");
				player.closeInventory();
				break;
			case DIAMOND_SWORD:
				ev.setCancelled(true);
				player.chat("/spawn");
				player.closeInventory();
				break;
			default: break;
			}
		}
	}
}
