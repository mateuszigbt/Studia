package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Main {
    static void saveSer(ProgresBar progresbar) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("progresbar.ser");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(progresbar);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
// moduł programowy, udostępniający swą funkcjonalność za pomocą jednoznacznie zdefiniowanego interfejsu
    static ProgresBar readSer() {
        ProgresBar progresBarRead = null;

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("progresbar.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            progresBarRead = (ProgresBar) objectInputStream.readObject();
            return progresBarRead;


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return progresBarRead;
    }

    public static void main(String[] args) {
        WindowDefault windowDefault = new WindowDefault();
        final ProgresBar[] progresBar = {new ProgresBar()};

        Przyciski przyciski = new Przyciski();
        final Color[] kolor = new Color[1];

        windowDefault.setLayout(new BorderLayout());

        windowDefault.add(przyciski, BorderLayout.CENTER);


        przyciski.ustawZbiorButton.addActionListener(new ActionListener() {
            @Override
                        public void actionPerformed(ActionEvent e) {
                        int wartosc = Integer.parseInt(przyciski.zbioryTextField.getText());
                        switch (przyciski.zbioryComboBox.getSelectedIndex()) {

                            case 0:
                                if (wartosc < progresBar[0].getInt40() && wartosc >= 0) {
                                    progresBar[0].setInt20(wartosc);
                                } else {
                                    JOptionPane.showMessageDialog(windowDefault, "Podano złą wartośc lub wartość nie jest mniejsza lub wieksza od reszty sprawdz czy wartosci sie zgadazaja", "Błąd", JOptionPane.ERROR_MESSAGE);
                                }
                                break;
                            case 1:
                                if (wartosc < progresBar[0].getInt60() && wartosc > progresBar[0].getInt20()) {
                            progresBar[0].setInt40(wartosc);
                        } else {
                            JOptionPane.showMessageDialog(windowDefault, "Podano złą wartośc lub wartość nie jest mniejsza lub wieksza od reszty sprawdz czy wartosci sie zgadazaja", "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        if (wartosc < progresBar[0].getInt80() && wartosc > progresBar[0].getInt40()) {
                            progresBar[0].setInt60(wartosc);
                        } else {
                            JOptionPane.showMessageDialog(windowDefault, "Podano złą wartośc lub wartość nie jest mniejsza lub wieksza od reszty sprawdz czy wartosci sie zgadazaja", "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (wartosc < progresBar[0].getInt100() && wartosc > progresBar[0].getInt60()) {
                            progresBar[0].setInt80(wartosc);
                        } else {
                            JOptionPane.showMessageDialog(windowDefault, "Podano złą wartośc lub wartość nie jest mniejsza lub wieksza od reszty sprawdz czy wartosci sie zgadazaja", "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        if (wartosc <= 100 && wartosc > progresBar[0].getInt80()) {
                            progresBar[0].setInt100(wartosc);
                        } else {
                            JOptionPane.showMessageDialog(windowDefault, "Podano złą wartośc lub wartość nie jest mniejsza lub wieksza od reszty sprawdz czy wartosci sie zgadazaja", "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            }

        });

        przyciski.KolorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolor[0] = JColorChooser.showDialog(windowDefault, "Select a color", kolor[0]);

            }
        });

        przyciski.ustawKolorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (przyciski.GranicaComboBox.getSelectedIndex()) {
                    case 0:
                        progresBar[0].setColor20(kolor[0]);
                        break;
                    case 1:
                        progresBar[0].setColor40(kolor[0]);
                        break;
                    case 2:
                        progresBar[0].setColor60((kolor[0]));
                        break;
                    case 3:
                        progresBar[0].setColor80(kolor[0]);
                        break;
                    case 4:
                        progresBar[0].setColor100(kolor[0]);
                        break;
                }
            }
        });

        przyciski.ustawFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nameFont = new String("Arial");
                switch (przyciski.fontNameComboBox.getSelectedIndex()) {
                    case 0:
                        nameFont = "Arial";
                        break;
                    case 1:
                        nameFont = "Times New Roman";
                        break;
                    case 2:
                        nameFont = "Courier";
                        break;
                }

                progresBar[0].setLocalFont(new Font(nameFont, Font.PLAIN, (Integer) przyciski.fontSpinner.getValue()));
            }
        });

        przyciski.ustawTempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (przyciski.temperaturaComboBox.getSelectedIndex()) {
                    case 0:
                        progresBar[0].setZnak("°C");
                        break;
                    case 1:
                        progresBar[0].setZnak("°F");
                        break;
                }
            }
        });

        przyciski.zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSer(progresBar[0]);
            }
        });


        przyciski.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowBar windowBar = new WindowBar();
                windowBar.add(progresBar[0], BorderLayout.WEST);
                windowBar.setVisible(true);
            }
        });


        windowDefault.setVisible(true);

        przyciski.ladujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progresBar[0] = readSer();
            }
        });

        progresBar[0].laduj();

    }
}
