package com.qualityplus.fastwrapper.api.dependency;

import java.util.Optional;

/**
 * Interface for Dependency plugins
 */
public interface DependencyPlugin {
    /**
     *
     * @return
     */
    public Optional<String> getAddonName();

    /**
     *
     * @return
     */
    public default String getVersion() {
        return "1.0";
    }

    public default boolean isEnabled() {
        return getAddonName().isPresent();
    }
}
