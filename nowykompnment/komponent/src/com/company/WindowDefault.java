package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowDefault extends JFrame {
    //
    ProgresBar progresBar = new ProgresBar();

    WindowDefault() {
        this.setTitle("Komponent");
        this.setSize(1000, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                WindowExit();
            }
        });

    }

    private void WindowExit() {
        int a = JOptionPane.showOptionDialog(this,
                "Czy chcesz zamknac aplikacje ?",
                "Uwaga", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null,
                new String[]{"Tak", "Nie"}, "Tak");
        if (a == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

}
