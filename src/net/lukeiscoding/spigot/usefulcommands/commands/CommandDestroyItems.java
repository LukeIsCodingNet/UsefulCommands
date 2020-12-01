package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandDestroyItems implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the Player to the CommandSender
        Player p = (Player) sender;

        // create the inventory
        final Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.AQUA + "Destroy Items");

        // check if not the sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command");
            return true;
        }

        // check if the player has permission
        if (p.hasPermission("usefulcommands.destroyitems")) {
            // check for command
            if (cmd.getName().equalsIgnoreCase("destoryitems")) {
                // open the inventory
                p.openInventory(inventory);
            }
        }

        return false;
    }
}
