package nrn.noah.priv.mgmt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFileManager {

    private static JsonFileManager instance;
    private final Gson gson;
    private final String baseDirectory;

    // Private constructor to prevent instantiation
    private JsonFileManager(String baseDirectory) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.baseDirectory = baseDirectory;
    }

    // Public method to get the instance
    public static synchronized JsonFileManager getInstance(String baseDirectory) {
        if (instance == null) {
            instance = new JsonFileManager(baseDirectory);
        }
        return instance;
    }

    public <T> void saveData(T data, String vacationName, String fileName) throws IOException {
        // Ensure the directory for the specific vacation exists
        String dirPath = baseDirectory + "/" + vacationName;
        java.io.File dir = new java.io.File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //Create or overwrite the file with the given data
        try (FileWriter writer = new FileWriter(dirPath + "/" + fileName)) {
            gson.toJson(data, writer);
        }
    }

    public <T> T loadData(Class<T> type, String vacationName, String fileName) throws IOException {
        // Build the full path to the file
        String filePath = baseDirectory + "/" + vacationName + "/" + fileName;

        // Read and deserialize the JSON file to a Java object of type T
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        }
    }
}