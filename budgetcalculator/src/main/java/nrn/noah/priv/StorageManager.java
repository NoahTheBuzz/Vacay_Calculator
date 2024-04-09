package nrn.noah.priv;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class StorageManager {
    
    private static StorageManager instance;
    private static final String BASE_DIRECTORY = System.getenv("VACATION_APP_BASE");

    private StorageManager() {
        // if(BASE_DIRECTORY == null) {
        //     throw new IllegalStateException("Base directory not specified. Please set the VACATION_APP_BASE environment variable.");
        // }
        ensureBaseDirectory();
    }

    public static synchronized StorageManager getInstance() {
        if (instance == null) {
            instance = new StorageManager();
        }
        return instance;
    }

    private void ensureBaseDirectory() {
        File baseDir = new File(BASE_DIRECTORY);
        if(!baseDir.exists() && !baseDir.mkdirs()) {
            throw new RuntimeException("Failed to create base directory at " + BASE_DIRECTORY);
        }
    }

    public boolean createNewCavation(String vacationName) {
        File vacationFolder = new File(BASE_DIRECTORY, vacationName);
        if(!vacationFolder.exists()) {
            return vacationFolder.mkdirs(); // Create the directory, including any necessary but nonexistent parent directories
        }
        return false; // Folder already exists
    }

    public List<String> listVacations() {
        File baseDir = new File(BASE_DIRECTORY);
        String[] directories = baseDir.list((current, name) -> new File(current, name).isDirectory());
        if (directories != null) {
            return Arrays.asList(directories);
        }
        return List.of(); // Return an empty list if no directories found
    }
}
