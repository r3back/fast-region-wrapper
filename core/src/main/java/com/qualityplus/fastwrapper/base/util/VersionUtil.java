package com.qualityplus.fastwrapper.base.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Version Utilities class
 */
@UtilityClass
public class VersionUtil {
    public final int VERSION;

    static {
        final Matcher matcher = Pattern.compile("MC: \\d\\.(\\d+)").matcher(Bukkit.getVersion());

        VERSION = Integer.parseInt(matcher.group(1));
    }
}
