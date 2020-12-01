package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CommandUsefulCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the Player to the CommandSender
        Player p = (Player) sender;

        // create the inventory gui
        final Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "Admin Panel");

        // create the item stack with the item
        final ItemStack clearChatButton = new ItemStack(Material.BARRIER, 1);
        // get the item meta from the clear chat button
        final ItemMeta meta = clearChatButton.getItemMeta();

        // set the clear chat button item lore
        meta.setLore(Arrays.asList(ChatColor.AQUA + "Clear Chat\n", ChatColor.GREEN + "Preforms the clear chat command."));

        // add the items to the gui
        inventory.setItem(0, clearChatButton);

        if (sender.hasPermission("usefulcommands.admin")) {
            if (cmd.getName().equalsIgnoreCase("usefulcommands")) {
                // check to see if we do not have any command arguments
                if (args.length == 0) {
                    // if we do not have any arguments than show the inventory admin gui
                    p.openInventory(inventory);
                }
            }
        }

        return false;
    }
}
