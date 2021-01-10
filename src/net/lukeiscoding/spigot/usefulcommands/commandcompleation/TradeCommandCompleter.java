package net.lukeiscoding.spigot.usefulcommands.commandcompleation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TradeCommandCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        // cast command sender to player
        Player p = (Player) sender;

        // get a list for player names
        List<String> playerNames = new ArrayList<>();

        // create a array of players
        Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];

        // check if args 1 and loop through players
        if (args.length == 1) {
            int i;
            for (i = 0; i < players.length; i++) {
                playerNames.add(players[i].getName());
            }

            players[i].sendMessage(ChatColor.AQUA + "You have received a trade request from " + ChatColor.GREEN + p.getDisplayName() + ChatColor.AQUA + " would you like to accept it? Type /trade accept to accept the trade.");
        }

        if (args[2].equalsIgnoreCase("accept")) {
            Player otherPlayer = p.getServer().getPlayer(args[1]);

            p.sendMessage(ChatColor.GREEN + otherPlayer.getDisplayName() + ChatColor.AQUA + " has accepted your trade request please send the items you want to trade.\n Then type /trade send to send the items ");
        }

        return null;
    }
}
