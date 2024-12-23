package com.lukecheskin.utils;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lukecheskin.classes.Collection;

public class FileManager {

    private static final String DATA_FILE_PATH = "assignment4/src/main/java/com/lukecheskin/data.json";
    
    public ArrayList<Collection> getData() {
        ArrayList<Collection> collections = new ArrayList<>();
    
        try {
            // Read JSON file
            JsonReader reader = new JsonReader(new FileReader(DATA_FILE_PATH));

            Gson gson = new Gson();
            Collection[] collectionArray = gson.fromJson(reader, Collection[].class);

            collections.addAll(Arrays.asList(collectionArray));
        } catch (Exception e) {
            System.out.println("Error reading data file. Likely that there is no data.");
        }
        
        return collections;
    }

    public void saveData(ArrayList<Collection> collections) {
        Gson gson = new Gson();
        String json = gson.toJson(collections);

        try {
            Files.write(Paths.get(DATA_FILE_PATH), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error writing to data file: " + e.getLocalizedMessage());
        }
    }

    public FileManager() {
        // Create data.json file if it does not exist
        try {
            File dataFile = new File(DATA_FILE_PATH);
            if (dataFile.createNewFile()) {
                System.out.println("Data file created: " + dataFile.getName());
            }
        } catch (Exception e) {
            System.out.println("An error occurred whilst creating the data file: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
