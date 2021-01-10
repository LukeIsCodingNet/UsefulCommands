package net.lukeiscoding.spigot.usefulcommands;

import net.lukeiscoding.spigot.usefulcommands.commandcompleation.TeleportCommandCompleter;
import net.lukeiscoding.spigot.usefulcommands.commands.*;
import net.lukeiscoding.spigot.usefulcommands.events.EventInventoryClose;
import net.lukeiscoding.spigot.usefulcommands.events.MOTDMessageListener;
import net.lukeiscoding.spigot.usefulcommands.events.PlayerSignInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class UsefulCommands extends JavaPlugin {

    /**
     * @name Useful Commands
     * @author Luke Is Coding
     * This project is lisensed under GNU General Public License version 2.0 or later. See LICENSE.md
     */

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

        // register events
        registerEvents();

        // register commands
        registerCommands();
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
        this.getCommand("destoryitems").setExecutor(new CommandDestroyItems());
        this.getCommand("crafting").setExecutor(new CommandCrafting());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("smelt").setExecutor(new CommandSmelt());
        this.getCommand("nick").setExecutor(new CommandNickname());
        this.getCommand("destroy").setExecutor(new CommandDestroyItem());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new MOTDMessageListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerSignInteractEvent(), this);
        this.getServer().getPluginManager().registerEvents(new EventInventoryClose(), this);
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
        // config defaults for messages.yml
        configManager.getMessagesConfig().addDefault("player-join-message", "&bWelcome &a%PLAYER% to the server!");
        configManager.getMessagesConfig().addDefault("crafting-table-command-message", "&bCrafting");
        configManager.getMessagesConfig().addDefault("furnace-command-message", "&bSmelting...");
        configManager.getMessagesConfig().addDefault("furnace-gui-title", "'Furnace'");

        // config defaults for kits.yml
    }
}
