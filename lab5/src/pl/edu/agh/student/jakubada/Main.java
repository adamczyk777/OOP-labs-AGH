package pl.edu.agh.student.jakubada;

import java.io.FileNotFoundException;

/*--------------------------------------------------------------------------------------------------------------------*/
/* Main Class */
public class Main {

    public static void main(String[] args) {
        MicroDvd delayer = new MicroDvd();

        try {
            delayer.delay(args[0], args[1], 5000, 25);
        } catch (InvalidMethodArgumentsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidSubtitlesFormatException e) {
            e.printStackTrace();
        }
    }
}
/*--------------------------------------------------------------------------------------------------------------------*/
