package com.blazevault;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class BlazeVault implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("BlazeVault Mod Initialized!");

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            registerVaultCommand(dispatcher);
        });
    }

    private void registerVaultCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("vault")
                .then(CommandManager.literal("help")
                        .executes(context -> {
                            context.getSource().sendFeedback(Text.literal(
                                    """
                                    §6BlazeVault Commands:
                                    §e/vault backup <name> §7- Create a new backup.
                                    §e/vault restore <name> §7- Restore a specific backup.
                                    §e/vault list §7- List all available backups.
                                    §e/vault status §7- Show the current backup/restore status.
                                    §e/vault health-check §7- Check server and backup health.
                                    """), false);
                            return 1;
                        }))
                .executes(context -> {
                    context.getSource().sendFeedback(Text.literal("§6BlazeVault: Use §e/vault help §6for available commands!"), false);
                    return 1;
                }));
    }
}