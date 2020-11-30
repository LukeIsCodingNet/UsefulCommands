package net.lukeiscoding.spigot.usefulcommands.commands;

import net.lukeiscoding.spigot.usefulcommands.helpers.HelperCreateGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandTestGUI implements CommandExecutor {

    private static final HelperCreateGUI helperGUI = new HelperCreateGUI();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        Inventory testGUI = helperGUI.createInventory(9, "Test GUI!");

        if (sender.hasPermission("usefulcommands.testgui")) {
            if (cmd.getName().equalsIgnoreCase("testgui")) {
                p.openInventory(testGUI);
            }
        }

        return false;
    }
}
