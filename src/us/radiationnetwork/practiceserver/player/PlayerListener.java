package us.radiationnetwork.practiceserver.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.Utils;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		FileManager.addUUID(player);
		if (!player.hasPlayedBefore()) {
			FileManager.addPlayer(player);
			kit(player);
			player.setMaxHealth(50.0D);
			player.setHealth(50.0D);
		}
		player.setHealthScale(20.0D);
		player.setHealthScaled(true);
		e.setJoinMessage(null);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}

	public void kit(Player player) {
		PSItem sword = new PSItem(Material.WOOD_SWORD);
		sword.setName("&fTraining Sword");
		sword.addLore("&cDMG: 2 - 4");
		sword.setUntradable(true);
		sword.setUnbreakable(true);
		
		PSItem axe = new PSItem(Material.WOOD_AXE);
		axe.setName("&fTraining Hatchet");
		axe.addLore("&cDMG: 2 - 5");
		axe.setUntradable(true);
		axe.setUnbreakable(true);
		
		switch (Utils.ir(0, 2)) {
		case 1:
			player.getInventory().addItem(axe.build());
			break;
		case 2:
			player.getInventory().addItem(sword.build());
			break;
		}
		
	}
}
