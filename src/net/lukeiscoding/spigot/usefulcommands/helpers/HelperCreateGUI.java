package net.lukeiscoding.spigot.usefulcommands.helpers;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class HelperCreateGUI {

    public Inventory createInventory(int size, String name) {
        Inventory newInventory = Bukkit.createInventory(null, size, name);

        return newInventory;
    }
}
