import me.reb4ck.worldguardwrapper.implementations.RegionPluginImpl;
import org.bukkit.Location;

import java.util.Set;

public class ResidenceWrapped implements RegionPluginImpl {
    @Override
    public String getRegionName(Location location) {
        return null;
    }

    @Override
    public Set<String> getRegions(Location location) {
        return null;
    }

    @Override
    public boolean matchRegion(Location location, String s) {
        return false;
    }
}
