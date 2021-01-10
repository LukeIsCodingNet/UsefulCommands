package net.lukeiscoding.spigot.usefulcommands.commandcompleation;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PrankCommandCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        // crate a new array list of player names on the server
        List<String> playerNames = new ArrayList<>();

        // create a new player variable from the player names array list
        Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];

        // get the online players as an array
        Bukkit.getServer().getOnlinePlayers().toArray(players);

        // get a instance of the current world
        final World world = null;

        if (args.length == 1) {
            // loop through the players
            for (int i = 0; i < players.length; i++) {
                playerNames.add(players[i].getName());
            }
        }

        if (args.length == 2) {
            for (Entity e : world.getEntities()) {
            }
        }

        return null;
    }
}
