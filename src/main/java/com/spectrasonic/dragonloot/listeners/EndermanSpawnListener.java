package com.spectrasonic.dragonloot.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.Location;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EndermanSpawnListener implements Listener {

    private static final double SPAWN_CHANCE = 0.75;
    private static final List<Material> VALID_BLOCKS = Arrays.asList(
        Material.PURPUR_BLOCK,
        Material.PURPUR_PILLAR,
        Material.PURPUR_STAIRS
    );
    
    private final Random random = new Random();

    @EventHandler
    public void onEndermanSpawn(CreatureSpawnEvent event) {
        // Verificar si es un spawn natural de enderman
        if (event.getEntityType() != EntityType.ENDERMAN || 
            event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) {
            return;
        }

        Enderman enderman = (Enderman) event.getEntity();
        Location location = enderman.getLocation();
        
        // Verificar si está parado en un bloque válido
        Material blockBelow = location.getBlock().getRelative(0, -1, 0).getType();
        
        if (!VALID_BLOCKS.contains(blockBelow)) {
            return;
        }

        // 75% de probabilidad de reemplazar por shulker
        if (random.nextDouble() <= SPAWN_CHANCE) {
            event.setCancelled(true);
            
            // Spawnear shulker en la misma ubicación
            Shulker shulker = (Shulker) location.getWorld().spawnEntity(
                location, 
                EntityType.SHULKER
            );
            
            // Copiar algunas propiedades del enderman original
            shulker.setPersistent(enderman.isPersistent());
        }
    }
}
