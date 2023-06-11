package com.qualityplus.assistant.api.addons;

import com.qualityplus.assistant.api.DependencyPlugin;
import org.bukkit.Location;

import java.util.List;
import java.util.Set;

/**
 * Region Addon interface
 */
public interface RegionAddon extends DependencyPlugin {
    /**
     * Check if a location is inside any region
     *
     * @param location {@link Location} location to check
     * @param regions  List of regions to check
     * @return true if location is in region
     */
    public default boolean isInAnyRegion(final Location location, final List<String> regions) {
        if (regions.isEmpty()) {
            return false;
        }

        return getRegions(location)
                .stream()
                .anyMatch(regions::contains);
    }

    /**
     *
     * @param location {@link Location} location to check
     * @param region   Region to check
     * @return true if location is inside region
     */
    public default boolean isInRegion(final Location location, final String region) {
        if(region == null) {
            return false;
        }

        return getRegions(location)
                .stream()
                .anyMatch(region::equals);
    }

    /**
     *
     * @param location {@link Location} location to check
     * @return List of regions in for a location
     */
    public Set<String> getRegions(final Location location);
}
