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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.command.commands.CommandAddLootbuff;
import us.radiationnetwork.practiceserver.command.commands.CommandAddUniqueLootbuff;
import us.radiationnetwork.practiceserver.storage.FileManager;
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
						FileManager.setCurrentLootbuff("loot", Utils.convertStringToMillis("30minute"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes(buff.getItemMeta().getDisplayName() + " &6 has been activated by " + p.getName()));
					}
				} else if (buff.equals(new CommandAddUniqueLootbuff().getLootbuff())) {
					if (buffs.isEmpty()) {
						p.setItemInHand(new ItemStack(Material.AIR));
						buffs.add("uq");
						FileManager.setCurrentLootbuff("uq", Utils.convertStringToMillis("30minute"));
						Bukkit.getServer().broadcastMessage(Utils.colorCodes(buff.getItemMeta().getDisplayName() + " &6 has been activated by " + p.getName()));
					}
				}
			}
		}
	}
	
	public static void checkLootbuffs() {
		if (!(FileManager.getCurrentLootbuff().equals("none"))) {
			if (Utils.endLB(FileManager.getLootbuffTime(FileManager.getCurrentLootbuff()))) {
				if (buffs.contains("loot")) {
					Bukkit.getServer().broadcastMessage(Utils.colorCodes("&6Global lootbuff has expired!"));
				} else if (buffs.contains("uq")) {
					Bukkit.getServer().broadcastMessage(Utils.colorCodes("&6Global &e&oUnique &6lootbuff has expired!"));
				}
				buffs.remove(FileManager.getCurrentLootbuff());
				FileManager.setLootbuffTime(FileManager.getCurrentLootbuff(), 0);
				FileManager.setCurrentLootbuff("none");
				return;
			}
		}
	}
	
	public static void enable() {
		try {
			FileManager.setupLootbuffs();
			checkLootbuffs();
			if (!(FileManager.getCurrentLootbuff().equals("none"))) {
				buffs.add(FileManager.getCurrentLootbuff());
			}
			System.out.println("[" + LootBuffHandler.class.getSimpleName() + "] has been enabled!");
		} catch (Exception e) {
			Main.getInstance().logError(e.getStackTrace(), e.getMessage(), e.getCause());
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!buffs.isEmpty()) {
			if (buffs.contains("loot")) {
				p.sendMessage(Utils.colorCodes("&6Global lootbuff is activated " + Utils.parseMilis(FileManager.getLootbuffTime("loot"))));
			} else if (buffs.contains("uq")) {
				p.sendMessage(Utils.colorCodes("&6Global &e&oUnique &6lootbuff is activated " + Utils.parseMilis(FileManager.getLootbuffTime("uq"))));
			}
		}
	}
}
