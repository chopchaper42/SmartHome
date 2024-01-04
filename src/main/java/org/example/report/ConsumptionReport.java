package org.example.report;

import org.example.Dispatcher;
import org.example.house.room.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ConsumptionReport extends Report {
    public ConsumptionReport() throws FileNotFoundException {
        super(new File("./src/main/reports/consumptionReport.txt"));
    }

    @Override
    public void generateReport() {
        Dispatcher dispatcher = Dispatcher.instance();
        List<Room> rooms = dispatcher.rooms();
        writer.println("\tConsumption report:");
        for (Room room : rooms) {
            writer.println(room.consumptionReport());
        }
        writer.close();
    }
}
