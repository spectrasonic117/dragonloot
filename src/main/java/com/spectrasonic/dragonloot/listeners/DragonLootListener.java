package com.spectrasonic.dragonloot.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Shulker;
import org.bukkit.inventory.ItemStack;

public class DragonLootListener implements Listener {

    // Este evento se ejecuta cuando un dragón de End muere
    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof EnderDragon) {
            // Dar la experiencia del dragón (12500 XP)

            // Dropear la Elytra
            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(Material.ELYTRA));

            // Evitar el drop predeterminado (la perla del dragón y el resto de lo que daría el dragón)
            event.getDrops().clear();
        }
    }

    // Este evento se ejecuta cuando un shulker muere
    @EventHandler
    public void onShulkerDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Shulker) {
            // Asegurarse de que se dropeen dos Shulker Shells
            event.getDrops().removeIf(item -> item.getType() == Material.SHULKER_SHELL);
            event.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2)); // Dropear dos en lugar de uno
        }
    }
}
