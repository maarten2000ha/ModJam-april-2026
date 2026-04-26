package com.example.modjamapril2026.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import com.example.modjamapril2026.modjamapril2026Plugin;

import javax.annotation.Nonnull;

/**
 * /mja2 info - Show plugin information
 */
public class InfoSubCommand extends CommandBase {

    public InfoSubCommand() {
        super("info", "Show plugin information");
        this.setPermissionGroup(null);
    }

    @Override
    protected boolean canGeneratePermission() {
        return false;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext context) {
        modjamapril2026Plugin plugin = modjamapril2026Plugin.getInstance();

        context.sendMessage(Message.raw(""));
        context.sendMessage(Message.raw("=== mod jam april 2026 Info ==="));
        context.sendMessage(Message.raw("Name: mod jam april 2026"));
        context.sendMessage(Message.raw("Version: 0.0.1"));
        context.sendMessage(Message.raw("Author: maarten2000ha"));
        context.sendMessage(Message.raw("Status: " + (plugin != null ? "Running" : "Not loaded")));
        context.sendMessage(Message.raw("===================="));
    }
}