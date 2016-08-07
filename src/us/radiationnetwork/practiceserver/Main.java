package us.radiationnetwork.practiceserver;

import org.bukkit.plugin.java.JavaPlugin;

import us.radiationnetwork.practiceserver.command.commands.CommandFVendor;
import us.radiationnetwork.practiceserver.menus.FVendor;
import us.radiationnetwork.practiceserver.player.PlayerListener;
import us.radiationnetwork.practiceserver.utils.APIUtils;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerCommands();
		
	}

	private void registerCommands() {
		APIUtils.registerCommand("fvendor", new CommandFVendor());
		
	}

	private void registerListeners() {
		APIUtils.registerListener(new FVendor());
		APIUtils.registerListener(new PlayerListener());
		
	}

	public static Main getInstance() {
		return plugin;
	}
}