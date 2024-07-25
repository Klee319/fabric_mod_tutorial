package com.github.klee.tutorial.mixin;

import com.github.klee.tutorial.Tutorial;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "createPlayerAttributes", at = @At("RETURN"))
    private static void addCustomAttribute(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue().add(Tutorial.TEST_V_ATTRIBUTE);
        cir.getReturnValue().add(Tutorial.TEST_V2_ATTRIBUTE);
    }

}
