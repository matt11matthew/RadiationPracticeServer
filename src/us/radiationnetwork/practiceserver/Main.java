package us.radiationnetwork.practiceserver;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import us.radiationnetwork.practiceserver.command.commands.CommandAddLootbuff;
import us.radiationnetwork.practiceserver.command.commands.CommandAddUniqueLootbuff;
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
import us.radiationnetwork.practiceserver.shop.LootBuffHandler;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.APIUtils;
import us.radiationnetwork.practiceserver.utils.BossBarUtils;
import us.radiationnetwork.practiceserver.utils.RegionUtils;
import us.radiationnetwork.practiceserver.utils.Utils;
import us.radiationnetwork.practiceserver.zones.Zone;
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
		combatTimeTask();
		mobTask();
		bcTask();
		offHandFix();
		
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
		
		APIUtils.registerCommand("addlootbuff", new CommandAddLootbuff());
		APIUtils.registerCommand("adduniquebuff", new CommandAddUniqueLootbuff());
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
		APIUtils.registerListener(new LootBuffHandler());
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
	
	
	public void bcTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				Bukkit.getServer().broadcastMessage(Utils.colorCodes("&c[BROADCAST] &aType /buy to view the shop! Where you can buy features like /bank!"));
			}
		}, (20L * 300L), (20L * 300L));
	}
	
	public void task() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					BossBarUtils.sendBar(pl);
					if ((pl.getInventory().getItemInOffHand() != null) && (pl.getInventory().getItemInOffHand().getType() != Material.AIR)) {
						pl.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
					}
				}
			}
		}, 5L, 5L);
	}
	
	public void offHandFix() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					if ((pl.getInventory().getItemInOffHand() != null) && (pl.getInventory().getItemInOffHand().getType() != Material.AIR)) {
						pl.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
					}
				}
			}
		}, 5L, 5L);
	}
	
	public void mobTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				for (Entity e : Bukkit.getWorld("world").getEntities()) {
					if (e instanceof Skeleton) {
						Zone zone = RegionUtils.getZone(e.getLocation());
						if (zone == Zone.SAFE) {
							e.remove();
						}
						
					}
				}
			}
		}, 5L, 5L);
	}
	
	public void combatTimeTask() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					if (FileManager.isCombat(pl.getName())) {
						int time = FileManager.getCombatTime(pl.getName());
						if (time > 0) {
							time--;
							FileManager.setCombatTime(pl.getName(), time);
						} else {
							FileManager.setCombatTime(pl.getName(), 0);
						}
					}
				}
			}
		}, 20L, 20L);
	}
}