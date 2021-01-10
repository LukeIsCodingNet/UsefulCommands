package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTrade implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the sender
        Player p = (Player) sender;

        // check if the sender is not a player
        if (!(sender instanceof Player)) {
            p.sendMessage(ChatColor.RED + "You need to be a player to use this command.");
            return true;
        }

        // check if player has permission
        if (p.hasPermission("usefulcommands.trade")) {
            if (cmd.getName().equalsIgnoreCase("trade")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Error in command please see: /trade help");
                }

                if (args[1].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.AQUA + "Trade Command Help:");
                    p.sendMessage(ChatColor.AQUA + "/trade <player> sends a trade request to that player.");
                    p.sendMessage(ChatColor.AQUA + "Once your request to trade has been sent the other player has to type /trade accept to accept your trade.");
                    p.sendMessage(ChatColor.AQUA + "To send item(s) make sure its in your hand to send more than one item it must be in a stack.");
                    p.sendMessage(ChatColor.AQUA + "To accept the item(s) from both of the player type /trade items accept");
                }
            }
        }

        return false;
    }
}
