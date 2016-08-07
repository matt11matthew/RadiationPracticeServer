package us.radiationnetwork.practiceserver.mobs;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.item.ItemGenerator;
import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.utils.Utils;

public class MobHandler implements Listener {
	
	public ItemRarity getRandomRarity() {
		int rare = Utils.ir(0, 50);
		if (rare <= 43) {
			return ItemRarity.COMMON;
		} else if ((rare == 44) || (rare == 45) || (rare == 46) || (rare == 47)) {
			return ItemRarity.UNCOMMON;
		} else if ((rare == 48) || (rare == 49)) {
			return ItemRarity.RARE;
		} else if (rare == 50) {
			return ItemRarity.UNIQUE;
		} else {
			return ItemRarity.COMMON;
		}
	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			LivingEntity l = e.getEntity();
			if (l.getCustomName() == null) return;
			String name = l.getCustomName();
			e.setDroppedExp(0);
			e.getDrops().clear();
			if (name.contains(ChatColor.WHITE.toString())) {
				int drop = Utils.ir(0, 20);
				int gems = Utils.ir(0, 2);
				int amt = (int) ItemGenerator.ir(5, 1);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					//helmet
				}
				if (drop == 2) {
					//chestplate
				}
				if (drop == 3) {
					//leggings
				}
				if (drop == 4) {
					//boots
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(1, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(1, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.GREEN.toString())) {
				int drop = Utils.ir(0, 40);
				int gems = Utils.ir(0, 2);
				int amt = (int) ItemGenerator.ir(7, 10);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					//helmet
				}
				if (drop == 2) {
					//chestplate
				}
				if (drop == 3) {
					//leggings
				}
				if (drop == 4) {
					//boots
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(2, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(2, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.AQUA.toString())) {
				int drop = Utils.ir(0, 60);
				int gems = Utils.ir(0, 2);
				int amt = (int) ItemGenerator.ir(17, 16);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					//helmet
				}
				if (drop == 2) {
					//chestplate
				}
				if (drop == 3) {
					//leggings
				}
				if (drop == 4) {
					//boots
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(3, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(3, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.LIGHT_PURPLE.toString())) {
				int drop = Utils.ir(0, 80);
				int gems = Utils.ir(0, 2);
				int amt = (int) ItemGenerator.ir(33, 32);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					//helmet
				}
				if (drop == 2) {
					//chestplate
				}
				if (drop == 3) {
					//leggings
				}
				if (drop == 4) {
					//boots
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(4, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(4, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.YELLOW.toString())) {
				int drop = Utils.ir(0, 10);
				int gems = Utils.ir(0, 2);
				int stacks = Utils.ir(0, 3);
				int amt = (int) ItemGenerator.ir(17, 16);
				if (gems == 1) {
					for (int i = 0; i < stacks; i++) {
						PSItem gem = new PSItem(Material.EMERALD);
						gem.setName("&fGem");
						gem.addLore("&7The currency of Andalucia");
						gem.setAmount(64);
						e.getDrops().add(gem.build());
					}
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					//helmet
				}
				if (drop == 2) {
					//chestplate
				}
				if (drop == 3) {
					//leggings
				}
				if (drop == 4) {
					//boots
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(5, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(5, getRandomRarity()));
				}
				
			}
		}
	}
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			Skeleton s = (Skeleton) e.getEntity();
			if (s.getCustomName() == null) return;
			String name = ChatColor.stripColor(s.getCustomName());
			switch (name) {
			case "T1":
				setUp(s, 1);
				break;
			case "T2":
				setUp(s, 2);
				break;
			case "T3":
				setUp(s, 3);
				break;
			case "T4":
				setUp(s, 4);
				break;
			case "T5":
				setUp(s, 5);
				break;
			case "null":
				break;
			default:
				break;
			}
		}
	}
	
	public void setUp(LivingEntity l, int tier) {
		String name = "";
		switch (l.getType()) {
		case SKELETON:
			switch (tier) {
			case 1:
				int r = Utils.ir(0, 2);
				switch (r) {
				case 1:
					name = "&fRotting Skeleton";
				case 2:
					name = "&fBroken Skeleton";			
				}
			case 2:
				name = "&aCracking Skeleton";
			case 3:
				name = "&bDemonic Skeleton";
			case 4:
				name = "&dSkeleton Guardian";
			case 5:
				name = "&eInfernal Skeleton";
			}
		}
		l.setCustomName(Utils.colorCodes(name));
		l.setCustomNameVisible(true);
		setupArmor(l, tier);
		Random random = new Random();
		double health = 0.0D;
		switch (tier) {
		case 1:
			health = random.nextInt(36) + 5;
		case 2:
			health = random.nextInt(51) + 50;
		case 3:
			health = random.nextInt(1101) + 400;
		case 4:
			health = random.nextInt(2501) + 2500;
		case 5:
			health = random.nextInt(1) + 2;
		}
		l.setMaxHealth(health);
		l.setHealth(l.getMaxHealth());
	}

	public void setupArmor(LivingEntity l, int tier) {
		switch (tier) {
		case 1:
			
		case 2:
			int armor = Utils.ir(0, 3);
			switch (armor) {
			case 1:
				l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
				l.getEquipment().setHelmet(getSkull(tier));
			case 2:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				l.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
			case 3:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
			}
			int held = Utils.ir(0, 6);
			switch (held) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD));
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD));
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_AXE));
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_AXE));
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SPADE));
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			}
		case 3:
			int armor1 = Utils.ir(0, 2);
			switch (armor1) {
			case 1:
				l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
				l.getEquipment().setHelmet(getSkull(tier));
			case 2:
				l.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
				l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				l.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
			}
			int held1 = Utils.ir(0, 6);
			switch (held1) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_AXE));
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_AXE));
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SPADE));
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			}
		case 4:
			l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			l.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			l.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			int held2 = Utils.ir(0, 6);
			switch (held2) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_AXE));
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_AXE));
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SPADE));
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			}
		case 5:
			l.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET));
			l.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			l.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
			l.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS));
			int held3 = Utils.ir(0, 6);
			switch (held3) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_AXE));
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_AXE));
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SPADE));
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			}
			l.getEquipment().setHelmetDropChance(0.0F);
			l.getEquipment().setChestplateDropChance(0.0F);
			l.getEquipment().setLeggingsDropChance(0.0F);
			l.getEquipment().setBootsDropChance(0.0F);
			l.getEquipment().setItemInOffHandDropChance(0.0F);
			l.getEquipment().setItemInMainHandDropChance(0.0F);
			l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 1000000), 0));
			l.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (20 * 1000000), 0));
		}
		
	}

	public ItemStack getSkull(int tier) {
		PSItem skull = new PSItem(Material.SKULL_ITEM);
		skull.setSkull(true);
		switch (tier) {
		case 1:
			skull.setSkullOwner("Lord_Kashi");
		case 2:
			skull.setSkullOwner("Lord_Kashi");
		case 3:
			skull.setSkullOwner("Lord_Kashi");
		case 4:
			skull.setSkullOwner("Lord_Kashi");
		case 5:
			skull.setSkullOwner("Lord_Kashi");
		}
		return skull.build();
	}
}
