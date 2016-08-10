package us.radiationnetwork.practiceserver.mining;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.item.ItemGenerator;
import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.Utils;

public class MiningHandler implements Listener {
	
	public static HashMap<Location, Material> ores = new HashMap<Location, Material>();
	public static HashMap<Location, Integer> ore_respawn = new HashMap<Location, Integer>();
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack pick = p.getEquipment().getItemInMainHand();
		Block b = e.getBlock();
		if ((pick != null) && (pick.getType() == Material.GOLD_PICKAXE)) {
			int amount = 1;
			e.setCancelled(true);
			switch (b.getType()) {
			case COAL_ORE:
				ores.put(b.getLocation(), b.getType());
				ore_respawn.put(b.getLocation(), 60);
				b.setType(Material.STONE);
				amount = ItemGenerator.ir(10, 1);
				b.getWorld().dropItemNaturally(b.getLocation(), makeGems(amount));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&e&l          Found " + amount + " GEM(s)"));
				}
				break;
			case EMERALD_ORE:
				ore_respawn.put(b.getLocation(), 120);
				ores.put(b.getLocation(), b.getType());
				b.setType(Material.STONE);
				amount = ItemGenerator.ir(20, 5);
				b.getWorld().dropItemNaturally(b.getLocation(), makeGems(amount));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&e&l          Found " + amount + " GEM(s)"));
				}
				break;
			case IRON_ORE:
				ore_respawn.put(b.getLocation(), 200);
				ores.put(b.getLocation(), b.getType());
				b.setType(Material.STONE);
				amount = ItemGenerator.ir(36, 7);
				b.getWorld().dropItemNaturally(b.getLocation(), makeGems(amount));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&e&l          Found " + amount + " GEM(s)"));
				}
				break;
			case DIAMOND_ORE:
				ore_respawn.put(b.getLocation(), 300);
				ores.put(b.getLocation(), b.getType());
				b.setType(Material.STONE);
				amount = ItemGenerator.ir(43, 13);
				b.getWorld().dropItemNaturally(b.getLocation(), makeGems(amount));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&e&l          Found " + amount + " GEM(s)"));
				}
				break;
			case GOLD_ORE:
				ore_respawn.put(b.getLocation(), 600);
				ores.put(b.getLocation(), b.getType());
				b.setType(Material.STONE);
				amount = ItemGenerator.ir(64, 12);
				b.getWorld().dropItemNaturally(b.getLocation(), makeGems(amount));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&e&l          Found " + amount + " GEM(s)"));
				}
				break;
			default:
				break;
			}
			
		} else if (p.isOp()) {
			return;
		} else {
			e.setCancelled(true);
		}
	}
	
	public ItemStack makeGems(int amount) {
		PSItem gem = new PSItem(Material.EMERALD);
		gem.setName("&fGem");
		gem.addLore("&7The currency of Andalucia");
		gem.setAmount(amount);
		return gem.build();
	}

	public static void reboot() {
		Location loc = null;
		for (Iterator<Location> localIterator = ores.keySet().iterator(); localIterator.hasNext(); ) {
			loc = localIterator.next();
			Material type = ores.get(loc);
			loc.getWorld().getBlockAt(loc).setType(type);
		}
		ores.remove(loc);
		ore_respawn.remove(loc);
		return;
	}
	
	public static void respawnOreTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			public void run() {
				for (Iterator<Location> localIterator = ore_respawn.keySet().iterator(); localIterator.hasNext(); ) {
					
					Location loc = (Location) localIterator.next();
					int time = ore_respawn.get(loc);
					if (time > 0) {
						time--;
						ore_respawn.remove(loc);
						ore_respawn.put(loc, time);
						return;
					} else {
						Material type = ores.get(loc);
						loc.getWorld().getBlockAt(loc).setType(type);
						ore_respawn.remove(loc);
						ores.remove(loc);
						return;
					}
				}
			}
		}, 20L, 20L);
	}
}