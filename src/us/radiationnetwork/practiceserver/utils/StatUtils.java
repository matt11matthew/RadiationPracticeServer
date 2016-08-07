package us.radiationnetwork.practiceserver.utils;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class StatUtils {
	
	public static boolean hasStat(ItemStack is, String stat) {
		boolean has = false;
		if ((is.hasItemMeta()) && (is.getItemMeta().hasLore())) {
			List<String> lore = is.getItemMeta().getLore();
			
			for (int i = 0; i < lore.size(); i++) {
				if (((String)lore.get(i)).contains(stat)) {
					has = true;
				}
			}
		}
		return has;
	}
}