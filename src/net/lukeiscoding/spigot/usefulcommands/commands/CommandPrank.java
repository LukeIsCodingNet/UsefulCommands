package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPrank implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        // check if sender is not a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You need to be a player to use this command");
            return true;
        }

        // check if player has permission
        if (p.hasPermission("usefulcommands.prank")) {
            if (cmd.getName().equalsIgnoreCase("prank")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Please see command help: /prank help");
                }

                if (args[1].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.AQUA + "Prank command help:");
                    p.sendMessage(ChatColor.AQUA + "/prank <player> <mob> <spawn amount>");
                }
            }
        }

        return false;
    }
}
