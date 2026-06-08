package com.spectrasonic.smpcore;

import com.spectrasonic.Utils.CommandUtils;
import com.spectrasonic.Utils.MessageUtils;
import com.spectrasonic.smpcore.managers.CommandManager;
import com.spectrasonic.smpcore.managers.ConfigManager;
import com.spectrasonic.smpcore.managers.EventManager;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Initialize managers
        ConfigManager configManager = new ConfigManager(this);
        new CommandManager(this, configManager);

        new EventManager(this, configManager);
        CommandUtils.setPlugin(this);
        MessageUtils.sendStartupMessage(this);

    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }
}