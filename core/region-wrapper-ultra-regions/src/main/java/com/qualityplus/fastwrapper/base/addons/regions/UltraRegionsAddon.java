package com.qualityplus.fastwrapper.base.addons.regions;

import com.qualityplus.fastwrapper.api.RegionAddon;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import me.TechsCode.UltraRegions.UltraRegions;
import me.TechsCode.UltraRegions.selection.XYZ;
import me.TechsCode.UltraRegions.storage.Region;
import org.bukkit.Location;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Ultra Regions implementation
 */
public final class UltraRegionsAddon implements RegionAddon {
    private static final RegionPlugin REGION_PLUGIN = RegionPlugin.ULTRA_REGIONS;

    @Override
    public Set<String> getRegions(final Location location) {
        return UltraRegions.getAPI().getWorlds().find(location.getWorld()).map(managedWorld -> UltraRegions.uregPlugin
                        .newRegionQuery(managedWorld)
                        .sortBySize()
                        .getRegions()
                        .stream()
                        .map(Region::getName)
                        .collect(Collectors.toSet()))
                        .orElseGet(HashSet::new);
    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.of(REGION_PLUGIN.getName());
    }
}
