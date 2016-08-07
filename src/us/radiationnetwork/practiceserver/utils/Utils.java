package us.radiationnetwork.practiceserver.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.Main;

public class Utils {

	public static String buildStringFromLocation(Location loc) {
		String location = (loc.getWorld().getName() + "," + ((int) loc.getX()) + "," + ((int) loc.getY()) + "," + ((int) loc.getZ()));
		return location;
	}
	
	public static String colorCodes(String s) {
		s = s.replaceAll("&", Unicodes.SECTION_SIGN.get());
    	s = s.replaceAll(Unicodes.SECTION_SIGN.get(), "\u00A7");
    	return s;
	}
	
	public static int convertStringToInteger(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return i;
		}
		return i;
	}
	
	public boolean isArmor(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("CHESTPLATE")) || (currentItem.getType().toString().contains("HELMET")) || (currentItem.getType().toString().contains("LEGGINGS")) || (currentItem.getType().toString().contains("BOOTS")));
	}
	
	public boolean isWeapon(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("SWORD")) || (currentItem.getType().toString().contains("AXE")) || (currentItem.getType().toString().contains("BOW")));
	}
	
	public boolean isTool(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("PICKAXE")) || (currentItem.getType().toString().contains("SPADE")) || (currentItem.getType().toString().contains("HOE")));
	}
	
	public static boolean isPickaxe(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("PICKAXE")));
	}
	
	public static boolean isShovel(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("SPADE")));
	}
	
	public static boolean isHoe(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("HOE")));
	}
	
	public static boolean isAxe(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("AXE")));
	}
	
	public static boolean isSword(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("SWORD")));
	}
	
	public static boolean isBow(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("BOW")));
	}
	
	public static boolean isHelmet(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("HELMET")));
	}
	
	public static boolean isChestplate(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("CHESTPLATE")));
	}
	
	public static boolean isLeggings(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("LEGGINGS")));
	}
	
	public static boolean isBoots(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("BOOTS")));
	}
	
	public static int ir(int low, int high) {
		Random r = new Random();
		int num = r.nextInt(high - low + 1) + low;
	    return (num > 0) ? num : 1;
	}
	
	public static void sendPlayer(Player p, String server) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
	    DataOutputStream out = new DataOutputStream(b);
	                     
	    try {
	          out.writeUTF("Connect");
	          out.writeUTF(server);
	     } catch (IOException ex) {
	                         
	     }
	     p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
	}
}
			