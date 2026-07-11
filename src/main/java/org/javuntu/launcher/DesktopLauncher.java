package org.javuntu.launcher;

import javax.swing.*;

public class DesktopLauncher implements Launcher {
    @Override
    public void run(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setNiceLookAndFeel();
            // run desktop shell (gui)
        });
    }

    private static void setNiceLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // The default Swing look and feel is good enough for this prototype.
        }
    }
}
