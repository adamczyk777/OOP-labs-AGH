package sample;

import io.indico.api.utils.IndicoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Controller {

    @FXML
    public TextField apiKey;
    @FXML
    public TextField dirPath;
    public Button dirBtn;
    public Button submitBtn;
    public Button clearBtn;

    public void handleDirectorySelection(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Folder ze zdjęciami");
        File folder = directoryChooser.showDialog(new Stage());
        dirPath.setText(folder.getAbsolutePath());
    }

    public void handleGetPhotosClick(ActionEvent actionEvent) {
        try {
            ImageClassificator classificator = new ImageClassificator(dirPath.getText(), apiKey.getText());
            final Map<String, String> mostMatchingFeatureValues = classificator.getMostMatchingFeatureValues();
            System.out.println(mostMatchingFeatureValues);
            for (Map.Entry<String, String> element : mostMatchingFeatureValues.entrySet()) {
                //handle adding cells
            }
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
