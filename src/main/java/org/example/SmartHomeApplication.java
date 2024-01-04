package org.example;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.DeviceFactory;
import org.example.device.devices.Computer.Computer;
import org.example.device.devices.Fridge.Fridge;
import org.example.device.devices.Lamp.Lamp;
import org.example.device.devices.TV.TV;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.room.Room;
import org.example.report.ConsumptionReport;
import org.example.report.HouseConfigurationReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SmartHomeApplication {
    public static void main(String[] args) {

        DeviceFactory factory = DeviceFactory.getInstance();
        House house = new House("John's House");

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);

        Room location = new Room("Living Room");
        Room location2 = new Room("Bedroom");
        Room location3 = new Room("Attic");
        Room location4 = new Room("Kitchen");

        Lamp lamp1 = factory.createDevice(Lamp.class);
        Lamp lamp2 = factory.createDevice(Lamp.class);
        Lamp lamp3 = factory.createDevice(Lamp.class);
        Lamp lamp4 = factory.createDevice(Lamp.class);
        Lamp lamp5 = factory.createDevice(Lamp.class);
        Lamp lamp6 = factory.createDevice(Lamp.class);
        Lamp lamp7 = factory.createDevice(Lamp.class);
        Lamp lamp8 = factory.createDevice(Lamp.class);

        TV tv = factory.createDevice(TV.class);
        Computer computer = factory.createDevice(Computer.class);
        Fridge fridge = factory.createDevice(Fridge.class);

        location.addAllDevices(List.of(lamp1, lamp2, computer));
        location2.addAllDevices(List.of(lamp3, lamp4, tv));
        location3.addAllDevices(List.of(lamp5, lamp6));
        location4.addAllDevices(List.of(lamp7, lamp8, fridge));

        floor1.addAllRooms(List.of(location, location4));
        floor2.addAllRooms(List.of(location2, location3));

        house.addAllFloors(List.of(floor1, floor2));

        Creature creature = new Creature("John", location);

        Dispatcher dispatcher = Dispatcher.instance();

        dispatcher.addLocations(house);

        List<Device> devices = dispatcher.rooms().stream().map(Room::getDevices).flatMap(Collection::stream).toList();


        for (int i = 0; i < 24; i++) {
            creature.goToNewLocation();

            for (Device dev : devices)
                dev.use();


        }

        try {
            ConsumptionReport report = new ConsumptionReport();
            report.generateReport();
            HouseConfigurationReport report1 = new HouseConfigurationReport(house);
            report1.generateReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}