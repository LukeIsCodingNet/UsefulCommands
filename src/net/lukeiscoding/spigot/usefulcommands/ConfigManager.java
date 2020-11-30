package net.lukeiscoding.spigot.usefulcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static final UsefulCommands plugin = UsefulCommands.getPlugin(UsefulCommands.class);

    private File messagesFile;

    private FileConfiguration messagesConfig;

    public void setup() {
        // check if we do not have a data folder
        if (!plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder().exists()) {
            plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder().mkdir();
        }

        messagesFile = new File(plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder(), "messages.yml");

        // check if the messages.yml file does not exist
        if (!messagesFile.exists()) {
            try {
                messagesFile.createNewFile();
                plugin.getServer().getLogger().severe(ChatColor.GREEN + "The messages.yml file has been created!");
            } catch (IOException e) {
                plugin.getServer().getLogger().severe(ChatColor.DARK_RED + "The messages.yml could not be created");
            }
        }

        // set the messages.yml to the Bukkit file configuration
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public FileConfiguration getMessagesConfig() {
        return messagesConfig;
    }

    public void saveConfigs() {
        try {
            messagesConfig.save(messagesFile);
            plugin.getServer().getLogger().severe(ChatColor.GREEN + "The configs have been saved successfully!");
        } catch (IOException e) {
            plugin.getServer().getLogger().severe(ChatColor.DARK_RED + "The config files could not be saved!");
        }
    }

    public void reloadConfigs() {
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
        plugin.getServer().getLogger().severe(ChatColor.GREEN + "The config files have been reloaded!");
    }
}
