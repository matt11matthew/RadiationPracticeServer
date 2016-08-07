package us.radiationnetwork.practiceserver.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
			