package org.javuntu.system;

public class SystemConstants {

    /// System property keys
    // Java Runtime
    public static final String JAVA_VERSION_KEY = "java.version";
    public static final String JAVA_VENDOR_KEY = "java.vendor";
    public static final String JAVA_VM_NAME_KEY = "java.vm.name";
    public static final String JAVA_VM_VERSION_KEY = "java.vm.version";
    public static final String JAVA_HOME_KEY = "java.home";

    // Host Operating System
    public static final String OS_NAME_KEY = "os.name";
    public static final String OS_VERSION_KEY = "os.version";
    public static final String OS_ARCHITECTURE_KEY = "os.arch";

    // User Session
    public static final String USER_NAME_KEY = "user.name";
    public static final String USER_HOME_KEY = "user.home";
    public static final String USER_WORKING_DIRECTORY_KEY = "user.dir";

    /// File system constants
    public static final String[] FILE_SIZE_UNITS = {"B", "KB", "MB", "GB", "TB"};
    public static final int FILE_SIZE_UNIT_LIMIT = 1024;

    private SystemConstants() {
    }
}
