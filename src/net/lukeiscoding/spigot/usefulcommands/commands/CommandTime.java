package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (sender.hasPermission("usefulcommands.time")) {
            if (cmd.getName().equalsIgnoreCase("time")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.DARK_RED + "Error in command please see /time help");
                }

                if (args[1].equalsIgnoreCase("help")) {
                    sender.sendMessage(ChatColor.AQUA + "Sets the time of day.");
                    sender.sendMessage(ChatColor.AQUA + "/time day sets the time to day");
                    sender.sendMessage(ChatColor.AQUA + "/time noon sets the time to noon");
                    sender.sendMessage(ChatColor.AQUA + "/time night sets the time to night");
                }

                if (args[1].equalsIgnoreCase("day")) {
                    p.getWorld().setTime(1000L);
                }

                if (args[1].equalsIgnoreCase("noon")) {
                    p.getWorld().setTime(6000L);
                }

                if (args[1].equalsIgnoreCase("night")) {
                    p.getWorld().setTime(13000L);
                    p.sendMessage(ChatColor.AQUA + "You set the time to " + ChatColor.GREEN + "night" + ChatColor.AQUA + " or " + ChatColor.GREEN + "13000 " + ChatColor.AQUA + "ticks in" + ChatColor.GREEN + p.getWorld().getName());
                }
            }
        }

        return false;
    }
}
