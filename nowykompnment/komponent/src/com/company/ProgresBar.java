package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ProgresBar extends JPanel implements Serializable {

    private static final long serialVersionUID = 260409533898396879L;

    private JLabel nazwa = new JLabel();
    private JTextField textField = new JTextField();
    private Dimension textAreaDimension = new Dimension(380, 100);
    private Przyciski przyciski = new Przyciski();
    private String znak = new String("°C");
    private Color color20 = new Color(0, 0, 204);
    private Color color40 = new Color(102, 153, 255);
    private Color color60 = new Color(255, 255, 0);
    private Color color80 = new Color(255, 153, 0);
    private Color color100 = new Color(255, 0, 0);
    private int int20 = 20;
    private int int40 = 40;
    private int int60 = 60;
    private int int80 = 80;
    private int int100 = 100;
    private transient int licznik = 0;

    private JProgressBar progressBar = new JProgressBar(0, 100);

    public JLabel getNazwa() {
        return nazwa;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public void setNazwa(JLabel nazwa) {
        this.nazwa = nazwa;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public Dimension getTextAreaDimension() {
        return textAreaDimension;
    }

    public void setTextAreaDimension(Dimension textAreaDimension) {
        this.textAreaDimension = textAreaDimension;
    }

    public Przyciski getPrzyciski() {
        return przyciski;
    }

    public void setPrzyciski(Przyciski przyciski) {
        this.przyciski = przyciski;
    }

    public Color getColor20() {
        return color20;
    }

    public void setColor20(Color color20) {
        this.color20 = color20;
    }

    public Color getColor40() {
        return color40;
    }

    public void setColor40(Color color40) {
        this.color40 = color40;
    }

    public Color getColor60() {
        return color60;
    }

    public void setColor60(Color color60) {
        this.color60 = color60;
    }

    public Color getColor80() {
        return color80;
    }

    public void setColor80(Color color80) {
        this.color80 = color80;
    }

    public Color getColor100() {
        return color100;
    }

    public void setColor100(Color color100) {
        this.color100 = color100;
    }

    public void setLocalFont(Font localFont) {
        this.localFont = localFont;
    }

    private Font localFont;

    public int getInt20() {
        return int20;
    }

    public void setInt20(int int20) {
        this.int20 = int20;
    }

    public int getInt40() {
        return int40;
    }

    public void setInt40(int int40) {
        this.int40 = int40;
    }

    public int getInt60() {
        return int60;
    }

    public void setInt60(int int60) {
        this.int60 = int60;
    }

    public int getInt80() {
        return int80;
    }

    public void setInt80(int int80) {
        this.int80 = int80;
    }

    public int getInt100() {
        return int100;
    }

    public void setInt100(int int100) {
        this.int100 = int100;
    }

    private String textBox = new String("");


    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    ProgresBar() {


        nazwa.setText("Jadro:");

        nazwa.setFont(localFont);

        progressBar.setValue(0);
        progressBar.setStringPainted(false);
        progressBar.setPreferredSize(new Dimension(380, 100));
        progressBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));

        textField.setPreferredSize(textAreaDimension);
        textField.setMaximumSize(textAreaDimension);
        textField.setFont(localFont);
        textField.setEditable(false);

        progressBar.setBorder(BorderFactory.createEmptyBorder(0, 100, 5, 5));
        textField.setBorder(BorderFactory.createEmptyBorder(11, 100, 5, 5));
        nazwa.setBorder(BorderFactory.createEmptyBorder(60, 100, 5, 5));

        this.setLayout(new GridLayout(3, 1, 2, 2));
        this.add(nazwa);
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.add(progressBar);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(textField);
        this.add(Box.createRigidArea(new Dimension(0, 20)));

        this.setVisible(true);

        nazwa.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void laduj() {


        int licznik = 0;


        while (licznik <= 100) {
            nazwa.setFont(localFont);
            textField.setFont(localFont);
            nazwa.setText("Temperatura jadra ");

            progressBar.setValue(licznik);
            progressBar.setValue(licznik);


            if (licznik >= 0) {
                textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak + " " + textBox);
            }

            if (licznik == int20) {
                // textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                textBox = "Zimno";
                progressBar.setForeground(color20);
            }

            if (licznik == int40) {
                // textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                textBox = "Letnio";
                progressBar.setForeground(color40);
            }

            if (licznik == int60) {
                //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                textBox = "Cieplo";
                progressBar.setForeground(color80);
            }

            if (licznik == int80) {
                //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                textBox = "Gorąco";
                progressBar.setForeground(color100);
            }

            if (licznik == int100) {
                //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                textBox = "Parzy";
                progressBar.setForeground(color100);
            }

            licznik += 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException c) {
                c.printStackTrace();
            }

            if (licznik == 100) {
                while (licznik >= 0) {
                    nazwa.setFont(localFont);
                    textField.setFont(localFont);
                    nazwa.setText("Temperatura jadra ");
                    progressBar.setValue(licznik);

                    if (licznik <= 100) {

                        textField.setText("Temperatura jadra to: " + Integer.toString(licznik) + znak + " " + textBox);
                    }

                    if (licznik == int100) {
                        //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                        textBox = "Parzy";
                        progressBar.setForeground(color100);
                    }

                    if (licznik == int80) {
                        //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                        textBox = "Gorąco";
                        progressBar.setForeground(color100);
                    }
                    if (licznik == int60) {
                        //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                        textBox = "Cieplo";
                        progressBar.setForeground(color80);
                    }
                    if (licznik == int40) {
                        //textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                        textBox = "Letnio";
                        progressBar.setForeground(color40);
                    }
                    if (licznik == int20) {
                        // textField.setText("Temperatura pieca to: " + Integer.toString(licznik) + znak +  " " + textBox);
                        textBox = "Zimno";
                        progressBar.setForeground(color20);
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException c) {
                        c.printStackTrace();
                    }
                    licznik -= 1;
                }
            }
        }
    }
}

