package com.github.klee.tutorial.item.tool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class obsidianPickaxe extends PickaxeItem  {
    private static final int attackDamage = 7;
    private static final float attackSpeed = 0.2F;

    public obsidianPickaxe() {
        super(new obsidianPickaxeToolMaterial(), attackDamage, attackSpeed, new Settings());
    }



    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity player) {
            //minerのインベントリに掘ったアイテムを追加
            for (ItemStack drop : Block.getDroppedStacks(state, (ServerWorld) world, pos, null, player, stack)) {
                if (!player.getInventory().insertStack(drop)) {
                    player.dropItem(drop, false);
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

}
