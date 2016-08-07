package us.radiationnetwork.practiceserver;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import us.radiationnetwork.practiceserver.command.commands.CommandFVendor;
import us.radiationnetwork.practiceserver.command.commands.CommandRoll;
import us.radiationnetwork.practiceserver.command.commands.CommandSync;
import us.radiationnetwork.practiceserver.command.commands.CommandToggleDebug;
import us.radiationnetwork.practiceserver.command.commands.CommandTogglePvP;
import us.radiationnetwork.practiceserver.fish.SpeedFish;
import us.radiationnetwork.practiceserver.menus.FVendor;
import us.radiationnetwork.practiceserver.player.PlayerListener;
import us.radiationnetwork.practiceserver.utils.APIUtils;
import us.radiationnetwork.practiceserver.utils.BossBarUtils;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerCommands();
		task();
		
	}

	private void registerCommands() {
		APIUtils.registerCommand("fvendor", new CommandFVendor());
	
		APIUtils.registerCommand("debug", new CommandToggleDebug());
		APIUtils.registerCommand("togglepvp", new CommandTogglePvP());
		
		APIUtils.registerCommand("sync", new CommandSync());
		APIUtils.registerCommand("roll", new CommandRoll());
	}

	private void registerListeners() {
		APIUtils.registerListener(new FVendor());
		APIUtils.registerListener(new PlayerListener());
		APIUtils.registerListener(new SpeedFish());
	}

	public static Main getInstance() {
		return plugin;
	}
	
	public void task() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					BossBarUtils.sendBar(pl);
				}
			}
		}, 5L, 5L);
	}
}