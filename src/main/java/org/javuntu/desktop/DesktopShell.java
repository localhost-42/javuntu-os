package org.javuntu.desktop;

import org.javuntu.shell.ui.ShellUI;

import javax.swing.*;
import java.awt.*;

/**
 * The graphical desktop shell of Javuntu.
 *
 * This class provides the main desktop UI, including navigation,
 * the top bar, dock, terminal, file manager, and settings.
 *
 * It is not a complete desktop environment by itself.
 * A full desktop environment would also include components such as
 * window management, session management, notifications, etc.
 */
public class DesktopShell extends JFrame implements ShellUI {

    public DesktopShell(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(960, 620));
        setLocationRelativeTo(null);
    }

    @Override
    public void build() {

    }

    @Override
    public void run() {

    }
}
