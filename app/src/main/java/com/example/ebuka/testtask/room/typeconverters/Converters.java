package com.example.ebuka.testtask.room.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converters {
    @TypeConverter
    public long convertDateToLong(Date date) { return date.getTime(); }

    @TypeConverter
    public Date convertLongToDate(long time) {
        return new Date(time);
    }

    @TypeConverter
    public static List<String> convertStringToList(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String convertListToString(List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
