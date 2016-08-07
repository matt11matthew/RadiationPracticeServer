package us.radiationnetwork.practiceserver.item;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import us.radiationnetwork.practiceserver.enums.ItemRarity;
import us.radiationnetwork.practiceserver.utils.Utils;

public class ItemGenerator {
	
	public static ItemStack generateAxe(int tier, ItemRarity rarity) {
		Material type = null;
		double mindmg = 0;
		double maxdmg = 0;
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
		
		PSItem sword = new PSItem(Material.WOOD_AXE);
		sword.setUnbreakable(true);
		switch (tier) {
		case 1:
			type = Material.WOOD_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(4, 1);
				maxdmg = ir((5 - mindmg + 1), mindmg);
			case UNCOMMON:
				mindmg = ir(2, 3);
				maxdmg = ir((6 - mindmg + 1), mindmg);
			case RARE:
				mindmg = ir(4, 6);
				maxdmg = ir(12, 9);
			case UNIQUE:
				mindmg = ir(2, 9);
				maxdmg = ir(7, 23);
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
		case 2:
			type = Material.STONE_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(6, 10);
				maxdmg = ir(20 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(6, 15);
				maxdmg = ir(19, 21);
			case RARE:
				mindmg = ir(7, 24);
				maxdmg = ir(25, 40);
			case UNIQUE:
				mindmg = ir(7, 24);
				maxdmg = ir(6, 65);
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
		case 3:
			type = Material.IRON_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(8, 25);
				maxdmg = ir(49 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(10, 30);
				maxdmg = ir(31, 40);
			case RARE:
				mindmg = ir(11, 35);
				maxdmg = ir(30, 71);
			case UNIQUE:
				mindmg = ir(6, 45);
				maxdmg = ir(51, 100);
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
		case 4:
			type = Material.DIAMOND_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 60);
				maxdmg = ir(99 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(26, 65);
				maxdmg = ir(21, 100);
			case RARE:
				mindmg = ir(21, 80);
				maxdmg = ir(79, 121);
			case UNIQUE:
				mindmg = ir(51, 100);
				maxdmg = ir(51, 200);
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
		case 5:
			type = Material.GOLD_AXE;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 130);
				maxdmg = ir((199 - mindmg + 1), mindmg);
			case UNCOMMON:
				mindmg = ir(31, 130);
				maxdmg = ir((250 - mindmg + 10 + 1), mindmg + 10);
			case RARE:
				mindmg = ir(11, 180);
				maxdmg = ir(151, 200);
			case UNIQUE:
				mindmg = ir(51, 200);
				maxdmg = ir(251, 250);
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
			case 2:
				hasPureDMG = true;
			case 3:
				hasIceDMG = true;
			case 4:
				hasFireDMG = true;
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
			name = "Pure " + name;
			sword.addLore("&cPURE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasAccuracy) {
			name = "Accurate " + name;
			sword.addLore("&cACCURACY: " + Utils.ir(0, accuracy_max) + "%");
		}
		if (hasKB) {
			name = "Brute " + name;
			sword.addLore("&cKNOCKBACK: " + Utils.ir(0, knockback_max) + "%");
		}
		if (hasBlind) {
			name = name + " of Blindness";
			sword.addLore("&cBLIND: " + Utils.ir(0, blind_max) + "%");
		}
		if (hasLS) {
			name = "Vampyric " + name;
			sword.addLore("&cLIFE STEAL: " + Utils.ir(0, life_steal_max) + "%");
		}
		if (hasCrit) {
			name = "Deadly " + name;
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
			case 2:
				if (name.contains("of")) {
					name = name + " Slaughter";
				} else {
					name = name + " of Slaughter";
				}
				sword.addLore("&cDMG Vs. Players: " + Utils.ir(0, vs_modifier_chance) + "%");
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
		double mindmg = 0;
		double maxdmg = 0;
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
			type = Material.WOOD_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(4, 1);
				maxdmg = ir((5 - mindmg + 1), mindmg);
			case UNCOMMON:
				mindmg = ir(2, 3);
				maxdmg = ir((6 - mindmg + 1), mindmg);
			case RARE:
				mindmg = ir(4, 6);
				maxdmg = ir(12, 9);
			case UNIQUE:
				mindmg = ir(2, 9);
				maxdmg = ir(7, 23);
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
		case 2:
			type = Material.STONE_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(6, 10);
				maxdmg = ir(20 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(6, 15);
				maxdmg = ir(19, 21);
			case RARE:
				mindmg = ir(7, 24);
				maxdmg = ir(25, 40);
			case UNIQUE:
				mindmg = ir(7, 24);
				maxdmg = ir(6, 65);
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
		case 3:
			type = Material.IRON_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(8, 25);
				maxdmg = ir(49 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(10, 30);
				maxdmg = ir(31, 40);
			case RARE:
				mindmg = ir(11, 35);
				maxdmg = ir(30, 71);
			case UNIQUE:
				mindmg = ir(6, 45);
				maxdmg = ir(51, 100);
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
		case 4:
			type = Material.DIAMOND_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 60);
				maxdmg = ir(99 - mindmg + 1, mindmg);
			case UNCOMMON:
				mindmg = ir(26, 65);
				maxdmg = ir(21, 100);
			case RARE:
				mindmg = ir(21, 80);
				maxdmg = ir(79, 121);
			case UNIQUE:
				mindmg = ir(51, 100);
				maxdmg = ir(51, 200);
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
		case 5:
			type = Material.GOLD_SWORD;
			switch (rarity) {
			case COMMON:
				mindmg = ir(21, 130);
				maxdmg = ir((199 - mindmg + 1), mindmg);
			case UNCOMMON:
				mindmg = ir(31, 130);
				maxdmg = ir((250 - mindmg + 10 + 1), mindmg + 10);
			case RARE:
				mindmg = ir(11, 180);
				maxdmg = ir(151, 200);
			case UNIQUE:
				mindmg = ir(51, 200);
				maxdmg = ir(251, 250);
			}
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
			case 2:
				hasPureDMG = true;
			case 3:
				hasIceDMG = true;
			case 4:
				hasFireDMG = true;
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
			name = "Pure " + name;
			sword.addLore("&cPURE DMG: +" + Utils.ir(0, edmg_max));
		}
		if (hasAccuracy) {
			name = "Accurate " + name;
			sword.addLore("&cACCURACY: " + Utils.ir(0, accuracy_max) + "%");
		}
		if (hasKB) {
			name = "Brute " + name;
			sword.addLore("&cKNOCKBACK: " + Utils.ir(0, knockback_max) + "%");
		}
		if (hasBlind) {
			name = name + " of Blindness";
			sword.addLore("&cBLIND: " + Utils.ir(0, blind_max) + "%");
		}
		if (hasLS) {
			name = "Vampyric " + name;
			sword.addLore("&cLIFE STEAL: " + Utils.ir(0, life_steal_max) + "%");
		}
		if (hasCrit) {
			name = "Deadly " + name;
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
			case 2:
				if (name.contains("of")) {
					name = name + " Slaughter";
				} else {
					name = name + " of Slaughter";
				}
				sword.addLore("&cDMG Vs. Players: " + Utils.ir(0, vs_modifier_chance) + "%");
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
	
	public static double ir(double max, double min) {
		Random r = new Random();
		return r.nextInt((int) max) + min;
	}
}
