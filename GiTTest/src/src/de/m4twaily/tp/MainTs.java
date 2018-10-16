package src.de.m4twaily.tp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MainTs extends JavaPlugin implements Listener {

	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(this, this);
		
		MySQL.disconnect();
	}
	
	public void onDisable() {
		MySQL.disconnect();
	}

	@EventHandler
	public void onArmorStand(PlayerArmorStandManipulateEvent e) {
		Player p = e.getPlayer();

		if (!p.isSneaking()) {

			e.setCancelled(true);
			p.sendMessage(" §8>> §c§lLevel gecheatet");
			p.setLevel(p.getLevel() + 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 20));
		} else {

		}
	}

}
