package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.utils.Utils;

public class CommandSync extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.saveData();
			p.sendMessage(Utils.colorCodes("&aSynced player data to &nHIVE&a server."));
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
