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

        // check if the player has permission and check for command name
        if (p.hasPermission("usefulcommands.smelt")) {
            if (cmd.getName().equalsIgnoreCase("smelt")) {
                p.openInventory(furnace);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', configManager.getMessagesConfig().getString("furnace-gui-title")));
            }
        }

        return false;
    }
}
