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
import us.radiationnetwork.practiceserver.menus.IVendor;
import us.radiationnetwork.practiceserver.utils.Utils;

public class EnchantHandler implements Listener {
	
	public static boolean canEnchant(ItemStack scroll, ItemStack item) {
		ItemStack t1scrollwep = IVendor.getWeaponEnchantPriced(1);
		IVendor.removePrice(t1scrollwep);
		ItemStack t2scrollwep = IVendor.getWeaponEnchantPriced(2);
		IVendor.removePrice(t2scrollwep);
		ItemStack t3scrollwep = IVendor.getWeaponEnchantPriced(3);
		IVendor.removePrice(t3scrollwep);
		ItemStack t4scrollwep = IVendor.getWeaponEnchantPriced(4);
		IVendor.removePrice(t4scrollwep);
		ItemStack t5scrollwep = IVendor.getWeaponEnchantPriced(5);
		IVendor.removePrice(t5scrollwep);
		
		ItemStack t1scrollarmor = IVendor.getArmorEnchantPriced(1);
		IVendor.removePrice(t1scrollarmor);
		ItemStack t2scrollarmor = IVendor.getArmorEnchantPriced(2);
		IVendor.removePrice(t2scrollarmor);
		ItemStack t3scrollarmor = IVendor.getArmorEnchantPriced(3);
		IVendor.removePrice(t3scrollarmor);
		ItemStack t4scrollarmor = IVendor.getArmorEnchantPriced(4);
		IVendor.removePrice(t4scrollarmor);
		ItemStack t5scrollarmor = IVendor.getArmorEnchantPriced(5);
		IVendor.removePrice(t5scrollarmor);
		
		if (scroll.equals(t1scrollarmor)) {
			if (Utils.isArmor(item)) {
				return (Utils.getTier(item) == 1) ? true : false;
				
			}
		}
		if (scroll.equals(t2scrollarmor)) {
			if (Utils.isArmor(item)) {
				return (Utils.getTier(item) == 2) ? true : false;
				
			}
		}
		if (scroll.equals(t3scrollarmor)) {
			if (Utils.isArmor(item)) {
				return (Utils.getTier(item) == 3) ? true : false;
				
			}
		}
		if (scroll.equals(t4scrollarmor)) {
			if (Utils.isArmor(item)) {
				return (Utils.getTier(item) == 4) ? true : false;
				
			}
		}
		if (scroll.equals(t5scrollarmor)) {
			if (Utils.isArmor(item)) {
				return (Utils.getTier(item) == 5) ? true : false;
				
			}
		}
		if (scroll.equals(t1scrollwep)) {
			if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
				return (Utils.getTier(item) == 1) ? true : false;
				
			}
		}
		if (scroll.equals(t2scrollwep)) {
			if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
				return (Utils.getTier(item) == 2) ? true : false;
				
			}
		}
		if (scroll.equals(t3scrollwep)) {
			if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
				return (Utils.getTier(item) == 3) ? true : false;
				
			}
		}
		if (scroll.equals(t4scrollwep)) {
			if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
				return (Utils.getTier(item) == 4) ? true : false;
				
			}
		}
		if (scroll.equals(t5scrollwep)) {
			if ((Utils.isAxe(item)) || (Utils.isSword(item))) {
				return (Utils.getTier(item) == 5) ? true : false;
				
			}
		}
		return false;
	}
	
	@EventHandler
	public void onEnchant(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory().equals(p.getInventory())) {
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
					if (failRate == 0) {
						if (Utils.isArmor(cur)) {
							PSItem new_armor = new PSItem(cur.getType());
							ItemMeta im = cur.getItemMeta();
							if (im.hasDisplayName()) {
								new_armor.setName(im.getDisplayName());
							}
							new_armor.setPlus(getPlus(cur));
							new_armor.setLore(im.getLore());
							new_armor.enchant(ItemType.ARMOR);
							e.setCurrentItem(new_armor.build());
						}
						if (Utils.isWeapon(cur)) {
							PSItem new_weapon = new PSItem(cur.getType());
							ItemMeta im = cur.getItemMeta();
							if (im.hasDisplayName()) {
								new_weapon.setName(im.getDisplayName());
							}
							new_weapon.setPlus(getPlus(cur));
							new_weapon.setLore(im.getLore());
							new_weapon.enchant(ItemType.WEAPON);
							e.setCurrentItem(new_weapon.build());
							
						}
						if (cursor.getAmount() > 1) {
							cursor.setAmount((cursor.getAmount() - 1));
						} else {
							e.setCursor(new ItemStack(Material.AIR));
						}
					}
					if (r.nextInt(100) <= failRate) {
						e.setCurrentItem(new ItemStack(Material.AIR));
						if (cursor.getAmount() > 1) {
							cursor.setAmount((cursor.getAmount() - 1));
						} else {
							e.setCursor(new ItemStack(Material.AIR));
						}
					} else {
						if (Utils.isArmor(cur)) {
							PSItem new_armor = new PSItem(cur.getType());
							ItemMeta im = cur.getItemMeta();
							if (im.hasDisplayName()) {
								new_armor.setName(im.getDisplayName());
							}
							new_armor.setPlus(getPlus(cur));
							new_armor.setLore(im.getLore());
							new_armor.enchant(ItemType.ARMOR);
							e.setCurrentItem(new_armor.build());
						}
						if (Utils.isWeapon(cur)) {
							PSItem new_weapon = new PSItem(cur.getType());
							ItemMeta im = cur.getItemMeta();
							if (im.hasDisplayName()) {
								new_weapon.setName(im.getDisplayName());
							}
							new_weapon.setPlus(getPlus(cur));
							new_weapon.setLore(im.getLore());
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
	
	public static int getPlus(String name) {
		int plus = 0;
		if (name != null) {
			try {
				name = ChatColor.stripColor(name);
				if (name.startsWith("[")) {
					plus = Integer.parseInt(name.substring(name.indexOf("+") + 1, name.lastIndexOf("]")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return plus;
	}

	public static int getPlus(ItemStack item) {
		ItemMeta im = item.getItemMeta();
		int plus = 0;
		if (im.hasDisplayName()) {
			try {
				String name = ChatColor.stripColor(im.getDisplayName());
				if (name.startsWith("[")) {
					plus = Integer.parseInt(name.substring(name.indexOf("+") + 1, name.lastIndexOf("]")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return plus;
	}

}

