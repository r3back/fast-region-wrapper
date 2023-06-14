package com.qualityplus.fastwrapper.base.addons.regions;

import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * World Guard 7 implementation
 */
public final class WG7Addon implements RegionAddon {
    private static final RegionPlugin REGION_PLUGIN = RegionPlugin.WORLD_GUARD_7;

    @Override
    public Set<String> getRegions(final Location location) {
        final World weWorld = Optional
                .ofNullable(location.getWorld()).map(BukkitAdapter::adapt)
                .orElse(null);

        final RegionContainer container = WorldGuard.getInstance()
                .getPlatform()
                .getRegionContainer();

        return Optional.ofNullable(container.get(weWorld))
                .map(manager -> container.createQuery()
                        .getApplicableRegions(BukkitAdapter.adapt(location))
                        .getRegions()
                        .stream()
                        .map(ProtectedRegion::getId)
                        .collect(Collectors.toSet()))
                .orElse(new HashSet<>());

    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.of(REGION_PLUGIN.getName());
    }
}
