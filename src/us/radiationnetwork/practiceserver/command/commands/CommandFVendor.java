package us.radiationnetwork.practiceserver.command.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.menus.FVendor;

public class CommandFVendor extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			FVendor.open(p);
		}
		
	}

	@Override
	public List<String> getPermissions() {
		return Arrays.asList("f.vendor");
	}

	@Override
	public String getNoPermissionMessage() {
		return "&c&lYou don't have &lPERMISSION! only &7&lS-Ultra &cand up can run this command!";
	}

}
