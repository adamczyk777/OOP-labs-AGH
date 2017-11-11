package sample;

import io.indico.api.utils.IndicoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.IOException;
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
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart<String,Number> bc =
                        new BarChart<String,Number>(xAxis,yAxis);
                bc.setTitle("Feature Values");
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

        imagesList.setCellFactory(listView -> new ListCell<Pair<Image, BarChart>>() {
            private ImageView imageView = new ImageView();
            private HBox hBox = new HBox();
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            private BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

            @Override
            protected void updateItem(Pair<Image, BarChart> item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    imageView.setImage(item.getKey());
                    hBox.getChildren().addAll(imageView, item.getValue());
                    setGraphic(hBox);

                }
            }
        });

        imagesList.setItems(items);
    }

}
