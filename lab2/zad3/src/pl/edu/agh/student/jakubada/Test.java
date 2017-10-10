package pl.edu.agh.student.jakubada;

import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    private static LinkedList<Punkt3D> punkty = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=====================================================================");
            System.out.print("1. Wczytaj punkt 3D\n" +
                    "2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odległość\n" +
                    "4. Zakończ\n");
            System.out.println("=====================================================================");

            System.out.print("Wybrana Opcja:");
            int selected = scanner.nextInt();

            switch (selected) {
                case 1:
                    System.out.println("Wpisz po kolei wspołrzędne:");

                    System.out.print("X: ");
                    double x = scanner.nextDouble();

                    System.out.print("Y: ");
                    double y = scanner.nextDouble();

                    System.out.print("Z: ");
                    double z = scanner.nextDouble();

                    punkty.add(new Punkt3D(x, y, z));
                    break;
                case 2:
                    System.out.println("=====================================================================");
                    for (Punkt3D punkt :
                            punkty) {
                        System.out.println("Lista punktów: ");
                        System.out.println(punkty.indexOf(punkt) + ": " + punkt.toString());
                    }
                    System.out.println("=====================================================================");
                    break;
                case 3:
                    System.out.println("Oto dostępne do wybrania punkty:");
                    wyswietlPunkty();
                    System.out.println("Wpisz indeks pierwszego punktu: ");
                    int first = scanner.nextInt();
                    System.out.println("Wpisz indeks drugiego punktu: ");
                    int second = scanner.nextInt();
                    if (first >= punkty.size() || second >= punkty.size() || first < 0 || second < 0) {
                        System.out.println("Wprowadzono błędne indeksy");
                    } else {
                        System.out.println("Odległość między wybranymi punktami wynosi: "
                                + punkty.get(first).distance(punkty.get(second)));
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void wyswietlPunkty() {
        for (Punkt3D punkt :
                punkty) {
            System.out.println(punkty.indexOf(punkt) + ": " + punkt.toString());
        }
    }
}
