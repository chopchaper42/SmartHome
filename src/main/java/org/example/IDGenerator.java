package org.example;

import java.util.HashMap;
import java.util.Map;

public class IDGenerator {
    private static IDGenerator instance;
    private HashMap<String, Integer> classMap = new HashMap<>();
    private IDGenerator() {}

    public static IDGenerator getInstance() {
        if (instance == null)
            instance = new IDGenerator();

        return instance;
    }

    public String generateID(Class clazz) {
        if (!classMap.containsKey(clazz.getSimpleName()))
            classMap.put(clazz.getSimpleName(), 0);

        classMap.put(clazz.getSimpleName(), classMap.get(clazz.getSimpleName()) + 1);
        return clazz.getSimpleName() + "#" + classMap.get(clazz.getSimpleName());
    }

    public Map<String, Integer> getClassMap() {
        return classMap;
    }
}
