package com.qualityplus.fastwrapper.base;

import com.qualityplus.fastwrapper.api.FastWrapperAPI;
import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.factory.FastWrapperFactory;

/**
 * Fast Wrapper API Implementation
 */
public final class FastWrapperAPIImpl implements FastWrapperAPI {
    private final FastWrapperFactory factory;

    public FastWrapperAPIImpl(final FastWrapperFactory factory) {
        this.factory = factory;
    }

    @Override
    public RegionAddon getRegionAddon() {
        return factory.getRegionAddon();
    }
}
