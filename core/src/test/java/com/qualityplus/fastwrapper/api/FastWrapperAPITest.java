package com.qualityplus.fastwrapper.api;

import com.qualityplus.fastwrapper.FastWrapperAPIImpl;
import com.qualityplus.fastwrapper.api.type.RegionPlugin;
import com.qualityplus.fastwrapper.base.addons.DefaultRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.ResidenceAddon;
import com.qualityplus.fastwrapper.base.addons.regions.UltraRegionsAddon;
import com.qualityplus.fastwrapper.base.addons.regions.WG6Addon;
import com.qualityplus.fastwrapper.base.addons.regions.WG7Addon;
import com.qualityplus.fastwrapper.base.factory.FastWrapperFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import be.seeseemelk.mockbukkit.MockBukkit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Fast Wrapper API Tests
 */
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public final class FastWrapperAPITest {
    @Mock
    private FastWrapperFactoryImpl factory;
    @InjectMocks
    private FastWrapperAPIImpl api;

    /**
     * Load MockBukkit
     */
    @BeforeAll
    public static void load() {
        MockBukkit.mock();
    }

    /**
     * Test when no addon plugin is present
     */
    @Test
    @DisplayName("Test when no addon plugin is present")
    public void testNoAddonPluginIsPresent() {
        Mockito.when(this.factory.getRegionAddon()).thenReturn(new DefaultRegionsAddon());

        Assertions.assertTrue(this.api.getRegionAddon().getAddonName().isEmpty());
    }

    /**
     * Test when WG 6 addon is present
     */
    @Test
    @DisplayName("Test when WG 6 addon is present")
    public void testWhenWG6PluginIsPresent() {
        Mockito.when(this.factory.getRegionAddon()).thenReturn(new WG6Addon());

        Assertions.assertTrue(this.api.getRegionAddon().getAddonName().isPresent());
        Assertions.assertEquals(RegionPlugin.WORLD_GUARD_6.getName(), this.api.getRegionAddon().getAddonName().get());
    }

    /**
     * Test when WG 7 addon is present
     */
    @Test
    @DisplayName("Test when WG 7 addon is present")
    public void testWhenWG7PluginIsPresent() {
        Mockito.when(this.factory.getRegionAddon()).thenReturn(new WG7Addon());

        Assertions.assertTrue(this.api.getRegionAddon().getAddonName().isPresent());
        Assertions.assertEquals(RegionPlugin.WORLD_GUARD_7.getName(), this.api.getRegionAddon().getAddonName().get());
    }

    /**
     * Test when Residence addon is present
     */
    @Test
    @DisplayName("Test when Residence addon is present")
    public void testWhenResidencePluginIsPresent() {
        Mockito.when(this.factory.getRegionAddon()).thenReturn(new ResidenceAddon());

        Assertions.assertTrue(this.api.getRegionAddon().getAddonName().isPresent());
        Assertions.assertEquals(RegionPlugin.RESIDENCE.getName(), this.api.getRegionAddon().getAddonName().get());
    }

    /**
     * Test when Ultra Regions addon is present
     */
    @Test
    @DisplayName("Test when Ultra Regions addon is present")
    public void testWhenUltraRegionsPluginIsPresent() {
        Mockito.when(this.factory.getRegionAddon()).thenReturn(new UltraRegionsAddon());

        Assertions.assertTrue(this.api.getRegionAddon().getAddonName().isPresent());
        Assertions.assertEquals(RegionPlugin.ULTRA_REGIONS.getName(), this.api.getRegionAddon().getAddonName().get());
    }

    /**
     * Unload MockBukkit
     */
    @AfterAll
    public static void unload() {
        MockBukkit.unmock();
    }
}
