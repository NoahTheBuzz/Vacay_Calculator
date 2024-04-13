package nrn.noah.priv.mgmt;

import java.io.Writer;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFileManager {

    private static JsonFileManager instance;
    private final Gson gson;
    private Path basePath;

    private JsonFileManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static synchronized JsonFileManager getInstance() {
        if (instance == null) {
            instance = new JsonFileManager();
        }
        return instance;
    }

    public synchronized void initialize(String basePathStr) {
        if (this.basePath != null) {
            throw new IllegalStateException("JsonFileManager is already initialized.");
        }
        this.basePath = Paths.get(basePathStr).toAbsolutePath();
        try {
            Files.createDirectories(this.basePath);
        } catch (Exception e) {
            throw new RuntimeException("Could not create base directory at " + this.basePath, e);
        }
    }

    /*
     * Save data to a JSON file
     * 
     * @param data The data to be saved
     * @param directoryName The name of the directory to save the file in
     * @param fileName The name of the file to save the data in
     * @throws Exception if the file cannot be saved
     */
    public <T> void saveData(T data, String directoryName, String fileName) {
        Path directoryPath = this.basePath.resolve(directoryName);
        try{
            Files.createDirectories(directoryPath); // Ensure the directory exists

            Path filePath = directoryPath.resolve(fileName);
            try (Writer writer = Files.newBufferedWriter(filePath)) {
                gson.toJson(data, writer);
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not save data to " + directoryName + "/" + fileName, e);
        }
    }

    /*
     * Load data from a JSON file
     * 
     * @param type The class type of the data to be loaded
     * @param directoryName The name of the directory to load the file from
     * @param fileName The name of the file to load the data from
     * @throws Exception if the file cannot be loaded
     * @return The loaded data
     */
    public <T> T loadData(Class<T> type, String directoryName, String fileName) throws Exception {
        Path filePath = this.basePath.resolve(Paths.get(directoryName, fileName));
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return gson.fromJson(reader, type);
        }
    }
}