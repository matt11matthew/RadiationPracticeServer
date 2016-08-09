package us.radiationnetwork.practiceserver.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.Utils;

public class Banker implements Listener {
	
	public static int GEM_SLOT = 26;
	
	public static ItemStack getBankGem(Player player) {
		PSItem gem = new PSItem(Material.EMERALD);
		gem.setName("&a" + FileManager.getGems(player.getName()) + " &lGEM(s)");
		gem.addLore("&7Right Click to create &aA GEM NOTE");
		return gem.build();
	}
	
	@EventHandler
	public void onInventoryOpenEvent(InventoryOpenEvent e) {
		if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {
			Player p = (Player) e.getPlayer();
			Inventory inv = p.getEnderChest();
			inv.setItem(GEM_SLOT, getBankGem(p));
		}
	}

	@EventHandler
	public void onBankClick(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {
			if (e.getInventory().contains(Material.EMERALD)) {
				for (int i = 0; i < e.getInventory().getSize(); i++) {
					if (e.getInventory().getItem(i) != null) {
						if ((e.getInventory().getItem(i) != null) && (i != GEM_SLOT)) {
							int amt = e.getInventory().getItem(i).getAmount();
							Player p = (Player) e.getWhoClicked();
							e.getInventory().removeItem(e.getInventory().getItem(i));
							FileManager.setGems(p.getName(), (FileManager.getGems(p.getName()) + amt));
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
							e.getInventory().setItem(GEM_SLOT, getBankGem(p));
							p.sendMessage(Utils.colorCodes("&a&l+&a" + amt + "&lG&a, &lNew Balance: &a" + FileManager.getGems(p.getName()) + " Gem(s)"));
						}
					}
				}
			}
			
		}
	}
	
	@EventHandler
	public void onBankClickEvent(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE) return;
		if (e.getClickedInventory().getType() == InventoryType.ENDER_CHEST) {
			ItemStack cur = e.getCurrentItem();
			if (cur.getType() == Material.AIR) return;
			if (cur.getType() == Material.EMERALD) {
				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				if (e.isRightClick()) {
					//Withdraw
				}
			}
		}
	}
}
