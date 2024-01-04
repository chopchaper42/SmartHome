package org.example.creature;

import lombok.Getter;
import org.example.Dispatcher;
import org.example.device.Device;
import org.example.device.devices.Lamp.Lamp;
import org.example.house.room.Room;

import java.util.Random;

@Getter
public class Creature {
    String name;
    Room currentRoom;

    public Creature(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        System.out.println(getName() + " is in " + currentRoom.getId());
    }

    public void goToNewLocation() {
        Room newRoom;

        do {
            newRoom = Dispatcher.instance().randomRoom();
        } while (newRoom == currentRoom);

        currentRoom.removeCreature(this);
        System.out.println(name + " left " + currentRoom.getId());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp.toString() + " is " + (lamp.isOn() ? "ON" : "OFF"));
        }
        currentRoom = newRoom;
        currentRoom.addCreature(this);
        System.out.println(name + " entered " + currentRoom.getId());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp.toString() + " is " + (lamp.isOn() ? "ON" : "OFF"));
        }
    }

    public void useRandomDevice() {
        Object[] devices = currentRoom.getDevices().stream().filter(device -> device.getClass() != Lamp.class).toArray();
        ((Device) devices[new Random().nextInt(devices.length)]).use();
    }
}
