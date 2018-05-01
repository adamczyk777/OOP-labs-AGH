package pl.edu.agh.student.jakubada;

import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {


    public static void main(String[] args) {
        // Could be read from args
        URL url = Main.class.getResource("foto");
        String PATH = url.getPath();
        System.out.println(PATH);

        try {
            // Creating instance of image classificator with image directory and api key for indico api
            ImageClassificator classificator = new ImageClassificator(
                    PATH,
                    "5357d5b1a333fd6a0cd4a19647f9f338");
            //Iterating over each map of results from image classificator
            for (Map.Entry<String, String> entry : classificator.getMostMatchingFeatureValues().entrySet()) {
                // create a new directory for each feature, for now just in java, it's like declaration of path that there may be a file
                File newDir = new File(PATH + "output\\" + entry.getValue());
                // Check if that specified earlier file exists
                if (!newDir.exists()) {
                    // and finally make a new directory if filesystem if not
                    newDir.mkdir();
                }
                File image = new File(entry.getKey());
                // copying image
                Files.copy(image.toPath(), new File(newDir.getAbsolutePath() + "\\" + image.getName()).toPath(), REPLACE_EXISTING);
            }
        } catch (IndicoException e) {
            e.printStackTrace();
            System.out.println("Indico API most likely has some problem with your data or your connection");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with input files, or folders");
        }

    }
}
