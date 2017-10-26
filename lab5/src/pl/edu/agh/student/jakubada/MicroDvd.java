package pl.edu.agh.student.jakubada;

/*--------------------------------------------------------------------------------------------------------------------*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * MicroDvd class is a class that handles operations
 * on microdvd subtitle format method that it uses
 * are specified in Subtitle format interface
 */
public class MicroDvd implements SubtitlesFormat {
    @Override
    public void delay(String in, String out, int delay, int fps) throws InvalidMethodArgumentsException, FileNotFoundException {
        // Instantiating files from input paths
        File fileIn = new File(in);
        File fileOut = new File(out);

        // Scanner and writer instantiation
        Scanner scanner = new Scanner(new FileReader(fileIn));
        PrintWriter writer = new PrintWriter(fileOut);

        // Main delay loop will rad here and overwrite with new frame numbers, one line is one subtitle
        while (scanner.hasNextLine()) {

        }
    }
}
/*--------------------------------------------------------------------------------------------------------------------*/
