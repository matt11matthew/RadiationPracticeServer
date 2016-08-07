package us.radiationnetwork.practiceserver.command.commands;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.command.PSCommand;
import us.radiationnetwork.practiceserver.utils.Utils;

public class CommandRoll extends PSCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if ((args.length == 2) && (player.isOp())) {
				String msg = player.getDisplayName() + " &7has rolled a &7&l&n" + args[0] + "&7 out of &7&l&n" + args[1] + ".";
				Bukkit.getServer().broadcastMessage(Utils.colorCodes(msg));
				return;
			}
 			if (args.length == 1) {
				int max = 0;
				try {
					max = Integer.parseInt(args[0]);
				} catch (NumberFormatException e) {
					player.sendMessage(Utils.colorCodes("&c&lNon-Numeric Max Number. /roll <1 - 10000>"));
					return;
				}
				if ((max < 1) || (max > 10000)) {
					player.sendMessage(Utils.colorCodes("&c&lIncorrect Syntax.&7 /roll <1 - 10000>"));
					return;
				} else {
					Random r = new Random();
					int roll = r.nextInt(max + 1);
					String msg = player.getDisplayName() + " &7has rolled a &7&l&n" + roll + "&7 out of &7&l&n" + max + ".";
					Bukkit.getServer().broadcastMessage(Utils.colorCodes(msg));
					return;
				}
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
