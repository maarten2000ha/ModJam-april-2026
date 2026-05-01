package com.example.modjamapril2026.commands;

import com.hypixel.hytale.server.core.command.system.basecommands.AbstractCommandCollection;

/**
 * Main command for mod jam april 2026 plugin.
 *
 * Usage:
 * - /mja2 help - Show available commands
 * - /mja2 info - Show plugin information
 * - /mja2 reload - Reload plugin configuration
 * - /mja2 ui - Open the plugin dashboard
 */
public class modjamapril2026PluginCommand extends AbstractCommandCollection {

    public modjamapril2026PluginCommand() {
        super("mja", "mod jam april 2026 plugin commands");

        // Add subcommands
        this.addSubCommand(new HelpSubCommand());
        this.addSubCommand(new InfoSubCommand());
        this.addSubCommand(new ReloadSubCommand());
        this.addSubCommand(new AddComponentCommand());
    }

    @Override
    protected boolean canGeneratePermission() {
        return false; // No permission required for base command
    }
}