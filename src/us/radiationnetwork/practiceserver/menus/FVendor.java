package us.radiationnetwork.practiceserver.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.fish.SpeedFish;
import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Utils;

public class FVendor implements Listener {
	
	public static String NAME = "Fisherman";
	public static int ROWS = 1;
	
	public static ItemStack getFishRawPriced(int tier) {
		switch (tier) {
		case 1:
			PSItem t1fish = new PSItem(Material.RAW_FISH);
			t1fish.setName("&fT1 Speedfish");
			t1fish.addLore("&cSPEED (I) BUFF &7(15s)");
			t1fish.addLore("&c-10% HUNGER &7(instant)");
			t1fish.addLore("&7&oA T1 Feesh.");
			t1fish.addLore("&aPrice: &f" + "100g");
			return t1fish.build();
		case 2:
			PSItem t2fish = new PSItem(Material.RAW_FISH);
			t2fish.setName("&aT2 Speedfish");
			t2fish.addLore("&cSPEED (I) BUFF &7(30s)");
			t2fish.addLore("&c-20% HUNGER &7(instant)");
			t2fish.addLore("&7&oA T3 Feesh.");
			t2fish.addLore("&aPrice: &f" + "200g");
			return t2fish.build();
		case 3:
			PSItem t3fish = new PSItem(Material.RAW_FISH);
			t3fish.setName("&bRaw Salmon of Lasting Agility");
			t3fish.addLore("&cSPEED (I) BUFF &7(60s)");
			t3fish.addLore("&c-30% HUNGER &7(instant)");
			t3fish.addLore("&7&oA beautiful jumping fish.");
			t3fish.addLore("&aPrice: &f" + "300g");
			return t3fish.build();
		case 4:
			PSItem t4fish = new PSItem(Material.RAW_FISH);
			t4fish.setName("&dRaw Lobster of Bursting Agility");
			t4fish.addLore("&cSPEED (III) BUFF &7(15s)");
			t4fish.addLore("&c-40% HUNGER &7(instant)");
			t4fish.addLore("&7&oA large red crustacean.");
			t4fish.addLore("&aPrice: &f" + "400g");
			return t4fish.build();
		case 5:
			PSItem t5fish = new PSItem(Material.RAW_FISH);
			t5fish.setName("&eRaw Swordfish of Godlike Speed");
			t5fish.addLore("&cSPEED (III) BUFF &7(30s)");
			t5fish.addLore("&c-50% HUNGER &7(instant)");
			t5fish.addLore("&7&oAn elongated fish with a long bill.");
			t5fish.addLore("&aPrice: &f" + "500g");
			return t5fish.build();
		}
		return null;
	}
	
	public static ItemStack getFishCooked(int tier) {
		switch (tier) {
		case 1:
			PSItem t1fish = new PSItem(Material.COOKED_FISH);
			t1fish.setName("&fT1 Speedfish");
			t1fish.addLore("&cSPEED (I) BUFF &7(15s)");
			t1fish.addLore("&c-10% HUNGER &7(instant)");
			t1fish.addLore("&7&oA T1 Feesh.");
			return t1fish.build();
		case 2:
			PSItem t2fish = new PSItem(Material.COOKED_FISH);
			t2fish.setName("&aT2 Speedfish");
			t2fish.addLore("&cSPEED (I) BUFF &7(30s)");
			t2fish.addLore("&c-20% HUNGER &7(instant)");
			t2fish.addLore("&7&oA T3 Feesh.");
			return t2fish.build();
		case 3:
			PSItem t3fish = new PSItem(Material.COOKED_FISH);
			t3fish.setName("&bCooked Salmon of Lasting Agility");
			t3fish.addLore("&cSPEED (I) BUFF &7(60s)");
			t3fish.addLore("&c-30% HUNGER &7(instant)");
			t3fish.addLore("&7&oA beautiful jumping fish.");
			return t3fish.build();
		case 4:
			PSItem t4fish = new PSItem(Material.COOKED_FISH);
			t4fish.setName("&dCooked Lobster of Bursting Agility");
			t4fish.addLore("&cSPEED (III) BUFF &7(15s)");
			t4fish.addLore("&c-40% HUNGER &7(instant)");
			t4fish.addLore("&7&oA large red crustacean.");
			return t4fish.build();
		case 5:
			PSItem t5fish = new PSItem(Material.COOKED_FISH);
			t5fish.setName("&eCooked Swordfish of Godlike Speed");
			t5fish.addLore("&cSPEED (III) BUFF &7(30s)");
			t5fish.addLore("&c-50% HUNGER &7(instant)");
			t5fish.addLore("&7&oAn elongated fish with a long bill.");
			return t5fish.build();
		}
		return null;
	}
	
	public static void open(Player p) {
		Inventory inv = Bukkit.createInventory(null, (9 * ROWS), NAME);
		inv.addItem(getFishRawPriced(1));
		inv.addItem(getFishRawPriced(2));
		inv.addItem(getFishRawPriced(3));
		inv.addItem(getFishRawPriced(4));
		inv.addItem(getFishRawPriced(5));
		p.openInventory(inv);
	}

	@EventHandler
	public void onFVendorClickEvent(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		if (e.getClickedInventory().getTitle().equalsIgnoreCase(NAME)) {
			e.setCancelled(true);
			ItemStack cur = e.getCurrentItem();
			if (cur.getType() == Material.AIR) return;
			if (StatUtils.hasStat(cur, "Price")) {
				double price = GemUtils.getPrice(cur);
				Player p = (Player) e.getWhoClicked();
				int tier = (int) (price / 100);
				buy(p, SpeedFish.getFishRaw(tier), 100);
			}
		}
	}

	public void buy(Player p, ItemStack fishRaw, int i) {
		double gems = FileManager.getGems(p.getName());
		if (gems >= i) {
			gems -= i;
			FileManager.setGems(p.getName(), gems);
			if (p.getInventory().firstEmpty() == -1) {
				p.sendMessage(Utils.colorCodes("&c&lWarning &cYour inventory is full!"));
				p.closeInventory();
				return;
			} else {
				p.sendMessage(Utils.colorCodes("&c-" + i + "&lG"));
				//p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
				p.getInventory().setItem(p.getInventory().firstEmpty(), fishRaw);
				return;
			}
		} else {
			p.sendMessage(Utils.colorCodes("&cYou don't have enough GEM(s) for 1x of this item."));
			p.sendMessage(Utils.colorCodes("&cCOST: 100g"));
			p.closeInventory();
			return;
		}
	}
}
