package org.example.report;

import org.example.creature.animals.Animal;
import org.example.events.Event;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EventReport implements Report{
    private static final Logger logger = Logger.getLogger(EventReport.class.getName());
    private static EventReport INSTANCE;
    private List<Event> events;

    private EventReport() {}

    @Override
    public void generateReport(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Event event : events) {

                writer.write(event.toString());
                writer.newLine();
            }
            logger.info("\n" +
                    "░█▀▀▀ ▀█─█▀ █▀▀ █▀▀▄ ▀▀█▀▀ 　 ░█▀▀█ █▀▀ █▀▀█ █▀▀█ █▀▀█ ▀▀█▀▀ 　 ░█▀▀█ █▀▀ █▀▀▄ █▀▀ █▀▀█ █▀▀█ ▀▀█▀▀ █▀▀ █▀▀▄ \n" +
                    "░█▀▀▀ ─█▄█─ █▀▀ █──█ ──█── 　 ░█▄▄▀ █▀▀ █──█ █──█ █▄▄▀ ──█── 　 ░█─▄▄ █▀▀ █──█ █▀▀ █▄▄▀ █▄▄█ ──█── █▀▀ █──█ \n" +
                    "░█▄▄▄ ──▀── ▀▀▀ ▀──▀ ──▀── 　 ░█─░█ ▀▀▀ █▀▀▀ ▀▀▀▀ ▀─▀▀ ──▀── 　 ░█▄▄█ ▀▀▀ ▀──▀ ▀▀▀ ▀─▀▀ ▀──▀ ──▀── ▀▀▀ ▀▀▀─ \n");
        } catch (IOException e) {
            logger.severe("Error writing to the file: " + e.getMessage());
            logger.severe("Error making the report.");
        }
    }

    public static EventReport getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EventReport();
            INSTANCE.events = new ArrayList<>();
        }
        return INSTANCE;
    }
}
