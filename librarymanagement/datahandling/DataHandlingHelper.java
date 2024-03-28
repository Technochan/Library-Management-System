package com.zsgs.chandru.librarymanagement.datahandling;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class DataHandlingHelper {

    private DataSerializerDeserializer dataSerializerDeserializer;

    private final String DATA_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "LibraryDatabase";

    public DataHandlingHelper() {
        dataSerializerDeserializer = new DataSerializerDeserializer();
    }

    public <T> void serializeData(T object, String fileName) {
        dataSerializerDeserializer.serializeData(object, DATA_FOLDER_PATH, fileName);
    }

    public <T> T deserializeData(String filename, Type type, Class<T> clazz) {
        T deserializedData = dataSerializerDeserializer.deserializeData(DATA_FOLDER_PATH, filename, type);
        if (deserializedData == null) {
            deserializedData = createInstance(clazz);
        }
        return deserializedData;
    }

    private <T> T createInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
