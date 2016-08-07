package us.radiationnetwork.practiceserver.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.utils.Utils;

public abstract class PSCommand implements CommandExecutor {
	
	public abstract void execute(CommandSender sender, String[] args);
	
	public abstract List<String> getPermissions();
	
	public abstract String getNoPermissionMessage();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			for (String permission : getPermissions()) {
				Player p = (Player) sender;
				if ((p.hasPermission(permission)) || (p.isOp())) {
					execute(p, args);
					return true;
				} else {
					p.sendMessage(Utils.colorCodes(getNoPermissionMessage()));
				}
			}
		}
		if (!(sender instanceof Player)) {
			execute(sender, args);
			return true;
		}
		return true;
	}
}