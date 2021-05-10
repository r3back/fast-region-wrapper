package com.reb4ck.regionwrapper.implementations;

import org.bukkit.plugin.java.JavaPlugin;

public class RegionWrapper extends JavaPlugin {
    private static RegionWrapper INSTANCE;
    private RegionPluginImpl regionPlugin;

    public static RegionWrapper getInstance() {
        return INSTANCE;
    }

    public RegionPluginImpl getRegionPlugin() {
        return regionPlugin;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        INSTANCE = this;
        regionPlugin = getVersion("WorldGuard").startsWith("7.") ? new WorldGuard7() : new WorldGuard6();
    }

    private String getVersion(String plugin){
        return getServer().getPluginManager().getPlugin(plugin).getDescription().getVersion();
    }
}
