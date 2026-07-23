package de.wrn.simpleban;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpleBan extends JavaPlugin {

    private BanManager banManager;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        banManager = new BanManager(this);

        getCommand("permban").setExecutor(new BanCommand(banManager));
        getCommand("tempban").setExecutor(new BanCommand(banManager));

        getServer().getPluginManager()
                .registerEvents(new BanListener(banManager), this);

        getLogger().info("SimpleBan wurde aktiviert!");
    }

    public BanManager getBanManager() {
        return banManager;
    }
}
