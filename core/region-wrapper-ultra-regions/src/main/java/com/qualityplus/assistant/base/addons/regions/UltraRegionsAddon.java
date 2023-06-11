package com.qualityplus.assistant.base.addons.regions;

import com.qualityplus.assistant.api.addons.RegionAddon;
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
    @Override
    public Set<String> getRegions(Location location) {
        return UltraRegions.getInstance().getWorlds().find(location.getWorld()).map(managedWorld -> UltraRegions.getInstance()
                .newRegionQuery(managedWorld)
                .location(XYZ.from(location))
                .sortBySize()
                .getRegions()
                .stream()
                .map(Region::getName)
                .collect(Collectors.toSet()))
                .orElseGet(HashSet::new);
    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.of("Ultra Regions");
    }
}
