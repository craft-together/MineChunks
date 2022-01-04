package com.github.crafttogether.minechunks.commands;

import com.github.crafttogether.minechunks.LoadedChunksHandler;
import com.github.crafttogether.minechunks.MineChunks;
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
            System.out.println(MineChunks.getPlugin().getConfig().getInt("maxLoadedChunks"));
            int loadedChunks = 0;
            if (LoadedChunksHandler.getConfig().contains(String.format("players.%s.loadedChunks", player.getUniqueId()))) {
                loadedChunks = LoadedChunksHandler.getConfig().getInt(String.format("players.%s.loadedChunks", player.getUniqueId()));
            }
            if (MineChunks.getPlugin().getConfig().getInt("maxLoadedChunks") <= loadedChunks) {
                player.sendMessage(ChatColor.RED + "Maximum loaded chunks has been reached");
                return true;
            }
            LoadedChunksHandler.getConfig().set(String.format("players.%s.loadedChunks", player.getUniqueId()), loadedChunks + 1);
            LoadedChunksHandler.getConfig().set(String.format("chunks." + player.getChunk().getChunkKey(), ))
            LoadedChunksHandler.save();
            player.getChunk().setForceLoaded(true);
            player.sendMessage(ChatColor.GREEN + "The chunk you are in has been loaded");
        }
        return true;
    }
}
