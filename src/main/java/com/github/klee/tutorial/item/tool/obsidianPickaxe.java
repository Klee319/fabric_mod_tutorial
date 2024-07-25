package com.github.klee.tutorial.item.tool;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class obsidianPickaxe extends PickaxeItem {
    public obsidianPickaxe(Settings settings) {
        super(new ObsidianPickaxeToolMaterial(), 0, 0, new Item.Settings());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        MinecraftServer server = attacker.getServer();
        server.sendMessage(Text.literal("postHit : target=" + target + " : attacker=" + attacker));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        MinecraftServer server = world.getServer();
        server.sendMessage(Text.literal("postMine : world=" + world.getDimensionKey().getRegistry().getNamespace() + " : miner=" + miner));
        return super.postMine(stack, world, state, pos, miner);
    }

}
