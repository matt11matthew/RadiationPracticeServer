package us.radiationnetwork.practiceserver.respawn;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.enums.Alignment;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Utils;

public class RespawnHandler implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.setKeepInventory(true);
		e.setKeepLevel(true);
		Alignment alignment = FileManager.getAlignment(p.getName());
		try {
			if (getDrops(p, alignment).isEmpty()) {
				p.spigot().respawn();
				return;
			}
			for (ItemStack drop : getDrops(p, alignment)) {
				p.getInventory().removeItem(drop);
				p.getWorld().dropItemNaturally(p.getLocation(), drop);
			}
			p.spigot().respawn();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public List<ItemStack> getDrops(Player p, Alignment alignment) {
		List<ItemStack> drops = new ArrayList<ItemStack>();
		switch (alignment) {
		case CHAOTIC:
			for (int i = 0; i < p.getInventory().getContents().length; i++) {
				ItemStack item = p.getInventory().getItem(i);
				if (item == null) continue;
				drops.add(item);
			}
			break;
		case LAWFUL:
			for (int i = 0; i < p.getInventory().getContents().length; i++) {
				ItemStack item = p.getInventory().getItem(i);
				if (item == null) continue;
				drops.add(item);
				if (p.getEquipment().getHelmet() != null) {
					drops.remove(p.getEquipment().getHelmet());
				}
				if (Utils.isPickaxe(p.getInventory().getItem(i))) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (Utils.isPickaxe(p.getInventory().getItem(ii))) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
				}
				if (p.getEquipment().getChestplate() != null) {
					drops.remove(p.getEquipment().getChestplate());
				}
				if (p.getEquipment().getLeggings() != null) {
					drops.remove(p.getEquipment().getLeggings());
				}
				if (StatUtils.hasStat(p.getInventory().getItem(i), "Untradable")) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (StatUtils.hasStat(p.getInventory().getItem(ii), "Untradable")) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
				}
				if (StatUtils.hasStat(p.getInventory().getItem(i), "Soulbound")) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (StatUtils.hasStat(p.getInventory().getItem(ii), "Soulbound")) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
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
				if (item == null) continue;
				drops.add(item);
				if (p.getEquipment().getHelmet() != null) {
					drops.remove(p.getEquipment().getHelmet());
				}
				if (p.getEquipment().getChestplate() != null) {
					drops.remove(p.getEquipment().getChestplate());
				}
				if (Utils.isPickaxe(p.getInventory().getItem(i))) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (Utils.isPickaxe(p.getInventory().getItem(ii))) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
				}
				if (StatUtils.hasStat(p.getInventory().getItem(i), "Untradable")) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (StatUtils.hasStat(p.getInventory().getItem(ii), "Untradable")) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
				}
				if (StatUtils.hasStat(p.getInventory().getItem(i), "Soulbound")) {
					for (int ii = 1; i < p.getInventory().getSize(); ii++) {
						if (p.getInventory().getItem(ii) != null) {
							if (StatUtils.hasStat(p.getInventory().getItem(ii), "Soulbound")) {
								drops.remove(p.getInventory().getItem(ii));
							}
						}
					}
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
