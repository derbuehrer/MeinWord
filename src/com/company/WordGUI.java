package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordGUI {
    private JPanel panel;
    private JButton speicher;
    private JTextArea textArea1;
    private JButton ladenButton;

    public static void main(String[] args) throws FileNotFoundException {
        // Aufbau des GUI Fensters mit genauen Angaben wie Position und Größe
        JFrame frame = new JFrame("Mein Word");
        frame.setContentPane(new WordGUI().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(670, 340);
        frame.setSize(600, 400);
    }

    public WordGUI() throws FileNotFoundException {



        speicher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Beim Speichern wird gefragt wie die Datei heissen soll
                String speichern = JOptionPane.showInputDialog(null, "Wie soll die Datei heißen?");
                StringBuilder sb = new StringBuilder();
                // Dateiname + ".txt" für das Dateiformat
                sb.append(speichern + ".txt");
                try {
                    // Erstellen der Hilfsdatei ".Dateien.txt" um die Datei mit induviduellem Namen zu laden
                    PrintWriter print = new PrintWriter(".Dateien.txt");
                    print.println(sb.toString());
                    print.close();
                    // Speichern der induviduell benannten Datei und ihr Inhalt
                    Speichere.speichern(textArea1.getText(), sb.toString());
                    // Damit Java ruhe gibt
                } catch (FileNotFoundException e1) {
                    System.err.println("Öööhh ich muss rumheulen mama");
                    System.exit(0);
                }
            }
        });

        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateien = "";
                try {
                    Scanner sc = new Scanner(new FileReader(".Dateien.txt"));
                    // Lesen wie die zu ladende Datei heisst
                    dateien = sc.nextLine();
                    // Laden der Datei
                    textArea1.append(Speichere.lesen(dateien));
                } catch (FileNotFoundException f) {
                    System.err.println("Ich bin Java und muss rumheulen");
                }
                catch (NoSuchElementException g) {
                    System.err.println("Es ist keine Datei gespeichert");
                }
            }
        });
    }
}
