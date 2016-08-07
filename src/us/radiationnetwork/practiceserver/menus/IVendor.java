package us.radiationnetwork.practiceserver.menus;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Utils;

public class IVendor implements Listener {
	
	public static String NAME = "Item Vendor";
	public static int ROWS = 2;
	
	public static ItemStack getArmorEnchantPriced(int tier) {
		switch (tier) {
		case 1:
			PSItem t1arm = new PSItem(Material.EMPTY_MAP);
			t1arm.setName("&f&lScroll: &fEnchant Leather Armor");
			t1arm.addLore("&c+5% HP");
			t1arm.addLore("&c+5% HP REGEN");
			t1arm.addLore("&7   - OR -");
			t1arm.addLore("&c+5% VIT");
			t1arm.addLore("&7&oArmor will VANISH if enchant above +3 FAILS.");
			t1arm.addLore("&aPrice: &f" + "2000g");
			return t1arm.build();
		case 2:
			PSItem t2arm = new PSItem(Material.EMPTY_MAP);
			t2arm.setName("&f&lScroll: &aEnchant Chainmail Armor");
			t2arm.addLore("&c+5% HP");
			t2arm.addLore("&c+5% HP REGEN");
			t2arm.addLore("&7   - OR -");
			t2arm.addLore("&c+5% VIT");
			t2arm.addLore("&7&oArmor will VANISH if enchant above +3 FAILS.");
			t2arm.addLore("&aPrice: &f" + "2000g");
			return t2arm.build();
		case 3:
			PSItem t3arm = new PSItem(Material.EMPTY_MAP);
			t3arm.setName("&f&lScroll: &bEnchant Iron Armor");
			t3arm.addLore("&c+5% HP");
			t3arm.addLore("&c+5% HP REGEN");
			t3arm.addLore("&7   - OR -");
			t3arm.addLore("&c+5% VIT");
			t3arm.addLore("&7&oArmor will VANISH if enchant above +3 FAILS.");
			t3arm.addLore("&aPrice: &f" + "2000g");
			return t3arm.build();
		case 4:
			PSItem t4arm = new PSItem(Material.EMPTY_MAP);
			t4arm.setName("&f&lScroll: &eEnchant Diamond Armor");
			t4arm.addLore("&c+5% HP");
			t4arm.addLore("&c+5% HP REGEN");
			t4arm.addLore("&7   - OR -");
			t4arm.addLore("&c+5% VIT");
			t4arm.addLore("&7&oArmor will VANISH if enchant above +3 FAILS.");
			t4arm.addLore("&aPrice: &f" + "2000g");
			return t4arm.build();
		case 5:
			PSItem t5arm = new PSItem(Material.EMPTY_MAP);
			t5arm.setName("&f&lScroll: &eEnchant Gold Armor");
			t5arm.addLore("&c+5% HP");
			t5arm.addLore("&c+5% HP REGEN");
			t5arm.addLore("&7   - OR -");
			t5arm.addLore("&c+5% VIT");
			t5arm.addLore("&7&oArmor will VANISH if enchant above +3 FAILS.");
			t5arm.addLore("&aPrice: &f" + "2000g");
			return t5arm.build();
		}
		return null;
	}
	
	public static ItemStack getWeaponEnchantPriced(int tier) {
		switch (tier) {
		case 0:
			PSItem orb = new PSItem(Material.MAGMA_CREAM);
			orb.setName("&dOrb of Alteration");
			orb.addLore("&7Randomizes stats of selected equipment.");
			orb.addLore("&aPrice: &f" + "2000g");
			return orb.build();
		case 1:
			PSItem t1wep = new PSItem(Material.EMPTY_MAP);
			t1wep.setName("&f&lScroll: &fEnchant Wooden Weapon");
			t1wep.addLore("&c+5% DMG");
			t1wep.addLore("&7&oWeapon will VANISH if enchant above +3 FAILS.");
			t1wep.addLore("&aPrice: &f" + "3000g");
			return t1wep.build();
		case 2:
			PSItem t2wep = new PSItem(Material.EMPTY_MAP);
			t2wep.setName("&f&lScroll: &aEnchant Stone Weapon");
			t2wep.addLore("&c+5% DMG");
			t2wep.addLore("&7&oWeapon will VANISH if enchant above +3 FAILS.");
			t2wep.addLore("&aPrice: &f" + "3000g");
			return t2wep.build();
		case 3:
			PSItem t3wep = new PSItem(Material.EMPTY_MAP);
			t3wep.setName("&f&lScroll: &bEnchant Iron Weapon");
			t3wep.addLore("&c+5% DMG");
			t3wep.addLore("&7&oWeapon will VANISH if enchant above +3 FAILS.");
			t3wep.addLore("&aPrice: &f" + "3000g");
			return t3wep.build();
		case 4:
			PSItem t4wep = new PSItem(Material.EMPTY_MAP);
			t4wep.setName("&f&lScroll: &dEnchant Diamond Weapon");
			t4wep.addLore("&c+5% DMG");
			t4wep.addLore("&7&oWeapon will VANISH if enchant above +3 FAILS.");
			t4wep.addLore("&aPrice: &f" + "3000g");
			return t4wep.build();
		case 5:
			PSItem t5wep = new PSItem(Material.EMPTY_MAP);
			t5wep.setName("&f&lScroll: &eEnchant Gold Weapon");
			t5wep.addLore("&c+5% DMG");
			t5wep.addLore("&7&oWeapon will VANISH if enchant above +3 FAILS.");
			t5wep.addLore("&aPrice: &f" + "3000g");
			return t5wep.build();
		}
		return null;
	}
	
	public static void open(Player p) {
		Inventory inv = Bukkit.createInventory(null, (9 * ROWS), NAME);
		inv.addItem(getWeaponEnchantPriced(0));
		inv.addItem(getArmorEnchantPriced(1));
		inv.addItem(getWeaponEnchantPriced(1));
		inv.addItem(getArmorEnchantPriced(2));
		inv.addItem(getWeaponEnchantPriced(2));
		inv.addItem(getArmorEnchantPriced(3));
		inv.addItem(getWeaponEnchantPriced(3));
		inv.addItem(getArmorEnchantPriced(4));
		inv.addItem(getWeaponEnchantPriced(4));
		inv.addItem(getArmorEnchantPriced(5));
		inv.addItem(getWeaponEnchantPriced(5));
		p.openInventory(inv);
	}

	@EventHandler
	public void onIVendorClickEvent(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		if (e.getClickedInventory().getTitle().equalsIgnoreCase(NAME)) {
			e.setCancelled(true);
			ItemStack cur = e.getCurrentItem();
			if (cur.getType() == Material.AIR) return;
			if (StatUtils.hasStat(cur, "Price")) {
				double price = GemUtils.getPrice(cur);
				Player p = (Player) e.getWhoClicked();
				buy(p, removePrice(cur), price);
				
			}
		}
	}

	public ItemStack removePrice(ItemStack is) {
		if (StatUtils.hasStat(is, "Price")) {
			double price = GemUtils.getPrice(is);
			ItemMeta im = is.getItemMeta();
			List<String> lore = im.getLore();
			lore.remove(Utils.colorCodes("&aPrice: &f" + (int) price + "g"));
			im.setLore(lore);
			is.setItemMeta(im);
			return is;
		}
		return is;
	}
	
	
	public void buy(Player p, ItemStack item, double i) {
		double gems = FileManager.getGems(p.getName());
		if (gems >= i) {
			gems -= i;
			FileManager.setGems(p.getName(), gems);
			if (p.getInventory().firstEmpty() == -1) {
				p.sendMessage(Utils.colorCodes("&c&lWarning &cYour inventory is full!"));
				p.closeInventory();
				return;
			} else {
				p.sendMessage(Utils.colorCodes("&c-" + (int) i + "&lG"));
				//p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
				p.getInventory().setItem(p.getInventory().firstEmpty(), item);
				return;
			}
		} else {
			p.sendMessage(Utils.colorCodes("&cYou don't have enough GEM(s) for 1x of this item."));
			p.sendMessage(Utils.colorCodes("&cCOST: " + (int) i + "g"));
			p.closeInventory();
			return;
		}
	}
}
