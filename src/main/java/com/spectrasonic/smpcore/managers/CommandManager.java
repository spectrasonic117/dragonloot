package com.spectrasonic.smpcore.managers;

import com.spectrasonic.smpcore.Main;
import com.spectrasonic.smpcore.commands.SMPCoreCommand;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommandManager {

    private final Main plugin;
    private final PaperCommandManager acfManager;

    public CommandManager(Main plugin, ConfigManager configManager, MessagesManager messagesManager) {
        this.plugin = plugin;
        this.acfManager = new PaperCommandManager(plugin);
        registerCommands(configManager, messagesManager);
    }

    private void registerCommands(ConfigManager configManager, MessagesManager messagesManager) {
        acfManager.registerCommand(new SMPCoreCommand(plugin, configManager, messagesManager));
    }
}