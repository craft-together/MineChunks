package com.github.crafttogether.minechunks;

import com.github.crafttogether.minechunks.commands.IsLoadedCommand;
import com.github.crafttogether.minechunks.commands.LoadCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MineChunks extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("load").setExecutor(new LoadCommand());
        getCommand("isloaded").setExecutor(new IsLoadedCommand());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MineChunks successfully loaded");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "MineChunks has been unloaded");
    }
}
