package pl.edu.agh.student.jakubada;

/*--------------------------------------------------------------------------------------------------------------------*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MicroDvd class is a class that handles operations
 * on microdvd subtitle format method that it uses
 * are specified in Subtitle format interface
 */
public class MicroDvd implements SubtitlesFormat {

    // constant pattern for matching
    private static final Pattern PATTERN = Pattern.compile("\\{([0-9]*)}\\{([0-9]*)}([^\\r\\n]*)");

    /**
     * Overriden method from the interface
     * it adds just one more functionality over the interface
     * that is validate static private method
     */
    @Override
    public void delay(String in, String out, int delay, int fps) throws InvalidMethodArgumentsException, FileNotFoundException, InvalidSubtitlesFormatException {
        // Instantiating files from input paths
        File fileIn = new File(in);
        File fileOut = new File(out);

        // Scanner and writer instantiation
        Scanner scanner = new Scanner(new FileReader(fileIn));
        PrintWriter writer = new PrintWriter(fileOut);

        String currentLine;
        // Main delay loop will rad here and overwrite with new frame numbers, one line is one subtitle
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            // subtitle format validation for each line
            if (validate(currentLine)) {
                Matcher matcher = PATTERN.matcher(currentLine);
                matcher.matches();

                String newStartFrame = Integer.toString(Integer.parseInt(matcher.group(1)) + (delay/1000)*fps);
                String newEndFrame = Integer.toString(Integer.parseInt(matcher.group(2)) + (delay/1000)*fps);

                String newCurrentLine = "{"
                        + newStartFrame
                        + "}{"
                        + newEndFrame
                        +"}"
                        + matcher.group(3);
                writer.println(newCurrentLine);
            } else {
                throw new InvalidSubtitlesFormatException();
            }
        }
        // closing streams in order to files be able to be saved
        scanner.close();
        writer.close();
    }

    /**
     * Validator method used for classwide validation of MicroDVD format lines
     */
    private static boolean validate(String line) {
        if (line.matches("\\{([0-9]*)}\\{([0-9]*)}([^\\r\\n]*)")) {
            return true;
        }
        return false;
    }
}
/*--------------------------------------------------------------------------------------------------------------------*/
