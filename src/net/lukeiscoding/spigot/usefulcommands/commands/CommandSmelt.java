package net.lukeiscoding.spigot.usefulcommands.commands;

import net.lukeiscoding.spigot.usefulcommands.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandSmelt implements CommandExecutor {

    private final ConfigManager configManager = new ConfigManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to CommandSender
        Player p = (Player) sender;

        // check if the sender is not a instance of a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command");
            return true;
        }

        // create the furnace inventory
        final Inventory furnace = Bukkit.createInventory(null, InventoryType.FURNACE, "Furnace");

        // create the blast furnace inventory
        final Inventory blastFurnace = Bukkit.createInventory(null, InventoryType.BLAST_FURNACE, "Blast Furnace");

        // check if the player has permission and check for command name
        if (p.hasPermission("usefulcommands.smelt")) {
            if (cmd.getName().equalsIgnoreCase("smelt")) {
                // check if the player did not enter any arguments
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "You did not enter any arguments see /smelt help");
                }

                if (args[1].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.AQUA + "Smelt command help:");
                    p.sendMessage(ChatColor.AQUA + "/smelt furnace opens a furnace GUI.");
                    p.sendMessage(ChatColor.AQUA + "/smelt blastFurnace opens a black furnace GUI.");
                }

                if (args[1].equalsIgnoreCase("furnace")) {
                    p.openInventory(furnace);
                    p.sendMessage(ChatColor.AQUA + "Smelting...");
                }

                if (args[1].equalsIgnoreCase("blastFurnace")) {
                    p.openInventory(blastFurnace);
                    p.sendMessage(ChatColor.AQUA + "Blast smelting...");
                }
            }
        }

        return false;
    }
}
