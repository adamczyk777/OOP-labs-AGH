package pl.edu.agh.student.jakubada;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            EmailMessage.Builder emailBuilder = EmailMessage.builder();
            emailBuilder.addFrom("adamczyk1997@gmail.com");
//            System.out.println("Wprowadź email wysyłającego:");
//            emailBuilder.addFrom(scanner.nextLine());
            System.out.println("Wprowadź adresata:");
            emailBuilder.addTo(scanner.nextLine());
            System.out.println("Wprowadź temat wiadomości:");
            emailBuilder.addSubject(scanner.nextLine());
            System.out.println("Wprowadź treść emaila::");
            emailBuilder.addContent(scanner.nextLine());
//                    .addFrom("adamczykjavax@gmail.com")
//                    .addTo("adamczyk777@gmail.com")
//                    .addSubject("testowy mail")
//                    .addContent("tresc maila")
//                    .build();
            EmailMessage email = emailBuilder.build();
            email.send();
            System.out.println("message sent");
        } catch (InvalidEmailMessageBuilderParameterData invalidEmailMessageBuilderParameterData) {
            invalidEmailMessageBuilderParameterData.printStackTrace();
        }
    }
}
