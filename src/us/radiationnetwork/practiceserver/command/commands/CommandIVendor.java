package us.radiationnetwork.practiceserver.command.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.menus.IVendor;

public class CommandIVendor extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			IVendor.open(p);
			return;
		}
		
	}

	@Override
	public List<String> getPermissions() {
		return Arrays.asList("i.vendor");
	}

	@Override
	public String getNoPermissionMessage() {
		return "&c&lYou don't have &lPERMISSION! only &6&lS-Ultra &cand up can run this command!";
	}

}
