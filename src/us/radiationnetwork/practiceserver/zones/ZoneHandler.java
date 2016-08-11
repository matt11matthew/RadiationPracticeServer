package us.radiationnetwork.practiceserver.zones;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import us.radiationnetwork.practiceserver.enums.Alignment;
import us.radiationnetwork.practiceserver.storage.FileManager;
import us.radiationnetwork.practiceserver.utils.RegionUtils;
import us.radiationnetwork.practiceserver.utils.Utils;

public class ZoneHandler implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		Zone from_zone = RegionUtils.getZone(from);
		Zone to_zone = RegionUtils.getZone(to);
		if ((from.getX() != to.getX()) || (from.getY() != to.getY()) || (from.getZ() != to.getZ())) {
			if (from_zone != to_zone) {
				p.sendMessage(to_zone.getMessage());
				p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 0.25F, 0.3F);
				if (!canEnterZone(p, to_zone)) {
					e.setCancelled(true);
					p.teleport(from);
				}
			}
		}
	}
	
	

	public boolean canEnterZone(Player p, Zone to_zone) {
		Alignment alignment = FileManager.getAlignment(p.getName());
		switch (to_zone) {
		case CHAOTIC:
			return true;
		case WILDERNESS:
			if (alignment == Alignment.CHAOTIC) {
				p.sendMessage(Utils.colorCodes("&cYou &ncannot&c enter &lNON-PVP&c zones with a chaotic alignment."));
				return false;
			} else if ((alignment == Alignment.NEUTRAL) && (FileManager.isCombat(p.getName()))) {
				p.sendMessage(Utils.colorCodes("&cYou &ncannot&c leave a chaotic zone while in combat."));
				p.sendMessage(Utils.colorCodes("&7Out of combat in: &l" + FileManager.getCombatTime(p.getName()) + "s"));
				return false;
			} else {
				return true;
			}
		case SAFE:
			if (alignment == Alignment.CHAOTIC) {
				p.sendMessage(Utils.colorCodes("&cYou &ncannot&c enter &lNON-PVP&c zones with a chaotic alignment."));
				return false;
			} else if ((alignment == Alignment.NEUTRAL) && (FileManager.isCombat(p.getName()))) {
				p.sendMessage(Utils.colorCodes("&cYou &ncannot&c leave a chaotic zone while in combat."));
				p.sendMessage(Utils.colorCodes("&7Out of combat in: &l" + FileManager.getCombatTime(p.getName()) + "s"));
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
}