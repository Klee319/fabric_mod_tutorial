package com.github.klee.tutorial;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Tutorial implements ModInitializer {
    public static final String MODID = "tutorial";
    public static Item CUSTOM_ITEM2 = new customItem(new Item.Settings());

    public final static EntityAttribute TEST_V_ATTRIBUTE = new ClampedEntityAttribute(
            "", 1, -1024, 1024).setTracked(true);
    public final static EntityAttribute TEST_V2_ATTRIBUTE = new ClampedEntityAttribute(
            "", 2, -1024, 1024).setTracked(true);

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MODID,"obsidian_pickaxe"),OB_PICKAXE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries -> entries.add(OB_PICKAXE)));

        Registry.register(Registries.ATTRIBUTE, new Identifier(MODID, "test_v"), TEST_V_ATTRIBUTE);
        Registry.register(Registries.ATTRIBUTE, new Identifier(MODID, "test_v2"), TEST_V2_ATTRIBUTE);
    }
}
