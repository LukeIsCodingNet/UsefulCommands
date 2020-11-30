package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (sender.hasPermission("usefulcommands.clearchat")) {
            if (cmd.getName().equalsIgnoreCase("clearchat")) {
                for (int i = 0; i < 1000; i++) {
                    sender.sendMessage("");
                }

                if (sender instanceof Player) {
                    sender.sendMessage(ChatColor.AQUA + "The chat was cleared by " + ChatColor.GREEN + p.getDisplayName() + ChatColor.AQUA + "!");
                }

                if (sender instanceof ConsoleCommandSender) {
                    sender.sendMessage(ChatColor.AQUA + "The chat was cleared by " + ChatColor.GREEN + "the console" + ChatColor.AQUA + "!");
                }
            }
        }

        return false;
    }
}
