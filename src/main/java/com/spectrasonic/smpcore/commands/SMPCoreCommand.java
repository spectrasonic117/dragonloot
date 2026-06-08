package com.spectrasonic.smpcore.commands;

import com.spectrasonic.smpcore.managers.ConfigManager;
import com.spectrasonic.smpcore.managers.MessagesManager;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.command.CommandSender;

@CommandAlias("smpcore")
public class SMPCoreCommand extends BaseCommand {

    private final MessagesManager messagesManager;
    private final ConfigManager configManager;

    public SMPCoreCommand(ConfigManager configManager, MessagesManager messagesManager) {
        this.messagesManager = messagesManager;
        this.configManager = configManager;
    }

    @Default
    @CommandPermission("smpcore.command")
    @Description("SMPCore plugin commands")
    public void onDefault(CommandSender sender) {
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_HEADER);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_RELOAD);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_MECHANIC_TOGGLE);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_MECHANICS_HEADER);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_ENDERDRAGON);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_ENDERMAN);
        messagesManager.sendMessage(sender, MessagesManager.COMMAND_LIST_SHULKER);
    }

    @Subcommand("reload")
    @CommandPermission("smpcore.command.reload")
    @Description("Reload plugin configuration")
    public void onReload(CommandSender sender) {
        configManager.reloadConfig();
        messagesManager.reloadMessages();
        messagesManager.sendMessage(sender, MessagesManager.RELOADED);
    }

    @Subcommand("enderdragon")
    @CommandPermission("smpcore.command.enderdragon")
    @Description("Toggle Ender Dragon death mechanic")
    @CommandCompletion("@bools")
    public void onEnderDragonToggle(CommandSender sender, @Values("true|false") boolean enabled) {
        configManager.setEnderDragonDeathEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        messagesManager.sendMessage(sender, MessagesManager.MECHANIC_TOGGLED, "%type%", "Ender Dragon death",
                "%status%", status);
    }

    @Subcommand("enderman")
    @CommandPermission("smpcore.command.enderman")
    @Description("Toggle Enderman spawn mechanic")
    @CommandCompletion("@bools")
    public void onEndermanToggle(CommandSender sender, @Values("true|false") boolean enabled) {
        configManager.setEndermanSpawnEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        messagesManager.sendMessage(sender, MessagesManager.MECHANIC_TOGGLED, "%type%", "Enderman spawn", "%status%",
                status);
    }

    @Subcommand("shulker")
    @CommandPermission("smpcore.command.shulker")
    @Description("Toggle Shulker death mechanic")
    @CommandCompletion("@bools")
    public void onShulkerToggle(CommandSender sender, @Values("true|false") boolean enabled) {
        configManager.setShulkerDeathEnabled(enabled);
        String status = enabled ? "&#00FF00enabled" : "&#FF0000disabled";
        messagesManager.sendMessage(sender, MessagesManager.MECHANIC_TOGGLED, "%type%", "Shulker death", "%status%",
                status);
    }

    @CommandPermission("smpcore.command")
    public void onNoPermission(CommandSender sender) {
        messagesManager.sendMessage(sender, MessagesManager.NO_PERMISSION);
    }
}