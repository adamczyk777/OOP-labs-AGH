package sample;

import io.indico.api.utils.IndicoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Controller {

    @FXML
    public TextField apiKey;
    @FXML
    public TextField dirPath;
    @FXML
    public Button dirBtn;
    @FXML
    public Button submitBtn;
    @FXML
    public Button clearBtn;

    @FXML
    public void initialize() {
        submitBtn.setDisable(true);
        apiKey.setText("5357d5b1a333fd6a0cd4a19647f9f338");
    }

    @FXML
    public void handleDirectorySelection(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Folder ze zdjęciami");
        File folder = directoryChooser.showDialog(new Stage());
        if (folder != null) {
            dirPath.setText(folder.getAbsolutePath());
            disableClassify();
        }
    }

    @FXML
    public void disableClassify() {
        String text1 = apiKey.getText();
        String text2 = dirPath.getText();

        boolean disableButtons = text1.isEmpty() ||
                text1.trim().isEmpty() ||
                text2.isEmpty() ||
                text2.trim().isEmpty();
        submitBtn.setDisable(disableButtons);
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        dirPath.setText("");
        apiKey.setText("");
        disableClassify();
    }

    public void handleSubmit(ActionEvent actionEvent) {
        try{
            Main.apiKey = apiKey.getText();
            Main.dirPath = dirPath.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("imagesList.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Classified Images");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
