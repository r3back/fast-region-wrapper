package com.qualityplus.fastwrapper.base.dependency;

import com.qualityplus.fastwrapper.api.dependency.DependencyResolver;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import org.bukkit.plugin.Plugin;

/**
 * Dependency Resolver implementation
 */
public final class DependencyResolverImpl implements DependencyResolver {
    @Override
    public boolean isPlugin(Plugin plugin, RegionPlugin regionPlugin) {
        return plugin.getServer().getPluginManager().getPlugin(regionPlugin.getName()) != null;
    }
}
