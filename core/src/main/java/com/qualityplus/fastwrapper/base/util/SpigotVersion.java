package com.qualityplus.fastwrapper.base.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represent Spigot Version
 */
@Getter
@RequiredArgsConstructor
public enum SpigotVersion {
    /**
     * Version to recognize when plugin instance is enabled
     */
    UNKNOWN("Unknown", true),
    /**
     * Version to recognize when test suite is enabled
     */
    UNIT_TEST("Unit Test Environment", true);

    private final String name;
    private final boolean virtual;
}
