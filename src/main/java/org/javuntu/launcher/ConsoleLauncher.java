package org.javuntu.launcher;

import org.javuntu.shell.ShellEngine;
import org.javuntu.shell.ui.ConsoleShell;

public class ConsoleLauncher implements Launcher {
    @Override
    public void run(String[] args) {
        ConsoleShell consoleShell = new ConsoleShell(new ShellEngine());

        consoleShell.run();
    }
}
