package com.qualityplus.assistant.api;

import java.util.Optional;

/**
 * Interface for Dependency plugins
 */
public interface DependencyPlugin {
    public Optional<String> getAddonName();

    public default String getVersion(){
        return "1.0";
    }

    public default boolean isEnabled(){
        return getAddonName().isPresent();
    }
}
