package com.example.modjamapril2026;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.logger.HytaleLogger;

import com.example.modjamapril2026.commands.modjamapril2026PluginCommand;
import com.example.modjamapril2026.listeners.PlayerListener;

import javax.annotation.Nonnull;
import java.util.logging.Level;

/**
 * mod jam april 2026 - A Hytale server plugin.
 */
public class modjamapril2026Plugin extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private static modjamapril2026Plugin instance;

    public modjamapril2026Plugin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
    }

    /**
     * Get the plugin instance.
     * @return The plugin instance
     */
    public static modjamapril2026Plugin getInstance() {
        return instance;
    }

    @Override
    protected void setup() {
        LOGGER.at(Level.INFO).log("[mod jam April 2026] Setting up...");

        // Register commands
        registerCommands();

        // Register event listeners
        registerListeners();

        LOGGER.at(Level.INFO).log("[mod jam April 2026] Setup complete!");
    }

    /**
     * Register plugin commands.
     */
    private void registerCommands() {
        try {
            getCommandRegistry().registerCommand(new modjamapril2026PluginCommand());
            LOGGER.at(Level.INFO).log("[mod jam april 2026] Registered /mja2 command");
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[mod jam april 2026] Failed to register commands");
        }
    }

    /**
     * Register event listeners.
     */
    private void registerListeners() {
        EventRegistry eventBus = getEventRegistry();

        try {
            new PlayerListener().register(eventBus);
            LOGGER.at(Level.INFO).log("[mod jam April 2026] Registered player event listeners");
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[mod jam April 2026] Failed to register listeners");
        }
    }

    @Override
    protected void start() {
        LOGGER.at(Level.INFO).log("[mod jam April 2026] Started!");
        LOGGER.at(Level.INFO).log("[mod jam April 2026] Use /mja2 help for commands");
    }

    @Override
    protected void shutdown() {
        LOGGER.at(Level.INFO).log("[mod jam April 2026] Shutting down...");
        instance = null;
    }
}