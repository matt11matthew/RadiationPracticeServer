package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.utils.RegionUtils;

public class CommandZone extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(RegionUtils.getZone(p.getLocation()).getMessage());
			p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 0.25F, 0.3F);
			return;
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
