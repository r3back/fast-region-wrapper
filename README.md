# Fast Region Wrapper

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/cb9e1b7178e54b649888715ff79a6d55)](https://app.codacy.com/gh/r3back/fast-region-wrapper/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![](https://jitpack.io/v/r3back/fast-region-wrapper.svg)](https://jitpack.io/#r3back/fast-region-wrapper)
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/r3back/fast-region-wrapper/tree/master.svg?style=shield)](https://dl.circleci.com/status-badge/redirect/gh/r3back/fast-region-wrapper/tree/master)

Lightweight library for developers to switch and handle easily between different region spigot mc plugins.

# API Usage

```java
/**
 * Region Addon interface
 */
public interface RegionAddon extends DependencyPlugin {
    /**
     * Check if a location is inside any of given regions
     *
     * @param location {@link Location} location to check
     * @param regions  List of regions to check
     * @return true if location is in region
     */
    public default boolean isInAnyRegion(final Location location, final List<String> regions) {
        if (regions.isEmpty()) {
            return false;
        }

        return this.getRegions(location)
                .stream()
                .anyMatch(regions::contains);
    }

    /**
     * Checks if a location is inside a region
     * 
     * @param location {@link Location} location to check
     * @param region   Region to check
     * @return true if location is inside region
     */
    public default boolean isInRegion(final Location location, final String region) {
        if (region == null) {
            return false;
        }

        return this.getRegions(location)
                .stream()
                .anyMatch(region::equals);
    }

    /**
     * Retrieves a list of regions given a location
     * 
     * @param location {@link Location} location to check
     * @return List of regions in for a location
     */
    public Set<String> getRegions(final Location location);
}
```

## Run application
This App uses Gradle to handle dependencies & building.

*   You can create a profile with Gradle module and deploy automatically project.
*   You can run it through gradle command.

#### Build Requirements
*   Java 8 JDK or newest
*   Gradle
*   Git

```
gradle clean build
```

## License
This App is licensed under the permissive MIT license. Please see [`LICENSE.txt`](https://github.com/r3back/users-service/blob/master/LICENSE.txt) for more info.
