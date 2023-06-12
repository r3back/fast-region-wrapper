package com.qualityplus.fastwrapper.api.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represent region plugins
 */
@Getter
@RequiredArgsConstructor
public enum RegionPlugin {
    /**
     * Ultra Regions
     */
    ULTRA_REGIONS("UltraRegions", "1"),
    /**
     * World Guard 6 or lower
     */
    WORLD_GUARD_6("WorldGuard", "6"),
    /**
     * World Guard 7 or highest
     */
    WORLD_GUARD_7("WorldGuard", "7"),
    /**
     * Residence
     */
    RESIDENCE("Residence", "1");


    private final String name;
    private final String version;
}
