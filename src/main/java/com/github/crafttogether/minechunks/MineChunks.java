package com.github.crafttogether.minechunks;

import com.github.crafttogether.minechunks.commands.IsLoadedCommand;
import com.github.crafttogether.minechunks.commands.LoadCommand;
import com.github.crafttogether.minechunks.commands.UnloadAllCommand;
import com.github.crafttogether.minechunks.commands.UnloadCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Files;
import java.nio.file.Path;

public class MineChunks extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        try {
            getConfig().load(Files.newBufferedReader(Path.of(plugin.getDataFolder() + "/config.yml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        getCommand("load").setExecutor(new LoadCommand());
        getCommand("isloaded").setExecutor(new IsLoadedCommand());
        getCommand("unload").setExecutor(new UnloadCommand());
        getCommand("unloadall").setExecutor(new UnloadAllCommand());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MineChunks successfully loaded");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "MineChunks has been unloaded");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
