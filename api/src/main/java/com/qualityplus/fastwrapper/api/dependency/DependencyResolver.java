package com.qualityplus.fastwrapper.api.dependency;

import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import org.bukkit.plugin.Plugin;

/**
 * Dependency resolver interface
 */
public interface DependencyResolver {
    /**
     * Retrieves if a plugin it's enabled
     *
     * @param plugin       {@link Plugin} plugin instance
     * @param regionPlugin {@link RegionPlugin} region plugin to check
     * @return true if plugin is enabled
     */
    public boolean isPlugin(final Plugin plugin, final RegionPlugin regionPlugin);
}
