package us.radiationnetwork.practiceserver.fish;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import us.radiationnetwork.practiceserver.item.PSItem;
import us.radiationnetwork.practiceserver.utils.Utils;

public class SpeedFish implements Listener {
	
	public static ItemStack getFishRaw(int tier) {
		switch (tier) {
		case 1:
			PSItem t1fish = new PSItem(Material.RAW_FISH);
			t1fish.setName("&fT1 Speedfish");
			t1fish.addLore("&cSPEED (I) BUFF &7(15s)");
			t1fish.addLore("&c-10% HUNGER &7(instant)");
			t1fish.addLore("&7&oA T1 Feesh.");
			return t1fish.build();
		case 2:
			PSItem t2fish = new PSItem(Material.RAW_FISH);
			t2fish.setName("&aT2 Speedfish");
			t2fish.addLore("&cSPEED (I) BUFF &7(30s)");
			t2fish.addLore("&c-20% HUNGER &7(instant)");
			t2fish.addLore("&7&oA T3 Feesh.");
			return t2fish.build();
		case 3:
			PSItem t3fish = new PSItem(Material.RAW_FISH);
			t3fish.setName("&bRaw Salmon of Lasting Agility");
			t3fish.addLore("&cSPEED (I) BUFF &7(60s)");
			t3fish.addLore("&c-30% HUNGER &7(instant)");
			t3fish.addLore("&7&oA beautiful jumping fish.");
			return t3fish.build();
		case 4:
			PSItem t4fish = new PSItem(Material.RAW_FISH);
			t4fish.setName("&dRaw Lobster of Bursting Agility");
			t4fish.addLore("&cSPEED (III) BUFF &7(15s)");
			t4fish.addLore("&c-40% HUNGER &7(instant)");
			t4fish.addLore("&7&oA large red crustacean.");
			return t4fish.build();
		case 5:
			PSItem t5fish = new PSItem(Material.RAW_FISH);
			t5fish.setName("&eRaw Swordfish of Godlike Speed");
			t5fish.addLore("&cSPEED (III) BUFF &7(30s)");
			t5fish.addLore("&c-50% HUNGER &7(instant)");
			t5fish.addLore("&7&oAn elongated fish with a long bill.");
			return t5fish.build();
		}
		return null;
	}
	
	public ItemStack cookFish(ItemStack raw_fish) {
		PSItem fish = new PSItem(Material.COOKED_FISH);
		fish.setLore(raw_fish.getItemMeta().getLore());
		fish.setName(raw_fish.getItemMeta().getDisplayName().replace("Raw", "Cooked"));
		fish.setAmount(raw_fish.getAmount());
		return fish.build();
	}
	
	public static ItemStack getFishCooked(int tier) {
		switch (tier) {
		case 1:
			PSItem t1fish = new PSItem(Material.COOKED_FISH);
			t1fish.setName("&fT1 Speedfish");
			t1fish.addLore("&cSPEED (I) BUFF &7(15s)");
			t1fish.addLore("&c-10% HUNGER &7(instant)");
			t1fish.addLore("&7&oA T1 Feesh.");
			return t1fish.build();
		case 2:
			PSItem t2fish = new PSItem(Material.COOKED_FISH);
			t2fish.setName("&aT2 Speedfish");
			t2fish.addLore("&cSPEED (I) BUFF &7(30s)");
			t2fish.addLore("&c-20% HUNGER &7(instant)");
			t2fish.addLore("&7&oA T3 Feesh.");
			return t2fish.build();
		case 3:
			PSItem t3fish = new PSItem(Material.COOKED_FISH);
			t3fish.setName("&bCooked Salmon of Lasting Agility");
			t3fish.addLore("&cSPEED (I) BUFF &7(60s)");
			t3fish.addLore("&c-30% HUNGER &7(instant)");
			t3fish.addLore("&7&oA beautiful jumping fish.");
			return t3fish.build();
		case 4:
			PSItem t4fish = new PSItem(Material.COOKED_FISH);
			t4fish.setName("&dCooked Lobster of Bursting Agility");
			t4fish.addLore("&cSPEED (III) BUFF &7(15s)");
			t4fish.addLore("&c-40% HUNGER &7(instant)");
			t4fish.addLore("&7&oA large red crustacean.");
			return t4fish.build();
		case 5:
			PSItem t5fish = new PSItem(Material.COOKED_FISH);
			t5fish.setName("&eCooked Swordfish of Godlike Speed");
			t5fish.addLore("&cSPEED (III) BUFF &7(30s)");
			t5fish.addLore("&c-50% HUNGER &7(instant)");
			t5fish.addLore("&7&oAn elongated fish with a long bill.");
			return t5fish.build();
		}
		return null;
	}
	
	@EventHandler
	public void onFishEat(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		Block block = e.getClickedBlock();
		if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)) {
			if ((p.getItemInHand() != null) && (p.getItemInHand().hasItemMeta()) && (p.getItemInHand().getType() == Material.COOKED_FISH)) {
				String name = p.getItemInHand().getItemMeta().getDisplayName();
				if (name.equalsIgnoreCase(getFishCooked(1).getItemMeta().getDisplayName())) {
					eat(p, 1);
					removeFish(p);
				}
				if (name.equalsIgnoreCase(getFishCooked(2).getItemMeta().getDisplayName())) {
					eat(p, 2);
					removeFish(p);
				}
				if (name.equalsIgnoreCase(getFishCooked(3).getItemMeta().getDisplayName())) {
					eat(p, 3);
					removeFish(p);
				}
				if (name.equalsIgnoreCase(getFishCooked(4).getItemMeta().getDisplayName())) {
					eat(p, 4);
					removeFish(p);
				}
				if (name.equalsIgnoreCase(getFishCooked(5).getItemMeta().getDisplayName())) {
					eat(p, 5);
					removeFish(p);
				}
			} else if ((p.getItemInHand() != null) && (p.getItemInHand().hasItemMeta()) && (p.getItemInHand().getType() == Material.RAW_FISH)) {
				if ((block != null) && (block.getType() != Material.AIR)) {
					if ((block.getType() == Material.LAVA) || (block.getType() == Material.STATIONARY_LAVA) || (block.getType() == Material.BURNING_FURNACE) || (block.getType() == Material.FURNACE) || (block.getType() == Material.FIRE)) {
						return;
					}
					p.sendMessage(Utils.colorCodes("&eTo cook, &nRIGHT CLICK&e any heat source."));
					p.sendMessage(Utils.colorCodes("&7Ex. Fire, Lava, Furnace"));
					return;
				}
			}
		}
		
	}
	
	
	public void removeFish(Player p) {
		ItemStack is = p.getItemInHand();
		if (is.getAmount() > 1) {
			is.setAmount((is.getAmount() - 1));
		} else {
			p.setItemInHand(new ItemStack(Material.AIR));
		}
		p.updateInventory();
		
		
	}

	public void eat(Player p, int i) {
		if (p.hasPotionEffect(PotionEffectType.SPEED)) {
			return;
		}
		switch (i) {
		case 1:
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 15), 0));
		case 2:
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 30), 0));
		case 3:
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 60), 1));
		case 4:
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 15), 2));
		case 5:
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (20 * 30), 2));
		}
		p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
	}

	@EventHandler
	public void onFishCook(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		Block block = e.getClickedBlock();
		if ((action == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand() != null) && (p.getItemInHand().hasItemMeta()) && (p.getItemInHand().getType() == Material.RAW_FISH)) {
			if ((block != null) && ((block.getType() == Material.FURNACE) || (block.getType() == Material.BURNING_FURNACE) || (block.getType() == Material.FIRE) || (block.getType() == Material.LAVA) || (block.getType() == Material.STATIONARY_LAVA))) {
				
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.0F, 0.0F);
				p.setItemInHand(cookFish(p.getItemInHand()));
			}
		}
	}
}

