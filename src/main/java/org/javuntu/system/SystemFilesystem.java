package org.javuntu.system;

import java.text.DecimalFormat;

public class SystemFilesystem {
    /// File system constants
    private static final DecimalFormat ONE_DECIMAL = new DecimalFormat("0.0");
    public static final String[] FILE_SIZE_UNITS = {"B", "KB", "MB", "GB", "TB"};
    public static final int FILE_SIZE_UNIT_FACTOR = 1024;

    // Format raw bits size (15423876) to readable format (14.6 MB)
    // 1024 B  -> 1 KB
    // 1024 KB -> 1 MB
    // 1024 MB -> 1 GB
    public static String formatBytes(long value) {
        // If the size is unavailable
        if (value < 0) {
            return SystemProperties.DEFAULT_VALUE;
        }

        double size = value;
        int unitIndex = 0;

        while (size >= FILE_SIZE_UNIT_FACTOR && unitIndex < FILE_SIZE_UNITS.length - 1) {
            size = size / FILE_SIZE_UNIT_FACTOR;
            unitIndex++;
        }

        return ONE_DECIMAL.format(size) + " " + FILE_SIZE_UNITS[unitIndex];
    }

    public static String getFilesystemReport() {
        return null;
    }
}
