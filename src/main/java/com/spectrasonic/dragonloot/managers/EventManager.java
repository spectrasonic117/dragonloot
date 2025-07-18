package com.spectrasonic.dragonloot.managers;

import com.spectrasonic.dragonloot.listeners.DragonLootListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

    public EventManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new DragonLootListener(), plugin);
    }
}
