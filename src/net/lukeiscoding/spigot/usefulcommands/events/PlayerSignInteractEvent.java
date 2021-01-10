package net.lukeiscoding.spigot.usefulcommands.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PlayerSignInteractEvent implements Listener {

    @EventHandler
    public void playerDidRightClickSign(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action action = event.getAction();

        Inventory destroyItemsGUI = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.RED + "Destroy Items");

        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType() == Material.OAK_SIGN) {
                Sign sign = (Sign) event.getClickedBlock().getState();
                if (sign.getLine(0).equalsIgnoreCase("[Destroy]")) {
                    sign.getLine(0).replace("[Destroy]", ChatColor.AQUA + "[Destroy]");
                    p.openInventory(destroyItemsGUI);
                }
            }
        }
    }
}
