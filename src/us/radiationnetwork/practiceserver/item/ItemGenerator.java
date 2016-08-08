package us.radiationnetwork.practiceserver.item;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.utils.Utils;

public class ItemGenerator {
	
	public static ItemStack generateAxe(int tier, ItemRarity rarity) {
		Material type = null;
		int mindmg = 0;
		int maxdmg = 0;
		String name = "";
		int knockback_chance = 0;
		int crit_hit_chance = 0;
		int blind_chance = 0;
		int edmg_chance = 0;
		int vs_modifier_chance = 0;
		int life_steal_chance = 0;
		int accuracy_chance = 0;
		boolean hasCrit = false;
		boolean hasLS = false;
		boolean hasPureDMG = false;
		boolean hasIceDMG = false;
		boolean hasFireDMG = false;
		boolean hasPoisonDMG = false;
		boolean hasBlind = false;
		boolean hasKB = false;
		boolean hasVS = false;
		boolean hasAccuracy = false;
		
		int life_steal_max = 20;
		int knockback_max = 0;
		int crit_hit_max = 11;
		int blind_max = 0;
		int edmg_max = 0;
		int accuracy_max = 0;
		String tag = "&f";
		PSItem sword = new PSItem(Material.WOOD_AXE);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			tag = "&f";
			type = Material.WOOD_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(4, 1);
				maxdmg = ir((5 - mindmg + 1), mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(2, 3);
				maxdmg = ir((6 - mindmg + 1), mindmg);
				break;
			case RARE:
				mindmg = ir(4, 6);
				maxdmg = ir(12, 9);
				break;
			case UNIQUE:
				mindmg = ir(2, 9);
				maxdmg = ir(7, 23);
				break;
			}

			name = "&fHatchet";
			
			//knockback_chance = 3;
			crit_hit_chance = 2;
			//blind_chance = 3;
			edmg_chance = 6;
			//vs_modifier_chance = 6;
			//accuracy_chance = 8;
			life_steal_chance = 2;
			//life_steal_max = 30;
			//knockback_max = 3;
			//crit_hit_max = 2;
			//blind_max = 5;
			edmg_max = 4;
			//accuracy_max = 10;
			break;
		case 2:
			type = Material.STONE_AXE;
			tag = "&a";
			switch (rarity) {
			case COMMON:
				mindmg = ir(6, 10);
				maxdmg = ir(20 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(6, 15);
				maxdmg = ir(19, 21);
				break;
			case RARE:
				mindmg = ir(7, 24);
				maxdmg = ir(25, 40);
				break;
			case UNIQUE:
				mindmg = ir(7, 24);
				maxdmg = ir(6, 65);
				break;
			}
			name = "&aGreat Axe";
		    life_steal_chance = 4;
		   // knockback_chance = 10;
		    crit_hit_chance = 5;
		    //blind_chance = 5;
		    edmg_chance = 9; 
		   // vs_modifier_chance = 9;
		    //accuracy_chance = 12;
		    //accuracy_max = 12;
		    //life_steal_max = 15;
		    //knockback_max = 6;
		    //crit_hit_max = 4;
		   // blind_max = 7;
		    edmg_max = 9;
		    break;
		case 3:
			type = Material.IRON_AXE;
			tag = "&b";
			switch (rarity) {
			case COMMON:
				mindmg = ir(8, 25);
				maxdmg = ir(49 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(10, 30);
				maxdmg = ir(31, 40);
				break;
			case RARE:
				mindmg = ir(11, 35);
				maxdmg = ir(30, 71);
				break;
			case UNIQUE:
				mindmg = ir(6, 45);
				maxdmg = ir(51, 100);
				break;
			}
			name = "&bWar Axe";
			life_steal_chance = 5;
		    //knockback_chance = 13;
		    crit_hit_chance = 8;
		    //blind_chance = 8;
		    edmg_chance = 10;  
		   // vs_modifier_chance = 10; 
		   // accuracy_chance = 15;
		   // accuracy_max = 25;
		    //life_steal_max = 12;
		    //knockback_max = 12;
		   // crit_hit_max = 5;
		    //blind_max = 9;
		    edmg_max = 15;
		    break;
		case 4:
			type = Material.DIAMOND_AXE;
			tag = "&d";
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 60);
				maxdmg = ir(99 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(26, 65);
				maxdmg = ir(21, 100);
				break;
			case RARE:
				mindmg = ir(21, 80);
				maxdmg = ir(79, 121);
				break;
			case UNIQUE:
				mindmg = ir(51, 100);
				maxdmg = ir(51, 200);
				break;
			}
			name = "&dAncient Axe";
			life_steal_chance = 10;
		   // knockback_chance = 16;
		    crit_hit_chance = 9;
		   // blind_chance = 9;
		    edmg_chance = 15; 
		   // vs_modifier_chance = 12;		  
		  //  accuracy_chance = 20;
		    accuracy_max = 28;
		    life_steal_max = 7;
		    knockback_max = 15;
		    crit_hit_max = 6;
		    blind_max = 9;
		    edmg_max = 25;
		    break;
		case 5:
			type = Material.GOLD_AXE;
			tag = "&e";
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 130);
				Bukkit.getServer().broadcastMessage(mindmg + "");
				maxdmg = ir((199 - mindmg + 1), mindmg);
				Bukkit.getServer().broadcastMessage(maxdmg + "");
				break;
			case UNCOMMON:
				mindmg = ir(31, 130);
				maxdmg = ir((250 - mindmg + 10 + 1), mindmg + 10);
				break;
			case RARE:
				mindmg = ir(11, 180);
				maxdmg = ir(151, 200);
				break;
			case UNIQUE:
				mindmg = ir(51, 200);
				maxdmg = ir(251, 250);
				break;
			}
			name = "&eLegendary Axe";
			life_steal_chance = 8;
		   // knockback_chance = 20;
		    crit_hit_chance = 7;
		    //blind_chance = 11;
		    edmg_chance = 20;     
		    //vs_modifier_chance = 15;	      
		    //accuracy_chance = 15;
		    accuracy_max = 35;
		    life_steal_max = 8;
		    knockback_max = 20;
		    crit_hit_max = 10;
		    blind_max = 11;
		    edmg_max = 55;
		    break;
		}
		sword.addLore("&cDMG: " + mindmg + " - " + maxdmg);
		Random r = new Random();
		if (r.nextInt(100) <= life_steal_chance) {
			hasLS = true;
		}
		if (r.nextInt(100) <= edmg_chance) {
			int e_random = Utils.ir(0, 4);
			switch (e_random) {
			case 1:
				hasPoisonDMG = true;
				break;
			case 2:
				hasPureDMG = true;
				break;
			case 3:
				hasIceDMG = true;
				break;
			case 4:
				hasFireDMG = true;
				break;
			}
		}
		if (r.nextInt(100) <= vs_modifier_chance) {
			hasVS = true;
		}
		if (r.nextInt(100) <= blind_chance) {
			hasBlind = true;
		}
		if (r.nextInt(100) <= crit_hit_chance) {
			hasCrit = true;
		}
		if (r.nextInt(100) <= accuracy_chance) {
			hasAccuracy = true;
		}
		if (r.nextInt(100) <= knockback_chance) {
			hasKB = true;
		}
		if (hasPureDMG) {
			name = tag + "Pure " + name;
			sword.addLore("&cPURE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasAccuracy) {
			name = tag + "Accurate " + name;
			sword.addLore("&cACCURACY: " + Utils.ir(0, accuracy_max) + "%");
		}
		if (hasKB) {
			name = tag + "Brute " + name;
			sword.addLore("&cKNOCKBACK: " + Utils.ir(0, knockback_max) + "%");
		}
		if (hasBlind) {
			name = name + " of Blindness";
			sword.addLore("&cBLIND: " + Utils.ir(0, blind_max) + "%");
		}
		if (hasLS) {
			name = tag + "Vampyric " + name;
			sword.addLore("&cLIFE STEAL: " + Utils.ir(0, life_steal_max) + "%");
		}
		if (hasCrit) {
			name = tag + "Deadly " + name;
			sword.addLore("&cCRITICAL HIT: " + Utils.ir(0, crit_hit_max) + "%");
		}
		if (hasVS) {
			int vs = Utils.ir(0, 2);
			switch (vs) {
			case 1:
				if (name.contains("of")) {
					name = name + " Slaying";
				} else {
					name = name + " of Slaying";
				}
				sword.addLore("&cDMG Vs. Monsters: " + Utils.ir(0, vs_modifier_chance) + "%");
				break;
			case 2:
				if (name.contains("of")) {
					name = name + " Slaughter";
				} else {
					name = name + " of Slaughter";
				}
				sword.addLore("&cDMG Vs. Players: " + Utils.ir(0, vs_modifier_chance) + "%");
				break;
			}
		}
		if (hasIceDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Ice";
			}
			if (!hasBlind) {
				name = name + " of Ice";
			}
			sword.addLore("&cICE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasFireDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Fire";
			}
			if (!hasBlind) {
				name = name + " of Fire";
			}
			sword.addLore("&cFIRE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasPoisonDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Poison";
			}
			if (!hasBlind) {
				name = name + " of Poison";
			}
			sword.addLore("&cPOISON DMG: +" + Utils.ir(0, edmg_max));
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}

	public static ItemStack generateSword(int tier, ItemRarity rarity) {
		Material type = null;
		int mindmg = 0;
		String tag = "&f";
		int maxdmg = 0;
		String name = "";
		int knockback_chance = 0;
		int crit_hit_chance = 0;
		int blind_chance = 0;
		int edmg_chance = 0;
		int vs_modifier_chance = 0;
		int life_steal_chance = 0;
		int accuracy_chance = 0;
		boolean hasCrit = false;
		boolean hasLS = false;
		boolean hasPureDMG = false;
		boolean hasIceDMG = false;
		boolean hasFireDMG = false;
		boolean hasPoisonDMG = false;
		boolean hasBlind = false;
		boolean hasKB = false;
		boolean hasVS = false;
		boolean hasAccuracy = false;
		
		int life_steal_max = 0;
		int knockback_max = 0;
		int crit_hit_max = 0;
		int blind_max = 0;
		int edmg_max = 0;
		int accuracy_max = 0;
		
		PSItem sword = new PSItem(Material.WOOD_SWORD);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			tag = "&f";
			type = Material.WOOD_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(4, 1);
				maxdmg = ir((5 - mindmg + 1), mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(2, 3);
				maxdmg = ir((6 - mindmg + 1), mindmg);
				break;
			case RARE:
				mindmg = ir(4, 6);
				maxdmg = ir(12, 9);
				break;
			case UNIQUE:
				mindmg = ir(2, 9);
				maxdmg = ir(7, 23);
				break;
			}

			name = "&fHatchet";
			
			//knockback_chance = 3;
			crit_hit_chance = 2;
			//blind_chance = 3;
			edmg_chance = 6;
			//vs_modifier_chance = 6;
			//accuracy_chance = 8;
			life_steal_chance = 2;
			//life_steal_max = 30;
			knockback_max = 3;
			crit_hit_max = 2;
			blind_max = 5;
			edmg_max = 4;
			accuracy_max = 10;
			break;
		case 2:
			tag = "&a";
			type = Material.STONE_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(6, 10);
				maxdmg = ir(20 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(6, 15);
				maxdmg = ir(19, 21);
				break;
			case RARE:
				mindmg = ir(7, 24);
				maxdmg = ir(25, 40);
				break;
			case UNIQUE:
				mindmg = ir(7, 24);
				maxdmg = ir(6, 65);
				break;
			}
			name = "&aBroadsword";
		    life_steal_chance = 4;
		   // knockback_chance = 10;
		    crit_hit_chance = 5;
		   // blind_chance = 5;
		    edmg_chance = 9; 
		  //  vs_modifier_chance = 9;
		  //  accuracy_chance = 12;
		    accuracy_max = 12;
		    //life_steal_max = 15;
		    knockback_max = 6;
		    crit_hit_max = 4;
		    blind_max = 7;
		    edmg_max = 9;
		    break;
		case 3:
			tag = "&b";
			type = Material.IRON_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(8, 25);
				maxdmg = ir(49 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(10, 30);
				maxdmg = ir(31, 40);
				break;
			case RARE:
				mindmg = ir(11, 35);
				maxdmg = ir(30, 71);
				break;
			case UNIQUE:
				mindmg = ir(6, 45);
				maxdmg = ir(51, 100);
				break;
			}
			name = "&bMagic Sword";
			life_steal_chance = 5;
		  //  knockback_chance = 13;
		    crit_hit_chance = 8;
		   // blind_chance = 8;
		    edmg_chance = 10;  
		   // vs_modifier_chance = 10; 
		   // accuracy_chance = 15;
		    accuracy_max = 25;
		   // life_steal_max = 12;
		    knockback_max = 12;
		    crit_hit_max = 5;
		    blind_max = 9;
		    edmg_max = 15;
		    break;
		case 4:
			tag = "&d";
			type = Material.DIAMOND_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 60);
				maxdmg = ir(99 - mindmg + 1, mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(26, 65);
				maxdmg = ir(21, 100);
				break;
			case RARE:
				mindmg = ir(21, 80);
				maxdmg = ir(79, 121);
				break;
			case UNIQUE:
				mindmg = ir(51, 100);
				maxdmg = ir(51, 200);
				break;
			}
			name = "&dAncient Sword";
			life_steal_chance = 10;
		   // knockback_chance = 16;
		    crit_hit_chance = 9;
		   // blind_chance = 9;
		    edmg_chance = 15; 
		   // vs_modifier_chance = 12;		  
		   // accuracy_chance = 20;
		    accuracy_max = 28;
		  //  life_steal_max = 7;
		    knockback_max = 15;
		    crit_hit_max = 6;
		    blind_max = 9;
		    edmg_max = 25;
		    break;
		case 5:
			type = Material.GOLD_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 130);
				maxdmg = ir((199 - mindmg + 1), mindmg);
				break;
			case UNCOMMON:
				mindmg = ir(31, 130);
				maxdmg = ir((250 - mindmg + 10 + 1), mindmg + 10);
				break;
			case RARE:
				mindmg = ir(11, 180);
				maxdmg = ir(151, 200);
				break;
			case UNIQUE:
				mindmg = ir(51, 200);
				maxdmg = ir(251, 250);	
				break;
			}
			tag = "&e";
			name = "&eLegendary Sword";
			life_steal_chance = 8;
		   // knockback_chance = 20;
		    crit_hit_chance = 7;
		  //  blind_chance = 11;
		    edmg_chance = 20;     
		  //  vs_modifier_chance = 15;	      
		  //  accuracy_chance = 15;
		    accuracy_max = 35;
		  //  life_steal_max = 8;
		    knockback_max = 20;
		    crit_hit_max = 10;
		    blind_max = 11;
		    edmg_max = 55;
		    break;
		}
		sword.addLore("&cDMG: " + mindmg + " - " + maxdmg);
		Random r = new Random();
		if (r.nextInt(100) <= life_steal_chance) {
			hasLS = true;
		}
		if (r.nextInt(100) <= edmg_chance) {
			int e_random = Utils.ir(0, 4);
			switch (e_random) {
			case 1:
				hasPoisonDMG = true;
				break;
			case 2:
				hasPureDMG = true;
				break;
			case 3:
				hasIceDMG = true;
				break;
			case 4:
				hasFireDMG = true;
				break;
			}
		}
		if (r.nextInt(100) <= vs_modifier_chance) {
			hasVS = true;
		}
		if (r.nextInt(100) <= blind_chance) {
			hasBlind = true;
		}
		if (r.nextInt(100) <= crit_hit_chance) {
			hasCrit = true;
		}
		if (r.nextInt(100) <= accuracy_chance) {
			hasAccuracy = true;
		}
		if (r.nextInt(100) <= knockback_chance) {
			hasKB = true;
		}
		if (hasPureDMG) {
			name = tag + "Pure " + name;
			sword.addLore("&cPURE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasAccuracy) {
			name = tag + "Accurate " + name;
			sword.addLore("&cACCURACY: " + Utils.ir(0, accuracy_max) + "%");
		}
		if (hasKB) {
			name = tag + "Brute " + name;
			sword.addLore("&cKNOCKBACK: " + Utils.ir(0, knockback_max) + "%");
		}
		if (hasBlind) {
			name = name + " of Blindness";
			sword.addLore("&cBLIND: " + Utils.ir(0, blind_max) + "%");
		}
		if (hasLS) {
			name = tag + "Vampyric " + name;
			sword.addLore("&cLIFE STEAL: " + Utils.ir(0, life_steal_max) + "%");
		}
		if (hasCrit) {
			name = tag + "Deadly " + name;
			sword.addLore("&cCRITICAL HIT: " + Utils.ir(0, crit_hit_max) + "%");
		}
		if (hasVS) {
			int vs = Utils.ir(0, 2);
			switch (vs) {
			case 1:
				if (name.contains("of")) {
					name = name + " Slaying";
				} else {
					name = name + " of Slaying";
				}
				sword.addLore("&cDMG Vs. Monsters: " + Utils.ir(0, vs_modifier_chance) + "%");
				break;
			case 2:
				if (name.contains("of")) {
					name = name + " Slaughter";
				} else {
					name = name + " of Slaughter";
				}
				sword.addLore("&cDMG Vs. Players: " + Utils.ir(0, vs_modifier_chance) + "%");
				break;
			}
			
		
		}
		if (hasIceDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Ice";
			}
			if (!hasBlind) {
				name = name + " of Ice";
			}
			sword.addLore("&cICE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasFireDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Fire";
			}
			if (!hasBlind) {
				name = name + " of Fire";
			}
			sword.addLore("&cFIRE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasPoisonDMG) {
			if ((hasBlind) && (name.contains("of"))) {
				name = name + " Poison";
			}
			if (!hasBlind) {
				name = name + " of Poison";
			}
			sword.addLore("&cPOISON DMG: +" + Utils.ir(0, edmg_max));
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}
	
	public static int ir(int max, int min) {
		Random r = new Random();
		return r.nextInt(max) + min;
	}
	
	public static ItemStack rerollStats(int tier, ItemStack is) {
		if (Utils.isBoots(is)) {
			PSItem sword = new PSItem(is);
			Material type = Material.LEATHER_BOOTS;
			
			int hp = 0;
			String name = "";
			boolean hasVit = false;
			boolean hasHps = false;
			
			int hps_max = 0;
			int vit_max = 0;
			sword.setUnbreakable(true);
			switch (tier) {
			case 1:
				hps_max = (int) ir(11, 5);
				vit_max = (int) ir(5, 1);
				break;
			case 2:
				hps_max = (int) ir(11, 10);
				vit_max = (int) ir(6, 5);
				break;
			case 3:
				hps_max = (int) ir(11, 40);
				vit_max = (int) ir(41, 20);
				break;
			case 4:
				hps_max = (int) ir(6, 60);
				vit_max = (int) ir(91, 60);
				break;
			case 5:
				hps_max = (int) ir(21, 90);
				vit_max = (int) ir(161, 150);
				break;
			}
			int stat = Utils.ir(0, 2);
			if (stat == 1) {
				hasHps = true;
			}
			else if (stat == 2) {
				hasVit = true;
			} else {
				hasVit = true;
			}
			if (hasVit) {
				switch (tier) {
				case 1:
					name = "&fLeather Boots of Fortitude";
					break;
				case 2:
					name = "&aChainmail Boots of Fortitude";
					break;
				case 3:
					name = "&bFull Boots of Fortitude";
					break;
				case 4:
					name = "&dAncient Full Boots of Fortitude";
					break;
				case 5:
					name = "&eLegendary Full Boots of Fortitude";
					break;
				}
				sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
			}
			if (hasHps) {
				switch (tier) {
				case 1:
					name = "&fMending Leather Boots";
					break;
				case 2:
					name = "&aMending Medium Boots";
					break;
				case 3:
					name = "&bMending Full Boots";
					break;
				case 4:
					name = "&dMending Ancient Full Boots";
					break;
				case 5:
					name = "&eMending Legendary Full Boots";
					break;
				}
				sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
			}
			sword.setName(name);
			sword.setRarity(Utils.getItemRarity(is));
			return sword.build();
		}
		if (Utils.isLeggings(is)) {
			PSItem sword = new PSItem(is);
			Material type = Material.LEATHER_LEGGINGS;
			
			int hp = 0;
			String name = "";
			boolean hasVit = false;
			boolean hasHps = false;
			
			int hps_max = 0;
			int vit_max = 0;
			sword.setUnbreakable(true);
			switch (tier) {
			case 1:
				type = Material.LEATHER_LEGGINGS;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(11, 10);
					break;
				case UNCOMMON:
					hp = ir(39, 21);
					break;
				case RARE:
					hp = ir(50, 50);
					break;
				case UNIQUE:
					hp = ir(51, 100);
					break;
				}
				hps_max = (int) ir(11, 5);
				vit_max = (int) ir(5, 1);
				break;
			case 2:
				type = Material.CHAINMAIL_LEGGINGS;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(40, 60);
					break;
				case UNCOMMON:
					hp = ir(100, 100);
					break;
				case RARE:
					hp = ir(100, 200);
					break;
				case UNIQUE:
					hp = ir(101, 300);
					break;
				}
				hps_max = (int) ir(11, 10);
				vit_max = (int) ir(6, 5);
				break;
			case 3:
				type = Material.IRON_LEGGINGS;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(150, 200);
					break;
				case UNCOMMON:
					hp = ir(150, 350);
					break;
				case RARE:
					hp = ir(300, 500);
					break;
				case UNIQUE:
					hp = ir(51, 800);
					break;
				}
				hps_max = (int) ir(11, 40);
				vit_max = (int) ir(41, 20);
				break;
			case 4:
				type = Material.DIAMOND_LEGGINGS;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(200, 600);
					break;
				case UNCOMMON:
					hp = ir(700, 800);
					break;
				case RARE:
					hp = ir(800, 1500);
					break;
				case UNIQUE:
					hp = ir(201, 2300);
					break;
				}
				hps_max = (int) ir(6, 60);
				vit_max = (int) ir(91, 60);
				break;

			case 5:
				type = Material.GOLD_LEGGINGS;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(1000, 1500);
					break;
				case UNCOMMON:
					hp = ir(1500, 2500);
					break;
				case RARE:
					hp = ir(1500, 4000);
					break;
				case UNIQUE:
					hp = ir(501, 5500);
					break;
				}
				hps_max = (int) ir(21, 90);
				vit_max = (int) ir(161, 150);
				break;
			}
			int stat = Utils.ir(0, 2);
			if (stat == 1) {
				hasHps = true;
			}
			else if (stat == 2) {
				hasVit = true;
			} else {
				hasVit = true;
			}
			if (hasVit) {
				switch (tier) {
				case 1:
					name = "&fLeather Leggings of Fortitude";
					break;
				case 2:
					name = "&aChainmail Leggings of Fortitude";
					break;
				case 3:
					name = "&bPlatemail Leggings of Fortitude";
					break;
				case 4:
					name = "&dAncient Full Leggings of Fortitude";
					break;
				case 5:
					name = "&eLegendary Full Leggings of Fortitude";
					break;
				}
				sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
			}
			if (hasHps) {
				switch (tier) {
				case 1:
					name = "&fMending Leather Leggings";
					break;
				case 2:
					name = "&aMending Chainmail Leggings";
					break;
				case 3:
					name = "&bMending Full Leggings";
					break;
				case 4:
					name = "&dMending Ancient Full Leggings";
					break;
				case 5:
					name = "&eMending Legendary Full Leggings";
					break;
				}
				sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
			}
			sword.setName(name);
			sword.setRarity(Utils.getItemRarity(is));
			return sword.build();
		}
		if (Utils.isChestplate(is)) {
			PSItem sword = new PSItem(is);
			Material type = Material.LEATHER_CHESTPLATE;
			
			int hp = 0;
			String name = "";
			boolean hasVit = false;
			boolean hasHps = false;
			
			int hps_max = 0;
			int vit_max = 0;
			sword.setUnbreakable(true);
			switch (tier) {
			case 1:
				type = Material.LEATHER_CHESTPLATE;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(11, 10);
					break;
				case UNCOMMON:
					hp = ir(39, 21);
					break;
				case RARE:
					hp = ir(50, 50);
					break;
				case UNIQUE:
					hp = ir(51, 100);
					break;
				}
				hps_max = (int) ir(11, 5);
				vit_max = (int) ir(5, 1);
				break;
			case 2:
				type = Material.CHAINMAIL_CHESTPLATE;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(40, 60);
					break;
				case UNCOMMON:
					hp = ir(100, 100);
					break;
				case RARE:
					hp = ir(100, 200);
					break;
				case UNIQUE:
					hp = ir(101, 300);
					break;
				}
				hps_max = (int) ir(11, 10);
				vit_max = (int) ir(6, 5);
				break;
			case 3:
				type = Material.IRON_CHESTPLATE;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(150, 200);
					break;
				case UNCOMMON:
					hp = ir(150, 350);
					break;
				case RARE:
					hp = ir(300, 500);
					break;
				case UNIQUE:
					hp = ir(51, 800);
					break;
				}
				hps_max = (int) ir(11, 40);
				vit_max = (int) ir(41, 20);
				break;
			case 4:
				type = Material.DIAMOND_CHESTPLATE;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(200, 600);
					break;
				case UNCOMMON:
					hp = ir(700, 800);
					break;
				case RARE:
					hp = ir(800, 1500);
					break;
				case UNIQUE:
					hp = ir(201, 2300);
					break;
				}
				hps_max = (int) ir(6, 60);
				vit_max = (int) ir(91, 60);
				break;

			case 5:
				type = Material.GOLD_CHESTPLATE;
				switch (Utils.getItemRarity(is)) {
				case COMMON:
					hp = ir(1000, 1500);
					break;
				case UNCOMMON:
					hp = ir(1500, 2500);
					break;
				case RARE:
					hp = ir(1500, 4000);
					break;
				case UNIQUE:
					hp = ir(501, 5500);
					break;
				}
				hps_max = (int) ir(21, 90);
				vit_max = (int) ir(161, 150);
				break;
			}
			int stat = Utils.ir(0, 2);
			if (stat == 1) {
				hasHps = true;
			}
			else if (stat == 2) {
				hasVit = true;
			} else {
				hasVit = true;
			}
			if (hasVit) {
				switch (tier) {
				case 1:
					name = "&fLeather Chestplate of Fortitude";
					break;
				case 2:
					name = "&aChainmail of Fortitude";
					break;
				case 3:
					name = "&bPlatemail of Fortitude";
					break;
				case 4:
					name = "&dAncient Full Platemail of Fortitude";
					break;
				case 5:
					name = "&eLegendary Full Platemail of Fortitude";
					break;
				}
				sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
			}
			if (hasHps) {
				switch (tier) {
				case 1:
					name = "&fMending Leather Chestplate";
					break;
				case 2:
					name = "&aMending Chainmail";
					break;
				case 3:
					name = "&bMending Full Platemail";
					break;
				case 4:
					name = "&dMending Ancient Full Platemail";
					break;
				case 5:
					name = "&eMending Legendary Full Platemail";
					break;
				}
				sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
			}
			sword.setName(name);
			sword.setRarity(Utils.getItemRarity(is));
			return sword.build();
		}
		if (Utils.isHelmet(is)) {
			PSItem sword = new PSItem(is);
			Material type = Material.LEATHER_HELMET;
			
			int hp = 0;
			String name = "";
			boolean hasVit = false;
			boolean hasHps = false;
			
			int hps_max = 0;
			int vit_max = 0;
			sword.setUnbreakable(true);
			switch (tier) {
			case 1:
				hps_max = (int) ir(11, 5);
				vit_max = (int) ir(5, 1);
				break;
			case 2:
				hps_max = (int) ir(11, 10);
				vit_max = (int) ir(6, 5);
				break;
			case 3:
				hps_max = (int) ir(11, 40);
				vit_max = (int) ir(41, 20);
				break;
			case 4:
				hps_max = (int) ir(6, 60);
				vit_max = (int) ir(91, 60);
				break;
			case 5:
				hps_max = (int) ir(21, 90);
				vit_max = (int) ir(161, 150);
				break;
			}
			int stat = Utils.ir(0, 2);
			if (stat == 1) {
				hasHps = true;
			}
			else if (stat == 2) {
				hasVit = true;
			} else {
				hasVit = true;
			}
			if (hasVit) {
				switch (tier) {
				case 1:
					name = "&fLeather Coif of Fortitude";
					break;
				case 2:
					name = "&aChainmail Helmet of Fortitude";
					break;
				case 3:
					name = "&bFull Helmet of Fortitude";
					break;
				case 4:
					name = "&dAncient Full Helmet of Fortitude";
					break;
				case 5:
					name = "&eLegendary Full Helmet of Fortitude";
					break;
				}
				sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
			}
			if (hasHps) {
				switch (tier) {
				case 1:
					name = "&fMending Leather Coif";
					break;
				case 2:
					name = "&aMending Medium Helmet";
					break;
				case 3:
					name = "&bMending Full Helmet";
					break;
				case 4:
					name = "&dMending Ancient Full Helmet";
					break;
				case 5:
					name = "&eMending Legendary Full Helmet";
					break;
				}
				sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
			}
			sword.setName(name);
			sword.setRarity(Utils.getItemRarity(is));
			return sword.build();
		}
		return is;
	}
	
	public static ItemStack generateHelmet(int tier, ItemRarity rarity) {
		Material type = Material.LEATHER_HELMET;
		
		int hp = 0;
		String name = "";
		boolean hasVit = false;
		boolean hasHps = false;
		
		int hps_max = 0;
		int vit_max = 0;
		
		PSItem sword = new PSItem(Material.LEATHER_HELMET);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			type = Material.LEATHER_HELMET;
			sword.addLore("&cDPS: 1 - 1%");
			switch (rarity) {
			case COMMON:
				hp = ir(5, 5);
				break;
			case UNCOMMON:
				hp = ir(10, 10);
				break;
			case RARE:
				hp = ir(30, 20);
				break;
			case UNIQUE:
				hp = ir(11, 50);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 5);
			vit_max = (int) ir(5, 1);
			break;
		case 2:
			type = Material.CHAINMAIL_HELMET;
			sword.addLore("&cDPS: 3 - 3%");
			switch (rarity) {
			case COMMON:
				hp = ir(13, 32);
				break;
			case UNCOMMON:
				hp = ir(40, 45);
				break;
			case RARE:
				hp = ir(35, 85);
				break;
			case UNIQUE:
				hp = ir(31, 120);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 10);
			vit_max = (int) ir(6, 5);
			break;
		case 3:
			type = Material.IRON_HELMET;
			sword.addLore("&cDPS: 4 - 4%");
			switch (rarity) {
			case COMMON:
				hp = ir(100, 100);
				break;
			case UNCOMMON:
				hp = ir(100, 200);
				break;
			case RARE:
				hp = ir(50, 300);
				break;
			case UNIQUE:
				hp = ir(81, 350);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 40);
			vit_max = (int) ir(41, 20);
			break;
		case 4:
			type = Material.DIAMOND_HELMET;
			sword.addLore("&cDPS: 6 - 6%");
			switch (rarity) {
			case COMMON:
				hp = ir(200, 300);
				break;
			case UNCOMMON:
				hp = ir(200, 500);
				break;
			case RARE:
				hp = ir(300, 700);
				break;
			case UNIQUE:
				hp = ir(201, 1000);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(6, 60);
			vit_max = (int) ir(91, 60);
			break;
		case 5:
			type = Material.GOLD_HELMET;
			sword.addLore("&cDPS: 8 - 8%");
			switch (rarity) {
			case COMMON:
				hp = ir(300, 700);
				break;
			case UNCOMMON:
				hp = ir(800, 1000);
				break;
			case RARE:
				hp = ir(500, 1800);
				break;
			case UNIQUE:
				hp = ir(701, 2300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(21, 90);
			vit_max = (int) ir(161, 150);
			break;
		}
		int stat = Utils.ir(0, 2);
		if (stat == 1) {
			hasHps = true;
		}
		else if (stat == 2) {
			hasVit = true;
		} else {
			hasVit = true;
		}
		if (hasVit) {
			switch (tier) {
			case 1:
				name = "&fLeather Coif of Fortitude";
				break;
			case 2:
				name = "&aChainmail Helmet of Fortitude";
				break;
			case 3:
				name = "&bFull Helmet of Fortitude";
				break;
			case 4:
				name = "&dAncient Full Helmet of Fortitude";
				break;
			case 5:
				name = "&eLegendary Full Helmet of Fortitude";
				break;
			}
			sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
		}
		if (hasHps) {
			switch (tier) {
			case 1:
				name = "&fMending Leather Coif";
				break;
			case 2:
				name = "&aMending Medium Helmet";
				break;
			case 3:
				name = "&bMending Full Helmet";
				break;
			case 4:
				name = "&dMending Ancient Full Helmet";
				break;
			case 5:
				name = "&eMending Legendary Full Helmet";
				break;
			}
			sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}
	
	public static ItemStack generateChestplate(int tier, ItemRarity rarity) {
		Material type = Material.LEATHER_CHESTPLATE;
		
		int hp = 0;
		String name = "";
		boolean hasVit = false;
		boolean hasHps = false;
		
		int hps_max = 0;
		int vit_max = 0;
		
		PSItem sword = new PSItem(Material.LEATHER_CHESTPLATE);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			type = Material.LEATHER_CHESTPLATE;
			sword.addLore("&cDPS: 1 - 1%");
			switch (rarity) {
			case COMMON:
				hp = ir(11, 10);
				break;
			case UNCOMMON:
				hp = ir(39, 21);
				break;
			case RARE:
				hp = ir(50, 50);
				break;
			case UNIQUE:
				hp = ir(51, 100);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 5);
			vit_max = (int) ir(5, 1);
			break;
		case 2:
			type = Material.CHAINMAIL_CHESTPLATE;
			sword.addLore("&cDPS: 3 - 3%");
			switch (rarity) {
			case COMMON:
				hp = ir(40, 60);
				break;
			case UNCOMMON:
				hp = ir(100, 100);
				break;
			case RARE:
				hp = ir(100, 200);
				break;
			case UNIQUE:
				hp = ir(101, 300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 10);
			vit_max = (int) ir(6, 5);
			break;
		case 3:
			type = Material.IRON_CHESTPLATE;
			sword.addLore("&cDPS: 6 - 6%");
			switch (rarity) {
			case COMMON:
				hp = ir(150, 200);
				break;
			case UNCOMMON:
				hp = ir(150, 350);
				break;
			case RARE:
				hp = ir(300, 500);
				break;
			case UNIQUE:
				hp = ir(51, 800);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 40);
			vit_max = (int) ir(41, 20);
			break;
		case 4:
			type = Material.DIAMOND_CHESTPLATE;
			sword.addLore("&cDPS: 12 - 12%");
			switch (rarity) {
			case COMMON:
				hp = ir(200, 600);
				break;
			case UNCOMMON:
				hp = ir(700, 800);
				break;
			case RARE:
				hp = ir(800, 1500);
				break;
			case UNIQUE:
				hp = ir(201, 2300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(6, 60);
			vit_max = (int) ir(91, 60);
			break;

		case 5:
			type = Material.GOLD_CHESTPLATE;
			sword.addLore("&cDPS: 16 - 16%");
			switch (rarity) {
			case COMMON:
				hp = ir(1000, 1500);
				break;
			case UNCOMMON:
				hp = ir(1500, 2500);
				break;
			case RARE:
				hp = ir(1500, 4000);
				break;
			case UNIQUE:
				hp = ir(501, 5500);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(21, 90);
			vit_max = (int) ir(161, 150);
			break;
		}
		int stat = Utils.ir(0, 2);
		if (stat == 1) {
			hasHps = true;
		}
		else if (stat == 2) {
			hasVit = true;
		} else {
			hasVit = true;
		}
		if (hasVit) {
			switch (tier) {
			case 1:
				name = "&fLeather Chestplate of Fortitude";
				break;
			case 2:
				name = "&aChainmail of Fortitude";
				break;
			case 3:
				name = "&bPlatemail of Fortitude";
				break;
			case 4:
				name = "&dMagic Platemail of Fortitude";
				break;
			case 5:
				name = "&eLegendary Full Platemail of Fortitude";
				break;
			}
			sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
		}
		if (hasHps) {
			switch (tier) {
			case 1:
				name = "&fMending Leather Chestplate";
				break;
			case 2:
				name = "&aMending Chainmail";
				break;
			case 3:
				name = "&bMending Platemail";
				break;
			case 4:
				name = "&dMending Magic Platemail";
				break;
			case 5:
				name = "&eMending Legendary Platemail";
				break;
			}
			sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}
	
	public static ItemStack generateLeggings(int tier, ItemRarity rarity) {
		Material type = Material.LEATHER_LEGGINGS;
		
		int hp = 0;
		String name = "";
		boolean hasVit = false;
		boolean hasHps = false;
		
		int hps_max = 0;
		int vit_max = 0;
		
		PSItem sword = new PSItem(Material.LEATHER_LEGGINGS);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			type = Material.LEATHER_LEGGINGS;
			sword.addLore("&cDPS: 1 - 1%");
			switch (rarity) {
			case COMMON:
				hp = ir(11, 10);
				break;
			case UNCOMMON:
				hp = ir(39, 21);
				break;
			case RARE:
				hp = ir(50, 50);
				break;
			case UNIQUE:
				hp = ir(51, 100);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 5);
			vit_max = (int) ir(5, 1);
			break;
		case 2:
			type = Material.CHAINMAIL_LEGGINGS;
			sword.addLore("&cDPS: 3 - 3%");
			switch (rarity) {
			case COMMON:
				hp = ir(40, 60);
				break;
			case UNCOMMON:
				hp = ir(100, 100);
				break;
			case RARE:
				hp = ir(100, 200);
				break;
			case UNIQUE:
				hp = ir(101, 300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 10);
			vit_max = (int) ir(6, 5);
			break;
		case 3:
			type = Material.IRON_LEGGINGS;
			sword.addLore("&cDPS: 6 - 6%");
			switch (rarity) {
			case COMMON:
				hp = ir(150, 200);
				break;
			case UNCOMMON:
				hp = ir(150, 350);
				break;
			case RARE:
				hp = ir(300, 500);
				break;
			case UNIQUE:
				hp = ir(51, 800);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 40);
			vit_max = (int) ir(41, 20);
			break;
		case 4:
			type = Material.DIAMOND_LEGGINGS;
			sword.addLore("&cDPS: 12 - 12%");
			switch (rarity) {
			case COMMON:
				hp = ir(200, 600);
				break;
			case UNCOMMON:
				hp = ir(700, 800);
				break;
			case RARE:
				hp = ir(800, 1500);
				break;
			case UNIQUE:
				hp = ir(201, 2300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(6, 60);
			vit_max = (int) ir(91, 60);
			break;
		case 5:
			type = Material.GOLD_LEGGINGS;
			sword.addLore("&cDPS: 16 - 16%");
			switch (rarity) {
			case COMMON:
				hp = ir(1000, 1500);
				break;
			case UNCOMMON:
				hp = ir(1500, 2500);
				break;
			case RARE:
				hp = ir(1500, 4000);
				break;
			case UNIQUE:
				hp = ir(501, 5500);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(21, 90);
			vit_max = (int) ir(161, 150);
			break;
		}	
		int stat = Utils.ir(0, 2);
		if (stat == 1) {
			hasHps = true;
		}
		else if (stat == 2) {
			hasVit = true;
		} else {
			hasVit = true;
		}
		if (hasVit) {
			switch (tier) {
			case 1:
				name = "&fLeather Leggings of Fortitude";
				break;
			case 2:
				name = "&aChainmail Leggings of Fortitude";
				break;
			case 3:
				name = "&bLeggings of Fortitude";
				break;
			case 4:
				name = "&dMagic Leggings of Fortitude";
				break;
			case 5:
				name = "&eLegendary Full Leggings of Fortitude";
				break;
			}
			sword.addLore("&cVIT: +" + Utils.ir(0, vit_max));
		}
		if (hasHps) {
			switch (tier) {
			case 1:
				name = "&fMending Leather Leggings";
				break;
			case 2:
				name = "&aMending Chainmail Leggings";
				break;
			case 3:
				name = "&bMending Leggings";
				break;
			case 4:
				name = "&dMending Magic Leggings";
				break;
			case 5:
				name = "&eMending Legendary Leggings";
				break;
			}
			sword.addLore("&cHP REGEN: +" + Utils.ir(0, hps_max) + " HP/s");
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}
	
	public static ItemStack generateBoots(int tier, ItemRarity rarity) {
		Material type = Material.LEATHER_BOOTS;
		
		int hp = 0;
		String name = "";
		boolean hasVit = false;
		boolean hasHps = false;
		
		int hps_max = 0;
		int vit_max = 0;
		
		PSItem sword = new PSItem(Material.LEATHER_BOOTS);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			type = Material.LEATHER_BOOTS;
			sword.addLore("&cDPS: 1 - 1%");
			switch (rarity) {
			case COMMON:
				hp = ir(5, 5);
				break;
			case UNCOMMON:
				hp = ir(10, 10);
				break;
			case RARE:
				hp = ir(30, 20);
				break;
			case UNIQUE:
				hp = ir(11, 50);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 5);
			vit_max = (int) ir(5, 1);
			break;
		case 2:
			type = Material.CHAINMAIL_BOOTS;
			sword.addLore("&cDPS: 3 - 3%");
			switch (rarity) {
			case COMMON:
				hp = ir(13, 32);
				break;
			case UNCOMMON:
				hp = ir(40, 45);
				break;
			case RARE:
				hp = ir(35, 85);
				break;
			case UNIQUE:
				hp = ir(31, 120);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 10);
			vit_max = (int) ir(6, 5);
			break;
		case 3:
			type = Material.IRON_BOOTS;
			sword.addLore("&cDPS: 4 - 4%");
			switch (rarity) {
			case COMMON:
				hp = ir(100, 100);
				break;
			case UNCOMMON:
				hp = ir(100, 200);
				break;
			case RARE:
				hp = ir(50, 300);
				break;
			case UNIQUE:
				hp = ir(81, 350);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(11, 40);
			vit_max = (int) ir(41, 20);
			break;
		case 4:
			type = Material.DIAMOND_BOOTS;
			sword.addLore("&cDPS: 6 - 6%");
			switch (rarity) {
			case COMMON:
				hp = ir(200, 300);
				break;
			case UNCOMMON:
				hp = ir(200, 500);
				break;
			case RARE:
				hp = ir(300, 700);
				break;
			case UNIQUE:
				hp = ir(201, 1000);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(6, 60);
			vit_max = (int) ir(91, 60);
			break;
		case 5:
			type = Material.GOLD_BOOTS;
			sword.addLore("&cDPS: 8 - 8%");
			switch (rarity) {
			case COMMON:
				hp = ir(300, 700);
				break;
			case UNCOMMON:
				hp = ir(800, 1000);
				break;
			case RARE:
				hp = ir(500, 1800);
				break;
			case UNIQUE:
				hp = ir(701, 2300);
				break;
			}
			sword.addLore("&cHP: +" + hp);
			hps_max = (int) ir(21, 90);
			vit_max = (int) ir(161, 150);
			break;
		}
		int stat = Utils.ir(0, 2);
		if (stat == 1) {
			hasHps = true;
		}
		else if (stat == 2) {
			hasVit = true;
		} else {
			hasVit = true;
		}
		if (hasVit) {
			switch (tier) {
			case 1:
				name = "&fLeather Boots of Fortitude";
				break;
			case 2:
				name = "&aChainmail Boots of Fortitude";
				break;
			case 3:
				name = "&bFull Boots of Fortitude";
				break;
			case 4:
				name = "&dAncient Full Boots of Fortitude";
				break;
			case 5:
				name = "&eLegendary Full Boots of Fortitude";
				break;
			}
			sword.addLore("&cVIT: +" + Utils.ir(1, vit_max));
		}
		if (hasHps) {
			switch (tier) {
			case 1:
				name = "&fMending Leather Boots";
				break;
			case 2:
				name = "&aMending Medium Boots";
				break;
			case 3:
				name = "&bMending Full Boots";
				break;
			case 4:
				name = "&dMending Ancient Full Boots";
				break;
			case 5:
				name = "&eMending Legendary Full Boots";
				break;
			}
			sword.addLore("&cHP REGEN: +" + Utils.ir(1, hps_max) + " HP/s");
		}
		sword.setType(type);
		sword.setName(name);
		sword.setRarity(rarity);
		return sword.build();
	}
	
}
