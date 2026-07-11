package org.javuntu.launcher;

import org.javuntu.shell.ConsoleShell;

public class ConsoleLauncher implements Launcher {
    @Override
    public void run(String[] args) {
        ConsoleShell consoleShell = new ConsoleShell();

        consoleShell.run();
    }
}
