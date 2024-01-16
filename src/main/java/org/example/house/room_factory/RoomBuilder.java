package org.example.house.room_factory;

import org.example.device.Device;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.house.Room;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for building rooms
 */
public class RoomBuilder {


    private final List<Device> devices = new ArrayList<>();
    private final List<AutomaticWindow> windowList = new ArrayList<>();
    private final List<AutomaticDoor> doorList = new ArrayList<>();
    RoomFactory roomFactory = new RoomFactory();
    RoomTypes roomName;

    /**
     * Add device to the room
     * @param device target device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Adds windows to room
     * @param numberOfWindows number of windows
     * @return room
     */
    public RoomBuilder addWindows(int numberOfWindows){
        for (int i = 0; i < numberOfWindows; i++) {
            AutomaticWindow window = new AutomaticWindow(roomFactory.createRoom(roomName));
            devices.add(window);
            windowList.add(window);
        }
        return this;
    }

    /**
     * Adds doors to room
     * @param numberOfDoors number of doors
     * @return room
     */
    public RoomBuilder addDoors(int numberOfDoors){
        for (int i = 0; i < numberOfDoors; i++) {
            AutomaticDoor door = new AutomaticDoor(roomFactory.createRoom(roomName));
            devices.add(door);
            doorList.add(door);
        }
        return this;
    }

    /**
     * Build (create) new room
     * @return target room
     */
    public Room build() {
        Room room = roomFactory.createRoom(roomName);
        room.setDevices(devices);
        for (Device device : devices) {
            device.setCurrentRoom(room);
        }
        return room;
    }


}
