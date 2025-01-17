package com.openrsc.server.plugins.authentic.npcs.varrock;

import com.openrsc.server.constants.ItemId;
import com.openrsc.server.constants.NpcId;
import com.openrsc.server.model.container.Item;
import com.openrsc.server.model.entity.npc.Npc;
import com.openrsc.server.model.entity.player.Player;
import com.openrsc.server.plugins.Functions;
import com.openrsc.server.plugins.triggers.UseNpcTrigger;
import com.openrsc.server.plugins.triggers.TalkNpcTrigger;

import static com.openrsc.server.plugins.RuneScript.*;

public class Thrander implements TalkNpcTrigger, UseNpcTrigger {

	@Override
	public boolean blockTalkNpc(Player player, Npc n) {
		return n.getID() == NpcId.THRANDER.id();
	}

	@Override
	public void onTalkNpc(Player player, Npc n) {
		npcsay("Hello I'm Thrander the smith",
			"I'm an expert in armour modification",
			"Give me your armour designed for men",
			"And I can convert it into something more comfortable for a women",
			"And visa versa"
		);
	}

	@Override
	public boolean blockUseNpc(Player player, Npc npc, Item item) {
		return npc.getID() == NpcId.THRANDER.id() && getNewId(item) != ItemId.NOTHING.id();
	}

	@Override
	public void onUseNpc(Player player, Npc npc, Item item) {
		if (isExchangeable(item)) {

			int newId = getNewId(item);
			Item newItem = new Item(newId);

			String itemNameLower = item.getDef(player.getWorld()).getName().toLowerCase();
			String newItemNameLower = newItem.getDef(player.getWorld()).getName().toLowerCase();

			// From replays, "Steel" seems to always be capitalized, rune is always lowercase. Unsure about other metals
			String metal = itemNameLower.substring(0, itemNameLower.indexOf(' '));
			if (metal.equals("steel")) {
				itemNameLower = itemNameLower.substring(0, 1).toUpperCase() + itemNameLower.substring(1);
				newItemNameLower = newItemNameLower.substring(0, 1).toUpperCase() + newItemNameLower.substring(1);
			}

			remove(item.getCatalogId(), 1);

			if (itemNameLower.contains("top") || itemNameLower.contains("body")) {
				mes("You give Thrander a " + itemNameLower);
				delay(3);
				mes("Thrander hammers it for a bit");
				delay(3);
				mes("Thrander gives you a " + newItemNameLower);
			} else if (itemNameLower.contains("skirt")) {
				mes("You give Thrander a " + metal + " skirt");
				delay(3);
				mes("Thrander hammers it for a bit");
				delay(3);
				mes("Thrander gives you some " + newItemNameLower);
			} else if (itemNameLower.contains("legs")) {
				mes("You give Thrander some " + itemNameLower);
				delay(3);
				mes("Thrander hammers it for a bit");
				delay(3);
				mes("Thrander gives you a " + metal + " skirt");
			}

			give(newId, 1);

		} else {
			mes("Nothing interesting happens");
		}
	}

	public int getNewId(Item item) {
		int newId = ItemId.NOTHING.id();
		switch (ItemId.getById(item.getCatalogId())) {
			case BRONZE_PLATE_MAIL_TOP:
				newId = ItemId.BRONZE_PLATE_MAIL_BODY.id();
				break;
			case IRON_PLATE_MAIL_TOP:
				newId = ItemId.IRON_PLATE_MAIL_BODY.id();
				break;
			case STEEL_PLATE_MAIL_TOP:
				newId = ItemId.STEEL_PLATE_MAIL_BODY.id();
				break;
			case BLACK_PLATE_MAIL_TOP:
				newId = ItemId.BLACK_PLATE_MAIL_BODY.id();
				break;
			case MITHRIL_PLATE_MAIL_TOP:
				newId = ItemId.MITHRIL_PLATE_MAIL_BODY.id();
				break;
			case ADAMANTITE_PLATE_MAIL_TOP:
				newId = ItemId.ADAMANTITE_PLATE_MAIL_BODY.id();
				break;
			case RUNE_PLATE_MAIL_TOP:
				newId = ItemId.RUNE_PLATE_MAIL_BODY.id();
				break;
			case DRAGON_PLATE_MAIL_TOP:
				newId = ItemId.DRAGON_PLATE_MAIL_BODY.id();
				break;
			case BRONZE_PLATE_MAIL_BODY:
				newId = ItemId.BRONZE_PLATE_MAIL_TOP.id();
				break;
			case IRON_PLATE_MAIL_BODY:
				newId = ItemId.IRON_PLATE_MAIL_TOP.id();
				break;
			case STEEL_PLATE_MAIL_BODY:
				newId = ItemId.STEEL_PLATE_MAIL_TOP.id();
				break;
			case BLACK_PLATE_MAIL_BODY:
				newId = ItemId.BLACK_PLATE_MAIL_TOP.id();
				break;
			case MITHRIL_PLATE_MAIL_BODY:
				newId = ItemId.MITHRIL_PLATE_MAIL_TOP.id();
				break;
			case ADAMANTITE_PLATE_MAIL_BODY:
				newId = ItemId.ADAMANTITE_PLATE_MAIL_TOP.id();
				break;
			case RUNE_PLATE_MAIL_BODY:
				newId = ItemId.RUNE_PLATE_MAIL_TOP.id();
				break;
			case DRAGON_PLATE_MAIL_BODY:
				newId = ItemId.DRAGON_PLATE_MAIL_TOP.id();
				break;
			case BRONZE_PLATED_SKIRT:
				newId = ItemId.BRONZE_PLATE_MAIL_LEGS.id();
				break;
			case IRON_PLATED_SKIRT:
				newId = ItemId.IRON_PLATE_MAIL_LEGS.id();
				break;
			case STEEL_PLATED_SKIRT:
				newId = ItemId.STEEL_PLATE_MAIL_LEGS.id();
				break;
			case BLACK_PLATED_SKIRT:
				newId = ItemId.BLACK_PLATE_MAIL_LEGS.id();
				break;
			case MITHRIL_PLATED_SKIRT:
				newId = ItemId.MITHRIL_PLATE_MAIL_LEGS.id();
				break;
			case ADAMANTITE_PLATED_SKIRT:
				newId = ItemId.ADAMANTITE_PLATE_MAIL_LEGS.id();
				break;
			case RUNE_SKIRT:
				newId = ItemId.RUNE_PLATE_MAIL_LEGS.id();;
				break;
			case DRAGON_PLATED_SKIRT:
				newId = ItemId.DRAGON_PLATE_MAIL_LEGS.id();
				break;
			case BRONZE_PLATE_MAIL_LEGS:
				newId = ItemId.BRONZE_PLATED_SKIRT.id();
				break;
			case IRON_PLATE_MAIL_LEGS:
				newId = ItemId.IRON_PLATED_SKIRT.id();
				break;
			case STEEL_PLATE_MAIL_LEGS:
				newId = ItemId.STEEL_PLATED_SKIRT.id();
				break;
			case BLACK_PLATE_MAIL_LEGS:
				newId = ItemId.BLACK_PLATED_SKIRT.id();
				break;
			case MITHRIL_PLATE_MAIL_LEGS:
				newId = ItemId.MITHRIL_PLATED_SKIRT.id();
				break;
			case ADAMANTITE_PLATE_MAIL_LEGS:
				newId = ItemId.ADAMANTITE_PLATED_SKIRT.id();
				break;
			case RUNE_PLATE_MAIL_LEGS:
				newId = ItemId.RUNE_SKIRT.id();
				break;
			case DRAGON_PLATE_MAIL_LEGS:
				newId = ItemId.DRAGON_PLATED_SKIRT.id();
				break;
			case BRONZE_CHAIN_MAIL_TOP:
				newId = ItemId.BRONZE_CHAIN_MAIL_BODY.id();
				break;
			case IRON_CHAIN_MAIL_TOP:
				newId = ItemId.IRON_CHAIN_MAIL_BODY.id();
				break;
			case STEEL_CHAIN_MAIL_TOP:
				newId = ItemId.STEEL_CHAIN_MAIL_BODY.id();
				break;
			case BLACK_CHAIN_MAIL_TOP:
				newId = ItemId.BLACK_CHAIN_MAIL_BODY.id();
				break;
			case MITHRIL_CHAIN_MAIL_TOP:
				newId = ItemId.MITHRIL_CHAIN_MAIL_BODY.id();
				break;
			case ADAMANTITE_CHAIN_MAIL_TOP:
				newId = ItemId.ADAMANTITE_CHAIN_MAIL_BODY.id();
				break;
			case RUNE_CHAIN_MAIL_TOP:
				newId = ItemId.RUNE_CHAIN_MAIL_BODY.id();
				break;
			case DRAGON_SCALE_MAIL_TOP:
				newId = ItemId.DRAGON_SCALE_MAIL.id();
				break;
			case BRONZE_CHAIN_MAIL_BODY:
				newId = ItemId.BRONZE_CHAIN_MAIL_TOP.id();
				break;
			case IRON_CHAIN_MAIL_BODY:
				newId = ItemId.IRON_CHAIN_MAIL_TOP.id();
				break;
			case STEEL_CHAIN_MAIL_BODY:
				newId = ItemId.STEEL_CHAIN_MAIL_TOP.id();
				break;
			case BLACK_CHAIN_MAIL_BODY:
				newId = ItemId.BLACK_CHAIN_MAIL_TOP.id();
				break;
			case MITHRIL_CHAIN_MAIL_BODY:
				newId = ItemId.MITHRIL_CHAIN_MAIL_TOP.id();
				break;
			case ADAMANTITE_CHAIN_MAIL_BODY:
				newId = ItemId.ADAMANTITE_CHAIN_MAIL_TOP.id();
				break;
			case RUNE_CHAIN_MAIL_BODY:
				newId = ItemId.RUNE_CHAIN_MAIL_TOP.id();
				break;
			case DRAGON_SCALE_MAIL:
				newId = ItemId.DRAGON_SCALE_MAIL_TOP.id();
				break;
			default:
				break;
		}
		return newId;
	}

	private boolean isExchangeable(final Item item) {
		final boolean isAuthenticItem = Functions.inArray(item.getCatalogId(), ItemId.BRONZE_PLATE_MAIL_TOP.id(), ItemId.IRON_PLATE_MAIL_TOP.id(), ItemId.STEEL_PLATE_MAIL_TOP.id(),
			ItemId.BLACK_PLATE_MAIL_TOP.id(), ItemId.MITHRIL_PLATE_MAIL_TOP.id(), ItemId.ADAMANTITE_PLATE_MAIL_TOP.id(), ItemId.RUNE_PLATE_MAIL_TOP.id(),
			ItemId.BRONZE_PLATE_MAIL_BODY.id(), ItemId.IRON_PLATE_MAIL_BODY.id(), ItemId.STEEL_PLATE_MAIL_BODY.id(),
			ItemId.BLACK_PLATE_MAIL_BODY.id(), ItemId.MITHRIL_PLATE_MAIL_BODY.id(), ItemId.ADAMANTITE_PLATE_MAIL_BODY.id(), ItemId.RUNE_PLATE_MAIL_BODY.id(),
			ItemId.BRONZE_PLATED_SKIRT.id(), ItemId.IRON_PLATED_SKIRT.id(), ItemId.STEEL_PLATED_SKIRT.id(),
			ItemId.BLACK_PLATED_SKIRT.id(), ItemId.MITHRIL_PLATED_SKIRT.id(), ItemId.ADAMANTITE_PLATED_SKIRT.id(), ItemId.RUNE_SKIRT.id(),
			ItemId.BRONZE_PLATE_MAIL_LEGS.id(), ItemId.IRON_PLATE_MAIL_LEGS.id(), ItemId.STEEL_PLATE_MAIL_LEGS.id(),
			ItemId.BLACK_PLATE_MAIL_LEGS.id(), ItemId.MITHRIL_PLATE_MAIL_LEGS.id(), ItemId.ADAMANTITE_PLATE_MAIL_LEGS.id(), ItemId.RUNE_PLATE_MAIL_LEGS.id(),
			ItemId.DRAGON_PLATE_MAIL_BODY.id(), ItemId.DRAGON_PLATE_MAIL_TOP.id(), ItemId.DRAGON_PLATE_MAIL_LEGS.id(), ItemId.DRAGON_PLATED_SKIRT.id());

		boolean isChainmail = false;
		if (Functions.config().WANT_CUSTOM_SPRITES) {
			isChainmail = Functions.inArray(item.getCatalogId(), ItemId.BRONZE_CHAIN_MAIL_TOP.id(), ItemId.IRON_CHAIN_MAIL_TOP.id(),
				ItemId.STEEL_CHAIN_MAIL_TOP.id(), ItemId.BLACK_CHAIN_MAIL_TOP.id(), ItemId.MITHRIL_CHAIN_MAIL_TOP.id(), ItemId.ADAMANTITE_CHAIN_MAIL_TOP.id(),
				ItemId.RUNE_CHAIN_MAIL_TOP.id(), ItemId.DRAGON_SCALE_MAIL_TOP.id(), ItemId.BRONZE_CHAIN_MAIL_BODY.id(), ItemId.IRON_CHAIN_MAIL_BODY.id(),
				ItemId.STEEL_CHAIN_MAIL_BODY.id(), ItemId.BLACK_CHAIN_MAIL_BODY.id(), ItemId.MITHRIL_CHAIN_MAIL_BODY.id(), ItemId.ADAMANTITE_CHAIN_MAIL_BODY.id(),
				ItemId.RUNE_CHAIN_MAIL_BODY.id(), ItemId.DRAGON_SCALE_MAIL.id());
		}

		return isAuthenticItem || isChainmail;
	}

}
