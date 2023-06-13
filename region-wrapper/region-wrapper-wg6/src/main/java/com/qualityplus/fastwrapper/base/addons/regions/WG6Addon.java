package com.qualityplus.fastwrapper.base.addons.regions;

import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
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
    private static final RegionPlugin REGION_PLUGIN = RegionPlugin.WORLD_GUARD_6;

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
        return Optional.of(REGION_PLUGIN.name());
    }
}
