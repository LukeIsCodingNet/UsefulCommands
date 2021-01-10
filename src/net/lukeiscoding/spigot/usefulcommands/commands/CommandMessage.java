package net.lukeiscoding.spigot.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CommandMessage implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the command sender
        Player p = (Player) sender;

        // create a hash map with 2 uuids
        HashMap<UUID, UUID> playerUUIDs = new HashMap<UUID, UUID>();

        if (sender.hasPermission("usefulcommands.msg")) {
            if (cmd.getName().equalsIgnoreCase("msg")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.AQUA + "Command help: /msg <player> <message>");
                }

                if (args.length == 1) {
                    for (Player otherPlayer : Bukkit.getServer().getOnlinePlayers()) {
                        playerUUIDs.put(p.getUniqueId(), otherPlayer.getUniqueId());
                        // create a string with the message from command argument 2
                        String sendMessage = args[2];
                    }
                }
            }
        }

        return false;
    }
}
