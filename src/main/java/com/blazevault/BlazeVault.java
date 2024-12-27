package com.blazevault;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.MutableText;

import static net.minecraft.server.command.CommandManager.literal;

public class BlazeVault implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("BlazeVault mod initialized!");
    }

    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("vault")
            .then(literal("backup")
                .executes(BlazeVault::executeBackupCommand)
            )
            .then(literal("help")
                .executes(BlazeVault::executeHelpCommand)
            )
        );
    }

    private static int executeBackupCommand(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("§6BlazeVault: Backup process has started!"), false);
        // Add logic to start the backup process here
        return 1;
    }

    private static int executeHelpCommand(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("§6BlazeVault: Use §e/vault backup §6to start a backup, or §e/vault help §6for commands!"), false);
        return 1;
    }
}

@Override
public void onInitialize() {
    System.out.println("BlazeVault mod initialized!");

    // Register backup command
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
        dispatcher.register(literal("backup")
            .then(literal("start").executes(context -> {
                BackupManager.createBackup();
                context.getSource().sendFeedback(Text.literal("Backup started!"), false);
                return 1;
            }))
        );
    });
}