package pl.edu.agh.student.jakubada;

/*--------------------------------------------------------------------------------------------------------------------*/

import java.io.FileNotFoundException;

/**
 * SubtitlesFormat interface
 * used for standarization of diffrent subtitle formats
 * ex. MicroDvd is one format and SubRIP is another
 * standarization is about single access methods interface to use them anywhere
 */
public interface SubtitlesFormat {
    /**
     * delay method:
     * in: input file path
     * out: output file path
     * delay: delay of subtitles in milliseconds
     * fps: move framerate in frames per second
     */
    void delay(String in, String out, int delay, int fps) throws InvalidMethodArgumentsException, FileNotFoundException, InvalidSubtitlesFormatException;
}
/*--------------------------------------------------------------------------------------------------------------------*/
