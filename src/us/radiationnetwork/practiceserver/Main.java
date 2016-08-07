package us.radiationnetwork.practiceserver;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerCommands();
		
	}

	private void registerCommands() {
		// TODO Auto-generated method stub
		
	}

	private void registerListeners() {
		// TODO Auto-generated method stub
		
	}

	public static Main getInstance() {
		return plugin;
	}
}