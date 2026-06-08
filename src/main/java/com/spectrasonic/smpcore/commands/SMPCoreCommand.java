package com.spectrasonic.smpcore.commands;

import com.spectrasonic.smpcore.Main;
import com.spectrasonic.smpcore.managers.ConfigManager;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.spectrasonic.Utils.MessageUtils;
import org.bukkit.command.CommandSender;

@CommandAlias("smpcore")
@SuppressWarnings("unused")
public class SMPCoreCommand extends BaseCommand {

    private final Main plugin;
    private final ConfigManager configManager;

    public SMPCoreCommand(Main plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @Default
    @CommandPermission("smpcore.command")
    @Description("SMPCore plugin commands")
    public void onDefault(CommandSender sender) {
        MessageUtils.sendMessage(sender, "&#FFD700=== SMPCore Commands ===");
        MessageUtils.sendMessage(sender, "&#00FFFF/smpcore reload &8- Reload plugin configuration");
        MessageUtils.sendMessage(sender, "&#00FFFF/smpcore <mechanic> <true|false> &8- Enable/disable mechanics");
        MessageUtils.sendMessage(sender, "&#FFD700Available mechanics:");
        MessageUtils.sendMessage(sender, "&#00FFFF  enderdragon &8- Ender Dragon death mechanic");
        MessageUtils.sendMessage(sender, "&#00FFFF  enderman &8- Enderman spawn mechanic");
        MessageUtils.sendMessage(sender, "&#00FFFF  shulker &8- Shulker death mechanic");
    }

    @Subcommand("reload")
    @CommandPermission("smpcore.command.reload")
    @Description("Reload plugin configuration")
    public void onReload(CommandSender sender) {
        configManager.reloadConfig();
        MessageUtils.sendMessage(sender, "&#00FF00SMPCore configuration reloaded successfully!");
    }

    @Subcommand("enderdragon")
    @CommandPermission("smpcore.command.enderdragon")
    @Description("Toggle Ender Dragon death mechanic")
    public void onEnderDragonToggle(CommandSender sender, boolean enabled) {
        configManager.setEnderDragonDeathEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        MessageUtils.sendMessage(sender, "&#00FFFFEnder Dragon death mechanic is now " + status + "!");
    }

    @Subcommand("enderman")
    @CommandPermission("smpcore.command.enderman")
    @Description("Toggle Enderman spawn mechanic")
    public void onEndermanToggle(CommandSender sender, boolean enabled) {
        configManager.setEndermanSpawnEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        MessageUtils.sendMessage(sender, "&#00FFFFEnderman spawn mechanic is now " + status + "!");
    }

    @Subcommand("shulker")
    @CommandPermission("smpcore.command.shulker")
    @Description("Toggle Shulker death mechanic")
    public void onShulkerToggle(CommandSender sender, boolean enabled) {
        configManager.setShulkerDeathEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        MessageUtils.sendMessage(sender, "&#00FFFFShulker death mechanic is now " + status + "!");
    }

    @CommandPermission("smpcore.command")
    public void onNoPermission(CommandSender sender) {
        MessageUtils.sendPermissionMessage(sender);
    }
}