package us.radiationnetwork.practiceserver.health;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.dmg.DamageHandler;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Utils;

public class HealthHandler implements Listener {
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		new BukkitRunnable() {
			
			@Override
			public void run() {
				hpCheck(p);
			}

		}.runTaskLater(Main.getInstance(), 1L);
	}
	
	@EventHandler
	public void onHeal(EntityRegainHealthEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	public static void hpRegen(Player player) {
		if (DamageHandler.tagged.contains(player)) {
			return;
		}
		double hps = 5.0D;
		double add_hps = getHPS(player);
		if (add_hps > 0.0D) {
			hps += add_hps;
		}
		if ((player.getHealth() + hps) > player.getMaxHealth()) {
			player.setHealth(player.getMaxHealth());
		} else {
			double new_hp = (player.getHealth() + hps);
			player.setHealth(new_hp);
		}
	}
	
	public void hpCheck(Player p) {
		double vit = getVIT(p);
		double a = 50.0D;
		double hp = getHP(p);
		a += hp;
		if (vit > 0.0D) {
			double divide = vit / 2000.0D;
			double pre = a * divide;
			int cleaned = (int)(a + pre);
			if (p.getHealth() > cleaned) {
				p.setHealth(cleaned);
			}
			p.setMaxHealth(cleaned);
		} else {
			p.setMaxHealth(a);
		}
		p.setHealthScale(20.0D);
		p.setHealthScaled(true);
	}

	
	public static double getVIT(Player p) {
		double vit = 0.0D;
		if ((p.getEquipment().getHelmet() != null) && (p.getEquipment().getHelmet().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getHelmet(), "VIT")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getHelmet(), "VIT: +", "", "+"));
			}
		}
		if ((p.getEquipment().getChestplate() != null) && (p.getEquipment().getChestplate().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getChestplate(), "VIT")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getChestplate(), "VIT: +", "", "+"));
			}
		}
		if ((p.getEquipment().getLeggings() != null) && (p.getEquipment().getLeggings().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getLeggings(), "VIT")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getLeggings(), "VIT: +", "", "+"));
			}
		}
		if ((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getBoots(), "VIT")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getBoots(), "VIT: +", "", "+"));
			}
		}
		return vit;
	}
	
	public static double getHPS(Player p) {
		double vit = 0.0D;
		if ((p.getEquipment().getHelmet() != null) && (p.getEquipment().getHelmet().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getHelmet(), "HP REGEN")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getHelmet(), "HP REGEN: ", "HP/s", ""));
			}
		}
		if ((p.getEquipment().getChestplate() != null) && (p.getEquipment().getChestplate().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getChestplate(), "HP REGEN")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getChestplate(), "HP REGEN: ", "HP/s", ""));
			}
		}
		if ((p.getEquipment().getLeggings() != null) && (p.getEquipment().getLeggings().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getLeggings(), "HP REGEN")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getLeggings(), "HP REGEN: ", "HP/s", ""));
			}
		}
		if ((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getBoots(), "HP REGEN")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getBoots(), "HP REGEN: ", "HP/s", ""));
			}
		}
		return vit;
	}
	
	public static double getHP(Player p) {
		double vit = 0.0D;
		if ((p.getEquipment().getHelmet() != null) && (p.getEquipment().getHelmet().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getHelmet(), "HP")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getHelmet(), "HP: +", "", ""));
			}
		}
		if ((p.getEquipment().getChestplate() != null) && (p.getEquipment().getChestplate().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getChestplate(), "HP")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getChestplate(), "HP: +", "", ""));
			}
		}
		if ((p.getEquipment().getLeggings() != null) && (p.getEquipment().getLeggings().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getLeggings(), "HP")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getLeggings(), "HP: +", "", ""));
			}
		}
		if ((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getBoots(), "HP")) {
				vit += (Utils.getStatFromLore(p.getEquipment().getBoots(), "HP: +", "", ""));
			}
		}
		return vit;
	}
	
	public static double getDPS(Player p) {
		double vit = 0.0D;
		if ((p.getEquipment().getHelmet() != null) && (p.getEquipment().getHelmet().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getHelmet(), "DPS")) {
				vit += (Utils.getDPSFromLore(p.getEquipment().getHelmet()));
			}
		}
		if ((p.getEquipment().getChestplate() != null) && (p.getEquipment().getChestplate().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getChestplate(), "DPS")) {
				vit += (Utils.getDPSFromLore(p.getEquipment().getChestplate()));
			}
		}
		if ((p.getEquipment().getLeggings() != null) && (p.getEquipment().getLeggings().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getLeggings(), "DPS")) {
				vit += (Utils.getDPSFromLore(p.getEquipment().getLeggings()));
			}
		}
		if ((p.getEquipment().getBoots() != null) && (p.getEquipment().getBoots().getItemMeta().hasLore())) {
			if (StatUtils.hasStat(p.getEquipment().getBoots(), "DPS")) {
				vit += (Utils.getDPSFromLore(p.getEquipment().getBoots()));
			}
		}
		return vit;
	}
	
	
}
	

