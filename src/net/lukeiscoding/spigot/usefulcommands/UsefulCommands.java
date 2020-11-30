package net.lukeiscoding.spigot.usefulcommands;

import net.lukeiscoding.spigot.usefulcommands.commands.CommandClearChat;
import net.lukeiscoding.spigot.usefulcommands.commands.CommandTestGUI;
import net.lukeiscoding.spigot.usefulcommands.events.MOTDMessageListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UsefulCommands extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        // save the default config file
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        // save custom configs
        loadConfigManager();

        // log a message using the Bukkit API built in logger to say that this plugin has been enabled
        this.getServer().getLogger().severe(ChatColor.GREEN + "UsefulCommands has been enabled!");

        // register commands
        registerCommands();

        // register events
        registerEvents();
    }

    @Override
    public void onDisable() {
        // save default config
        this.saveConfig();

        // save custom configs
        configManager.saveConfigs();
    }

    private void registerCommands() {
        this.getCommand("clearchat").setExecutor(new CommandClearChat());
        this.getCommand("testgui").setExecutor(new CommandTestGUI());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new MOTDMessageListener(), this);
    }

    private void loadConfigManager() {
        configManager = new ConfigManager();
        configManager.setup();
        setConfigDefaults();
        configManager.getMessagesConfig().options().copyDefaults(true);
        configManager.saveConfigs();
        configManager.reloadConfigs();
    }

    private void setConfigDefaults() {
        configManager.getMessagesConfig().addDefault("player-join-message", "&bWelcome &a%PLAYER% to the server!");
    }
}
