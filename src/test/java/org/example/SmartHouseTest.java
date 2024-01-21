package org.example;

import org.example.creature.Adult;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.device_factory.DeviceFactory;
import org.example.device.devices.Lamp.Lamp;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.strategy.DayStrategy;
import org.example.house.strategy.NightStrategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartHouseTest {

    @BeforeEach
    void init() {
        Room room1 = new Room("Bedroom");
        Room room2 = new Room("Living Room");

        Floor floor = new Floor(1);
        floor.addAllRooms(List.of(room1, room2));

        Creature creature1 = new Adult("John", room1);
        Creature creature2 = new Adult("Mary", room1);

        SmartHouse.instance().addCreatures(List.of(creature2, creature1));

        House house = new House("Test house");
        house.addFloor(floor);
        SmartHouse.instance().addLocations(house);
    }

    @AfterEach
    void purge() {
        SmartHouse.instance().purgeCreatures();
        SmartHouse.instance().purgeRooms();
    }

    @Test
    void assignTaskWithCreatureAsSource() {
        Creature creature1 = SmartHouse.instance().getCreatures().get(0);
        Creature creature2 = SmartHouse.instance().getCreatures().get(1);
        SmartHouse.instance().assignTask(creature1, Task.Type.HELP);

        Assertions.assertEquals(1, creature2.getTasks().size());
        Assertions.assertEquals(Task.Type.HELP, creature2.getTasks().peek().getType());
        Assertions.assertEquals(creature1, creature2.getTasks().peek().getCreatureSource());
    }

    @Test
    void assignTaskWithLocationAsSource() {
        Creature creature1 = SmartHouse.instance().getCreatures().get(0);
        Creature creature2 = SmartHouse.instance().getCreatures().get(1);
        creature2.setWaiting(true);
        Room room1 = SmartHouse.instance().getRandomRoom();

        SmartHouse.instance().assignTask(room1, Task.Type.CLEAN_ROOM);

        Assertions.assertEquals(1, creature1.getTasks().size());
        Assertions.assertEquals(Task.Type.CLEAN_ROOM, creature1.getTasks().peek().getType());
        Assertions.assertEquals(room1, creature1.getTasks().peek().getRoomSource());
    }

    @Test
    void generateTask() {
        Creature creature1 = SmartHouse.instance().getCreatures().get(0);
        Creature creature2 = SmartHouse.instance().getCreatures().get(1);

        creature2.setWaiting(true);

        SmartHouse.instance().generateTask();

        Assertions.assertEquals(1, creature1.getTasks().size());
        Task.Type type = creature1.getTasks().peek().getType();
        Assertions.assertTrue(type == Task.Type.CLEAN_ROOM || type == Task.Type.WASH_DISHES);
    }

    @Test
    void getKitchenWhenThereIsNoOne() {
        Room kitchen = SmartHouse.instance().getKitchen();
        Assertions.assertNull(kitchen);
    }
    @Test
    void getKitchenWhenThereIsOne() {
        SmartHouse.instance().addRoom(new Room("Kitchen"));
        Room kitchen = SmartHouse.instance().getKitchen();

        Assertions.assertNotNull(kitchen);
    }

    @Test
    void locateDevice() {
        SmartHouse.instance().addRoom(new Room("Kitchen"));
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room kitchen = SmartHouse.instance().getKitchen();
        kitchen.addDevice(lamp1);

        Room roomWIthLamp = SmartHouse.instance().locateDevice(lamp1);

        Assertions.assertEquals(kitchen, roomWIthLamp);
    }

    @Test
    void executeStrategy() {
        Lamp lamp1 = DeviceFactory.getInstance().createDevice(Lamp.class);
        Lamp lamp2 = DeviceFactory.getInstance().createDevice(Lamp.class);

        Room room = SmartHouse.instance().getRooms().get(0);
        room.addAllDevices(List.of(lamp1, lamp2));

        lamp1.on();
        lamp2.on();

        Assertions.assertTrue(lamp1.isON() && lamp2.isON());

        SmartHouse.instance().setStrategy(new NightStrategy());

        Assertions.assertTrue(room.getDevices().stream().noneMatch(Device::isON));
        Assertions.assertTrue(SmartHouse.instance().getRooms().stream()
                .map(Room::getCreatures)
                .flatMap(Collection::stream)
                .allMatch(Creature::isAsleep));

        SmartHouse.instance().setStrategy(new DayStrategy());

        Assertions.assertTrue(SmartHouse.instance().getRooms().stream()
                .map(Room::getCreatures)
                .flatMap(Collection::stream)
                .noneMatch(Creature::isAsleep));

    }
}