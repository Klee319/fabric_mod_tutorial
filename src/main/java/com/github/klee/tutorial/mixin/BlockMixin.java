package com.github.klee.tutorial.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
    private static void tutorial$dropStacks(BlockState state, World world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack tool, CallbackInfo ci) {
        System.out.println("isClient: " + world.isClient);

        System.out.println("tutorial$dropStacks");
        System.out.println("isCancelled: " + ci.isCancelled());
        System.out.println("isCancellable: " + ci.isCancellable());

        if (entity != null) {
            System.out.println("entity: " + entity.getType().getName() + " / " + entity.getDisplayName());
        } else {
            System.out.println("entity: null");
        }

        System.out.println("pos: " + pos);
        System.out.println("block: " + state.getBlock().getName());
        System.out.println("tool:" + tool);


        ci.cancel();

    }

}
