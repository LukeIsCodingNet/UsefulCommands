package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandDestroyItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the command sender
        Player p = (Player) sender;

        // create a inventory for the destroy items gui
        Inventory destroyGUI = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.RED + "Destroy Items");

        // check if not the player is a instance of the command sender then send the sender a message saying that this command can only be used by a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command.");
            return true;
        }

        // check if player has permission
        if (p.hasPermission("usefulcommands.destroy")) {
            if (cmd.getName().equalsIgnoreCase("destroy")) {
                p.openInventory(destroyGUI);
                if (!destroyGUI.isEmpty()) {
                    destroyGUI.clear();
                }

                p.sendMessage(ChatColor.AQUA + "All items have been destroyed");
            }
        }

        return false;
    }
}
