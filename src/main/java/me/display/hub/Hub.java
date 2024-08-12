package me.display.hub;

import me.display.hub.listener.PlayerListener;
import me.display.hub.command.SetSpawnCommand;
import me.vaperion.blade.Blade;
import me.vaperion.blade.paper.BladePaperPlatform;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

    private static Hub instance;
    private Location spawnLocation;

    @Override
    public void onEnable() {
        instance = this;

        // Load the spawn location from the config
        if (getConfig().contains("spawn")) {
            spawnLocation = (Location) getConfig().get("spawn");
        }

        // Register the event listener and command
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        Blade.forPlatform(new BladePaperPlatform(this)).config(cfg -> {
            cfg.setFallbackPrefix("core");
            cfg.setDefaultPermissionMessage("No permission!");
        }).build().registerPackage(Hub.class, "me.display.hub.command");

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Hub getInstance() {
        return instance;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }
}
