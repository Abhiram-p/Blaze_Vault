package com.blazevault.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerBackupMixin {
    @Inject(method = "shutdown", at = @At("HEAD"))
    private void onServerShutdown(CallbackInfo ci) {
        System.out.println("Blaze Vault: Server is shutting down. Initiating backup...");
        // Add backup logic here.
    }
}
