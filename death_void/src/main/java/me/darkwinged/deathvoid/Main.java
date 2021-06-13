package me.darkwinged.deathvoid;

import me.darkwinged.deathvoid.Commands.voidCommand;
import me.darkwinged.deathvoid.Events.voidEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main getInstance;

    public void onEnable() {
        getInstance = this;

        loadConfig();
        registerEvents();
        registerCommands();

        // Console Start Message
        getServer().getConsoleSender().sendMessage(Utils.chat("&aDeathVoid plugin has been enabled!"));
    }

    public void onDisable() {
        // Console Stop Message
        getServer().getConsoleSender().sendMessage(Utils.chat("&cDeathVoid plugin has been disabled!"));
    }

    public void registerCommands() {
        getCommand("void").setExecutor(new voidCommand());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new voidEvent(), this);
    }

    public void loadConfig() {
        // Loading the config and custom files to the server
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveDefaultConfig();
        new File(getDataFolder(), "config.yml");
    }
}
