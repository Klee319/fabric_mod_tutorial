package com.github.klee.tutorial.mixin;


import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "startServer", at = @At("HEAD"))
    private static void tutorial$startServer(Function<Thread, ?> serverFactory, CallbackInfoReturnable<?> cir) {
        System.out.println("tutorial$startServer");
    }

}
