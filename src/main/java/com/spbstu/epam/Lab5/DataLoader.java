package com.spbstu.epam.Lab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.epam.Lab5.entities.MetalsAndColorsDataSet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DataLoader {
    private static Map<String, MetalsAndColorsDataSet> loadedData;

    static {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load() throws FileNotFoundException {
        FileReader fr = new FileReader(DataLoader.class.getClassLoader().getResource("data.json").getFile());
        JsonReader jr = new JsonReader(fr);

        Type type = new TypeToken<Map<String, MetalsAndColorsDataSet>>() {
        }.getType();

        loadedData = new Gson().fromJson(jr, type);

    }

    public static MetalsAndColorsDataSet getData(String subData) {
        return loadedData.get(subData);
    }

    public static Object[] getAllData() {
        return loadedData.values().toArray();
    }

}
