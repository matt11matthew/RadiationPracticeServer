package us.radiationnetwork.practiceserver.shop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.command.commands.CommandAddLootbuff;
import us.radiationnetwork.practiceserver.utils.Utils;

public class LootBuffHandler implements Listener {
	
	public static List<String> buffs = new ArrayList<String>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if ((p.getItemInHand() != null) && (p.getItemInHand().getType() != Material.AIR)) {
				ItemStack buff = p.getItemInHand();
				if (buff.equals(new CommandAddLootbuff().getLootbuff())) {
					if (buffs.isEmpty()) {
						p.setItemInHand(new ItemStack(Material.AIR));
						buffs.add("loot");
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&a------------------"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&6Lootbuff Activated"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&720%"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&730 Minutes"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&7By: " + p.getName()));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes("&a------------------"));
					}
					
				}
				
			}
		}
	}

}
