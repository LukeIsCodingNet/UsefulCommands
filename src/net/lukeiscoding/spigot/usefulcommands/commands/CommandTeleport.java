package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command!");
            return true;
        }

        if (p.hasPermission("usefulcommands.teleport")) {
            if (cmd.getName().equalsIgnoreCase("tp")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.AQUA + "Teleport command help: /tp <player>");
                }

                if (args.length == 1) {
                    for (Player playerToTP : Bukkit.getServer().getOnlinePlayers()) {
                        p.teleport(playerToTP);
                        p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.AQUA + playerToTP.getDisplayName());
                    }
                }
            }
        }

        return false;
    }
}
