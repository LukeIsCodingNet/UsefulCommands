package net.lukeiscoding.spigot.usefulcommands.commandcompleation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class UsefulCommandsCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> commandArgs = new ArrayList<>();

        return null;
    }
}