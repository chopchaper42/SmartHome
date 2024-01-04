package org.example;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.devices.Lamp.Lamp;
import org.example.house.room.Room;
import org.example.report.ConsumptionReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SmartHomeApplication {
    public static void main(String[] args) {

        Room location = new Room("Living Room");
        Room location2 = new Room("Bedroom");

        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp();
        Lamp lamp3 = new Lamp();
        Lamp lamp4 = new Lamp();

        location.addAllDevices(List.of(lamp1, lamp2));
        location2.addAllDevices(List.of(lamp3, lamp4));

        Creature creature = new Creature("John", location);

        Dispatcher dispatcher = Dispatcher.instance();

        dispatcher.addLocation(location);
        dispatcher.addLocation(location2);

        List<Device> devices = dispatcher.rooms().stream().map(Room::getDevices).flatMap(Collection::stream).toList();


        for (int i = 0; i < 24; i++) {
            creature.goToNewLocation();

            for (Device dev : devices)
                dev.use();


        }

        File consumptionReportFile = new File("./src/main/reports/consumptionReport.txt");
        try {
            ConsumptionReport report = new ConsumptionReport(consumptionReportFile);
            report.generateReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}