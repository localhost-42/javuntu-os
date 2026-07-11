package org.javuntu.launcher;

import javax.swing.*;

public class DesktopLauncher implements Launcher {
    @Override
    public void run(String[] args) {
        // Runs the GUI initialization on Swing's Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            setNiceLookAndFeel();
            // run desktop shell (gui)
        });
    }

    // Applies the native look and feel of the current operating system the app run on
    // If run on Windows distro, use Windows style kit
    // If on Linux kernel, use default Linux style
    private static void setNiceLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // The default Swing look and feel is good enough for this prototype.
        }
    }
}
