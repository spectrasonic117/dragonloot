package com.spectrasonic.smpcore.listeners;

import com.spectrasonic.smpcore.managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Shulker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShulkerDeathListener implements Listener {

    private final ConfigManager configManager;

    public ShulkerDeathListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    // Este evento se ejecuta cuando un shulker muere
    @EventHandler
    public void onShulkerDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Shulker && configManager.isShulkerDeathEnabled()) {
            // Asegurarse de que se dropeen dos Shulker Shells
            event.getDrops().removeIf(item -> item.getType() == Material.SHULKER_SHELL);
            event.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2)); // Dropear dos en lugar de uno
        }
    }
}