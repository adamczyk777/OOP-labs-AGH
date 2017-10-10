package pl.edu.agh.student.jakubada;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jakub Adamczyk on 10.10.2017
 */
public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)
    public EmailMessage(String from,
                        LinkedList<String> to,
                        String subject,
                        String content,
                        String mimeType,
                        LinkedList<String> cc,
                        LinkedList<String> bcc) {
        // wiele if, else, sprawdzania czy string jest e-mail, itd.
    }

    public void send() {
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
//        Composing the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
//            this.to.stream().forEach(s -> {
//                try {
//                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
//                } catch (MessagingException e) {
//                    e.printStackTrace();
//                }
//            });
            message.setRecipients(Message.RecipientType.TO, String.valueOf(this.to));
            message.setRecipients(Message.RecipientType.CC, String.valueOf(this.cc));
            message.setRecipients(Message.RecipientType.BCC, String.valueOf(this.bcc));
            message.setSubject(this.subject);
            message.setText(this.content);
//            mimetype missing
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static Builder builder() {       // Factory??
        return new EmailMessage.Builder();
    }

    public static class Builder {

        private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        private static boolean validateEmail(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
            return matcher.find();
        }

        private String newFrom;
        private LinkedList<String> newTo;
        private String newSubject;
        private String newContent;
        private String newMimeType;
        private LinkedList<String> newCc;
        private LinkedList<String> newBcc;

        public Builder addFrom(String from) throws InvalidEmailMessageBuilderParameterData {
            if (validateEmail(from) && from != null) {
                this.newFrom = from;
                return this;
            } else {
                throw new InvalidEmailMessageBuilderParameterData("Wrong from email");
            }
        }

        public Builder addTo(String... tos) throws InvalidEmailMessageBuilderParameterData {
            if (Arrays.stream(tos).allMatch(s -> validateEmail(s) && s != null)) {
                this.newTo = new LinkedList<>();
                this.newTo.addAll(Arrays.asList(tos));
                return this;
            } else {
                throw new InvalidEmailMessageBuilderParameterData("One of To emails is invalid");
            }
        }

        public Builder addSubject(String subject) {
            this.newSubject = subject;
            return this;
        }

        public Builder addContent(String content) {
            this.newContent = content;
            return this;
        }

        public Builder addMimeType(String mimeType) {
            this.newMimeType = mimeType;
            return this;
        }

        public Builder addCc(String... ccs) throws InvalidEmailMessageBuilderParameterData {
            if (Arrays.stream(ccs).allMatch(s -> validateEmail(s) && s != null)) {
                this.newCc = new LinkedList<>();
                this.newCc.addAll(Arrays.asList(ccs));
                return this;
            } else {
                throw new InvalidEmailMessageBuilderParameterData("One of CC emails is invalid");
            }
        }

        public Builder addBcc(String... bccs) throws InvalidEmailMessageBuilderParameterData {
            if (Arrays.stream(bccs).allMatch(s -> validateEmail(s) && s != null)) {
                this.newBcc = new LinkedList<>();
                this.newBcc.addAll(Arrays.asList(bccs));
                return this;
            } else {
                throw new InvalidEmailMessageBuilderParameterData("One of BCC emails is invalid");
            }
        }

        public EmailMessage build() throws InvalidEmailMessageBuilderParameterData {
            if (this.newFrom == null || this.newTo != null) {
                return new EmailMessage(newFrom, newTo, newSubject, newContent, newMimeType, newCc, newBcc);
            } else {
                throw new InvalidEmailMessageBuilderParameterData("Not all required fields were added to this build!");
            }
        }

        public class InvalidEmailMessageBuilderParameterData extends Exception {
            public InvalidEmailMessageBuilderParameterData(String message) {
                super(message);
            }
        }

    }
}
