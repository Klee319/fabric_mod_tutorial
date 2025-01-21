package com.github.klee.tutorial.item;

import com.github.klee.tutorial.Tutorial;
import com.github.klee.tutorial.item.tool.obsidianPickaxe;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static final Item OB_PICKAXE = register(new obsidianPickaxe(), "obsidian_pickaxe", ItemGroups.TOOLS);
    public static Item register(Item item, String id, RegistryKey<ItemGroup> group) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(Tutorial.MOD_ID, id);
        Item RegisteredItem = Registry.register(Registries.ITEM, itemID, item);
        ItemGroupEvents.modifyEntriesEvent(group).register((entries -> entries.add(RegisteredItem)));
        // Return the registered item!
        return RegisteredItem;
    }

    public static void initialize() {
    }
}
