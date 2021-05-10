package me.reb4ck.regionwrapper.implementations;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import me.reb4ck.regionwrapper.implementations.RegionPluginImpl;
import org.bukkit.Location;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorldGuard7 implements RegionPluginImpl {

    private final RegionContainer container = com.sk89q.worldguard.WorldGuard.getInstance().getPlatform().getRegionContainer();

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
        RegionManager regions = container.get(BukkitAdapter.adapt(location.getWorld()));
        RegionQuery query = container.createQuery();
        if (regions != null)
            return query.getApplicableRegions(BukkitAdapter.adapt(location)).getRegions().stream().map(ProtectedRegion::getId).collect(Collectors.toSet());
        return null;
    }
}
