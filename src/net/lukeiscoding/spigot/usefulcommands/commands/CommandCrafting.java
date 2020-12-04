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

public class CommandCrafting implements CommandExecutor {

    // TODO: fix message.

    private ConfigManager configManager;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        // create the crafting GUI
        final Inventory crafting = Bukkit.createInventory(null, InventoryType.CRAFTING, ChatColor.GREEN + "Crafting");

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command.");
            return true;
        }

        if (p.hasPermission("usefulcommands.crafting")) {
            if (cmd.getName().equalsIgnoreCase("crafting")) {
                p.openInventory(crafting);
                p.sendMessage(ChatColor.AQUA + "Crafting...");
            }
        }

        return false;
    }
}
