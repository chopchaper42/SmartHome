package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDGeneratorTest {

    @Test
    void generateID() {
        IDGenerator generator = IDGenerator.getInstance();

        String id = generator.generateID(Integer.class);

        Assertions.assertEquals("Integer#1", id);
        Assertions.assertEquals(1, generator.getClassMap().get("Integer"));

        String id2 = generator.generateID(Integer.class);

        Assertions.assertEquals("Integer#2", id2);
        Assertions.assertEquals(2, generator.getClassMap().get("Integer"));

        String id3 = generator.generateID(String.class);

        Assertions.assertEquals("String#1", id3);
        Assertions.assertEquals(1, generator.getClassMap().get("String"));
    }
}