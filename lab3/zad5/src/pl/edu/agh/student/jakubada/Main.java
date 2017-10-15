package pl.edu.agh.student.jakubada;

public class Main {

    public static void main(String[] args) {
        try {
            EmailMessage email = EmailMessage.builder()
                    .addFrom("adamczykjavax@gmail.com")
                    .addTo("adamczyk777@gmail.com", "patrykofbat@gmail.com")
                    .addSubject("testowy mail")
                    .addContent("tresc maila")
                    .build();
            email.send();
            System.out.println("message sent");
        } catch (EmailMessage.Builder.InvalidEmailMessageBuilderParameterData invalidEmailMessageBuilderParameterData) {
            invalidEmailMessageBuilderParameterData.printStackTrace();
        }
    }
}
