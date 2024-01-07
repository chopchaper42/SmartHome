package org.example.logger;

import java.io.*;
import java.util.Date;

public class Logger {
    private static File logFile = new File("./src/main/logs/log.txt");
    private static BufferedWriter writer;

    private Logger() {}

    /**
     * Writes the given string to the log file
     * @param log the string to log
     */
    public static void log(String log) {
        try {
            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.append(new Date().toString()).append(": ").append(log).append('\n');
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to log the data.");
        }
    }

}
