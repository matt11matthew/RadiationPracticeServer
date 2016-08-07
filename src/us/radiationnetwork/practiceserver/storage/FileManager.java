package us.radiationnetwork.practiceserver.storage;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import us.radiationnetwork.practiceserver.Main;
import us.radiationnetwork.practiceserver.enums.Alignment;


public class FileManager {
	
	public static FileConfiguration loadFile(String name, String path) {
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		f = new File(path, name + ".yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static FileConfiguration getPlayerFile(String name) {
		return loadFile(getUUID(name), Main.getInstance().getDataFolder() + File.separator + "Players");
	}
	
	public static FileConfiguration getPlayerFile(Player player) {
		return loadFile(getUUID(player), Main.getInstance().getDataFolder() + File.separator + "Players");
	}
	
	public static FileConfiguration getUUIDCatching() {
		return loadFile("uuids", Main.getInstance().getDataFolder() + File.separator);
	}
	
	public static String getUUID(String name) {
		return (getUUIDCatching().isConfigurationSection(name)) ? getUUIDCatching().getString(name + ".uuid") : null;
	}
	
	public static void addUUID(Player player) {
		FileConfiguration c = getUUIDCatching();
		File f = new File(Main.getInstance().getDataFolder() + File.separator, "uuids.yml");
		c.set(player.getName() + ".uuid", player.getUniqueId().toString());
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUUID(Player player) {
		return (getUUIDCatching().isConfigurationSection(player.getName())) ? getUUIDCatching().getString(player.getName() + ".uuid") : player.getUniqueId().toString();
	}
	
	public static int getGems(String name) {
		return getPlayerFile(name).getInt("Gems");
	}
	
	public static Alignment getAlignment(String name) {
		return Alignment.valueOf(getPlayerFile(name).getString("Alignment"));
	}
	
	public static int getAlignmentTime(String name) {
		return getPlayerFile(name).getInt("AlignmentTime");
	}
	
	public static void setGems(String name, int gems) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("Gems", gems);
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAlignment(String name, Alignment alignment) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("Alignment", alignment.toString());
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAlignmentTime(String name, int time) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("AlignmentTime", time);
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setCombatTime(String name, int time) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("CombatTime", time);
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setDebug(String name, boolean debug) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("Debug", debug);
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setTogglePvP(String name, boolean togglePvP) {
		FileConfiguration c = getPlayerFile(name);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(name) + ".yml");
		c.set("TogglePvP", togglePvP);
		try {
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isCombat(String name) {
		return (getCombatTime(name) > 0) ? true : false;
	}
	
	public static boolean isTogglePvP(String name) {
		return getPlayerFile(name).getBoolean("TogglePvP");
	}
	
	public static boolean isDebug(String name) {
		return getPlayerFile(name).getBoolean("Debug");
	}
	
	public static int getCombatTime(String name) {
		return getPlayerFile(name).getInt("CombatTime");
	}
	
	public static void addPlayer(Player player) {
		FileConfiguration c = getPlayerFile(player);
		File f = new File(Main.getInstance().getDataFolder() + File.separator + "Players", getUUID(player) + ".yml");
		try {
			c.set("UUID", getUUID(player));
			c.set("IGN", player.getName());
			c.set("Gems", 0);
			c.set("Alignment", Alignment.LAWFUL.toString());
			c.set("AlignmentTime", Alignment.LAWFUL.getTime());
			c.set("Ecash", 0);
			c.set("Horse", 0);
			c.set("Heartstone", "none");
			c.set("Guild", "none");
			c.set("CombatTime", 0);
			c.set("Debug", true);
			c.set("TogglePvP", false);
			c.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}