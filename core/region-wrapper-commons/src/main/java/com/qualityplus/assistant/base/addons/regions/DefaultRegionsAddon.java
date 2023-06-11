package com.qualityplus.assistant.base.addons.regions;

import com.qualityplus.assistant.api.addons.RegionAddon;
import org.bukkit.Location;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * No region plugin implementation
 */
public final class DefaultRegionsAddon implements RegionAddon {
    @Override
    public Set<String> getRegions(final Location location) {
        return Collections.emptySet();
    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.empty();
    }
}
