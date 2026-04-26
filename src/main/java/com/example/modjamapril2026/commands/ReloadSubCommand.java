package com.example.modjamapril2026.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import com.example.modjamapril2026.modjamapril2026Plugin;

import javax.annotation.Nonnull;

/**
 * /mja2 reload - Reload plugin configuration
 */
public class ReloadSubCommand extends CommandBase {

    public ReloadSubCommand() {
        super("reload", "Reload plugin configuration");
        this.setPermissionGroup(null);
    }

    @Override
    protected boolean canGeneratePermission() {
        return false;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext context) {
        modjamapril2026Plugin plugin = modjamapril2026Plugin.getInstance();

        if (plugin == null) {
            context.sendMessage(Message.raw("Error: Plugin not loaded"));
            return;
        }

        context.sendMessage(Message.raw("Reloading mod jam april 2026..."));

        // TODO: Add your reload logic here
        // Example: Reload config files, refresh caches, etc.

        context.sendMessage(Message.raw("mod jam april 2026 reloaded successfully!"));
    }
}