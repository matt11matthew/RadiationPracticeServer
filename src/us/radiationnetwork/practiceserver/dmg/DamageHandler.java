package us.radiationnetwork.practiceserver.dmg;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.radiationnetwork.practiceserver.health.HealthHandler;
import us.radiationnetwork.practiceserver.item.ItemGenerator;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.RegionUtils;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Unicodes;
import us.radiationnetwork.practiceserver.utils.Utils;
import us.radiationnetwork.practiceserver.zones.Zone;

public class DamageHandler implements Listener {
	
	public double getFinalDMGMob(Player p, LivingEntity l) {
		if ((RegionUtils.getZone(l.getLocation()) == Zone.SAFE) || (RegionUtils.getZone(p.getLocation()) == Zone.SAFE)) {
			return -1;	
		}
		ItemStack wep = p.getEquipment().getItemInMainHand();
		double dmg = 0.0D;
		double crit = 0;
		if (StatUtils.hasStat(wep, "DMG")) {
			dmg = getRawDMG(wep);
			if (StatUtils.hasStat(wep, "ICE DMG")) {
				dmg += Utils.getStatFromLore(wep, "ICE DMG: +", "", "");
				l.getWorld().playEffect(l.getEyeLocation(), Effect.POTION_BREAK, 8194);
				l.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (20 * 1), 0));
			}
			if (StatUtils.hasStat(wep, "FIRE DMG")) {
				dmg += Utils.getStatFromLore(wep, "FIRE DMG: +", "", "");
				l.setFireTicks(10);
			}
			if (StatUtils.hasStat(wep, "PURE DMG")) {
				dmg += Utils.getStatFromLore(wep, "PURE DMG: +", "", "");
			}
			if (StatUtils.hasStat(wep, "POISON DMG")) {
				dmg += Utils.getStatFromLore(wep, "POISON DMG: +", "", "");
				l.getWorld().playEffect(l.getEyeLocation(), Effect.POTION_BREAK, 40);
				l.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10, 1));
			}
			if (StatUtils.hasStat(wep, "LIFE STEAL")) {
				double ls = Utils.getStatFromLore(wep, "LIFE STEAK: ", "%", "");
				double pcnt = ls / 100.0D;
				int life = 0;
				if ((pcnt * dmg) > 0) {
					life = (int) (pcnt * dmg);
				} else {
					life = 1;
				}
				l.getWorld().playEffect(l.getEyeLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
				if (p.getHealth() < p.getMaxHealth() - life) {
					p.setHealth(p.getHealth() + life);
				} else if (p.getHealth() >= p.getMaxHealth() - life) {
					p.setHealth(p.getMaxHealth());
				}
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&a&l            +&a" + life + " &lHP&7 [" + (int) p.getHealth() + "/" + (int) p.getMaxHealth() + "HP]"));
				}
			}
			if (HealthHandler.getDPS(p) > 0) {
				double dps = HealthHandler.getDPS(p) / 2;
				double divide = dps / 100.0D;
				double pre = dmg * divide;
				int cleaned = (int)(dmg + pre);
				dmg = cleaned;
			}
			if (HealthHandler.getVIT(p) > 0) {
				if (Utils.isSword(wep)) {
					double vit = HealthHandler.getVIT(p) / 2;
					if (vit > 0.0D) {
						double divide = vit / 7500.0D;
				        double pre = dmg * divide;
				        int cleaned = (int) (dmg + pre);
				        dmg = cleaned;
					}
				}
			}
			if (StatUtils.hasStat(wep, "CRITICAL HIT")) {
				crit += Utils.getStatFromLore(wep, "CRITICAL HIT: ", "%", "");
			}
			if (Utils.isAxe(wep)) {
				crit += 5;
			}
			if (crit > 0) {
				Random r = new Random();
				if (r.nextInt(100) <= crit) {
					dmg *= 2;
					p.playSound(p.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 0.65F);
				}
			}
			
			
		} else {
			dmg = 1.0D;
		}
		return dmg;
	}
	
	public double getRawDMG(ItemStack wep) {
		double dmg = 0.0D;
		if (StatUtils.hasStat(wep, "DMG")) {
			String raw = Utils.getStringFromLore(wep, "DMG: ");
			int min = Utils.convertStringToInteger(raw.split("-")[0].trim());
			int max = Utils.convertStringToInteger(raw.split("-")[1].trim());
			dmg = Utils.ir(min, max);
		} else {
			dmg = 1.0D;
		}
		return dmg;
	}

	@EventHandler
	public void onTarget(EntityTargetEvent e) {
		if (!(e.getTarget() instanceof Player)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDMG(EntityDamageByEntityEvent e) {
		if ((e.getEntity() instanceof Player) && ((e.getDamager() instanceof Arrow)) && (!(e.getDamager() instanceof Player))) {
			Arrow a = (Arrow) e.getDamager();
			if (!(a.getShooter() instanceof Player)) {
				Player p = (Player) e.getEntity();
				LivingEntity l = (LivingEntity) a.getShooter();
				int tier = Utils.getTier(l);
				e.setCancelled(true);
				if ((RegionUtils.getZone(a.getLocation()) == Zone.SAFE) || (RegionUtils.getZone(p.getLocation()) == Zone.SAFE)) {
					return;	
				}
				p.setVelocity(l.getLocation().getDirection().multiply(0.4));
				p.playEffect(EntityEffect.HURT);
				p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_HURT, 1.0F, 1.0F);
				double dmg = 0.0D;
				switch (tier) {
				case 1:
					dmg = ItemGenerator.ir(15, 10);
					break;
				case 2:
					dmg = ItemGenerator.ir(40, 20);
					break;
				case 3:
					dmg = ItemGenerator.ir(70, 30);
					break;
				case 4:
					dmg = ItemGenerator.ir(140, 80);
					break;
				case 5:
					dmg = ItemGenerator.ir(220, 160);
					break;
				}
				l.setNoDamageTicks(0);
				
				p.setNoDamageTicks(0);
				if (dmg >= p.getHealth()) {
					p.damage(p.getHealth());
					if (FileManager.isDebug(p.getName())) {
						p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[0&lHP&a]"));
					}
					p.spigot().respawn();
				} else {
					p.setHealth((p.getHealth() - dmg));
					if (FileManager.isDebug(p.getName())) {
						p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[" + (int) p.getHealth() + "&lHP&a]"));
					}
				}
			}
		}
		if ((e.getEntity() instanceof Player) && (!(e.getDamager() instanceof Arrow)) && (!(e.getDamager() instanceof Player))) {
			Player p = (Player) e.getEntity();
			LivingEntity l = (LivingEntity) e.getDamager();
			int tier = Utils.getTier(l);
			e.setCancelled(true);
			if ((RegionUtils.getZone(l.getLocation()) == Zone.SAFE) || (RegionUtils.getZone(p.getLocation()) == Zone.SAFE)) {
				return;	
			}
			p.setVelocity(l.getLocation().getDirection().multiply(0.4));
			p.playEffect(EntityEffect.HURT);
			p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_HURT, 1.0F, 1.0F);
			double dmg = 0.0D;
			switch (tier) {
			case 1:
				dmg = ItemGenerator.ir(8, 3);
				break;
			case 2:
				dmg = ItemGenerator.ir(15, 7);
				break;
			case 3:
				dmg = ItemGenerator.ir(30, 12);
				break;
			case 4:
				dmg = ItemGenerator.ir(80, 60);
				break;
			case 5:
				dmg = ItemGenerator.ir(120, 60);
				break;
			}
			l.setNoDamageTicks(0);
			
			p.setNoDamageTicks(0);
			if (dmg >= p.getHealth()) {
				p.damage(p.getHealth());
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[0&lHP&a]"));
				}
				p.spigot().respawn();
			} else {
				p.setHealth((p.getHealth() - dmg));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[" + (int) p.getHealth() + "&lHP&a]"));
				}
			}
		}
		if ((e.getDamager() instanceof Player) && (!(e.getEntity() instanceof Player))) {
			Player p = (Player) e.getDamager();
			LivingEntity l = (LivingEntity) e.getEntity();
			double dmg = getFinalDMGMob(p, l);
			e.setCancelled(true);
			if (dmg == -1) {
				return;
			} else {
				l.setNoDamageTicks(0);
				p.setNoDamageTicks(0);
				l.setVelocity(p.getLocation().getDirection().multiply(0.4));
				l.playEffect(EntityEffect.HURT);
				p.playSound(l.getLocation(), Sound.ENTITY_GENERIC_HURT, 1.0F, 1.0F);
				if (dmg >= l.getHealth()) {
					l.playEffect(EntityEffect.DEATH);
					l.damage(l.getHealth());
					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -" + Unicodes.DEBUG_ARROW.get() + " &r" + l.getCustomName() + " [0]"));
					}
				} else {
					l.setHealth((l.getHealth() - dmg));
					l.damage(0);
					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -" + Unicodes.DEBUG_ARROW.get() + " &r" + l.getCustomName() + " [" + (int) l.getHealth() + "]"));
					}
				}
			}
			
		}
	}

}
