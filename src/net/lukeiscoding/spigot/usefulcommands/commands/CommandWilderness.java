package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWilderness implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the command sender to the player
        Player p = (Player) sender;

        // get the players location
        Location location = p.getLocation();

        // check if sender is not instance of a player than send a error message to the sender saying that this command can only be used by a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command!");
            return true;
        }

        if (p.hasPermission("usefulcommands.wilderness")) {
            if (cmd.getName().equalsIgnoreCase("wilderness")) {
            }
        }

        return false;
    }
}
