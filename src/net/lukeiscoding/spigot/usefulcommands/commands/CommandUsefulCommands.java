package net.lukeiscoding.spigot.usefulcommands.commands;

import net.lukeiscoding.spigot.usefulcommands.ConfigManager;
import net.lukeiscoding.spigot.usefulcommands.UsefulCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandUsefulCommands implements CommandExecutor {

    private static final UsefulCommands plugin = UsefulCommands.getPlugin(UsefulCommands.class);
    private final ConfigManager configManager = new ConfigManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // check if the sender has permission
        if (sender.hasPermission("usefulcommands.admin")) {
            if (cmd.getName().equalsIgnoreCase("usefulcommands")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.AQUA + "UsefulCommands admin command. For help see /help usefulcommands.");
                }

                if (args[1].equalsIgnoreCase("reload")) {
                    plugin.saveConfig();
                    configManager.reloadConfigs();
                    sender.sendMessage(ChatColor.AQUA + "All configs have been reloaded!");
                }
            }
        }

        return false;
    }
}
