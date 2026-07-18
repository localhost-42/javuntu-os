package org.javuntu.system;

import org.javuntu.metadata.AppMetadata;

public class SystemSpecs {
    private SystemSpecs() {
    }

    public static String shortReport() {
        Runtime runtime = Runtime.getRuntime();

        return String.format("""
                %s %s
                Author: %s
                Java: %s (%s)
                Host: %s %s
                Architecture: %s
                User: %s
                CPU cores: %s
                JVM memory: %s / %s
                """,
                AppMetadata.NAME, AppMetadata.VERSION,
                AppMetadata.AUTHOR,
                SystemProperties.getProperty(SystemConstants.JAVA_VERSION_KEY),
                SystemProperties.getProperty(SystemConstants.JAVA_VENDOR_KEY),
                SystemProperties.getProperty(SystemConstants.OS_NAME_KEY),
                SystemProperties.getProperty(SystemConstants.OS_VERSION_KEY),
                SystemProperties.getProperty(SystemConstants.OS_ARCHITECTURE_KEY),
                SystemProperties.getProperty(SystemConstants.USER_NAME_KEY),
                runtime.availableProcessors(),
                SystemFilesystem.formatBytes(runtime.totalMemory() - runtime.freeMemory()),
                SystemFilesystem.formatBytes(runtime.maxMemory()));
    }
}
