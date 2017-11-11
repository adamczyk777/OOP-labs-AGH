package sample;

import io.indico.api.utils.IndicoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImagesList {

    @FXML
    public ListView imagesList;

    private ImageClassificator classificator;

    public void initialize() {
        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList();
        try {
            classificator = new ImageClassificator(Main.dirPath, Main.apiKey);
            items.addAll(classificator.getMostMatchingFeatureValues().entrySet());
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagesList.setCellFactory(listView -> new ListCell<Map.Entry<String, String>>() {
            private ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Map.Entry<String, String> item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Image image = new Image("file:" + item.getKey(), true);
                    imageView.setImage(image);
                    setText(item.getValue());
                    setGraphic(imageView);
                }
            }
        });

        imagesList.setItems(items);
    }

}
