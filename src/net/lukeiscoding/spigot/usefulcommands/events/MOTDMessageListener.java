package net.lukeiscoding.spigot.usefulcommands.events;

import net.lukeiscoding.spigot.usefulcommands.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MOTDMessageListener implements Listener {

    private static final ConfigManager configManager = new ConfigManager();

    @EventHandler
    public void sendMOTD(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        p.sendMessage(configManager.getMessagesConfig().getString("player-join-message").replace('&', '§').replaceAll("%PLAYER%", p.getDisplayName()));
    }
}
