package org.javuntu.launcher;

import java.util.Arrays;

public final class JavuntuLauncher implements Launcher {
    public JavuntuLauncher() {
    }

    @Override
    public void run(String[] args) {
        boolean shellOnly = Arrays.asList(args).contains("--shell");

        if (shellOnly) {
            runConsoleBootstrap();
        } else {
            runDesktopBootstrap();
        }
    }

    private void runConsoleBootstrap() {
        // run console ui (CLI)
    }

    private void runDesktopBootstrap() {
        // run desktop ui (GUI)
    }
}
