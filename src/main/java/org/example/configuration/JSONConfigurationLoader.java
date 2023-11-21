package org.example.configuration;


import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class JSONConfigurationLoader implements ConfigurationLoader {

    private String json;

    @Override
    public HouseConfiguration loadConfiguration(){
        Gson gson = new Gson();
        return gson.fromJson(json, HouseConfiguration.class);
    }
}
