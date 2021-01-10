package net.lukeiscoding.spigot.usefulcommands.commands;

import net.lukeiscoding.spigot.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandTPA implements CommandExecutor {

    private static final UsefulCommands plugin = UsefulCommands.getPlugin(UsefulCommands.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // cast the player to the command sender
        Player p = (Player) sender;

        // boolean to check if the other player has accepted the teleport request
        boolean hasAcceptedTeleport = false;

        // create a new bukkit timer
        int timer = plugin.getConfig().getInt("tpa-request-timer");
        Runnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                //timer--;
            }
        };

        // check if not the player is a instance of sender
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "You need to be a player to use this command.");
            return true;
        }

        if (p.hasPermission("usefulcommands.tpa")) {
            if (cmd.getName().equalsIgnoreCase("tpa")) {
                // check if the length of the given command arguments is equal to 0
                if (args.length == 0) {
                    p.sendMessage(ChatColor.AQUA + "TPA command help: /tpa <player>");
                }

                if (args.length == 1) {
                    for (Player otherPlayer : Bukkit.getServer().getOnlinePlayers()) {
                        if (timer == 0) {

                        }
                    }
                }
            }
        }

        return false;
    }
}
