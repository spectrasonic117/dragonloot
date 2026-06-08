package com.spectrasonic.smpcore.managers;

import com.spectrasonic.smpcore.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    
    private final Main plugin;
    private FileConfiguration config;
    private File configFile;
    
    // Configuration keys for mechanics
    public static final String ENDER_DRAGON_DEATH_ENABLED = "mechanics.ender-dragon-death.enabled";
    public static final String ENDERMAN_SPAWN_ENABLED = "mechanics.enderman-spawn.enabled";
    public static final String SHULKER_DEATH_ENABLED = "mechanics.shulker-death.enabled";
    
    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        loadConfig();
        saveDefaultConfig();
    }
    
    public void loadConfig() {
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }
    
    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save config.yml: " + e.getMessage());
        }
    }
    
    public void reloadConfig() {
        loadConfig();
    }
    
    public FileConfiguration getConfig() {
        return config;
    }
    
    private void saveDefaultConfig() {
        if (!configFile.exists()) {
            config = new YamlConfiguration();
            
            // Set default values for mechanics (all enabled by default)
            config.set(ENDER_DRAGON_DEATH_ENABLED, true);
            config.set(ENDERMAN_SPAWN_ENABLED, true);
            config.set(SHULKER_DEATH_ENABLED, true);
            
            saveConfig();
        }
    }
    
    // Getter methods for mechanics
    public boolean isEnderDragonDeathEnabled() {
        return config.getBoolean(ENDER_DRAGON_DEATH_ENABLED, true);
    }
    
    public boolean isEndermanSpawnEnabled() {
        return config.getBoolean(ENDERMAN_SPAWN_ENABLED, true);
    }
    
    public boolean isShulkerDeathEnabled() {
        return config.getBoolean(SHULKER_DEATH_ENABLED, true);
    }
    
    // Setter methods for mechanics
    public void setEnderDragonDeathEnabled(boolean enabled) {
        config.set(ENDER_DRAGON_DEATH_ENABLED, enabled);
        saveConfig();
    }
    
    public void setEndermanSpawnEnabled(boolean enabled) {
        config.set(ENDERMAN_SPAWN_ENABLED, enabled);
        saveConfig();
    }
    
    public void setShulkerDeathEnabled(boolean enabled) {
        config.set(SHULKER_DEATH_ENABLED, enabled);
        saveConfig();
    }
}