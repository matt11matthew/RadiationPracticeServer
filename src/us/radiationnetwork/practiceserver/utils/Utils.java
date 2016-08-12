package us.radiationnetwork.practiceserver.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.enums.ItemRarity;

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
	
	public static int convertStringToInt(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			
		}
		return i;
	}
	
	public static String parseMilis(long l) {
		long min = TimeUnit.MILLISECONDS.toMinutes(l);
		if (min - TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis()) > 0) {
			min = min - TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
		}
		if (min == 1) {
			return min + " Minute";
		} else if (min > 1) {
			return min + " Minutes";
		}
		return null;
	}
	
	public static long convertStringToMillis(String s) {
		try {
			if (s.contains("minute")) {
				return System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(convertStringToInt(s.split("minute")[0]));
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static boolean endLB(long l) {
		return (System.currentTimeMillis() >= l) ? true : false;
	}

	public static double getStatFromLore(List<String> lore, String value, String value2, String plus) {
		double returnVal = 0.0D;
		try {
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains(value)) {
						if (!value2.equals("")) {
							String vals = ((String)lore.get(i)).split(value)[1].split(value2)[0];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							vals = vals.replaceAll(value2, "");
							returnVal = Integer.parseInt(vals.trim());
						} else {
							String vals = ((String)lore.get(i)).split(value)[1];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							vals = vals.replaceAll(value2, "");
							returnVal = Integer.parseInt(vals.trim());
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
	public static double getStatFromLore(ItemStack item, String value, String value2, String plus) {
		double returnVal = 0.0D;
		ItemMeta meta = item.getItemMeta();
		try {
			List<String> lore = meta.getLore();
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains(value)) {
						if (!value2.equals("")) {
							String vals = ((String)lore.get(i)).split(value)[1].split(value2)[0];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							vals = vals.replaceAll(value2, "");
							returnVal = Integer.parseInt(vals.trim());
						} else {
							String vals = ((String)lore.get(i)).split(value)[1];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							vals = vals.replaceAll(value2, "");
							returnVal = Integer.parseInt(vals.trim());
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
	public static String getStringFromLore(ItemStack item, String value) {
		String returnVal = "";
		ItemMeta meta = item.getItemMeta();
		try {
			List<String> lore = meta.getLore();
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(0)).contains(value)) {
					
							String vals = ((String)lore.get(0)).split(value)[1];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							returnVal = vals;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
	public static String getStringFromLore(List<String> lore, String value) {
		String returnVal = "";
		try {
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(0)).contains(value)) {
					
							String vals = ((String)lore.get(0)).split(value)[1];
							vals = ChatColor.stripColor(vals).trim();
							vals = vals.replaceAll(" ", "");
							returnVal = vals;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}

	
	
	public static double getDPSFromLore(ItemStack item) {
		double returnVal = 0.0D;
		ItemMeta meta = item.getItemMeta();
		try {
			List<String> lore = meta.getLore();
			if (lore != null) {
				
				for (int i = 0; i < lore.size(); i++) {
					if (((String)lore.get(i)).contains("DPS")) {
						String raw = ((String)lore.get(i)).split("DPS: ")[1];
						raw = ChatColor.stripColor(raw);
						raw = raw.replaceAll(" ", "");
						raw = raw.replaceAll("%", "");
						int min = Integer.parseInt(raw.split("-")[0]);
						int max = Integer.parseInt(raw.split("-")[1]);
						int total = Utils.ir(min, max);
						returnVal = total;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnVal;
	}
	
	public static boolean isArmor(ItemStack currentItem) {
		return ((currentItem.getType().toString().contains("CHESTPLATE")) || (currentItem.getType().toString().contains("HELMET")) || (currentItem.getType().toString().contains("LEGGINGS")) || (currentItem.getType().toString().contains("BOOTS")));
	}
	
	public static boolean isWeapon(ItemStack currentItem) {
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

	public static int getTier(ItemStack cur) {
		String name = cur.getItemMeta().getDisplayName();
		if (name.contains(ChatColor.WHITE.toString())) {
			return 1;
		}
		if (name.contains(ChatColor.GREEN.toString())) {
			return 2;
		}
		if (name.contains(ChatColor.AQUA.toString())) {
			return 3;
		}
		if (name.contains(ChatColor.LIGHT_PURPLE.toString())) {
			return 4;
		}
		if (name.contains(ChatColor.YELLOW.toString())) {
			return 5;
		}
		return 0;
	}
	
	public static int getTier(LivingEntity l) {
		String name = l.getCustomName();
		if (name.contains(ChatColor.WHITE.toString())) {
			return 1;
		}
		if (name.contains(ChatColor.GREEN.toString())) {
			return 2;
		}
		if (name.contains(ChatColor.AQUA.toString())) {
			return 3;
		}
		if (name.contains(ChatColor.LIGHT_PURPLE.toString())) {
			return 4;
		}
		if (name.contains(ChatColor.YELLOW.toString())) {
			return 5;
		}
		return 0;
	}

	public static ItemRarity getItemRarity(ItemStack is) {
		if (StatUtils.hasStat(is, "Common")) {
			return ItemRarity.COMMON;
		} else if (StatUtils.hasStat(is, "Uncommon")) {
			return ItemRarity.UNCOMMON;
		} else if (StatUtils.hasStat(is, "Rare")) {
			return ItemRarity.RARE;
		} else if (StatUtils.hasStat(is, "Unique")) {
			return ItemRarity.UNCOMMON;
		}
		return null;
	}
}
			