package com.example.modjamapril2026.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

import javax.annotation.Nonnull;

/**
 * /mja2 help - Show available commands
 */
public class HelpSubCommand extends CommandBase {

    public HelpSubCommand() {
        super("help", "Show available commands");
    }

    @Override
    protected boolean canGeneratePermission() {
        return false;
    }

    @Override
    protected void executeSync(@Nonnull CommandContext context) {
        context.sendMessage(Message.raw(""));
        context.sendMessage(Message.raw("=== mod jam april 2026 Commands ==="));
        context.sendMessage(Message.raw("/mja2 help - Show this help message"));
        context.sendMessage(Message.raw("/mja2 info - Show plugin information"));
        context.sendMessage(Message.raw("/mja2 reload - Reload configuration"));
        context.sendMessage(Message.raw("/mja2 ui - Open the dashboard UI"));
        context.sendMessage(Message.raw("========================"));
    }
}