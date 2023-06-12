package com.qualityplus.fastwrapper;


import com.qualityplus.fastwrapper.api.FastWrapperAPI;
import com.qualityplus.fastwrapper.api.factory.FastWrapperFactory;
import com.qualityplus.fastwrapper.base.FastWrapperAPIImpl;
import com.qualityplus.fastwrapper.base.factory.FastWrapperFactoryImpl;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Fast Region Plugin
 */
public final class FastWrapperPlugin extends JavaPlugin {
    private static FastWrapperAPI API;

    public static FastWrapperAPI getAPI() {
        return API;
    }

    @Override
    public void onEnable() {
        final FastWrapperFactory factory = new FastWrapperFactoryImpl(this);

        API = new FastWrapperAPIImpl(factory);
    }
}
