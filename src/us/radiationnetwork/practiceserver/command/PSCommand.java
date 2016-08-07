package us.radiationnetwork.practiceserver.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PSCommand implements CommandExecutor {
	
	public abstract void execute(CommandSender sender, String[] args);
	
	public abstract List<String> getPermissions();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			for (String permission : getPermissions()) {
				if ((sender.hasPermission(permission)) || (sender.isOp())) {
					Player p = (Player) sender;
					execute(p, args);
					return true;
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