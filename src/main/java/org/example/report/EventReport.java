package org.example.report;

import org.example.EventManager;
import org.example.Task;
import org.example.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class EventReport extends Report {
    public EventReport() throws FileNotFoundException {
        super(new File("./src/main/reports/eventReport.txt"));
    }


    /**
     * Generates an Event report
     */
    @Override
    public void generateReport() {
        List<Task> events = EventManager.getInstance().getEvents();
        for (Task task : events) {
            String source = task.getCreatureSource() != null ? task.getCreatureSource().getName() :
                                        task.getDeviceSource() != null ? task.getDeviceSource().getId() :
                                        task.getRoomSource().getId();
            writer.println("Type: " + task.getType() + "; Source: " + source + "; Target: " + task.getTarget().getName());
        }
        writer.close();
        Logger.log("EventReport generated");
    }
}
