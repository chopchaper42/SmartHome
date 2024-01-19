package org.example.report;

import org.example.device.Device;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.floors.Floor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class ElectricityReport implements Report{
    private static final Logger logger = Logger.getLogger(ElectricityReport.class.getName());
    private static ElectricityReport instance;
    @Override
    public void generateReport(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Floor floor : House.getInstance().getFloors()) {
                writer.write("FLOOR # " + floor.getLevel() + "\n");
                for (Room room : floor.getRooms()) {
                    writer.write("ROOM: " + room.getRoomName() + "\n");
                    for (Device device : room.getDevices()) {
                        writer.write("DEVICE: " + device.getNameOfDevice() + " spend " + device.getElectricityRecord().toString() + "\n");

                    }
                }
            }
            logger.info("\n" +
                    "░█▀▀▀ █── █▀▀ █▀▀ ▀▀█▀▀ █▀▀█ ─▀─ █▀▀ ─▀─ ▀▀█▀▀ █──█ 　 ░█▀▀█ █▀▀ █▀▀█ █▀▀█ █▀▀█ ▀▀█▀▀ \n" +
                    "░█▀▀▀ █── █▀▀ █── ──█── █▄▄▀ ▀█▀ █── ▀█▀ ──█── █▄▄█ 　 ░█▄▄▀ █▀▀ █──█ █──█ █▄▄▀ ──█── \n" +
                    "░█▄▄▄ ▀▀▀ ▀▀▀ ▀▀▀ ──▀── ▀─▀▀ ▀▀▀ ▀▀▀ ▀▀▀ ──▀── ▄▄▄█ 　 ░█─░█ ▀▀▀ █▀▀▀ ▀▀▀▀ ▀─▀▀ ──▀── \n" +
                    "\n" +
                    "░█▀▀█ █▀▀ █▀▀▄ █▀▀ █▀▀█ █▀▀█ ▀▀█▀▀ █▀▀ █▀▀▄ \n" +
                    "░█─▄▄ █▀▀ █──█ █▀▀ █▄▄▀ █▄▄█ ──█── █▀▀ █──█ \n" +
                    "░█▄▄█ ▀▀▀ ▀──▀ ▀▀▀ ▀─▀▀ ▀──▀ ──▀── ▀▀▀ ▀▀▀─ \n");
        }
        catch (IOException e) {
            logger.severe("Error writing to the file: " + e.getMessage());
            logger.severe("Error making the report.");
        }
    }

    public static ElectricityReport getInstance() {
        if(instance == null) {
            instance = new ElectricityReport();
            //instance.events = new ArrayList<>();
        }
        return instance;
    }
}
