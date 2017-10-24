package pl.edu.agh.student.jakubada;

import java.io.*;
import java.util.Scanner;

/** Klasa Cryptographer
 *  Jest klasą obsługująca szyfrowanie
 *  Dostając plik obsługuje czytanie z niego
 *  poza tym umożliwia podanie obiektu, dzieki ktoremu okreslamy jakim algorytmem szyfrujemy lub deszyfrujemy*/

public class Cryptographer {

    // Metoda cryptfile przyjmyje plik wejscia wyjscia, oraz obiekt typu Algorithm zawierajacy alorytm szyfrowania
    public static void cryptfile(File inputFile, File outputFile, Algorithm cryptingMethod) throws IOException {
        // Creating streams for reading ad writing files method may throw an exception that needs to be handled further
        Scanner inputFileReader = new Scanner(new FileReader(inputFile));
        PrintWriter outputFileWriter = new PrintWriter(new FileWriter(outputFile));

        // While file didn't reach the end read lines
        while (inputFileReader.hasNextLine()) {
            // add line to file with crypted line string using crypt method
            outputFileWriter.println(cryptingMethod.crypt(inputFileReader.nextLine()));
        }

        // close readers
        inputFileReader.close();
        outputFileWriter.close();
    }
    // blizniacza metoda do cryptfile robi to samo tylko wywołuje w algorytmie metody do rozszyfrowywania
    public static void decryptfile(File inputFile, File outputFile, Algorithm decryptingMethod) throws IOException {
        // Creating streams for reading ad writing files method may throw an exception that needs to be handled further
        Scanner inputFileReader = new Scanner(new FileReader(inputFile));
        PrintWriter outputFileWriter = new PrintWriter(new FileWriter(outputFile));

        // While file didn't reach the end read lines
        while (inputFileReader.hasNextLine()) {
            // add decrypted line to a file using certain decrypt method provided
            outputFileWriter.println(decryptingMethod.decrypt(inputFileReader.nextLine()));
        }

        // close readers
        inputFileReader.close();
        outputFileWriter.close();
    }
}
