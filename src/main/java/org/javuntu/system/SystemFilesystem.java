package org.javuntu.system;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.Set;

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
        StringBuilder result = new StringBuilder();
        Set<String> seenFileStores = new LinkedHashSet<>();

        for (FileStore store : FileSystems.getDefault().getFileStores()) {
            try {
                long totalSpace = store.getTotalSpace();
                long usableSpace = store.getUsableSpace();
                long freeSpace = store.getUnallocatedSpace();

                // In case of virtual stores
                if (totalSpace <= 0) {
                    continue;
                }

                String storeName = store.name().isBlank() ? store.toString() : store.name();
                String storeId = String.format("%s-%s-%s", storeName, store.type(), totalSpace);

                // Check if we already handle this file store/volume
                if (seenFileStores.add(storeId)) {

                    result.append(formatFileStore(
                            storeName, store.type(), totalSpace, usableSpace, freeSpace)
                    ).append("\n");
                }
            } catch (Exception ignored) {
                // Some virtual filesystems do not expose space information.
            }
        }

        if (result.isEmpty()) {
            result.append("\tNo filesystem details available.\n");
        }

        return result.toString();
    }

    private static String formatFileStore(String name, String type,
            long totalSpace, long usableSpace, long freeSpace) {

        return String.format("""
              %s [%s]
                Total:  %s
                Usable: %s
                Free:   %s
            """,
                name,
                type,
                formatBytes(totalSpace),
                formatBytes(usableSpace),
                formatBytes(freeSpace)
        );
    }
}
