package us.radiationnetwork.practiceserver.respawn;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.enums.Alignment;
import us.radiationnetwork.practiceserver.storage.FileManager;

public class RespawnHandler implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.setKeepInventory(true);
		e.setKeepLevel(true);
		List<ItemStack> drops = new ArrayList<ItemStack>();
		Alignment alignment = FileManager.getAlignment(p.getName());
		drops.addAll(getDrops(p, alignment));
		for (ItemStack drop : drops) {
			p.getInventory().removeItem(drop);
			p.getWorld().dropItemNaturally(p.getLocation(), drop);
		}
		p.spigot().respawn();
	}

	public List<ItemStack> getDrops(Player p, Alignment alignment) {
		List<ItemStack> drops = new ArrayList<ItemStack>();
		switch (alignment) {
		case CHAOTIC:
			for (int i = 0; i < p.getInventory().getContents().length; i++) {
				ItemStack item = p.getInventory().getItem(i);
				if (item.getType() == Material.AIR) continue;
				drops.add(item);
			}
			break;
		case LAWFUL:
			for (int i = 0; i < p.getInventory().getContents().length; i++) {
				ItemStack item = p.getInventory().getItem(i);
				if (item.getType() == Material.AIR) continue;
				drops.add(item);
				if (p.getEquipment().getHelmet() != null) {
					drops.remove(p.getEquipment().getHelmet());
				}
				if (p.getEquipment().getChestplate() != null) {
					drops.remove(p.getEquipment().getChestplate());
				}
				if (p.getEquipment().getLeggings() != null) {
					drops.remove(p.getEquipment().getLeggings());
				}
				if (p.getEquipment().getBoots() != null) {
					drops.remove(p.getEquipment().getBoots());
				}
				if (p.getInventory().getItem(0) != null) {
					drops.remove(p.getInventory().getItem(0));
				}
			}
			break;
		case NEUTRAL:
			for (int i = 0; i < p.getInventory().getContents().length; i++) {
				ItemStack item = p.getInventory().getItem(i);
				if (item.getType() == Material.AIR) continue;
				drops.add(item);
				if (p.getEquipment().getHelmet() != null) {
					drops.remove(p.getEquipment().getHelmet());
				}
				if (p.getEquipment().getChestplate() != null) {
					drops.remove(p.getEquipment().getChestplate());
				}
				if (p.getEquipment().getLeggings() != null) {
					drops.remove(p.getEquipment().getLeggings());
				}
				if (p.getEquipment().getBoots() != null) {
					drops.remove(p.getEquipment().getBoots());
				}
				if (p.getInventory().getItem(0) != null) {
					drops.remove(p.getInventory().getItem(0));
				}
			}
			break;
		}
		return drops;
	}

}
