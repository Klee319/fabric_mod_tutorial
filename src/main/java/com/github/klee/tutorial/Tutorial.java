package com.github.klee.tutorial;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Tutorial implements ModInitializer {
    public static final String MODID = "tutorial";
    public static Item CUSTOM_ITEM2 = new customItem(new Item.Settings());
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MODID,"obsidian_pickaxe"),OB_PICKAXE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries -> entries.add(OB_PICKAXE)));
    }
}
