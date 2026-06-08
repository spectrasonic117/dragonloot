package com.spectrasonic.smpcore.managers;

import com.spectrasonic.smpcore.Main;
import com.spectrasonic.Utils.MessageUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Getter
public class MessagesManager {

    private final Main plugin;
    private FileConfiguration messagesConfig;
    private File messagesFile;

    private static final String MESSAGES_PATH = "messages.yml";

    public static final String PREFIX = "prefix";
    public static final String DIVIDER = "divider";

    public static final String RELOADED = "reloaded";
    public static final String NO_PERMISSION = "no-permission";

    public static final String COMMAND_LIST_HEADER = "command-list-header";
    public static final String COMMAND_LIST_RELOAD = "command-list-reload";
    public static final String COMMAND_LIST_MECHANIC_TOGGLE = "command-list-mechanic-toggle";
    public static final String COMMAND_LIST_MECHANICS_HEADER = "command-list-mechanics-header";
    public static final String COMMAND_LIST_ENDERDRAGON = "command-list-enderdragon";
    public static final String COMMAND_LIST_ENDERMAN = "command-list-enderman";
    public static final String COMMAND_LIST_SHULKER = "command-list-shulker";

    public static final String MECHANIC_TOGGLED = "mechanic-toggled";

    public void loadMessages() {
        messagesFile = new File(plugin.getDataFolder(), MESSAGES_PATH);
        if (!messagesFile.exists()) {
            plugin.saveResource(MESSAGES_PATH, false);
        }
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public void saveMessages() {
        try {
            messagesConfig.save(messagesFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save messages.yml: " + e.getMessage());
        }
    }

    public void reloadMessages() {
        loadMessages();
    }

    public String getMessage(String key) {
        String path = "messages." + key;
        String message = messagesConfig.getString(path, key);
        return message != null ? message : key;
    }

    public void sendMessage(CommandSender sender, String key) {
        MessageUtils.sendMessage(sender, getMessage(key));
    }

    public void sendMessage(CommandSender sender, String key, String placeholder, String value) {
        MessageUtils.sendMessage(sender, getMessage(key).replace(placeholder, value));
    }

    public void sendMessage(CommandSender sender, String key, String... placeholders) {
        String message = getMessage(key);
        for (int i = 0; i < placeholders.length; i += 2) {
            if (i + 1 < placeholders.length) {
                message = message.replace(placeholders[i], placeholders[i + 1]);
            }
        }
        MessageUtils.sendMessage(sender, message);
    }
}