package org.javuntu.launcher;

import java.util.Arrays;

public final class JavuntuLauncher {
    private JavuntuLauncher() {
    }

    public static void run(String[] args) {
        boolean shellOnly = Arrays.asList(args).contains("--shell");

        Launcher launcher = shellOnly ?
                new ConsoleLauncher() :
                new DesktopLauncher();

        launcher.run(args);
    }
}
