package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.item.PSItem;

public class CommandAddLootbuff extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 1) {
				String name = args[0];
				if ((Bukkit.getPlayerExact(name) != null) && (Bukkit.getPlayerExact(name).isOnline())) {
					Player target = Bukkit.getPlayerExact(name);
					target.getInventory().addItem(getLootbuff());
				}
			}
		}
	}

	public ItemStack getLootbuff() {
		PSItem lootbuff = new PSItem(Material.FIREWORK_CHARGE);
		lootbuff.setName("&aGlobal Lootbuff &7(&c20%&7) &7(&c30M&7)");
		lootbuff.addLore("&7(RIGHT-CLICK)");
		lootbuff.addLore("&aTo Activate lootbuff");
		lootbuff.setGlow(true);
		lootbuff.setUntradable(true);
		lootbuff.setRarity(ItemRarity.RARE);
		return lootbuff.build();
	}

	@Override
	public List<String> getPermissions() {
		return null;
	}

	@Override
	public String getNoPermissionMessage() {
		return null;
	}

}
