package com.spectrasonic.smpcore.managers;

import org.bukkit.plugin.java.JavaPlugin;

import com.spectrasonic.smpcore.listeners.DragonLootListener;
import com.spectrasonic.smpcore.listeners.EndermanSpawnListener;

public class EventManager {

    public EventManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new DragonLootListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EndermanSpawnListener(), plugin);
    }
}
