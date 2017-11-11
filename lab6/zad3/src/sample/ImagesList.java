package sample;

import io.indico.api.utils.IndicoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagesList {

    @FXML
    public ListView imagesList;
    private ImageClassificator classificator;

    public void initialize() {
        List<String> imagePaths = new ArrayList<>();
        try {
            classificator = new ImageClassificator(Main.dirPath, Main.apiKey);
            imagePaths.addAll(classificator.getMostMatchingFeatureValues().keySet());
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        imagePaths.forEach(item -> items.add("file:" + item));

        imagesList.setCellFactory(listView -> new ListCell<String>() {
            private ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Image image = new Image(item, true);
                    imageView.setImage(image);
                    setGraphic(imageView);
                }
            }
        });

        imagesList.setItems(items);
    }

}
