package com.qualityplus.fastwrapper.api;

import com.qualityplus.fastwrapper.api.dependency.DependencyPlugin;
import org.bukkit.Location;

import java.util.List;
import java.util.Set;

/**
 * Region Addon interface
 */
public interface RegionAddon extends DependencyPlugin {
    /**
     * Check if a location is inside any of given regions
     *
     * @param location {@link Location} location to check
     * @param regions  List of regions to check
     * @return true if location is in region
     */
    public default boolean isInAnyRegion(final Location location, final List<String> regions) {
        if (regions.isEmpty()) {
            return false;
        }

        return this.getRegions(location)
                .stream()
                .anyMatch(regions::contains);
    }

    /**
     * Checks if a location is inside a region
     *
     * @param location {@link Location} location to check
     * @param region   Region to check
     * @return true if location is inside region
     */
    public default boolean isInRegion(final Location location, final String region) {
        if (region == null) {
            return false;
        }

        return this.getRegions(location)
                .stream()
                .anyMatch(region::equals);
    }

    /**
     * Retrieves a list of regions given a location
     *
     * @param location {@link Location} location to check
     * @return List of regions in for a location
     */
    public Set<String> getRegions(final Location location);
}
