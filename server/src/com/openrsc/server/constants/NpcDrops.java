package com.openrsc.server.constants;

import com.openrsc.server.content.DropTable;
import com.openrsc.server.model.container.Item;
import com.openrsc.server.model.entity.Mob;

import java.util.HashMap;
import java.util.HashSet;

public class NpcDrops {

	private HashMap<Integer, DropTable> npcDrops;
	private HashSet<Integer> bonelessNpcs;
	private HashSet<Integer> bigBoneNpcs;
	private HashSet<Integer> ashesNpcs;

	private DropTable herbDropTable;
	private DropTable rareDropTable;
	private DropTable megaRareDropTable;
	private DropTable ultraRareDropTable;

	public NpcDrops() {
		this.npcDrops = new HashMap<>();
		this.bigBoneNpcs = new HashSet<>();
		this.ashesNpcs = new HashSet<>();
		this.bonelessNpcs = new HashSet<>();

		createHerbDropTable();
		createRareDropTable();
		createMegaRareDropTable();
		createUltraRareDropTable();

		createBoneDrops();
		createMobDrops();
	}

	private void createHerbDropTable() {
		herbDropTable = new DropTable();
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_GUAM_LEAF.id(), 1, 32);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_MARRENTILL.id(), 1, 24);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_TARROMIN.id(), 1, 18);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_HARRALANDER.id(), 1, 14);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_RANARR_WEED.id(), 1, 11);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_IRIT_LEAF.id(), 1, 8);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_AVANTOE.id(), 1, 6);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_KWUARM.id(), 1, 5);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_CADANTINE.id(), 1, 4);
		herbDropTable.addItemDrop(ItemId.UNIDENTIFIED_DWARF_WEED.id(), 1, 3);
	}

	private void createRareDropTable() {
		rareDropTable = new DropTable();
		rareDropTable.addItemDrop(ItemId.UNCUT_SAPPHIRE.id(), 1, 32);
		rareDropTable.addItemDrop(ItemId.UNCUT_EMERALD.id(), 1, 16);
		rareDropTable.addItemDrop(ItemId.UNCUT_RUBY.id(), 1, 8);
		rareDropTable.addItemDrop(ItemId.UNCUT_DIAMOND.id(), 1, 4);
		rareDropTable.addItemDrop(ItemId.TOOTH_KEY_HALF.id(), 1, 1);
		rareDropTable.addItemDrop(ItemId.LOOP_KEY_HALF.id(), 1, 1);
		rareDropTable.addTableDrop(megaRareDropTable, 1);
	}

	private void createMegaRareDropTable() {
		megaRareDropTable = new DropTable();
		megaRareDropTable.addItemDrop(ItemId.RUNE_SPEAR.id(), 1, 2);
		megaRareDropTable.addItemDrop(ItemId.LEFT_HALF_DRAGON_SQUARE_SHIELD.id(), 1, 1);
	}

	private void createUltraRareDropTable() {
		ultraRareDropTable = new DropTable();
		ultraRareDropTable.addItemDrop(ItemId.NOTHING.id(), 0, 81);
		ultraRareDropTable.addItemDrop(ItemId.COINS.id(), 3000, 42);
		ultraRareDropTable.addItemDrop(ItemId.TOOTH_KEY_HALF.id(), 1, 34);
		ultraRareDropTable.addItemDrop(ItemId.LOOP_KEY_HALF.id(), 1, 34);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_2_HANDED_SWORD.id(), 1, 8);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_BATTLE_AXE.id(), 1, 6);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_AXE.id(), 1, 6);
		ultraRareDropTable.addItemDrop(ItemId.NATURE_RUNE.id(), 45, 6);
		ultraRareDropTable.addItemDrop(ItemId.SILVER_CERTIFICATE.id(), 20, 4);
		ultraRareDropTable.addItemDrop(ItemId.COAL_CERTIFICATE.id(), 20, 4);
		ultraRareDropTable.addItemDrop(ItemId.DRAGONSTONE.id(), 1, 4);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_SQUARE_SHIELD.id(), 1, 4);
		ultraRareDropTable.addItemDrop(ItemId.RUNITE_BAR.id(), 1, 4);
		ultraRareDropTable.addItemDrop(ItemId.DEATH_RUNE.id(), 30, 4);
		ultraRareDropTable.addItemDrop(ItemId.LAW_RUNE.id(), 30, 4);
		ultraRareDropTable.addItemDrop(ItemId.BRONZE_ARROWS.id(), 300, 4);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_CHAIN_MAIL_BODY.id(), 1, 2);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_PLATE_MAIL_LEGS.id(), 1, 2);
		ultraRareDropTable.addItemDrop(ItemId.RUNE_KITE_SHIELD.id(), 1, 2);
		ultraRareDropTable.addItemDrop(ItemId.DRAGON_MEDIUM_HELMET.id(), 1, 1);
	}

	private void createBoneDrops() {
		generateBonelessNpcs();
		generateBigBoneDrops();
		generateAshesDrops();
	}

	private void createMobDrops() {
		generateNpcDrops();
		//	put(NpcId.MAN.id(), new ArrayList<Map.Entry<Integer, Integer>> {{
		//		add(new Map.Entry<Integer, Integer>() {{
	}

	private void generateBonelessNpcs() {
		this.bonelessNpcs.add(NpcId.GHOST_RESTLESS.id());
		this.bonelessNpcs.add(NpcId.GIANT_SPIDER_LVL8.id());
		this.bonelessNpcs.add(NpcId.SPIDER.id());
		this.bonelessNpcs.add(NpcId.GIANT_BAT.id());
		this.bonelessNpcs.add(NpcId.GHOST1.id());
		this.bonelessNpcs.add(NpcId.SCORPION.id());
		this.bonelessNpcs.add(NpcId.GIANT_SPIDER_LVL31.id());
		this.bonelessNpcs.add(NpcId.GHOST2.id());
		this.bonelessNpcs.add(NpcId.COUNT_DRAYNOR.id());
		this.bonelessNpcs.add(NpcId.DEADLY_RED_SPIDER.id());
		this.bonelessNpcs.add(NpcId.KING_SCORPION.id());
		this.bonelessNpcs.add(NpcId.SUIT_OF_ARMOUR.id());
		this.bonelessNpcs.add(NpcId.TREE_SPIRIT.id());
		this.bonelessNpcs.add(NpcId.SHAPESHIFTER_HUMAN.id());
		this.bonelessNpcs.add(NpcId.SHAPESHIFTER_SPIDER.id());
		this.bonelessNpcs.add(NpcId.SHAPESHIFTER_BEAR.id());
		this.bonelessNpcs.add(NpcId.POISON_SCORPION.id());
		this.bonelessNpcs.add(NpcId.POISON_SPIDER.id());
		this.bonelessNpcs.add(NpcId.SHADOW_SPIDER.id());
		this.bonelessNpcs.add(NpcId.KHAZARD_SCORPION.id());
		this.bonelessNpcs.add(NpcId.FIRST_PLAGUE_SHEEP.id());
		this.bonelessNpcs.add(NpcId.SECOND_PLAGUE_SHEEP.id());
		this.bonelessNpcs.add(NpcId.THIRD_PLAGUE_SHEEP.id());
		this.bonelessNpcs.add(NpcId.FOURTH_PLAGUE_SHEEP.id());
		this.bonelessNpcs.add(NpcId.RAT_TUTORIAL.id());
		this.bonelessNpcs.add(NpcId.JUNGLE_SPIDER.id());
		this.bonelessNpcs.add(NpcId.ZADIMUS.id());
		this.bonelessNpcs.add(NpcId.NAZASTAROOL_GHOST.id());
		this.bonelessNpcs.add(NpcId.BLESSED_SPIDER.id());
		this.bonelessNpcs.add(NpcId.GHOST_SCORPIUS.id());
		this.bonelessNpcs.add(NpcId.SPIRIT_OF_SCORPIUS.id());
		this.bonelessNpcs.add(NpcId.SCORPION_GRAVE.id());
		this.bonelessNpcs.add(NpcId.PIT_SCORPION.id());
	}

	private void generateBigBoneDrops() {
		// NPCs that only drop Big Bones
		this.bigBoneNpcs.add(NpcId.BABY_BLUE_DRAGON.id());
		this.bigBoneNpcs.add(NpcId.KHAZARD_OGRE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_TRAINING_CAMP.id());
		this.bigBoneNpcs.add(NpcId.OGRE_CHIEFTAN.id());
		this.bigBoneNpcs.add(NpcId.OGRE_SHAMAN.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GUARD_EASTGATE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GUARD_WESTGATE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GUARD_BATTLEMENT.id());
		this.bigBoneNpcs.add(NpcId.OG.id());
		this.bigBoneNpcs.add(NpcId.GREW.id());
		this.bigBoneNpcs.add(NpcId.TOBAN.id());
		this.bigBoneNpcs.add(NpcId.GORAD.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GUARD_CAVE_ENTRANCE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_MERCHANT.id());
		this.bigBoneNpcs.add(NpcId.OGRE_TRADER_GENSTORE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_TRADER_ROCKCAKE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_TRADER_FOOD.id());
		this.bigBoneNpcs.add(NpcId.CITY_GUARD.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GUARD_BRIDGE.id());
		this.bigBoneNpcs.add(NpcId.OGRE_CITIZEN.id());
		this.bigBoneNpcs.add(NpcId.OGRE_GENERAL.id());

		// Other
		this.bigBoneNpcs.add(NpcId.FIRE_GIANT.id());
		this.bigBoneNpcs.add(NpcId.GIANT.id());
		this.bigBoneNpcs.add(NpcId.ICE_GIANT.id());
		this.bigBoneNpcs.add(NpcId.MOSS_GIANT.id());
		this.bigBoneNpcs.add(NpcId.MOSS_GIANT2.id());
		this.bigBoneNpcs.add(NpcId.OGRE.id());
		this.bigBoneNpcs.add(NpcId.JOGRE.id());
	}

	private void generateAshesDrops() {
		// NPCs that only drop ashes
		this.ashesNpcs.add(NpcId.DELRITH.id());
		this.ashesNpcs.add(NpcId.THRANTAX.id());
		this.ashesNpcs.add(NpcId.CHRONOZON.id());
		this.ashesNpcs.add(NpcId.BLACK_DEMON_GRANDTREE.id());
		this.ashesNpcs.add(NpcId.DOOMION.id());
		this.ashesNpcs.add(NpcId.HOLTHION.id());
		this.ashesNpcs.add(NpcId.NEZIKCHENED.id());

		// Other
		this.ashesNpcs.add(NpcId.IMP.id());
		this.ashesNpcs.add(NpcId.LESSER_DEMON.id());
		this.ashesNpcs.add(NpcId.GREATER_DEMON.id());
		this.ashesNpcs.add(NpcId.BLACK_DEMON.id());
		this.ashesNpcs.add(NpcId.OTHAINIAN.id());
	}

	private void generateNpcDrops() {
		DropTable currentNpcDrops;

		// Unicorn (0)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.UNICORN_HORN.id(), 1, 0);
		this.npcDrops.put(NpcId.UNICORN.id(), currentNpcDrops);

		// Chicken (3)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_CHICKEN.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.NOTHING.id(), 0, 32);
		currentNpcDrops.addItemDrop(ItemId.FEATHER.id(), 3, 76);
		currentNpcDrops.addItemDrop(ItemId.FEATHER.id(), 10, 20);
		this.npcDrops.put(NpcId.CHICKEN.id(), currentNpcDrops);

		// Goblin Level 13 (4, 153, 154)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addTableDrop(herbDropTable, 2);
		currentNpcDrops.addItemDrop(ItemId.NOTHING.id(), 0, 34);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 1, 34);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 3, 13);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_SPEAR.id(), 1, 9);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 5, 8);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 16, 7);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_AXE.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.MIND_RUNE.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.EARTH_RUNE.id(), 3, 3);
		currentNpcDrops.addItemDrop(ItemId.BODY_RUNE.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_ARROWS.id(), 7, 3);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 24, 3);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_SCIMITAR.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.CHAOS_RUNE.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.NATURE_RUNE.id(), 1, 1);
		this.npcDrops.put(NpcId.GOBLIN_LVL13.id(), currentNpcDrops); // (4)
		this.npcDrops.put(NpcId.GOBLIN1_LVL13.id(), currentNpcDrops); // (153)
		this.npcDrops.put(NpcId.GOBLIN2_LVL13.id(), currentNpcDrops); // (154)

		// Cow (6)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.COW_HIDE.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.RAW_BEEF.id(), 1, 0);
		this.npcDrops.put(NpcId.COW_ATTACKABLE.id(), currentNpcDrops);

		// Bear Level 24 (8)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_BEAR_MEAT.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.FUR.id(), 1, 0);
		this.npcDrops.put(NpcId.BEAR_LVL24.id(), currentNpcDrops);

		// Man (11, 72, 318)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addTableDrop(herbDropTable, 23);
		currentNpcDrops.addItemDrop(ItemId.NOTHING.id(), 0, 32);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 3, 38);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 5, 9);
		currentNpcDrops.addItemDrop(ItemId.FISHING_BAIT.id(), 1, 5);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 15, 4);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_ARROWS.id(), 7, 3);
		currentNpcDrops.addItemDrop(ItemId.EARTH_RUNE.id(), 3, 2);
		currentNpcDrops.addItemDrop(ItemId.FIRE_RUNE.id(), 4, 2);
		currentNpcDrops.addItemDrop(ItemId.MIND_RUNE.id(), 6, 2);
		currentNpcDrops.addItemDrop(ItemId.COPPER_ORE.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.MEDIUM_BRONZE_HELMET.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.CABBAGE.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.IRON_DAGGER.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.CHAOS_RUNE.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 25, 1);
		this.npcDrops.put(NpcId.MAN1.id(), currentNpcDrops); // (11)
		this.npcDrops.put(NpcId.MAN2.id(), currentNpcDrops); // (72)
		this.npcDrops.put(NpcId.MAN3.id(), currentNpcDrops); // (318)

		// Rat Level 8 (19, 29, 47, 177, 241, 367)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_RAT_MEAT.id(), 1, 0);
		this.npcDrops.put(NpcId.RAT_LVL8.id(), currentNpcDrops);
		this.npcDrops.put(NpcId.RAT_WITCHES_POTION.id(), currentNpcDrops);
		this.npcDrops.put(NpcId.RAT_LVL13.id(), currentNpcDrops);
		this.npcDrops.put(NpcId.RAT_WMAZEKEY.id(), currentNpcDrops);
		this.npcDrops.put(NpcId.RAT_WITCHES_HOUSE.id(), currentNpcDrops);
		this.npcDrops.put(NpcId.DUNGEON_RAT.id(), currentNpcDrops);

		// Mugger (21)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addTableDrop(herbDropTable, 13);
		currentNpcDrops.addItemDrop(ItemId.NOTHING.id(), 0, 40);
		currentNpcDrops.addItemDrop(ItemId.ROPE.id(), 1, 40);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 5, 12);
		currentNpcDrops.addItemDrop(ItemId.FISHING_BAIT.id(), 1, 6);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.MIND_RUNE.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.COPPER_ORE.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.MEDIUM_BRONZE_HELMET.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.WATER_RUNE.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.EARTH_RUNE.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.KNIFE.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.CABBAGE.id(), 1, 1);
		this.npcDrops.put(NpcId.MUGGER.id(), currentNpcDrops);

		// Lesser Demon (22)

		// Jonny the Beard (25)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.SCROLL.id(), 1, 0);
		this.npcDrops.put(NpcId.JONNY_THE_BEARD.id(), currentNpcDrops);

		// Skeleton Level 21 (40, 498)

		// Zombie Level 24 (41, 516)

		// Giant Bat (43)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.BAT_BONES.id(), 1, 0);
		this.npcDrops.put(NpcId.GIANT_BAT.id(), currentNpcDrops);

		// Skeleton Level 31 (45)

		// Skeleton Level 25 (46)

		// Bear (49)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_BEAR_MEAT.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.FUR.id(), 1, 0);
		this.npcDrops.put(NpcId.BEAR.id(), currentNpcDrops);

		// Zombie Level 19 (52)

		// Darkwizard Level 13 (57)

		// Darkwizard Level 25 (60)

		// Giant (61)

		// Goblin Level 7 (62)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.NOTHING.id(), 0, 50);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 5, 28);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_SPEAR.id(), 1, 12);
		currentNpcDrops.addItemDrop(ItemId.WATER_RUNE.id(), 4, 6);
		currentNpcDrops.addItemDrop(ItemId.BODY_RUNE.id(), 7, 5);
		currentNpcDrops.addItemDrop(ItemId.GOBLIN_ARMOUR.id(), 1, 5);
		currentNpcDrops.addItemDrop(ItemId.BRONZE_SQUARE_SHIELD.id(), 1, 3);
		currentNpcDrops.addItemDrop(ItemId.CROSSBOW_BOLTS.id(), 8, 3);
		currentNpcDrops.addItemDrop(ItemId.EARTH_RUNE.id(), 3, 3);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 9, 3);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 15, 3);
		currentNpcDrops.addItemDrop(ItemId.COINS.id(), 20, 2);
		currentNpcDrops.addItemDrop(ItemId.BEER.id(), 1, 2);
		currentNpcDrops.addItemDrop(ItemId.SHORTBOW.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.BRASS_NECKLACE.id(), 1, 1);
		currentNpcDrops.addItemDrop(ItemId.CHEFS_HAT.id(), 1, 1);
		this.npcDrops.put(NpcId.GOBLIN_LVL7.id(), currentNpcDrops);

		// Farmer (63, 319)

		// Thief (64, 351, 352)

		// Guard (65, 321, 420, 710)

		// Black Knight (66)

		// Hobgoblin Level 32 (67)

		// Zombie Level 32 (68)

		// Barbarian (76)

		// Gunthor the Brave (78)

		// Wizard (81)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.WIZARDS_ROBE.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.A_BLUE_WIZARDS_HAT.id(), 1, 0);
		this.npcDrops.put(NpcId.WIZARD.id(), currentNpcDrops);

		// Highwayman (89)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.BLACK_CAPE.id(), 1, 0);
		this.npcDrops.put(NpcId.HIGHWAYMAN.id(), currentNpcDrops);

		// Dwarf (94, 356, 694. 699)

		// Fortress Guard (100)

		// White Knight (102)

		// Moss Giant (104, 594)

		// Imp (114)

		// Ice Giant (135)

		// Pirate Level 27 (137)

		// Monk of Zamorak Level 29 (139)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.STEEL_MACE.id(), 1, 0);
		this.npcDrops.put(NpcId.MONK_OF_ZAMORAK_MACE.id(), currentNpcDrops);

		// Goblin Level 13 (153, 154)

		// Ice Warrior (158)

		// Warrior (86, 159, 320)

		// Skeleton (Maze) (179)

		// Zombie (Maze) (180)

		// Lesser Demon (Maze) (181)

		// Melzar the Mad (182)

		// Greater Demon (184)

		// Bear Level 26 (188)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_BEAR_MEAT.id(), 1, 0);
		currentNpcDrops.addItemDrop(ItemId.FUR.id(), 1, 0);
		this.npcDrops.put(NpcId.BEAR_LVL26.id(), currentNpcDrops);

		// Black Knight (Fortress) (189)

		// Chaos Dwarf (190)

		// Skeleton Level 54 (195)

		// Dragon (196)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.DRAGON_BONES.id(), 1, 0);
		this.npcDrops.put(NpcId.DRAGON.id(), currentNpcDrops);

		// Dark Warrior (199)

		// Druid (200)

		// Red Dragon (201)

		// Blue Dragon (202)

		// Zombie (Entrana) (214)

		// Bandit (Aggressive) (232)

		// Bandit (Not Aggressive) (234)

		// Donny the Lad (236)

		// Black Heather (237)

		// Speedy Keith (238)

		// Grey Wolf (243)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.GREY_WOLF_FUR.id(), 1, 0);
		this.npcDrops.put(NpcId.GREY_WOLF.id(), currentNpcDrops);

		// Thug (251)

		// Firebird (252)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RED_FIREBIRD_FEATHER.id(), 1, 0);
		this.npcDrops.put(NpcId.FIREBIRD.id(), currentNpcDrops);

		// Ice Queen (254)

		// Pirate Level 30 (264)

		// Jailer (265)

		// Lord Darquarius (266)

		// Chaos Druid (270)

		// Renegade Knight (277)

		// Black Demon (290)

		// Black Dragon (291)

		// Animated Axe (295)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.IRON_BATTLE_AXE.id(), 1, 0);
		this.npcDrops.put(NpcId.ANIMATED_AXE.id(), currentNpcDrops);

		// Black Unicorn (296)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.UNICORN_HORN.id(), 1, 0);
		this.npcDrops.put(NpcId.BLACK_UNICORN.id(), currentNpcDrops);

		// Otherworldly Being (298)

		// Hobgoblin Level 48 (311)

		// Paladin (323)

		// Rogue (342)

		// Fire Giant (344)

		// Necromancer (358)

		// Zombie Level 24 (359)

		// First plague sheep (430)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.PLAGUED_SHEEP_REMAINS_1.id(), 1, 0);
		this.npcDrops.put(NpcId.FIRST_PLAGUE_SHEEP.id(), currentNpcDrops);

		// First plague sheep (431)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.PLAGUED_SHEEP_REMAINS_2.id(), 1, 0);
		this.npcDrops.put(NpcId.SECOND_PLAGUE_SHEEP.id(), currentNpcDrops);

		// First plague sheep (432)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.PLAGUED_SHEEP_REMAINS_3.id(), 1, 0);
		this.npcDrops.put(NpcId.THIRD_PLAGUE_SHEEP.id(), currentNpcDrops);

		// First plague sheep (433)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.PLAGUED_SHEEP_REMAINS_4.id(), 1, 0);
		this.npcDrops.put(NpcId.FOURTH_PLAGUE_SHEEP.id(), currentNpcDrops);

		// King Black Dragon (477)

		// Jogre (523)

		// Chaos Druid Warrior (555)

		// Salarin the Twisted (567)

		// Earth Warrior (584)

		// Ugthanki (653)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_UGTHANKI_MEAT.id(), 1, 0);
		this.npcDrops.put(NpcId.UGTHANKI.id(), currentNpcDrops);

		// Goblin Level 19 (660)

		// Oomlie Bird (777)
		currentNpcDrops = new DropTable();
		currentNpcDrops.addItemDrop(ItemId.RAW_OOMLIE_MEAT.id(), 1, 0);
		this.npcDrops.put(NpcId.OOMLIE_BIRD.id(), currentNpcDrops);

	}

	public DropTable getDropTable(int npcId) {
		return this.npcDrops.get(npcId);
	}
}
