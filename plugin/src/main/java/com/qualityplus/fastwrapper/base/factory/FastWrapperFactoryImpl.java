package com.qualityplus.fastwrapper.base.factory;

import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.factory.FastWrapperFactory;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import com.qualityplus.fastwrapper.base.addons.DefaultRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.ResidenceAddon;
import com.qualityplus.fastwrapper.base.addons.regions.UltraRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.WG6Addon;
import com.qualityplus.fastwrapper.base.addons.regions.WG7Addon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fast Wrapper Factory Implementation
 */
public final class FastWrapperFactoryImpl implements FastWrapperFactory {
    private static final int VERSION;

    static {
        final Matcher matcher = Pattern.compile("MC: \\d\\.(\\d+)").matcher(Bukkit.getVersion());

        VERSION = Integer.parseInt(matcher.group(1));
    }

    private final RegionAddon regionAddon;

    public FastWrapperFactoryImpl(final Plugin plugin) {
        this.regionAddon = setup(plugin);
    }

    @Override
    public RegionAddon getRegionAddon() {
        return regionAddon;
    }

    private RegionAddon setup(final Plugin plugin) {
        if (isPlugin(plugin, RegionPlugin.ULTRA_REGIONS)) {
            return new UltraRegionsAddon();
        } else if (isPlugin(plugin, RegionPlugin.RESIDENCE)) {
            return new ResidenceAddon();
        } else if (isPlugin(plugin, RegionPlugin.WORLD_GUARD_6) && VERSION <= 12) {
            return new WG6Addon();
        } else if (isPlugin(plugin, RegionPlugin.WORLD_GUARD_7) && VERSION > 12) {
            return new WG7Addon();
        }
        return new DefaultRegionsAddon();
    }

    private boolean isPlugin(final Plugin plugin, final RegionPlugin regionPlugin){
        return plugin.getServer().getPluginManager().getPlugin(regionPlugin.getName()) != null;
    }
}
