package org.example;

import java.util.HashMap;
import java.util.Map;

public class IDGenerator {
    private static IDGenerator instance;
    private HashMap<String, Integer> classMap = new HashMap<>();
    private IDGenerator() {}

    /**
     * Returns the singleton instance of the IDGenerator
     * @return the instance of the IDGenerator
     */
    public static IDGenerator getInstance() {
        if (instance == null)
            instance = new IDGenerator();

        return instance;
    }

    /**
     * Generates an unique ID
     * @param clazz a class to generate id for
     * @return unique ID
     */
    public String generateID(Class clazz) {
        if (!classMap.containsKey(clazz.getSimpleName()))
            classMap.put(clazz.getSimpleName(), 0);

        classMap.put(clazz.getSimpleName(), classMap.get(clazz.getSimpleName()) + 1);
        return clazz.getSimpleName() + "#" + classMap.get(clazz.getSimpleName());
    }

    /**
     * @return map <Class name, number of instances>
     */
    public Map<String, Integer> getClassMap() {
        return classMap;
    }
}
