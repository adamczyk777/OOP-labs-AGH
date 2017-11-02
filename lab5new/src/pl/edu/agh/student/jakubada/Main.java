package pl.edu.agh.student.jakubada;

import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {


    public static void main(String[] args) {
        String PATH = "C:\\Users\\jadamczyk\\Documents\\GitRepositories\\programowanie-obiektowe-agh\\lab5new\\";
        try {
            ImageClassificator classificator = new ImageClassificator(
                    PATH + "foto",
                    "5357d5b1a333fd6a0cd4a19647f9f338");
            for (Map.Entry<String, String> entry : classificator.getMostMatchingFeatureValues().entrySet()) {
                File newDir = new File(PATH + "output\\" + entry.getValue());
                if (!newDir.exists()) {
                    newDir.mkdir();
                }
                File image = new File(entry.getKey());
                Files.copy(image.toPath(), new File(newDir.getAbsolutePath() + "\\" + image.getName()).toPath(), REPLACE_EXISTING);
            }
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
