package com.qualityplus.fastwrapper.base.factory;

import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.dependency.DependencyResolver;
import com.qualityplus.fastwrapper.api.factory.FastWrapperFactory;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import com.qualityplus.fastwrapper.base.addons.DefaultRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.ResidenceAddon;
import com.qualityplus.fastwrapper.base.addons.regions.UltraRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.WG6Addon;
import com.qualityplus.fastwrapper.base.addons.regions.WG7Addon;
import com.qualityplus.fastwrapper.base.dependency.DependencyResolverImpl;
import com.qualityplus.fastwrapper.base.util.VersionUtil;
import org.bukkit.plugin.Plugin;

/**
 * Fast Wrapper Factory Implementation
 */
public final class FastWrapperFactoryImpl implements FastWrapperFactory {
    private DependencyResolver resolver;
    private RegionAddon regionAddon;

    /**
     * Default constructor
     */
    public FastWrapperFactoryImpl() {
    }

    /**
     * Constructor with Plugin instance
     *
     * @param plugin {@link Plugin}
     */
    public FastWrapperFactoryImpl(final Plugin plugin) {
        this.regionAddon = setup(plugin);
        this.resolver = new DependencyResolverImpl();
    }

    /**
     *
     * @param plugin   {@link Plugin} plugin
     * @param resolver {@link DependencyResolver} dependency resolver
     */
    public FastWrapperFactoryImpl(final Plugin plugin, final DependencyResolver resolver) {
        this.regionAddon = setup(plugin);
        this.resolver = resolver;
    }

    @Override
    public RegionAddon getRegionAddon() {
        return regionAddon;
    }

    private RegionAddon setup(final Plugin plugin) {
        if (this.resolver.isPlugin(plugin, RegionPlugin.ULTRA_REGIONS)) {
            return new UltraRegionsAddon();
        } else if (this.resolver.isPlugin(plugin, RegionPlugin.RESIDENCE)) {
            return new ResidenceAddon();
        } else if (this.resolver.isPlugin(plugin, RegionPlugin.WORLD_GUARD_6) && VersionUtil.VERSION <= 12) {
            return new WG6Addon();
        } else if (this.resolver.isPlugin(plugin, RegionPlugin.WORLD_GUARD_7) && VersionUtil.VERSION > 12) {
            return new WG7Addon();
        }
        return new DefaultRegionsAddon();
    }
}
