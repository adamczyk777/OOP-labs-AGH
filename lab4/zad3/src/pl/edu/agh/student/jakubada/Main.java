package pl.edu.agh.student.jakubada;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File input = new File("C:\\Users\\jadamczyk\\IdeaProjects\\programowanie-obiektowe-agh\\lab4\\zad3\\src\\pl\\edu\\agh\\student\\jakubada\\in.txt");
        File output = new File("C:\\Users\\jadamczyk\\IdeaProjects\\programowanie-obiektowe-agh\\lab4\\zad3\\src\\pl\\edu\\agh\\student\\jakubada\\out.txt");
        File decrypted = new File("C:\\Users\\jadamczyk\\IdeaProjects\\programowanie-obiektowe-agh\\lab4\\zad3\\src\\pl\\edu\\agh\\student\\jakubada\\decrypted.txt");
        try {
            Cryptographer.cryptfile(input, output, new Polibiusz());
            Cryptographer.decryptfile(output, decrypted, new Polibiusz());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
