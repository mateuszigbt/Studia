package com.company;

import javax.swing.*;
import java.awt.*;

public class Przyciski extends JPanel {

    String[] GranicznyString = {"zimno", "letnio", "cieplo", "gorąco", "parzy"};
    String[] temperaturaString = {"C", "F"};
    String[] fontNameString = {"Arial", "Times New Roman", "Courier"};

    SpinnerNumberModel fontSpinnerNumberModel = new SpinnerNumberModel(15, 15, 25, 1);
    JSpinner fontSpinner = new JSpinner(fontSpinnerNumberModel);

    JButton ustawKolorButton = new JButton("Ustaw Kolor");
    JButton ustawFontButton = new JButton("Ustaw font");
    JButton startButton = new JButton("Start");
    JButton ustawZbiorButton = new JButton("Ustaw wartosc");
    JButton zapiszButton = new JButton("zapisz stan");
    JButton ustawTempButton = new JButton("Ustaw znak");
    JButton KolorButton = new JButton("Wybierz kolor");
    JButton ladujButton = new JButton("laduj");

    JLabel kolorLabel = new JLabel("Wybierz kolor");
    JLabel granicaLabel = new JLabel("Kolory graniczne");
    JLabel temperaturaLabel = new JLabel("Jednostka Temepartury");
    JLabel fontLabel = new JLabel("Rozmiar czcionki");
    JLabel fontNameLabel = new JLabel("Nazwa fontu");
    JLabel zbioryLabel = new JLabel("Wybor zbioru");
    JLabel wartoscLabel = new JLabel("Wartosc");


    JComboBox GranicaComboBox = new JComboBox(GranicznyString);
    JComboBox temperaturaComboBox = new JComboBox(temperaturaString);
    JComboBox fontNameComboBox = new JComboBox(fontNameString);
    JComboBox zbioryComboBox = new JComboBox(GranicznyString);

    JTextField zbioryTextField = new JTextField();

    JPanel localPanel = new JPanel();
    JPanel downPanel = new JPanel();

    Przyciski() {

        this.setPreferredSize(new Dimension(1, 1));
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new BorderLayout());

        localPanel.setLayout(new GridLayout(4, 5, 10, 10));

        localPanel.add(zbioryLabel);
        localPanel.add(zbioryComboBox);
        localPanel.add(wartoscLabel);
        localPanel.add(zbioryTextField);
        localPanel.add(ustawZbiorButton);

        localPanel.add(granicaLabel);
        localPanel.add(GranicaComboBox);
        localPanel.add(kolorLabel);
        localPanel.add(KolorButton);
        localPanel.add(ustawKolorButton);

        localPanel.add(fontNameLabel);
        localPanel.add(fontNameComboBox);
        localPanel.add(fontLabel);
        localPanel.add(fontSpinner);
        localPanel.add(ustawFontButton);

        localPanel.add(temperaturaLabel);
        localPanel.add(temperaturaComboBox);
        localPanel.add(ustawTempButton);

        downPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        downPanel.setLayout(new FlowLayout(SwingConstants.RIGHT));
        downPanel.add(zapiszButton);
        downPanel.add(startButton);
        downPanel.add(ladujButton);

        this.add(localPanel, BorderLayout.CENTER);
        this.add(downPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }


}
