package org.javuntu.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemProperties {
    public static final String DEFAULT_VALUE = "unknown";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getProperty(String key) {
        return System.getProperty(key, DEFAULT_VALUE);
    }

    public static String getProperty(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }

    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
}
