/*
 * Creation : 4 Jun 2020
 */
package com.qa.psa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qa.psa.base.BaseTest;

public class Utilities extends BaseTest {

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
    }

    public static String formatJSONResponse(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);
    }

}
