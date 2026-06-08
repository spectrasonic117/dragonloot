package com.spectrasonic.smpcore.managers;

import org.bukkit.plugin.java.JavaPlugin;

import com.spectrasonic.smpcore.listeners.EnderDragonDeathListener;
import com.spectrasonic.smpcore.listeners.EndermanSpawnListener;
import com.spectrasonic.smpcore.listeners.ShulkerDeathListener;

public class EventManager {

    public EventManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new EnderDragonDeathListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ShulkerDeathListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EndermanSpawnListener(), plugin);
    }
}
