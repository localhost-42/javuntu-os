package org.javuntu.system;

import org.javuntu.metadata.AppMetadata;
import org.javuntu.shell.ShellConstants;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemSpecs {
    private SystemSpecs() {
    }

    public static String getShortReport() {
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

    public static String getFullReport() {
        Runtime runtime = Runtime.getRuntime();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        return String.format("""
            %s System Specs
            =====================

            Project
              Name: %s
              Version: %s
              Author: %s
              Description: %s
              Shell prompt: %s
              Started at: %s

            Java Runtime
              Java version: %s
              Java vendor: %s
              JVM: %s
              JVM version: %s
              Java home: %s

            Host OS
              OS name: %s
              OS version: %s
              Architecture: %s
              Available processors: %d
              OS bean: %s %s

            Memory
              JVM used: %s
              JVM free: %s
              JVM allocated: %s
              JVM max: %s

            User Session
              User: %s
              Home: %s
              Working directory: %s
              File separator: %s
              Path separator: %s

            Filesystem
            %s

            %s Runtime Plan
              Current mode: Java desktop prototype
              Future boot stack: Linux kernel -> init -> X11/Wayland -> Java runtime -> %s
              Future ISO target: Buildroot based live ISO
              Native layer: small C launcher only when needed
            """,
                AppMetadata.NAME,

                // Project
                AppMetadata.NAME,
                AppMetadata.VERSION,
                AppMetadata.AUTHOR,
                AppMetadata.TAGLINE,
                ShellConstants.PROMPT,
                SystemProperties.now(),

                // Java Runtime
                SystemProperties.getProperty(SystemConstants.JAVA_VERSION_KEY),
                SystemProperties.getProperty(SystemConstants.JAVA_VENDOR_KEY),
                SystemProperties.getProperty(SystemConstants.JAVA_VM_NAME_KEY),
                SystemProperties.getProperty(SystemConstants.JAVA_VM_VERSION_KEY),
                SystemProperties.getProperty(SystemConstants.JAVA_HOME_KEY),

                // Host OS
                SystemProperties.getProperty(SystemConstants.OS_NAME_KEY),
                SystemProperties.getProperty(SystemConstants.OS_VERSION_KEY),
                SystemProperties.getProperty(SystemConstants.OS_ARCHITECTURE_KEY),
                runtime.availableProcessors(),
                osBean.getName(),
                osBean.getVersion(),

                // Memory
                SystemFilesystem.formatBytes(runtime.totalMemory() - runtime.freeMemory()),
                SystemFilesystem.formatBytes(runtime.freeMemory()),
                SystemFilesystem.formatBytes(runtime.totalMemory()),
                SystemFilesystem.formatBytes(runtime.maxMemory()),

                // User Session
                SystemProperties.getProperty(SystemConstants.USER_NAME_KEY),
                SystemProperties.getProperty(SystemConstants.USER_HOME_KEY),
                SystemProperties.getProperty(SystemConstants.USER_WORKING_DIRECTORY_KEY),
                File.separator,
                File.pathSeparator,

                // Filesystem
                SystemFilesystem.getFilesystemReport(),

                // Runtime Plan
                AppMetadata.NAME,
                AppMetadata.NAME
        );
    }
}
