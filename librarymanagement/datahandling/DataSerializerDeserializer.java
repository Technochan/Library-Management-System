package com.zsgs.chandru.librarymanagement.datahandling;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.*;
import java.lang.reflect.Type;

public class DataSerializerDeserializer {

    private final Gson gson = new Gson();

    // Serialize data to JSON and write to file
    public <T> void serializeData(T data, String filePath, String fileName) {
        createDataFolder(filePath); // Create data folder if it doesn't exist
        String completeFilePath = filePath + File.separator + fileName;
        try (Writer writer = new FileWriter(completeFilePath)) {
            gson.toJson(data, writer);
            System.out.println("Data serialized and written to file successfully: " + completeFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Error while serializing data: " + e.getMessage(), e);
        }
    }

    // Deserialize JSON from file and convert to object of specified type
    public <T> T deserializeData(String filePath, String fileName, Type type) {
        String completeFilePath = filePath + File.separator + fileName;
        try (Reader reader = new FileReader(completeFilePath)) {
            return gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + completeFilePath);
            return null;
        } catch (IOException e) {
            throw new RuntimeException("Error while deserializing data: " + e.getMessage(), e);
        }
    }

    // Create data folder if it doesn't exist
    private void createDataFolder(String filePath) {
        File dataFolder = new File(filePath);
        if (!dataFolder.exists() && !dataFolder.mkdirs()) {
            throw new RuntimeException("Failed to create data folder: " + filePath);
        }
    }
}
