package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Speichere {


    public static void speichern(String textArea1, String text) throws FileNotFoundException {
        // Speichern der induviduell benannten Datei
        PrintWriter print = new PrintWriter(text);
        print.print(textArea1);
        print.close();
    }

    public static String lesen(String dateien) {
        // Mithilfe des StringBuilders wird der Inhalt der Textdatei gelesen und im textAreal geschrieben
        StringBuilder sb = new StringBuilder();
        try {
            Scanner lesen = new Scanner(new FileReader(dateien));
            do {
                // Laden von jeder Zeile
                sb.append(lesen.nextLine());
                sb.append("\n");
            }
            while (lesen.hasNextLine());
        }
        catch (NoSuchElementException e) {
            return null;
        }
        catch (FileNotFoundException f) {
            return null;
        }
        return sb.toString();
    }
}
