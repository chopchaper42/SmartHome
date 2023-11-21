package org.example.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConfigurationLoaderFactory {
    public JSONConfigurationLoader createJsonConfigurationLoader(File file) throws IOException {
        String json;
        try (FileInputStream stream = new FileInputStream(file)) {
            json = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
        return new JSONConfigurationLoader(json);
    }
}
