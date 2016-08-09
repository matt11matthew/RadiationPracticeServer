package us.radiationnetwork.practiceserver.utils;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class StatUtils {
	
	public static boolean hasStat(ItemStack is, String stat) {
		boolean has = false;
		try {
			if ((is.hasItemMeta()) && (is.getItemMeta().hasLore())) {
				List<String> lore = is.getItemMeta().getLore();
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains(stat)) {
						has = true;
					}
				}
			}
		} catch (Exception e) {
			has = false;
		}
		return has;
	}
	
	public static boolean hasStat(List<String> lore, String stat) {
		boolean has = false;
		try {
			if (lore != null) {
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains(stat)) {
						has = true;
					}
				}
			}
		} catch (Exception e) {
			has = false;
		}
		return has;
	}
}