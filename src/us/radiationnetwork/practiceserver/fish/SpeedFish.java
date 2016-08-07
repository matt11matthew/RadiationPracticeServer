package us.radiationnetwork.practiceserver.fish;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.item.PSItem;

public class SpeedFish {
	
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
}

