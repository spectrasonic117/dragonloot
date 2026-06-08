package com.spectrasonic.smpcore.managers;

import com.spectrasonic.smpcore.Main;
import com.spectrasonic.smpcore.commands.SMPCoreCommand;
import co.aikar.commands.PaperCommandManager;

public class CommandManager {

    private final Main plugin;
    private final PaperCommandManager acfManager;

    public CommandManager(Main plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.acfManager = new PaperCommandManager(plugin);
        registerCommands(configManager);
    }

    private void registerCommands(ConfigManager configManager) {
        acfManager.registerCommand(new SMPCoreCommand(plugin, configManager));
    }

    public PaperCommandManager getAcfManager() {
        return acfManager;
    }
}