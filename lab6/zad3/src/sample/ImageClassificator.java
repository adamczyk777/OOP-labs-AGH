package sample;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageClassificator {
    private File folder;
    private Indico apiInstance;

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public Indico getApiInstance() {
        return apiInstance;
    }

    public void setApiInstance(Indico apiInstance) {
        this.apiInstance = apiInstance;
    }

    public ImageClassificator(String folderPath, String apiKey) throws IndicoException {
        this.folder = new File(folderPath);
        this.apiInstance = new Indico(apiKey);
    }

    public Map<String, String> getMostMatchingFeatureValues() throws IndicoException, IOException {
        // Geting File paths
        File[] photosFileList = folder.listFiles();
        String[] photoPathList = new String[photosFileList.length];
        for (int i = 0; i < photoPathList.length; i++) {
            photoPathList[i] = photosFileList[i].getAbsolutePath();
        }
        // Api Call
        BatchIndicoResult multiple = this.apiInstance.imageRecognition.predict(photoPathList);
        List<Map<String, Double>> imageRecognition = multiple.getImageRecognition();

        Map<String, String> results = new HashMap<>();
        // simple max function to find entry with max double valued
        int i = 0;
        for (Map<String, Double> map : imageRecognition) {
            Map.Entry<String, Double> maxEntry = null;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            results.put(photoPathList[i], maxEntry.getKey());
            i++;
        }
        return results;
    }

    public Map<String, Map<String, Double>> getAllFeatureValues() throws IndicoException, IOException {
        // Geting File paths
        File[] photosFileList = folder.listFiles();
        String[] photoPathList = new String[photosFileList.length];
        for (int i = 0; i < photoPathList.length; i++) {
            photoPathList[i] = photosFileList[i].getAbsolutePath();
        }
        // Api Call
        BatchIndicoResult multiple = this.apiInstance.imageRecognition.predict(photoPathList);
        List<Map<String, Double>> imageRecognition = multiple.getImageRecognition();

        Map<String, Map<String, Double>> results = new HashMap<>();
        // simple max function to find entry with max double valued
        int i = 0;
        for (Map<String, Double> map : imageRecognition) {
            Map<String, Double> resultMap = new HashMap<>();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() > 0.01) {
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }
            results.put(photoPathList[i], resultMap);
            i++;
        }
        return results;
    }
}
