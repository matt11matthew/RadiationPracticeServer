package us.radiationnetwork.practiceserver.enchants;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.radiationnetwork.practiceserver.enums.ItemType;
import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.utils.Utils;

public class EnchantHandler implements Listener {
	
	public static boolean canEnchant(ItemStack scroll, ItemStack item) {
		if (scroll.getType() == Material.EMPTY_MAP) {
			ItemMeta sm = scroll.getItemMeta();
			if (sm.hasDisplayName()) {
				if (sm.getDisplayName().contains("Weapon")) {
					if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
						int scrollTier = Utils.getTier(scroll);
						int itemTier = Utils.getTier(item);
						int plus = getPlus(item);
						if (plus < 12) {
							return (scrollTier == itemTier) ? true : false;
						}
					}
				}
				if (sm.getDisplayName().contains("Armor")) {
					if (Utils.isArmor(item)) {
						int scrollTier = Utils.getTier(scroll);
						int itemTier = Utils.getTier(item);
						int plus = getPlus(item);
						if (plus < 12) {
							return (scrollTier == itemTier) ? true : false;
						}
					}
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onEnchant(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory() == p.getInventory()) {
			if ((e.getCurrentItem() != null) && (e.getCursor() != null)) {
				ItemStack cur = e.getCurrentItem();
				ItemStack cursor = e.getCursor();
				if (canEnchant(cursor, cur)) {
					e.setCancelled(true);
					int plus = getPlus(cur);
					double failRate = 0;
					switch (plus) {
					case 0:
						failRate = 0;
						break;
					case 1:
						failRate = 0;
						break;
					case 2:
						failRate = 0;
						break;
					case 3:
						failRate = 20;
						break;
					case 4:
						failRate = 30;
						break;
					case 5:
						failRate = 50;
						break;
					case 6:
						failRate = 60;
						break;
					case 7:
						failRate = 70;
						break;
					case 8:
						failRate = 80;
						break;
					case 9:
						failRate = 85;
						break;
					case 10:
						failRate = 90;
						break;
					case 11:
						failRate = 95;
						break;
					}
					Random r = new Random();
					if (r.nextInt(100) <= failRate) {
						e.setCurrentItem(new ItemStack(Material.AIR));
						if (cursor.getAmount() > 1) {
							cursor.setAmount((cursor.getAmount() - 1));
						} else {
							e.setCursor(new ItemStack(Material.AIR));
						}
					} else {
						if (Utils.isArmor(cur)) {
							PSItem new_armor = new PSItem(cur);
							new_armor.enchant(ItemType.ARMOR);
							e.setCurrentItem(new_armor.build());
						}
						if (Utils.isWeapon(cur)) {
							PSItem new_weapon = new PSItem(cur);
							new_weapon.enchant(ItemType.WEAPON);
							e.setCurrentItem(new_weapon.build());
						}
						if (cursor.getAmount() > 1) {
							cursor.setAmount((cursor.getAmount() - 1));
						} else {
							e.setCursor(new ItemStack(Material.AIR));
						}
					}
				}
			}
		}
	}

	public static int getPlus(ItemStack item) {
		ItemMeta im = item.getItemMeta();
		int plus = 0;
		if (im.hasDisplayName()) {
			try {
				String name = ChatColor.stripColor(im.getDisplayName());
				if (name.contains("[+")) {
					String raw = name.split("[+")[1].split("]")[0].trim();
					plus = Utils.convertStringToInteger(raw);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return plus;
	}

}

