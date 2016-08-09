package us.radiationnetwork.practiceserver.npcs;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import us.radiationnetwork.practiceserver.menus.FVendor;
import us.radiationnetwork.practiceserver.menus.IVendor;
import us.radiationnetwork.practiceserver.menus.PickaxeVendor;
import us.radiationnetwork.practiceserver.utils.Utils;

public class NPCHandler implements Listener {
	
	@EventHandler
	public void onNPCRightClick(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof HumanEntity) {
			Player p = e.getPlayer();
			HumanEntity npc = (HumanEntity) e.getRightClicked();
			if (npc.hasMetadata("NPC")) {
				switch (npc.getName()) {
				case "Healer":
					p.setHealth(p.getMaxHealth());
					p.sendMessage(Utils.colorCodes("&7Healer: &fYou have been healed"));
					break;
				case "Item Vendor":
					IVendor.open(p);
					p.sendMessage(Utils.colorCodes("&7Item Vendor: &fPlease store your gems in your bank before buying items from me."));
					break;
				case "Fisherman":
					FVendor.open(p);
					p.sendMessage(Utils.colorCodes("&7Fisherman: &fPlease store your gems in your bank before buying items from me."));
					break;
				case "Pickaxe Vendor":
					PickaxeVendor.open(p);
					p.sendMessage(Utils.colorCodes("&7Pickaxe Vendor: &fPlease store your gems in your bank before buying items from me."));
					break;
				case "Banker":
					p.openInventory(p.getEnderChest());
					p.sendMessage(Utils.colorCodes("&7Banker: &fUse these bank chests to store your precious items."));
					break;
				case "Beta Vendor":
					p.sendMessage(Utils.colorCodes("&7Beta Vendor: &fWhere did you find me?"));
					break;
				default:
					p.sendMessage(Utils.colorCodes("&7" + ChatColor.stripColor(npc.getName()) + ": &fCome back to me later!"));
					break;
				}
			}
		}
	}
}