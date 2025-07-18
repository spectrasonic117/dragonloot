package com.spectrasonic.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessageUtils {

    private static final JavaPlugin plugin = JavaPlugin.getProvidingPlugin(MessageUtils.class);
    public static final String DIVIDER = "&7----------------------------------------";
    public static final String PREFIX = "&7[&6" + plugin.getPluginMeta().getName() + "&7] &6»";

    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("&#([0-9a-fA-F]{6})");

    private MessageUtils() {
        // Private constructor to prevent instantiation
    }

    public static String formatMessage(String message) {
        // Handle hex colors (e.g., &#RRGGBB)
        Matcher hexMatcher = HEX_COLOR_PATTERN.matcher(message);
        while (hexMatcher.find()) {
            String hexColor = hexMatcher.group(1);
            message = message.replace(hexMatcher.group(), ChatColor.of("#" + hexColor) + "");
        }

        // Translate standard Minecraft color codes (e.g., &a, &l)
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(formatMessage(PREFIX + message));
    }

    public static void sendConsoleMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(formatMessage(PREFIX + message));
    }

    public static void sendPermissionMessage(CommandSender sender) {
        sender.sendMessage(formatMessage(PREFIX + "&cYou do not have permission to use this command!"));
    }

    public static void sendStartupMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "&f" + plugin.getPluginMeta().getName() + " &aPlugin Enabled!",
                PREFIX + "&bVersion: &f" + plugin.getPluginMeta().getVersion(),
                PREFIX + "&fDeveloped by: &c" + plugin.getPluginMeta().getAuthors(),
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(formatMessage(message));
        }
    }

    public static void sendVeiMessage(JavaPlugin plugin) {
        String[] messages = {
                PREFIX + "&8⣇⣿⠘⣿⣿⣿⡿⡿⣟⣟⢟⢟⢝⠵⡝⣿⡿⢂⣼⣿⣷⣌⠩⡫⡻⣝⠹⢿⣿⣷",
                PREFIX + "&8⡆⣿⣆⠱⣝⡵⣝⠂⠙⣿⢕⢕⢕⢕⢝⣥⢒⠅⣿⣿⣿⡿⣳⣌⠪⡪⣡⢑⢝⣇",
                PREFIX + "&8⡆⣿⣿⣦⠹⣳⣳⣕⢅⠈⢗⢕⢕⢕⢕⢕⢈⢆⠟⠋⠉⠁⠉⠉⠁⠈⠼⢐⢕⢽",
                PREFIX + "&8⡗⢰⣶⣶⣦⣝⢝⢕⢕⠅⡆⢕⢕⢕⢕⢕⣴⠏⣠⡶⠛⡉⡉⡛⢶⣦⡀⠐⣕⢕",
                PREFIX + "&8⡝⡄⢻⢟⣿⣿⣷⣕⣕⣅⣿⣔⣕⣵⣵⣿⣿⢠⣿⢠⣮⡈⣌⠨⠅⠹⣷⡀⢱⢕",
                PREFIX + "&8⡝⡵⠟⠈⢀⣀⣀⡀⠉⢿⣿⣿⣿⣿⣿⣿⣿⣼⣿⢈⡋⠴⢿⡟⣡⡇⣿⡇⡀⢕",
                PREFIX + "&8⡝⠁⣠⣾⠟⡉⡉⡉⠻⣦⣻⣿⣿⣿⣿⣿⣿⣿⣿⣧⠸⣿⣦⣥⣿⡇⡿⣰⢗⢄",
                PREFIX + "&8⠁⢰⣿⡏⣴⣌⠈⣌⠡⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣬⣉⣉⣁⣄⢖⢕⢕⢕",
                PREFIX + "&8⡀⢻⣿⡇⢙⠁⠴⢿⡟⣡⡆⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣵⣵⣿",
                PREFIX + "&8⡻⣄⣻⣿⣌⠘⢿⣷⣥⣿⠇⣿⣿⣿⣿⣿⣿⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                PREFIX + "&8⣷⢄⠻⣿⣟⠿⠦⠍⠉⣡⣾⣿⣿⣿⣿⣿⣿⢸⣿⣦⠙⣿⣿⣿⣿⣿⣿⣿⣿⠟",
                PREFIX + "&8⡕⡑⣑⣈⣻⢗⢟⢞⢝⣻⣿⣿⣿⣿⣿⣿⣿⠸⣿⠿⠃⣿⣿⣿⣿⣿⣿⡿⠁⣠",
                PREFIX + "&8⡝⡵⡈⢟⢕⢕⢕⢕⣵⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⠿⠋⣀⣈⠙",
                PREFIX + "&8⡝⡵⡕⡀⠑⠳⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⢉⡠⡲⡫⡪⡪⡣",
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(formatMessage(message));
        }
    }

    public static void sendBroadcastMessage(String message) {
        Bukkit.getOnlinePlayers().forEach(player ->
                player.sendMessage(formatMessage(message))
        );
    }

    public static void sendShutdownMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "&c" + plugin.getPluginMeta().getName() + " plugin Disabled!",
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(formatMessage(message));
        }
    }

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        // Note: Bukkit's Player.sendTitle method handles color codes directly.
        // We need to convert MiniMessage format to ChatColor format for title and subtitle.
        player.sendTitle(formatMessage(title), formatMessage(subtitle), fadeIn * 20, stay * 20, fadeOut * 20);
    }

    public static void sendActionBar(Player player, String message) {
        player.sendActionBar(formatMessage(message));
    }

    public static void broadcastTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        Bukkit.getOnlinePlayers().forEach(player ->
                player.sendTitle(formatMessage(title), formatMessage(subtitle), fadeIn * 20, stay * 20, fadeOut * 20));
    }

    // Uso - Send Title to players
    // MiniMessageUtils.sendTitle(player, 
    //     "&6¡Alerta!", 
    //     "&cMensaje importante", 
    //     2, 40, 2
    // );

    public static void broadcastActionBar(String message) {
        Bukkit.getOnlinePlayers().forEach(player ->
                player.sendActionBar(formatMessage(message)));
    }

    // Uso Broadcast ActionBAR
    // MiniMessageUtils.broadcastActionBar("&e¡Evento e…special activado!");
}
