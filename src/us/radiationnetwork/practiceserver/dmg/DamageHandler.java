package us.radiationnetwork.practiceserver.dmg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
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
import org.bukkit.scheduler.BukkitRunnable;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.enums.Alignment;
import us.radiationnetwork.practiceserver.health.HealthHandler;
import us.radiationnetwork.practiceserver.item.ItemGenerator;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.RegionUtils;
import us.radiationnetwork.practiceserver.utils.StatUtils;
import us.radiationnetwork.practiceserver.utils.Utils;
import us.radiationnetwork.practiceserver.zones.Zone;

public class DamageHandler implements Listener {
	
	public static List<Player> tagged = new ArrayList<Player>();
	public static List<Player> nodmg = new ArrayList<Player>();
	public static HashMap<Player, Integer> flags = new HashMap<Player, Integer>();
	
	public double getFinalDMGMob(Player p, LivingEntity l) {
		if ((RegionUtils.getZone(l.getLocation()) == Zone.SAFE) || (RegionUtils.getZone(p.getLocation()) == Zone.SAFE)) {
			return -1;	
		}
		if (nodmg.contains(p)) {
			if (!flags.containsKey(p)) {
				flags.put(p, 1);
			} else {
				int time = flags.get(p);
				time++;
				flags.put(p, time);
				if (flags.get(p) >= 20) {
					flag(p);
				}
			}
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
	
	public void flag(Player p) {
		for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
			int lvl = flags.get(p);
			if ((lvl == 100) || (lvl == 300) || (lvl == 500) || (lvl == 1000)) {
				if (pl.isOp()) {
					pl.sendMessage(Utils.colorCodes("&c[NoCheat] &a" + p.getName() + " &chas been kicked for &aAutoClicker &c&l(" + flags.get(p) + "LVL)"));	
				}
				p.kickPlayer(Utils.colorCodes("&c[NoCheat]\n&aStop Auto Clicking"));
			}
			if ((lvl == 20) || (lvl == 100) || (lvl == 200) || (lvl == 500) || (lvl == 1000)) {
				if (pl.isOp()) {
					pl.sendMessage(Utils.colorCodes("&c[NoCheat] &a" + p.getName() + " AutoClicker &c&l(" + flags.get(p) + "LVL)"));
				}
			}
		}
		return;
	}
	
	public double getFinalDMGPlayer(Player p, LivingEntity l) {
		if (nodmg.contains(p)) {
			if (!flags.containsKey(p)) {
				flags.put(p, 1);
			} else {
				int time = flags.get(p);
				time++;
				flags.put(p, time);
				if (flags.get(p) >= 20) {
					flag(p);
				}
			}
			return -1;
		}
		if ((RegionUtils.getZone(l.getLocation()) == Zone.SAFE) || (RegionUtils.getZone(p.getLocation()) == Zone.SAFE)) {
			return -1;	
		}
		if ((RegionUtils.getZone(l.getLocation()) == Zone.WILDERNESS) || (RegionUtils.getZone(p.getLocation()) == Zone.WILDERNESS)) {
			return -1;	
		}
		if (FileManager.isTogglePvP(p.getName())) {
			p.sendMessage(Utils.colorCodes("&cYou &ncannot&c &lPVP&c with togglepvp on!"));
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
	
	public double getRawDMG(List<String> lore) {
		double dmg = 0.0D;
		if (StatUtils.hasStat(lore, "DMG")) {
			String raw = Utils.getStringFromLore(lore, "DMG: ");
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
	
	public void tag(final Player p) {
		tagged.add(p);
		new BukkitRunnable() {
			public void run() {
				tagged.remove(p);
			}
		}.runTaskLater(Main.plugin, (20L * 10L));
	}
	
	public void noDMG(final Player p) {
		nodmg.add(p);
		new BukkitRunnable() {
			public void run() {
				nodmg.remove(p);
			}
		}.runTaskLater(Main.getInstance(), 2L);
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
				tag(p);
				if (dmg >= p.getHealth()) {
					p.damage(p.getHealth());
					if (FileManager.isDebug(p.getName())) {
						p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[0&lHP&a]"));
					}
					String msg = p.getDisplayName() + "&f was killed a(n) &r" + l.getCustomName();
					Bukkit.getServer().broadcastMessage(Utils.colorCodes(msg));
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
			tag(p);
			if (dmg >= p.getHealth()) {
				p.damage(p.getHealth());
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[0&lHP&a]"));
				}
				String msg = p.getDisplayName() + "&f was killed a(n) &r" + l.getCustomName();
				Bukkit.getServer().broadcastMessage(Utils.colorCodes(msg));
			} else {
				p.setHealth((p.getHealth() - dmg));
				if (FileManager.isDebug(p.getName())) {
					p.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[" + (int) p.getHealth() + "&lHP&a]"));
				}
			}
		}
		if ((e.getDamager() instanceof Player) && (e.getEntity() instanceof Player)) {
			Player p = (Player) e.getDamager();
			Player l = (Player) e.getEntity();
			double dmg = getFinalDMGPlayer(p, l);
			e.setCancelled(true);
			noDMG(p);
			if (dmg == -1) {
				return;
			} else {
				l.setNoDamageTicks(0);
				p.setNoDamageTicks(0);
				tag(p);
				tag(l);
				FileManager.setCombatTime(p.getName(), 10);
				l.setVelocity(p.getLocation().getDirection().multiply(0.4));
				l.playEffect(EntityEffect.HURT);
				p.playSound(l.getLocation(), Sound.ENTITY_GENERIC_HURT, 1.0F, 1.0F);
				if (dmg >= l.getHealth()) {
					l.playEffect(EntityEffect.DEATH);
					l.damage(l.getHealth());
					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -> " + l.getName()));
					}
					if (FileManager.isDebug(l.getName())) {
						l.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[0&lHP&a]"));
					}
					testAlignment(p, l, true);
					String msg = l.getDisplayName() + " &fwas killed by &r" + p.getDisplayName() + "&f with a(n) " + p.getItemInHand().getItemMeta().getDisplayName(); 
					Bukkit.getServer().broadcastMessage(Utils.colorCodes(msg));
				} else {
					l.setHealth((l.getHealth() - dmg));
					l.damage(0);
					testAlignment(p, l, false);
					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -> " + l.getName()));
					}
					if (FileManager.isDebug(l.getName())) {
						l.sendMessage(Utils.colorCodes("&c            -" + (int) dmg + "&lHP &7[-0%A -> -0&lDMG&7] &a[" + (int) l.getHealth() + "&lHP&a]"));
					}				
				}
			}
		}
		if ((e.getDamager() instanceof Player) && (!(e.getEntity() instanceof Player))) {
			Player p = (Player) e.getDamager();
			LivingEntity l = (LivingEntity) e.getEntity();
			double dmg = getFinalDMGMob(p, l);
			e.setCancelled(true);
			noDMG(p);
			if (dmg == -1) {
				return;
			} else {
				l.setNoDamageTicks(0);
				p.setNoDamageTicks(0);
				tag(p);
				l.setVelocity(p.getLocation().getDirection().multiply(0.4));
				l.playEffect(EntityEffect.HURT);
				p.playSound(l.getLocation(), Sound.ENTITY_GENERIC_HURT, 1.0F, 1.0F);
				if (dmg >= l.getHealth()) {

					l.playEffect(EntityEffect.DEATH);
					l.damage(l.getHealth());
					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -> &r" + l.getCustomName() + " [0]"));
					}
				} else {
					l.setHealth((l.getHealth() - dmg));
					l.damage(0);

					if (FileManager.isDebug(p.getName()))  {
						p.sendMessage(Utils.colorCodes("&c            " + (int) dmg + "&c&l DMG -> &r" + l.getCustomName() + " [" + (int) l.getHealth() + "]"));
					}
				}
			}
			
		}
	}
	
	
	public int getTime(Player p) {
		return FileManager.getAlignmentTime(p.getName());
	}
	
	public void setAlignment(Player p, Alignment alignment) {
		Alignment old = FileManager.getAlignment(p.getName());
		FileManager.setAlignment(p.getName(), alignment);
		switch (alignment) {
		case CHAOTIC:
			switch (old) {
			case CHAOTIC:
				p.sendMessage("§cLAWFUL player slain, §l+300s §cadded to Chaotic timer");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			case LAWFUL:
				p.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
				p.sendMessage("§7If you are killed while chaotic, you will lose enerything");
				p.sendMessage("§7in your inventory. Chaotic alignment will expire 5 minutes after");
				p.sendMessage("§7your last player kill.");
				p.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
				p.sendMessage("§cLAWFUL player slain, §l+300s §cadded to Chaotic timer");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			case NEUTRAL:
				p.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
				p.sendMessage("§7If you are killed while chaotic, you will lose enerything");
				p.sendMessage("§7in your inventory. Chaotic alignment will expire 5 minutes after");
				p.sendMessage("§7your last player kill.");
				p.sendMessage("          §c* YOU ARE NOW §lCHAOTIC §cALIGNMENT *");
				p.sendMessage("§cLAWFUL player slain, §l+300s §cadded to Chaotic timer");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			
			}
			break;
		case LAWFUL:
			switch (old) {
			case CHAOTIC:
				p.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
				p.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
				p.sendMessage("§7Any players who kill you while you're lawfully aligned will");
				p.sendMessage("§7become chaotic.");
				p.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			case LAWFUL:
				break;
			case NEUTRAL:
				p.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
				p.sendMessage("§7While lawful, you will not lose any equiped armor on death.");
				p.sendMessage("§7Any players who kill you while you're lawfully aligned will");
				p.sendMessage("§7become chaotic.");
				p.sendMessage("          §a* YOU ARE NOW §lLAWFUL §aALIGNMENT *");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			}
			break;
		case NEUTRAL:
			switch (old) {
			case CHAOTIC:
				p.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
				p.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
				p.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
				p.sendMessage("§7chance of dropping each piece of equiped armor on death.");
				p.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
				p.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			case LAWFUL:
				p.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
				p.sendMessage("§7While neutral, players who kill you will not become chaotic. You");
				p.sendMessage("§7have a 50% chance of dropping your weapon, and a 25%");
				p.sendMessage("§7chance of dropping each piece of equiped armor on death.");
				p.sendMessage("§7Neutral alignment will expire 1 minute after last hit on player.");
				p.sendMessage("          §e* YOU ARE NOW §e§lNEUTRAL §eALIGNMENT *");
				p.setPlayerListName(alignment.getTabColor() + p.getName());
				break;
			case NEUTRAL:
				break;
			}
			break;
		}
	}
	
	public void setAlignmentTime(Player p, int time) {
		FileManager.setAlignmentTime(p.getName(), time);
	}

	public void testAlignment(Player p, Player l, boolean death) {
		Alignment p_alignment = FileManager.getAlignment(p.getName());
		Alignment l_alignment = FileManager.getAlignment(l.getName());
		switch (p_alignment) {
		case CHAOTIC:
			switch (l_alignment) {
			case CHAOTIC:
				if (death) {
					setAlignment(p, Alignment.CHAOTIC);
					setAlignmentTime(p, (getTime(p) - 160));
					p.sendMessage("§cCHAOTIC player slain, §l-160s §cremoved from Chaotic timer");
					break;	
				}
				break;
			case LAWFUL:
				if (death) {
					setAlignment(p, Alignment.CHAOTIC);
					setAlignmentTime(p, (getTime(p) + 300));
					break;
				}
				break;
			case NEUTRAL:
				break;
			}
		case LAWFUL:
			switch (l_alignment) {
			case CHAOTIC:
				setAlignment(p, Alignment.NEUTRAL);
				setAlignmentTime(p, 60);
				break;
			case LAWFUL:
				if (death) {
					setAlignment(p, Alignment.CHAOTIC);
					setAlignmentTime(p, (getTime(p) + 300));
					break;
				} else {
					setAlignment(p, Alignment.NEUTRAL);
					setAlignmentTime(p, 60);
					break;
				}
			case NEUTRAL:
				setAlignment(p, Alignment.NEUTRAL);
				setAlignmentTime(p, 60);
				break;
			
			}
			break;
		case NEUTRAL:
			switch (l_alignment) {
			case CHAOTIC:
				setAlignment(p, Alignment.NEUTRAL);
				setAlignmentTime(p, 60);
				break;
			case LAWFUL:
				if (death) {
					setAlignment(p, Alignment.CHAOTIC);
					setAlignmentTime(p, (getTime(p) + 300));
					break;
				} else {
					setAlignment(p, Alignment.NEUTRAL);
					setAlignmentTime(p, 60);
					break;
				}
			case NEUTRAL:
				setAlignment(p, Alignment.NEUTRAL);
				setAlignmentTime(p, 60);
				break;
			}
			break;
		}
	}
}
