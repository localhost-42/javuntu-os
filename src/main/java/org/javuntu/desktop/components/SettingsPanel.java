package org.javuntu.desktop.components;

import org.javuntu.desktop.Theme;
import org.javuntu.system.SystemSpecs;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public SettingsPanel(String label) {
        super(new BorderLayout(10, 10));

        build(label);
    }

    private void build(String label) {
        setBackground(Theme.BACKGROUND);
        setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JLabel title = new JLabel(label);
        title.setForeground(Theme.TEXT);
        title.setFont(Theme.TITLE_FONT);

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setBackground(Theme.PANEL_DARK);
        text.setForeground(Theme.TEXT);
        text.setFont(Theme.MONO_FONT);
        text.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
        text.setLineWrap(false);
        text.setText(SystemSpecs.getFullReport());
        text.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBorder(BorderFactory.createLineBorder(Theme.BORDER));

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
