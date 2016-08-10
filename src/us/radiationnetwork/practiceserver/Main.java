package us.radiationnetwork.practiceserver;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import us.radiationnetwork.practiceserver.command.commands.CommandFVendor;
import us.radiationnetwork.practiceserver.command.commands.CommandIVendor;
import us.radiationnetwork.practiceserver.command.commands.CommandRoll;
import us.radiationnetwork.practiceserver.command.commands.CommandSync;
import us.radiationnetwork.practiceserver.command.commands.CommandToggleDebug;
import us.radiationnetwork.practiceserver.command.commands.CommandTogglePvP;
import us.radiationnetwork.practiceserver.command.commands.CommandZone;
import us.radiationnetwork.practiceserver.dmg.DamageHandler;
import us.radiationnetwork.practiceserver.enchants.EnchantHandler;
import us.radiationnetwork.practiceserver.fish.SpeedFish;
import us.radiationnetwork.practiceserver.health.HealthHandler;
import us.radiationnetwork.practiceserver.menus.Banker;
import us.radiationnetwork.practiceserver.menus.FVendor;
import us.radiationnetwork.practiceserver.menus.IVendor;
import us.radiationnetwork.practiceserver.menus.PickaxeVendor;
import us.radiationnetwork.practiceserver.mining.MiningHandler;
import us.radiationnetwork.practiceserver.mobs.MobHandler;
import us.radiationnetwork.practiceserver.npcs.NPCHandler;
import us.radiationnetwork.practiceserver.player.PlayerListener;
import us.radiationnetwork.practiceserver.respawn.RespawnHandler;
import us.radiationnetwork.practiceserver.utils.APIUtils;
import us.radiationnetwork.practiceserver.utils.BossBarUtils;
import us.radiationnetwork.practiceserver.zones.ZoneHandler;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		registerListeners();
		registerCommands();
		task();
		BossBarUtils.setHPAboveHead();
		hpRegenTask();
		MiningHandler.respawnOreTask();
		
	}
	
	public void onDisable() {
		removeBossBar();
		MiningHandler.reboot();
	}

	private void registerCommands() {
		APIUtils.registerCommand("fvendor", new CommandFVendor());
		APIUtils.registerCommand("ivendor", new CommandIVendor());
		
		APIUtils.registerCommand("debug", new CommandToggleDebug());
		APIUtils.registerCommand("togglepvp", new CommandTogglePvP());
		
		APIUtils.registerCommand("sync", new CommandSync());
		APIUtils.registerCommand("roll", new CommandRoll());
		APIUtils.registerCommand("zone", new CommandZone());
	}

	private void registerListeners() {
		APIUtils.registerListener(new FVendor());
		APIUtils.registerListener(new IVendor());
		APIUtils.registerListener(new PlayerListener());
		APIUtils.registerListener(new SpeedFish());
		APIUtils.registerListener(new ZoneHandler());
		APIUtils.registerListener(new HealthHandler());
		APIUtils.registerListener(new NPCHandler());
		APIUtils.registerListener(new MobHandler());
		APIUtils.registerListener(new DamageHandler());
		APIUtils.registerListener(new EnchantHandler());
		APIUtils.registerListener(new RespawnHandler());
		APIUtils.registerListener(new PickaxeVendor());
		APIUtils.registerListener(new Banker());
		APIUtils.registerListener(new MiningHandler());
	}

	public static Main getInstance() {
		return plugin;
	}
	
	public void removeBossBar() {
		
		for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
			BossBarUtils.removeBar(pl);
		}
	}
	
	public void hpRegenTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					HealthHandler.hpRegen(pl);
				}
			}
		}, 20L, 20L);
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