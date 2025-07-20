package com.spectrasonic.dragonloot.managers;

import com.spectrasonic.dragonloot.listeners.DragonLootListener;
import com.spectrasonic.dragonloot.listeners.EndermanSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

    public EventManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new DragonLootListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EndermanSpawnListener(), plugin);
    }
}
