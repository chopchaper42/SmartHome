package org.example.report;

import org.example.device.Device;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.room.Room;
import org.example.logger.Logger;

import java.io.File;
import java.io.FileNotFoundException;

public class HouseConfigurationReport extends Report {
    private House house;
    public HouseConfigurationReport(House house) throws FileNotFoundException {
        super(new File("./src/main/reports/houseConfigurationReport.txt"));
        this.house = house;
    }

    @Override
    public void generateReport() {
        writer.println(house.getName() + ":");
        for (Floor floor : house.getFloors()) {
            writer.println("\tFloor #" + floor.getNumber() + ":");
            for (Room room : floor.getRooms()) {
                writer.println("\t\t" + room.getId() + ":");
                for (Device d : room.getDevices())
                    writer.println("\t\t\t" + d + (d.isON() ? " ON" : " OFF"));
            }
        }
        writer.close();
        Logger.log("HouseConfigurationReport generated");
    }
}
