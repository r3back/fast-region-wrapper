package com.qualityplus.assistant.base.addons.regions;

import com.qualityplus.assistant.api.addons.RegionAddon;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * World guard 6 implementation
 */
public final class WG6Addon implements RegionAddon {
    private static final String WORLD_GUARD_6 = "World Guard 6";

    @Override
    public Set<String> getRegions(final Location location) {
        final RegionManager regionManager = WGBukkit.getRegionManager(location.getWorld());

        final ApplicableRegionSet regionSet = regionManager.getApplicableRegions(location);

        return regionSet.getRegions()
                .stream()
                .map(ProtectedRegion::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.of(WORLD_GUARD_6);
    }
}