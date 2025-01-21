package com.github.klee.tutorial;

import com.github.klee.tutorial.item.ItemRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Tutorial implements ModInitializer {
    public static final String MOD_ID = "tutorial";
    @Override
    public void onInitialize() {
        ItemRegister.initialize();
    }
}
