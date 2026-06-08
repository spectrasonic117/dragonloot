package com.spectrasonic.smpcore.listeners;

import com.spectrasonic.smpcore.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.EnderDragon;
import org.bukkit.inventory.ItemStack;

public class EnderDragonDeathListener implements Listener {

    private final ConfigManager configManager;

    public EnderDragonDeathListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    // Este evento se ejecuta cuando un dragón de End muere
    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof EnderDragon && configManager.isEnderDragonDeathEnabled()) {
            // Dar la experiencia del dragón (12500 XP)

            // Dropear la Elytra
            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                    new ItemStack(Material.ELYTRA));

            // Evitar el drop predeterminado (la perla del dragón y el resto de lo que daría
            // el dragón)
            event.getDrops().clear();
        }
    }
}