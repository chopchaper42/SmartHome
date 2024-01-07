package org.example;

import org.example.creature.Adult;
import org.example.creature.Animal;
import org.example.creature.Child;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.DeviceFactory;
import org.example.device.devices.AudioPlayer.AudioPlayer;
import org.example.device.devices.Bicycle.Bicycle;
import org.example.device.devices.CoffeMachine.CoffeeMachine;
import org.example.device.devices.Computer.Computer;
import org.example.device.devices.Fridge.Fridge;
import org.example.device.devices.Lamp.Lamp;
import org.example.device.devices.TV.TV;
import org.example.device.devices.Treadmill.Treadmill;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.strategy.DayStrategy;
import org.example.house.strategy.NightStrategy;
import org.example.logger.Logger;
import org.example.report.ActivityAndUsageReport;
import org.example.report.ConsumptionReport;
import org.example.report.EventReport;
import org.example.report.HouseConfigurationReport;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class SmartHomeApplication {
    private static List<Device> devices;
    private static House house;
    public static void main(String[] args) {

        // - - - - - - - - - - Setting everything up - - - - - - - - -

        Logger.log("Application started");

        DeviceFactory factory = DeviceFactory.getInstance();

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter 1 or 2 for the first and the second scenario");
        String scenario;
        do {
             scenario = scr.nextLine();
             if (scenario.equals("1") || scenario.equals("2"))
                 break;
            System.out.println("Bad input. Please enter 1 or 2");

        } while (true);
        switch (scenario) {
            case "1" -> {
                configuration1(factory);
                break;
            }
            case "2" -> {
                configuration2(factory);
                break;
            }
        }

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
            ConsumptionReport report1 = new ConsumptionReport();
            report1.generateReport();
            HouseConfigurationReport report2 = new HouseConfigurationReport(house);
            report2.generateReport();
            EventReport report3 = new EventReport();
            report3.generateReport();
            ActivityAndUsageReport report4 = new ActivityAndUsageReport(SmartHouse.instance().getCreatures(c -> !(c instanceof Animal)));
            report4.generateReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Logger.log("Application stopped");

        // - - - - - - - - - - - - - - - - - - - - - - - - -

    }

    private static void configuration1(DeviceFactory factory) {
        house = new House("John's House");

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);

        Room location1 = new Room("Living Room");
        Room location2 = new Room("Bedroom #1");
        Room location3 = new Room("Attic");
        Room location4 = new Room("Kitchen");
        Room location5 = new Room("Bedroom #2");
        Room location6 = new Room("Basement");
        Room location7 = new Room("Home Office");

        Lamp lamp1 = factory.createDevice(Lamp.class);
        Lamp lamp2 = factory.createDevice(Lamp.class);
        Lamp lamp3 = factory.createDevice(Lamp.class);
        Lamp lamp4 = factory.createDevice(Lamp.class);
        Lamp lamp5 = factory.createDevice(Lamp.class);
        Lamp lamp6 = factory.createDevice(Lamp.class);
        Lamp lamp7 = factory.createDevice(Lamp.class);
        Lamp lamp8 = factory.createDevice(Lamp.class);
        Lamp lamp9 = factory.createDevice(Lamp.class);
        Lamp lamp10 = factory.createDevice(Lamp.class);
        Lamp lamp11 = factory.createDevice(Lamp.class);
        Lamp lamp12 = factory.createDevice(Lamp.class);
        Lamp lamp13 = factory.createDevice(Lamp.class);
        Lamp lamp14 = factory.createDevice(Lamp.class);

        TV tv = factory.createDevice(TV.class);
        Computer computer1 = factory.createDevice(Computer.class);
        Fridge fridge = factory.createDevice(Fridge.class);
        Computer computer2 = factory.createDevice(Computer.class);
        CoffeeMachine coffeeMachine1 = factory.createDevice(CoffeeMachine.class);
        Treadmill treadmill1 = factory.createDevice(Treadmill.class);
        Bicycle bicycle1 = factory.createDevice(Bicycle.class);
        AudioPlayer audioPlayer1 = factory.createDevice(AudioPlayer.class);

        location1.addAllDevices(List.of(lamp1, lamp2, computer1));
        location2.addAllDevices(List.of(lamp3, lamp4, tv));
        location3.addAllDevices(List.of(lamp5, lamp6, audioPlayer1));
        location4.addAllDevices(List.of(lamp7, lamp8, fridge, coffeeMachine1));
        location5.addAllDevices(List.of(lamp9, lamp10, computer2));
        location6.addAllDevices(List.of(lamp11, lamp12, bicycle1));
        location7.addAllDevices(List.of(lamp13, lamp14, treadmill1));

        floor1.addAllRooms(List.of(location1, location4, location5, location7));
        floor2.addAllRooms(List.of(location2, location3, location6));

        house.addAllFloors(List.of(floor1, floor2));

        Creature john = new Adult("John", location1);
        Creature mary = new Adult("Mary", location2);
        Creature bob = new Child("Bob", location1);
        Creature bobik = new Animal("Bobik", location4);
        Creature katy = new Adult("Katy", location4);
        Creature karl = new Child("Karl", location3);
        Creature biba = new Animal("Biba", location6);
        Creature boba = new Animal("Boba", location7);

        SmartHouse smartHouse = SmartHouse.instance();

        smartHouse.addLocations(house);
        smartHouse.addCreatures(List.of(john, mary, bob, bobik, katy, karl, biba, boba));

        devices = smartHouse.getRooms().stream().map(Room::getDevices).flatMap(Collection::stream).toList();
    }

    private static void configuration2(DeviceFactory factory) {
        house = new House("John's House");

        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);

        Room location1 = new Room("Living Room");
        Room location2 = new Room("Bedroom #1");
        Room location3 = new Room("Attic");
        Room location4 = new Room("Kitchen #1");
        Room location8 = new Room("Kitchen #2");
        Room location5 = new Room("Game Room");
        Room location6 = new Room("Basement");
        Room location7 = new Room("Home Office");

        Lamp lamp1 = factory.createDevice(Lamp.class);
        Lamp lamp2 = factory.createDevice(Lamp.class);
        Lamp lamp3 = factory.createDevice(Lamp.class);
        Lamp lamp4 = factory.createDevice(Lamp.class);
        Lamp lamp5 = factory.createDevice(Lamp.class);
        Lamp lamp6 = factory.createDevice(Lamp.class);
        Lamp lamp7 = factory.createDevice(Lamp.class);
        Lamp lamp8 = factory.createDevice(Lamp.class);
        Lamp lamp9 = factory.createDevice(Lamp.class);
        Lamp lamp10 = factory.createDevice(Lamp.class);
        Lamp lamp11 = factory.createDevice(Lamp.class);
        Lamp lamp12 = factory.createDevice(Lamp.class);
        Lamp lamp13 = factory.createDevice(Lamp.class);
        Lamp lamp14 = factory.createDevice(Lamp.class);
        Lamp lamp15 = factory.createDevice(Lamp.class);
        Lamp lamp16 = factory.createDevice(Lamp.class);

        TV tv1 = factory.createDevice(TV.class);
        TV tv2 = factory.createDevice(TV.class);
        Computer computer1 = factory.createDevice(Computer.class);
        Fridge fridge1 = factory.createDevice(Fridge.class);
        Fridge fridge2 = factory.createDevice(Fridge.class);
        Computer computer2 = factory.createDevice(Computer.class);
        CoffeeMachine coffeeMachine1 = factory.createDevice(CoffeeMachine.class);
        Treadmill treadmill1 = factory.createDevice(Treadmill.class);
        Bicycle bicycle1 = factory.createDevice(Bicycle.class);
        AudioPlayer audioPlayer1 = factory.createDevice(AudioPlayer.class);
        AudioPlayer audioPlayer2 = factory.createDevice(AudioPlayer.class);

        location1.addAllDevices(List.of(lamp1, lamp2, computer1, audioPlayer2));
        location2.addAllDevices(List.of(lamp3, lamp4, tv1));
        location3.addAllDevices(List.of(lamp5, lamp6, audioPlayer1));
        location4.addAllDevices(List.of(lamp7, lamp8, fridge1, coffeeMachine1));
        location5.addAllDevices(List.of(lamp9, lamp10, computer2));
        location6.addAllDevices(List.of(lamp11, lamp12, bicycle1));
        location7.addAllDevices(List.of(lamp13, lamp14, treadmill1));
        location8.addAllDevices(List.of(lamp15, lamp16, fridge2, tv2));

        floor1.addAllRooms(List.of(location1, location4, location5, location7));
        floor2.addAllRooms(List.of(location2, location3, location6, location8));

        house.addAllFloors(List.of(floor1, floor2));

        Creature john = new Adult("John", location1);
        Creature mary = new Adult("Mary", location2);
        Creature bob = new Child("Bob", location1);
        Creature karl = new Child("Karl", location3);
        Creature pete = new Child("Pete", location3);

        SmartHouse smartHouse = SmartHouse.instance();

        smartHouse.addLocations(house);
        smartHouse.addCreatures(List.of(john, mary, bob, karl, pete));

        devices = smartHouse.getRooms().stream().map(Room::getDevices).flatMap(Collection::stream).toList();
    }
}