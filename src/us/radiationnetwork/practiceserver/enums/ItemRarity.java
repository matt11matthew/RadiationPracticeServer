package us.radiationnetwork.practiceserver.enums;

public enum ItemRarity {
	
	COMMON("&7&oCommon"),
	UNCOMMON("&a&oUncommon"),
	RARE("&b&oRare"),
	UNIQUE("&e&oUnique");
	
	String lore;
	
	ItemRarity(String lore) {
		this.lore = lore;
	}
	
	public String getLore() {
		return this.lore;
	}
	
}
