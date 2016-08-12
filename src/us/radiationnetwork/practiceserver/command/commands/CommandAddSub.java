package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;

public class CommandAddSub extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 1) {
				String name = args[0];
				Bukkit.getServer().dispatchCommand(sender, "manuadd " + name + " S");
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
