package us.radiationnetwork.practiceserver.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.utils.Utils;


public class PSItem {
	
	private Material material;
	private int amount = 1;
	private short durability = 0;
	private List<String> item_lore = new ArrayList<String>();
	private String name = "";
	private boolean unbreakable = false;
	private boolean glow = false;
	private boolean potion = false;
	private PotionType potionEffect = PotionType.INSTANT_HEAL;
	private int potionLevel = 1;
	private boolean splash = false;
	private boolean untradable = false;
	private boolean soulbound = false;
	private boolean skull = false;
	private String skullOwner = "matt11matthew";
	private ItemRarity rarity = null;
	
	public PSItem(Material material, int amount, short durability) {
		setType(material);
		setAmount(amount);
		setDurability(durability);
	}
	
	public PSItem(ItemStack item) {
		ItemMeta im = item.getItemMeta();
		setAmount(item.getAmount());
		setDurability(item.getDurability());
		if (im.hasDisplayName()) {
			setName(im.getDisplayName());
		} 
		if (im.hasLore()) {
			setLore(im.getLore());
		}
		if (Utils.getItemRarity(item) != null) {
			setRarity(Utils.getItemRarity(item));
		}
	}

	public PSItem(Material material, int amount) {
		setType(material);
		setAmount(amount);
	}

	public PSItem(Material material, short durability) {
		setType(material);
		setDurability(durability);
	}

	public PSItem(Material material) {
		setType(material);
	}
	
	public ItemStack build() {
		if (soulbound) {
			addLore("&4Soulbound");
		}
		if (untradable) {
			addLore("&7&oUntradable");
		}
		if (potion) {
			Potion pot = new Potion(potionEffect, potionLevel, splash);
			ItemStack is = new ItemStack(pot.toItemStack(getAmount()));
			ItemMeta im = is.getItemMeta();
			if (!item_lore.isEmpty()) {
				List<String> new_lore = new ArrayList<String>();
				for (String lore : item_lore) {
					new_lore.add(Utils.colorCodes(lore));
				}
				im.setLore(new_lore);
			}
			if (!name.isEmpty()) {
				im.setDisplayName(Utils.colorCodes(getName()));
			}
			im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			im.spigot().setUnbreakable(unbreakable);
			is.setItemMeta(im);
			if (glow) {
				is.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
			}
			is.setAmount(amount);
			return is;
		} else {
			ItemStack is = new ItemStack(getType());
			ItemMeta im = is.getItemMeta();
			if (rarity != null) {
				item_lore.add(rarity.getLore());
			}
			if (!item_lore.isEmpty()) {
				List<String> new_lore = new ArrayList<String>();
				for (String lore : item_lore) {
					new_lore.add(Utils.colorCodes(lore));
				}
				im.setLore(new_lore);
			}
			if (!name.isEmpty()) {
				im.setDisplayName(Utils.colorCodes(getName()));
			}
			im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			im.spigot().setUnbreakable(unbreakable);
			is.setItemMeta(im);
			if (glow) {
				is.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
			}
			is.setAmount(amount);
			is.setDurability(durability);
			if (skull) {
				is.setType(Material.SKULL_ITEM);
				is.setDurability((short) 3);
				SkullMeta sm = (SkullMeta) im;
				sm.setOwner(skullOwner);
				is.setItemMeta(sm);
			}
			return is;
		}
	}

	public Material getType() {
		return material;
	}

	public void setType(Material material) {
		this.material = material;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void removeStats() {
		if (item_lore.contains("DMG")) {
			String dmg = item_lore.get(0);
			item_lore.clear();
			item_lore.add(dmg);
		}
		if (item_lore.contains("HP")) {
			String dps = item_lore.get(0);
			String hp = item_lore.get(1);
			item_lore.clear();
			item_lore.add(dps);
			item_lore.add(hp);
		}
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public short getDurability() {
		return durability;
	}

	public void setDurability(short durability) {
		this.durability = durability;
	}

	public List<String> getLore() {
		return item_lore;
	}
	
	public void addLore(String lore) {
		item_lore.add(lore);
	}

	public void setLoreLine(int line, String lore) {
		line--;
		item_lore.set(line, lore);
	}

	public void setLore(List<String> lore) {
		this.item_lore = lore;
	}

	public boolean isUnbreakable() {
		return unbreakable;
	}

	public void setUnbreakable(boolean unbreakable) {
		this.unbreakable = unbreakable;
	}

	public boolean isGlow() {
		return glow;
	}


	public void setGlow(boolean glow) {
		this.glow = glow;
	}

	public boolean isPotion() {
		return potion;
	}

	public void setPotion(boolean potion) {
		this.potion = potion;
	}

	public int getPotionLevel() {
		return potionLevel;
	}

	public void setPotionLevel(int potionLevel) {
		this.potionLevel = potionLevel;
	}

	public PotionType getPotionEffect() {
		return potionEffect;
	}

	public void setPotionEffect(PotionType potionEffect) {
		this.potionEffect = potionEffect;
	}

	public boolean isSplash() {
		return splash;
	}

	public void setSplash(boolean splash) {
		this.splash = splash;
	}

	public boolean isUntradable() {
		return untradable;
	}

	public void setUntradable(boolean untradable) {
		this.untradable = untradable;
	}

	public boolean isSoulbound() {
		return soulbound;
	}

	public void setSoulbound(boolean soulbound) {
		this.soulbound = soulbound;
	}

	public boolean isSkull() {
		return skull;
	}

	public void setSkull(boolean skull) {
		this.skull = skull;
	}

	public String getSkullOwner() {
		return skullOwner;
	}

	public void setSkullOwner(String skullOwner) {
		this.skullOwner = skullOwner;
	}

	public ItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(ItemRarity rarity) {
		this.rarity = rarity;
	}

	public void removeLore(int size) {
		item_lore.remove(size);
		
	}
}
