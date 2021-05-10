package me.reb4ck.regionwrapper;

import me.reb4ck.regionwrapper.implementations.RegionPluginImpl;
import me.reb4ck.regionwrapper.implementations.WorldGuard6;
import me.reb4ck.regionwrapper.implementations.WorldGuard7;
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
