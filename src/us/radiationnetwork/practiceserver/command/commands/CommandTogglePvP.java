package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.Utils;

public class CommandTogglePvP extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			boolean togglepvp = FileManager.isTogglePvP(player.getName());
			if (togglepvp) {
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
				FileManager.setTogglePvP(player.getName(), false);
				player.sendMessage(Utils.colorCodes("&aOutgoing PVP Damage - &lENABLED"));
				return;
			} else {
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
				FileManager.setTogglePvP(player.getName(), true);
				player.sendMessage(Utils.colorCodes("&cOutgoing PVP Damage - &lDISABLED"));
				return;
			}
		}
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
