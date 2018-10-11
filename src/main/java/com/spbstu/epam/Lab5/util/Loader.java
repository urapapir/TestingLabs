package com.spbstu.epam.Lab5.util;

import java.lang.reflect.Type;
import java.util.Map;
import com.google.gson.stream.JsonReader;
import com.spbstu.epam.Lab5.entities.MetalsAndColorsDataSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Loader {
    //Map для загрузки данных
    private static Map<String, MetalsAndColorsDataSet> DATA;

    static {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load() throws FileNotFoundException {
        FileReader fileReader = new FileReader(Loader.class.getClassLoader().getResource("metalsAndColorsDataSet.json").getFile());
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, MetalsAndColorsDataSet>>() {
        }.getType();

        DATA = new Gson().fromJson(jsonReader, type);

    }

    public static MetalsAndColorsDataSet getData(String subData) {
        return DATA.get(subData);
    }

    public static Object[] getPageDatas() {
        return DATA.values().toArray();
    }
}
