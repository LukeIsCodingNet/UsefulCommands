package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the CommandSender
        Player p = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command.");
            return true;
        }

        if (p.hasPermission("usefulcommands.fly")) {
            if (cmd.getName().equalsIgnoreCase("fly")) {
                // check if the player is not currently flying
                if (!p.isFlying()) {
                    // if we are not flying than enable flight mode
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.AQUA + "Set fly mode enabled.");
                    return true;
                }

                // check if the player is flying
                if (p.isFlying()) {
                    // if we are flying than disable flight mode
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.AQUA + "Set fly mode disabled");
                    return true;
                }
            }
        }

        return false;
    }
}
