package us.radiationnetwork.practiceserver.enums;

import org.bukkit.ChatColor;

public enum Alignment {

	LAWFUL(0, ChatColor.GREEN),
	NEUTRAL(160, ChatColor.YELLOW),
	CHAOTIC(1200, ChatColor.RED);
	
	ChatColor color;
	int time;
	
	Alignment(int time, ChatColor color) {
		this.time = time;
		this.color = color;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public ChatColor getColor() {
		return this.color;
	}
	
	public ChatColor getTabColor() {
		switch (this) {
			case LAWFUL:
				return ChatColor.WHITE;
			case NEUTRAL:
				return ChatColor.YELLOW;
			case CHAOTIC:
				return ChatColor.RED;
		}
		return ChatColor.WHITE;
	}
	
}
