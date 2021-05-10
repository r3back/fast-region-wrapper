package com.reb4ck.regionwrapper.implementations;

import org.bukkit.Location;
import java.util.List;
import java.util.Set;

public interface RegionPluginImpl {
    boolean isInRegion(Location location, List<String> regions);

    boolean isInRegion(Location location, String region);

    Set<String> getRegions(Location location);
}
