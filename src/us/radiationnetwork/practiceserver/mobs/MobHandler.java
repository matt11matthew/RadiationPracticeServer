package us.radiationnetwork.practiceserver.mobs;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.item.ItemGenerator;
import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.shop.LootBuffHandler;
import us.radiationnetwork.practiceserver.utils.Utils;

public class MobHandler implements Listener {
	
	  public static ItemRarity getRandomRarity() {
		  Random random = new Random();
		  int rarity = random.nextInt(50) + 1;
		  if (rarity <= 43) {
			  return ItemRarity.COMMON;
		  } else if ((rarity == 44) || (rarity == 45) || (rarity == 46) ||  (rarity == 47)) {
			  return ItemRarity.UNCOMMON;
		  } else if ((rarity == 48) || (rarity == 49)) {
			  return ItemRarity.RARE;
		  } else if (rarity == 50) {
			  return ItemRarity.UNIQUE;
		  }
		return ItemRarity.UNIQUE;
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
				int drop = 0;
				if (LootBuffHandler.buffs.contains("loot")) {
					drop = ItemGenerator.ir(70, 1);
				} else if (LootBuffHandler.buffs.contains("uq")) {
					drop = ItemGenerator.ir(40, 1);
				} else {
					ItemGenerator.ir(80, 1);
				}
				int gems =  ItemGenerator.ir(2, 1);
				int amt = (int) ItemGenerator.ir(5, 1);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					e.getDrops().add(ItemGenerator.generateHelmet(1, getRandomRarity()));
				}
				if (drop == 2) {
					e.getDrops().add(ItemGenerator.generateChestplate(1, getRandomRarity()));
				}
				if (drop == 3) {
					e.getDrops().add(ItemGenerator.generateLeggings(1, getRandomRarity()));
				}
				if (drop == 4) {
					e.getDrops().add(ItemGenerator.generateBoots(1, getRandomRarity()));
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(1, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(1, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.GREEN.toString())) {
				int drop = 0;
				if (LootBuffHandler.buffs.contains("loot")) {
					drop = ItemGenerator.ir(80, 1);
				} else if (LootBuffHandler.buffs.contains("uq")) {
					drop = ItemGenerator.ir(50, 1);
				} else {
					drop = ItemGenerator.ir(100, 1);
				}
				int gems =  ItemGenerator.ir(2, 1);
				int amt = (int) ItemGenerator.ir(7, 10);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					e.getDrops().add(ItemGenerator.generateHelmet(2, getRandomRarity()));
				}
				if (drop == 2) {
					e.getDrops().add(ItemGenerator.generateChestplate(2, getRandomRarity()));
				}
				if (drop == 3) {
					e.getDrops().add(ItemGenerator.generateLeggings(2, getRandomRarity()));
				}
				if (drop == 4) {
					e.getDrops().add(ItemGenerator.generateBoots(2, getRandomRarity()));
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(2, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(2, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.AQUA.toString())) {
				int drop = 0;
				if (LootBuffHandler.buffs.contains("loot")) {
					drop = ItemGenerator.ir(100, 1);;
				} else if (LootBuffHandler.buffs.contains("uq")) {
					drop = ItemGenerator.ir(60, 1);
				} else {
					drop = ItemGenerator.ir(120, 1);
				}
				int gems =  ItemGenerator.ir(2, 1);
				int amt = (int) ItemGenerator.ir(17, 16);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					e.getDrops().add(ItemGenerator.generateHelmet(3, getRandomRarity()));
				}
				if (drop == 2) {
					e.getDrops().add(ItemGenerator.generateChestplate(3, getRandomRarity()));
				}
				if (drop == 3) {
					e.getDrops().add(ItemGenerator.generateLeggings(3, getRandomRarity()));
				}
				if (drop == 4) {
					e.getDrops().add(ItemGenerator.generateBoots(3, getRandomRarity()));
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(3, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(3, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.LIGHT_PURPLE.toString())) {
				int drop = 0;
				if (LootBuffHandler.buffs.contains("loot")) {
					drop = ItemGenerator.ir(120, 1);
				} else if (LootBuffHandler.buffs.contains("uq")) {
					drop = ItemGenerator.ir(80, 1);
				} else {
					drop = ItemGenerator.ir(160, 1);
				}
				int gems =  ItemGenerator.ir(2, 1);
				int amt = (int) ItemGenerator.ir(33, 32);
				if (gems == 1) {
					PSItem gem = new PSItem(Material.EMERALD);
					gem.setName("&fGem");
					gem.addLore("&7The currency of Andalucia");
					gem.setAmount(amt);
					e.getDrops().add(gem.build());
				}
				if (drop == 1) {
					e.getDrops().add(ItemGenerator.generateHelmet(4, getRandomRarity()));
				}
				if (drop == 2) {
					e.getDrops().add(ItemGenerator.generateChestplate(4, getRandomRarity()));
				}
				if (drop == 3) {
					e.getDrops().add(ItemGenerator.generateLeggings(4, getRandomRarity()));
				}
				if (drop == 4) {
					e.getDrops().add(ItemGenerator.generateBoots(4, getRandomRarity()));
				}
				if ((drop == 5) || (drop == 6)) {
					e.getDrops().add(ItemGenerator.generateAxe(4, getRandomRarity()));
				}
				if ((drop == 7) || (drop == 8)) {
					e.getDrops().add(ItemGenerator.generateSword(4, getRandomRarity()));
				}
			}
			if (name.contains(ChatColor.YELLOW.toString())) {
				int drop = 0;
				if (LootBuffHandler.buffs.contains("loot")) {
					drop = ItemGenerator.ir(160, 1);
				} else if (LootBuffHandler.buffs.contains("uq")) {
					drop = ItemGenerator.ir(100, 1);
				} else {
					drop = ItemGenerator.ir(200, 1);
				}
				int gems =  ItemGenerator.ir(2, 1);
				int stacks = ItemGenerator.ir(3, 1);
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
					e.getDrops().add(ItemGenerator.generateHelmet(5, getRandomRarity()));
				}
				if (drop == 2) {
					e.getDrops().add(ItemGenerator.generateChestplate(5, getRandomRarity()));
				}
				if (drop == 3) {
					e.getDrops().add(ItemGenerator.generateLeggings(5, getRandomRarity()));
				}
				if (drop == 4) {
					e.getDrops().add(ItemGenerator.generateBoots(5, getRandomRarity()));
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
	public void onItemChange(PlayerSwapHandItemsEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
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
	
	public static void setUp(LivingEntity l, int tier) {
		String name = "";
		switch (l.getType()) {
		case SKELETON:
			switch (tier) {
			case 1:
				int r = ItemGenerator.ir(2, 1);
				switch (r) {
				case 1:
					name = "&fRotting Skeleton";
					break;
				case 2:
					name = "&fBroken Skeleton";	
					break;
				}
				break;
			case 2:
				name = "&aCracking Skeleton";
				break;
			case 3:
				name = "&bDemonic Skeleton";
				break;
			case 4:
				name = "&dSkeleton Guardian";
				break;
			case 5:
				name = "&eInfernal Skeleton";
				break;
				
			}
			break;
		}
		l.setCustomName(Utils.colorCodes(name));
		l.setCustomNameVisible(true);
		setupArmor(l, tier);
		Random random = new Random();
		double health = 0.0D;
		switch (tier) {
		case 1:
			health = random.nextInt(36) + 5;
			break;
		case 2:
			health = random.nextInt(51) + 50;
			break;
		case 3:
			health = random.nextInt(1101) + 400;
			break;
		case 4:
			health = random.nextInt(2501) + 2500;
			break;
		case 5:
			health = random.nextInt(8000) + 4001;
			break;
		}
		l.setMaxHealth(health);
		l.setHealth(l.getMaxHealth());
	}

	public static void setupArmor(LivingEntity l, int tier) {
		switch (tier) {
		case 1:
			int armor6 = ItemGenerator.ir(3, 1);
			switch (armor6) {
			case 1:
				l.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
				l.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
				l.getEquipment().setHelmet(getSkull(tier));
				break;
			case 2:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
				l.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				l.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
				break;
			case 3:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
				break;
			}
			int held6 = ItemGenerator.ir(6, 1);
			switch (held6) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
				break;
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
				break;
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_AXE));
				break;
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_AXE));
				break;
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SPADE));
				break;
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
				break;
			}
			break;
		case 2:
			int armor = ItemGenerator.ir(3, 1);
			switch (armor) {
			case 1:
				l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
				l.getEquipment().setHelmet(getSkull(tier));
				break;
			case 2:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				l.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
				break;
			case 3:
				l.getEquipment().setHelmet(getSkull(tier));
				l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
				break;
			}
			
			int held = ItemGenerator.ir(6, 1);

			switch (held) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD));
				break;
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SWORD));
				break;
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_AXE));
				break;
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_AXE));
				break;
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.STONE_SPADE));
				break;
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
				break;
			}
			break;
		case 3:
			int armor1 = ItemGenerator.ir(2, 1);
			switch (armor1) {
			case 1:
				l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
				l.getEquipment().setHelmet(getSkull(tier));
				break;
			case 2:
				l.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
				l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				l.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
				break;
			}
			int held1 = ItemGenerator.ir(6, 1);
			switch (held1) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
				break;
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
				break;
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_AXE));
				break;
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_AXE));
				break;
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SPADE));
				break;
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
				break;
			}
			break;
		case 4:
			l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			l.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			l.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			int held2 = ItemGenerator.ir(6, 1);
			switch (held2) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
				break;
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
				break;
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_AXE));
				break;
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_AXE));
				break;
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SPADE));
				break;
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
				break;
			}
			break;
		case 5:
			l.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET));
			l.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			l.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
			l.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS));
			int held3 = ItemGenerator.ir(6, 1);
			switch (held3) {
			case 1:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
				break;
			case 2:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
				break;
			case 3:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_AXE));
				break;
			case 4:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_AXE));
				break;
			case 5:
				l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SPADE));
				break;
			case 6:
				l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
				break;
			}
			break;
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

	public static ItemStack getSkull(int tier) {
		PSItem skull = new PSItem(Material.SKULL_ITEM);
		skull.setSkull(true);
		switch (tier) {
		case 1:
			skull.setSkullOwner("Lord_Kashi");
			break;
		case 2:
			skull.setSkullOwner("Lord_Kashi");
			break;
		case 3:
			skull.setSkullOwner("Lord_Kashi");
			break;
		case 4:
			skull.setSkullOwner("Lord_Kashi");
			break;
		case 5:
			skull.setSkullOwner("Lord_Kashi");
			break;
		}
		return skull.build();
	}
}
