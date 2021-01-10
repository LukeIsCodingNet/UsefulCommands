package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandNickname implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the command sender
        Player p = (Player) sender;

        if (sender.hasPermission("usefulcommands.nick")) {
            if (cmd.getName().equalsIgnoreCase("nick")) {
                // check if the sender did not enter any command arguments
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.AQUA + "Command help: /nick <nickname> or /nick <another player>");
                }

                if (args.length == 1) {
                    if (args[1].equals("")) {
                        p.setDisplayName(args[1]);
                        p.sendMessage(ChatColor.AQUA + "You set your own nickname to " + ChatColor.translateAlternateColorCodes('&', args[1]));
                    }

                    if (sender.hasPermission("usefulcommands.nick.other")) {
                        for (Player otherPlayer : Bukkit.getServer().getOnlinePlayers()) {
                            if (args[1].equals(otherPlayer.getName())) {
                                otherPlayer.setDisplayName(args[2]);
                                if (sender instanceof ConsoleCommandSender) {
                                    otherPlayer.sendMessage(ChatColor.AQUA + "Your nickname was set to " + ChatColor.translateAlternateColorCodes('&', args[2]) + ChatColor.AQUA + " by the console.");
                                }

                                if (sender instanceof Player) {
                                    otherPlayer.sendMessage(ChatColor.AQUA + "Your nickname was set to " + ChatColor.translateAlternateColorCodes('&', args[2]) + ChatColor.AQUA + " by " + ChatColor.GREEN + p.getDisplayName());
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
