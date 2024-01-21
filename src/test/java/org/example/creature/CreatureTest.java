package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.device.Device;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatureTest {

    @BeforeEach
    void init() {
        Room room1 = new Room("Room1");
        Room room2 = new Room("Room2");
        Room room3 = new Room("Room3");

        Floor floor = new Floor(1);
        floor.addAllRooms(List.of(room1, room2, room3));

        House house = new House("Test house");
        house.addFloor(floor);
        SmartHouse.instance().addLocations(house);
    }

    @Test
    @DisplayName("goToNewRoom() changes the current room if isWaiting is false")
    void goToNewRoom() {
        Room room1 = SmartHouse.instance().getRandomRoom();
        Creature creature = new Adult("Adult", room1);

        creature.goToNewRoom();

        assertFalse(creature.isWaiting());
        assertNotEquals(creature.getCurrentRoom(), room1);
    }

    @Test
    @DisplayName("goToNewRoom() doesn't affect the current room if isWaiting is true")
    void goToNewRoom_WhenIsWaitingIsTrue() {
        Room room1 = SmartHouse.instance().getRandomRoom();
        Creature creature = new Adult("Adult", room1);
        creature.setWaiting(true);

        assertTrue(creature.isWaiting());

        creature.goToNewRoom();

        assertEquals(creature.getCurrentRoom(), room1);
    }

    @Test
    @DisplayName("changeRoom() changes the room")
    void changeRoom() {
        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        Creature creature = new Adult("TestCreature", room1);

        assertFalse(creature.isWaiting());

        creature.changeRoom(room2);

        assertNotEquals(room1, creature.getCurrentRoom());
        assertEquals(room2, creature.getCurrentRoom());
    }
    @Test
    @DisplayName("changeRoom() doesn't change the room when isWaiting is true")
    void changeRoom_WhenIsWaitingIsTrue() {
        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);

        Creature creature = new Adult("TestCreature", room1);
        creature.setWaiting(true);

        assertTrue(creature.isWaiting());

        creature.changeRoom(room2);

        assertEquals(room1, creature.getCurrentRoom());
        assertNotEquals(room2, creature.getCurrentRoom());
    }

    @Test
    void wakeUp() {
        Creature creature = new Adult("rae", SmartHouse.instance().getRandomRoom());
        creature.setAsleep(true);

        creature.wakeUp();

        assertFalse(creature.isAsleep());
    }

    @Test
    void sleep() {
        Creature creature = new Adult("rae", SmartHouse.instance().getRandomRoom());

        assertFalse(creature.isAsleep());

        creature.sleep();

        assertTrue(creature.isAsleep());
    }

    @Test
    void useRandomDevice() {
        Device mock = mock(Device.class);
        Room room = SmartHouse.instance().getRandomRoom();
        room.addDevice(mock);

        Creature creature = new Adult("adult", room);
        creature.useRandomDevice();

        verify(mock, times(1)).update();
        verify(mock, times(1)).on();
        verify(mock, times(1)).off();
    }

    @Test
    void askForHelp() {
        Creature creature = new Adult("Adult", SmartHouse.instance().getRandomRoom());
        Creature creature1 = new Adult("Adult2", SmartHouse.instance().getRandomRoom());

        SmartHouse.instance().addCreatures(List.of(creature, creature1));

        creature.askForHelp();

        assertTrue(creature.isWaiting());
        assertTrue(creature1.hasTasks());
        assertNotNull(creature1.getTasks().peek());
        assertSame(creature1.getTasks().peek().getType(), Task.Type.HELP);
    }

    @Test
    void washDishes() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);
        Creature creature = new Adult("Pete", room1);

        creature.washDishes(room2);

        assertEquals(room2, creature.currentRoom);
        assertTrue(out.toString().contains(creature.getName() + " is washing dishes"));
    }

    @Test
    void cleanRoom() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Room room1 = SmartHouse.instance().getRooms().get(0);
        Room room2 = SmartHouse.instance().getRooms().get(1);
        Creature creature = new Adult("Pete", room1);

        creature.cleanRoom(room2);

        assertEquals(room2, creature.currentRoom);
        assertTrue(out.toString().contains(creature.getName() + " is cleaning the " + room2.getId()));
    }
}