package src.de.m4twaily.tp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.m4twaily.mysql.MySQL;
import de.m4twaily.mysql.Points;

public class MainTs extends JavaPlugin implements Listener {
	static MainTs main;
	
	public void onEnable() {
		main = this;
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(this, this);

		doMySQL();
		
		SpinningSkull.spinSkull(new Location(Bukkit.getWorld("world"), 1297, 64, -330));

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

			Points.addCoins(p.getUniqueId(), 10);

		} else {

		}
	}

	public void doMySQL() {
		try {
			MySQL.connect();

			PreparedStatement ps = MySQL.getConnection()
					.prepareStatement("CREATE TABLE IF NOT EXISTS Points (UUID VARCHAR(100),Value INT(100))");

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
