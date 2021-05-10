package me.reb4ck.regionwrapper.implementations;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorldGuard6 implements RegionPluginImpl {

    @Override
    public boolean isInRegion(Location location, List<String> regions) {
        Set<String> locationRegions = getRegions(location);
        for(String region : regions)
            return locationRegions.contains(region);
        return false;
    }

    @Override
    public boolean isInRegion(Location location, String region) {
        return getRegions(location).contains(region);
    }

    @Override
    public Set<String> getRegions(Location location) {
        RegionManager regionManager = WGBukkit.getRegionManager(location.getWorld());
        ApplicableRegionSet set = regionManager.getApplicableRegions(location);
        return set.getRegions().stream().map(ProtectedRegion::getId).collect(Collectors.toSet());
    }


}
