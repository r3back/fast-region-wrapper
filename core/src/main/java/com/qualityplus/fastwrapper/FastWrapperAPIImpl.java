package com.qualityplus.fastwrapper;

import com.qualityplus.fastwrapper.api.FastWrapperAPI;
import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.factory.FastWrapperFactory;
import com.qualityplus.fastwrapper.base.dependency.DependencyResolverImpl;
import com.qualityplus.fastwrapper.base.factory.FastWrapperFactoryImpl;
import org.bukkit.plugin.Plugin;

/**
 * Fast Wrapper API Implementation
 */
public final class FastWrapperAPIImpl implements FastWrapperAPI {
    private FastWrapperFactory factory;

    /**
     * Default constructor
     */
    public FastWrapperAPIImpl() {
    }

    /**
     * Constructor with Plugin instance
     *
     * @param plugin {@link Plugin} Plugin
     */
    public FastWrapperAPIImpl(final Plugin plugin) {
        this.factory = new FastWrapperFactoryImpl(plugin);
    }

    /**
     * Constructor with custom factory
     *
     * @param factory {@link FastWrapperFactory} Addon factory
     */
    public FastWrapperAPIImpl(final FastWrapperFactory factory) {
        this.factory = factory;
    }

    @Override
    public RegionAddon getRegionAddon() {
        return factory.getRegionAddon();
    }
}
