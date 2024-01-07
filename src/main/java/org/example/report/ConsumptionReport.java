package org.example.report;

import org.example.SmartHouse;
import org.example.house.Room;
import org.example.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ConsumptionReport extends Report {
    public ConsumptionReport() throws FileNotFoundException {
        super(new File("./src/main/reports/consumptionReport.txt"));
    }

    /**
     * Generates a Consumption report
     */
    @Override
    public void generateReport() {
        SmartHouse smartHouse = SmartHouse.instance();
        List<Room> rooms = smartHouse.getRooms();
        writer.println("\tConsumption report:");
        for (Room room : rooms) {
            writer.println(room.consumptionReport());
        }
        writer.close();
        Logger.log("ConsumptionReport generated");
    }
}
