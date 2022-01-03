package com.github.crafttogether.minechunks.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LoadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You must run this command as a player");
        } else {
            Player player = (Player) commandSender;
            player.getChunk().setForceLoaded(true);
            player.sendMessage(ChatColor.GREEN + "The chunk you are in has been loaded");
        }
        return true;
    }
}
