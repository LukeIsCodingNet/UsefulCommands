package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the sender
        Player p = (Player) sender;

        // check if the sender is not a player than send a error message saying that you need to be a player to use tis command.
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command.");
            return true;
        }

        return false;
    }
}
