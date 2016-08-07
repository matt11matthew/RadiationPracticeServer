package us.radiationnetwork.practiceserver.menus;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.radiationnetwork.practiceserver.utils.StatUtils;

public class GemUtils {
	
	public static double getStatFromLore(ItemStack item, String value, String value2) {
		double returnVal = 0.0D;
		ItemMeta meta = item.getItemMeta();
		try {
			List<String> lore = meta.getLore();
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains(value)) {
						String vals = ((String)lore.get(i)).split(value + ": ")[1].split(value2)[0];
						vals = ChatColor.stripColor(vals);
						returnVal = Integer.parseInt(vals.trim());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}

	public static double getPrice(ItemStack is) {
		return (StatUtils.hasStat(is, "Price")) ? getStatFromLore(is, "Price", "g") : 0.0D;
	}

}
