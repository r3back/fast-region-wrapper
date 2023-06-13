package com.qualityplus.fastwrapper.api.factory;

import com.qualityplus.fastwrapper.api.RegionAddon;

/**
 * Factory to Set Up Region Plugin
 */
public interface FastWrapperFactory {
    /**
     *
     * @return {@link RegionAddon}
     */
    public RegionAddon getRegionAddon();
}
