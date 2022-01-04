package com.github.crafttogether.minechunks;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LoadedChunksHandler {
    private static FileConfiguration config;
    private static File configFile;

    public static void init() {
        configFile = new File(MineChunks.getPlugin().getDataFolder() + "/loadedChunks.yml");
        if (!configFile.exists()) {
            // TODO: handle file generation
        }
        load();
    }

    public static void load() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static FileConfiguration getConfig() {
        return config;
    }
}
