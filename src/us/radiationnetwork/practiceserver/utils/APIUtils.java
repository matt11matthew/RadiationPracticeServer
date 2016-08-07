package us.radiationnetwork.practiceserver.utils;

import org.bukkit.event.Listener;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.command.PSCommand;


public class APIUtils {
	
	public static void registerCommand(String command, PSCommand ctCommand) {
		Main.getInstance().getCommand(command).setExecutor(ctCommand);
	}
	
	public static void registerListener(Listener listener) {
		Main.getInstance().getServer().getPluginManager().registerEvents(listener, Main.getInstance());
	}
}