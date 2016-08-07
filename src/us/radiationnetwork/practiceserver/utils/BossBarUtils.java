package us.radiationnetwork.practiceserver.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarUtils {
	
	public static HashMap<Player, BossBar> bossbar = new HashMap<Player, BossBar>();
	
	public static void sendBar(Player player) {
		if (!bossbar.containsKey(player)) {
			int hp = (int) player.getHealth();
			int maxhp = (int) player.getMaxHealth();
			bossbar.put(player, Bukkit.createBossBar(Utils.colorCodes("&d" + hp + " &l/&d " + maxhp), BarColor.PINK, BarStyle.SOLID, BarFlag.CREATE_FOG));
			bossbar.get(player).addPlayer(player);
			double progress = (player.getHealth() / player.getMaxHealth());
			bossbar.get(player).setProgress(progress);
			bossbar.get(player).setVisible(true);
		} else {
			int hp = (int) player.getHealth();
			int maxhp = (int) player.getMaxHealth();
			double progress = (player.getHealth() / player.getMaxHealth());
			bossbar.get(player).setProgress(progress);
			bossbar.get(player).setTitle(Utils.colorCodes("&d" + hp + " &l/&d " + maxhp));
		}
	}
	public static void removeBar(Player player) {
		if (bossbar.containsKey(player)) {
			bossbar.get(player).removeAll();
			
		}
	}
	
	
	


}
