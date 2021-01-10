package net.lukeiscoding.spigot.usefulcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    // gets a instance of the main class the one that extends JavaPlugin
    private static final UsefulCommands plugin = UsefulCommands.getPlugin(UsefulCommands.class);

    // crate files for yml config files.
    private File messagesFile;
    private File kitsFile;

    // create instances of the bukkit FileConfiguration class.
    private FileConfiguration messagesConfig;
    private FileConfiguration kitsConfig;

    // this method preforms the initial setup.
    public void setup() {
        // check if we do not have a data folder
        if (!plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder().exists()) {
            // create a new data folder if we do not have the data folder already.
            plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder().mkdir();
        }

        // set the files to a new file and create the files in the plugin data folder.
        messagesFile = new File(plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder(), "messages.yml");
        kitsFile = new File(plugin.getServer().getPluginManager().getPlugin("UsefulCommands").getDataFolder(), "kits.yml");

        // check if the messages.yml file does not exist and if it does not create it.
        if (!messagesFile.exists()) {
            try {
                messagesFile.createNewFile();
                plugin.getServer().getLogger().severe(ChatColor.GREEN + "The messages.yml file has been created!");
            } catch (IOException e) {
                plugin.getServer().getLogger().severe(ChatColor.DARK_RED + "The messages.yml could not be created!");
            }
        }

        // check if the kits.yml file does not exist and if it does not create it.
        if (!kitsFile.exists()) {
            try {
                kitsFile.createNewFile();
                plugin.getServer().getLogger().severe(ChatColor.GREEN + "The kits.yml file has been created!");
            } catch (IOException e) {
                plugin.getServer().getLogger().severe(ChatColor.DARK_RED + "The kits.yml file could not be created!");
            }
        }

        // set the config files to the Bukkit file configuration
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
        kitsConfig = YamlConfiguration.loadConfiguration(kitsFile);
    }

    // create getters to get the new config files from any class.
    public FileConfiguration getMessagesConfig() {
        return messagesConfig;
    }

    public FileConfiguration getKitsConfig() {
        return kitsConfig;
    }

    // this method saves the config files after server reloads and restarts.
    public void saveConfigs() {
        try {
            messagesConfig.save(messagesFile);
            kitsConfig.save(kitsFile);
            plugin.getServer().getLogger().severe(ChatColor.GREEN + "The configs have been saved successfully!");
        } catch (IOException e) {
            plugin.getServer().getLogger().severe(ChatColor.DARK_RED + "The config files could not be saved!");
        }
    }

    // this is a method that you can call to reload all configs files that are not the default config.yml file.
    public void reloadConfigs() {
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
        kitsConfig = YamlConfiguration.loadConfiguration(kitsFile);
        plugin.getServer().getLogger().severe(ChatColor.GREEN + "The config files have been reloaded!");
    }
}
