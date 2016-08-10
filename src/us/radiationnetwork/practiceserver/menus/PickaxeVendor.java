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

public class PickaxeVendor implements Listener {
	
	public static String NAME = "Pickaxe Vendor";
	public static int ROWS = 1;
	
	public static ItemStack getPickaxePriced(int tier) {
		switch (tier) {
		case 5:
			PSItem t5pick = new PSItem(Material.GOLD_PICKAXE);
			t5pick.setName("&eMaster Pickaxe");
			t5pick.addLore("&cTREASURE FIND: 1%");
			t5pick.addLore("&7&oA pickaxe made out of gold.");
			t5pick.setPrice(5000);
			t5pick.setUnbreakable(true);
			return t5pick.build();
		}
		return null;
	}
	
	
	public static void open(Player p) {
		Inventory inv = Bukkit.createInventory(null, (9 * ROWS), NAME);
		inv.addItem(getPickaxePriced(5));
		p.openInventory(inv);
	}

	@EventHandler
	public void onPickaxeVendorClickEvent(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		if (e.getClickedInventory().getTitle().equalsIgnoreCase(NAME)) {
			e.setCancelled(true);
			ItemStack cur = e.getCurrentItem();
			if (cur.getType() == Material.AIR) return;
			if (StatUtils.hasStat(cur, "Price")) {
				double price = GemUtils.getPrice(cur);
				Player p = (Player) e.getWhoClicked();
				buy(p, cur, price);
				
			}
		}
	}

	public static void removePrice(ItemStack is) {
		if (StatUtils.hasStat(is, "Price")) {
			double price = GemUtils.getPrice(is);
			ItemMeta im = is.getItemMeta();
			List<String> lore = im.getLore();
			lore.remove(Utils.colorCodes("&aPrice: &f" + (int) price + "g"));
			im.setLore(lore);
			is.setItemMeta(im);
		}
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
				PSItem orb = new PSItem(item.getType());
				orb.setLore(item.getItemMeta().getLore());
				orb.setName(item.getItemMeta().getDisplayName());
				orb.removeLore(orb.getLore().size() - 1);
				orb.setUnbreakable(true);
				p.getInventory().setItem(p.getInventory().firstEmpty(), orb.build());
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
