package org.example.house;

import org.example.SmartHouse;
import org.example.creature.Adult;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.DeviceFactory;
import org.example.device.devices.Lamp.Lamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @BeforeEach
    void init() {
        Room room1 = new Room("Room1");
        Room room2 = new Room("Room2");
//        Room room3 = new Room("Room3");

        Floor floor = new Floor(1);
        floor.addAllRooms(List.of(room1, room2/*, room3*/));

        House house = new House("Test house");
        house.addFloor(floor);
        SmartHouse.instance().addLocations(house);
    }

    @Test
    @DisplayName("onCreatureEnter() turns all lamps in the room ON if there was no creature before")
    void onCreatureEnterTurnsONLamps() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        room2.addAllDevices(List.of(lamp1, lamp2));

        Creature creature = new Adult("adult", room1);

        Assertions.assertTrue(room2.getDevices().stream().filter(d -> d instanceof Lamp).noneMatch(Device::isON));

        creature.changeRoom(room2);

        Assertions.assertTrue(room2.getDevices().stream().filter(d -> d instanceof Lamp).allMatch(Device::isON));
    }

    @Test
    @DisplayName("onCreatureLeft() does not turn lamps OFF if there is at least one creature in the room")
    void onCreatureLeftLampsStillON() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        room2.addAllDevices(List.of(lamp1, lamp2));

        Creature creature = new Adult("adult1", room1);
        Creature creature1 = new Adult("adult2", room1);

        creature.changeRoom(room2);
        creature1.changeRoom(room2);

        Assertions.assertTrue(room2.getDevices().stream().filter(d -> d instanceof Lamp).allMatch(Device::isON));

        creature.changeRoom(room1);

        Assertions.assertTrue(room2.getDevices().stream().filter(d -> d instanceof Lamp).allMatch(Device::isON));
    }
    @Test
    @DisplayName("onCreatureLeft() turns lamps OFF if there is no creature left in the room")
    void onCreatureLeftLampsOFF() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        room2.addAllDevices(List.of(lamp1, lamp2));

        Creature creature = new Adult("adult", room1);


        creature.changeRoom(room2);

        Assertions.assertTrue(room2.getDevices()
                                        .stream()
                                        .filter(d -> d instanceof Lamp)
                                        .allMatch(Device::isON));

        creature.changeRoom(room1);

        Assertions.assertTrue(room2.getDevices()
                                        .stream()
                                        .filter(d -> d instanceof Lamp)
                                        .noneMatch(Device::isON));
    }

    @Test
    void devicesByType() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        room2.addAllDevices(List.of(lamp1, lamp2));

        Assertions.assertEquals(2, room2.devicesByType(Lamp.class).size());
    }

    @Test
    void consumptionReport() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room room2 = SmartHouse.instance().getRooms().get(1);

        room2.addAllDevices(List.of(lamp1, lamp2));

        lamp2.on();
        lamp1.on();

        lamp1.update();
        lamp2.update();

        String expected = room2.getId() + ":\n" +
                "\t" + lamp1.getId() + "\n" +
                "\t\tElectricity consumed: 3.0\n" +
                "\t" + lamp2.getId() + "\n" +
                "\t\tElectricity consumed: 3.0\n";

        String report = room2.consumptionReport();

        Assertions.assertEquals(expected, report);
    }
}