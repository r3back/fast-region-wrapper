package com.qualityplus.fastwrapper.base.addons.regions;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.google.common.collect.ImmutableSet;
import com.qualityplus.fastwrapper.api.RegionAddon;
import org.bukkit.Location;

import java.util.Optional;
import java.util.Set;

/**
 * Residence implementation
 */
public final class ResidenceAddon implements RegionAddon {
    private static final String RESIDENCE = "Residence";

    @Override
    public Set<String> getRegions(final Location location) {
        return Optional.ofNullable(getByLoc(location))
                .map(ClaimedResidence::getName)
                .map(ImmutableSet::of)
                .orElseGet(ImmutableSet::of);
    }

    @Override
    public Optional<String> getAddonName() {
        return Optional.of(RESIDENCE);
    }


    private ClaimedResidence getByLoc(final Location location) {
        return Residence.getInstance()
                .getResidenceManager()
                .getByLoc(location);
    }
}
