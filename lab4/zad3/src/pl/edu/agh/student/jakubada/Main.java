package pl.edu.agh.student.jakubada;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File input = new File(args[0]);
        File output = new File(args[1]);
//        File decrypted = new File("C:\\Users\\jadamczyk\\IdeaProjects\\programowanie-obiektowe-agh\\lab4\\zad3\\src\\pl\\edu\\agh\\student\\jakubada\\decrypted.txt");
//        try {
//            Cryptographer.cryptfile(input, output, new ROT11());
//            Cryptographer.decryptfile(output, decrypted, new ROT11());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz 1 aby szyfrować, lub 0 aby odszyfrować:");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Wybierz algorytm jakim chcesz szyfrować");
        System.out.println("0 - Algorytm ROT11");
        System.out.println("1 - Algorytm Polibiusza");
        int choiceAlgo = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            if (choiceAlgo == 0) {
                System.out.println("Wybrano algorytm ROT11, szyfrowanie ...");
                try {
                    Cryptographer.cryptfile(input, output, new ROT11());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choiceAlgo == 1) {
                System.out.println("Wybrano algorytm polibiusza, szyfrowanie ...");
                try {
                    Cryptographer.cryptfile(input, output, new Polibiusz());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("zły wybór algorytmu, uruchon ponownie program");
                return;
            }
            System.out.println("Zaszyfrowano!");
        } else if (choice == 0) {
            if (choiceAlgo == 1) {
                System.out.println("Wybrano algorytm polibiusza, rozszyfrowywanie ...");
                try {
                    Cryptographer.decryptfile(input, output, new Polibiusz());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choiceAlgo == 0) {
                System.out.println("Wybrano algorytm ROT11, rozszyfrowywanie ...");
                try {
                    Cryptographer.decryptfile(input, output, new ROT11());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("zły wybór algorytmu uruchom ponownie program");
                return;
            }
            System.out.println("Rozszyfrowano!");
        } else {
            System.out.println("Zły wybór trybu pracy uruchom program ponownie");
        }
    }
}
