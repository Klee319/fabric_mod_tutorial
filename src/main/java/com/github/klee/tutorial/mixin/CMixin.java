package com.github.klee.tutorial.mixin;


import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class CMixin {
    @Inject(method = "mouseClicked", at = @At("HEAD"))
    private static void tutorial$mouseClicked(double mouseX, double mouseY, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("tutorial$mouseClicked");
    }

}
