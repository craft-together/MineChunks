package com.github.crafttogether.minechunks.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnloadAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You must run this command as a player");
        } else {
            Player player = (Player) commandSender;
            for (Chunk chunk : player.getWorld().getForceLoadedChunks()) {
                chunk.setForceLoaded(false);
            }
            player.sendMessage(ChatColor.GREEN + "Removed all chunk loading in the world: " + player.getWorld().getName());
        }
        return true;
    }
}
