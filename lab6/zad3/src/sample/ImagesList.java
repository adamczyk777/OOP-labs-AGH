package sample;

import io.indico.api.utils.IndicoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.Map;

public class ImagesList {

    @FXML
    public ListView imagesList;

    private ImageClassificator classificator;

    public void initialize() {
        ObservableList<Pair<Image, BarChart<String, Number>>> items = FXCollections.observableArrayList();
        try {
            classificator = new ImageClassificator(Main.dirPath, Main.apiKey);
//            items.addAll(classificator.getAllFeatureValues().entrySet());
            classificator.getAllFeatureValues().forEach((key, value) -> {
                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis();
                BarChart<String,Number> bc =
                        new BarChart<String,Number>(xAxis,yAxis);
                xAxis.setLabel("Name");
                yAxis.setLabel("Value");

                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Features");
                value.forEach((chKey, chValue) -> {
                    series1.getData().add(new XYChart.Data<String, Double>(chKey, chValue));
                });
                bc.getData().add(series1);
                Image image = new Image("file:" + key);
                items.add(new Pair<>(image, bc));
            });
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagesList.setCellFactory(listView -> new ListCell<Pair<Image, BarChart<String, Number>>>() {
            private ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Pair<Image, BarChart<String, Number>> item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    imageView.setImage(item.getKey());
                    setText("Click to get Chart");
                    setGraphic(imageView);
                    this.setOnMouseClicked(mouseEvent -> {
                        HBox hBox = new HBox(item.getValue());
                        hBox.setHgrow(item.getValue(), Priority.ALWAYS);
                        Scene scene = new Scene(hBox, 1000, 800);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setWidth(1000);
                        stage.setHeight(800);
                        stage.show();
                    });
                }
            }
        });

        imagesList.setItems(items);
    }

}
