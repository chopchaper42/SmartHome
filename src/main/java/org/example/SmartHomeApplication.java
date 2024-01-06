package org.example;

import org.example.creature.Adult;
import org.example.creature.Animal;
import org.example.creature.Child;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.DeviceFactory;
import org.example.device.devices.Computer.Computer;
import org.example.device.devices.Fridge.Fridge;
import org.example.device.devices.Lamp.Lamp;
import org.example.device.devices.TV.TV;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.strategy.DayStrategy;
import org.example.house.strategy.NightStrategy;
import org.example.logger.Logger;
import org.example.report.ConsumptionReport;
import org.example.report.EventReport;
import org.example.report.HouseConfigurationReport;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

public class SmartHomeApplication {
    public static void main(String[] args) {

        // - - - - - - - - - - Setting everything up - - - - - - - - -

        Logger.log("Application started");

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

        Creature john = new Adult("John", location);
        Creature mary = new Adult("Mary", location2);
        Creature bob = new Child("Bob", location);
        Creature bobik = new Animal("Bobik", location4);

        SmartHouse smartHouse = SmartHouse.instance();

        smartHouse.addLocations(house);
        smartHouse.addCreatures(List.of(john, mary, bob, bobik));

        List<Device> devices = smartHouse.rooms().stream().map(Room::getDevices).flatMap(Collection::stream).toList();

        // - - - - - - - - - - - - - - - - - - - - - - - - -

        // - - - - - - - - - - Cycle - - - - - - - - - - - -

        for (int i = 8; i < 256; i++) {
            // system assign tasks but not every time

            if (i % 24 == 8)
                SmartHouse.instance().setStrategy(new DayStrategy());
            if (i % 24 == 23)
                SmartHouse.instance().setStrategy(new NightStrategy());

            SmartHouse.instance().executeStrategy();

            // common
            for (Device dev : devices.stream().filter(Device::isON).toList())
                dev.update();
        }

        // - - - - - - - - Reports generation - - - - - - - - - - -

        try {
            ConsumptionReport report = new ConsumptionReport();
            report.generateReport();
            HouseConfigurationReport report1 = new HouseConfigurationReport(house);
            report1.generateReport();
            EventReport report3 = new EventReport();
            report3.generateReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Logger.log("Application stopped");

        // - - - - - - - - - - - - - - - - - - - - - - - - -

    }
}