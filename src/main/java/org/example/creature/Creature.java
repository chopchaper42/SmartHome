package org.example.creature;


import lombok.Getter;
import lombok.Setter;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.events.EventType;
import org.example.events.observer.EventObserver;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.floors.Floor;
import org.example.house.strategy.Strategy;

import java.util.List;
import java.util.Random;

/**
 * Class representing Creature (living object) in the house
 */
@Getter
@Setter
public abstract class Creature implements EventObserver {

    protected Room currentRoom;
    protected Device currentDevice;
    protected CreaturesEnum creatureType;
    protected String name;
    protected int age;
    protected DeviceTypes deviceType;
    protected Strategy strategy;

//    protected Creature() {
//        EventManager.getInstance.subscribe(DAY, this);
//    }

    /**
     * Creature go to another room
     * @param room target room
     */
    public void goToAnotherRoom(Room room){
        room.getCreaturesInside().remove(this);
        room.getCreaturesInside().add(this);
        currentRoom = room;
    }

    public abstract void interactWithDevice(Device device);

    /**
     * Creature breaks device
     * @param currentRoom
     */
    public void breakDevice(Room currentRoom){
        Device device;
        List<Device> devices = currentRoom.getDevices().stream().filter(Device::isFree).toList();
        if(!devices.isEmpty()) {
            Random random = new Random();
            int deviceIndex = random.nextInt(devices.size());
            device = devices.get(deviceIndex);
            device.breakDevice(this);
        }
    }

    //public abstract void stopIteract();

    //public void creatureDoStrategy() { strategy.doStuff(this); }
    public void everythingIsHappeningAsISaid() { strategy.everythingIsHappeningAsISaid(this);}
    /**
     * Creature stops using device
     */
    public void freeDevice() {
        if(currentDevice == null) {
            return;
        }
        currentDevice.setFree(true);
        currentDevice = null;
    }

    /**
     * Creature finds a certain device in room by name of device
     * @param name name of target device
     * @return target device
     */
    public Device findDevice(String name){
        for (Floor floor: House.getInstance().getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Device device : room.getDevices()) {
                    if(device.getNameOfDevice().equals(name) && device.isFree()) {
                        return device;
                    }
                }
            }
        }
        return null;
    }


    /**
     * Creature finds certain room
     * @param nameOfRoom name of target room
     * @return found room
     */
    public Room findRoom(String nameOfRoom) {
        for (Floor floor: House.getInstance().getFloors()) {
            for (Room room : floor.getRooms()) {
                if(room.getRoomName().equals(nameOfRoom)) {
                    return room;
                }
            }
        }
        return null;
    }
    /**
     * Creature chooses random room
     * @return found room
     */
    public Room randomRoom(){
        List<Floor> floors = House.getInstance().getFloors();
        Random random = new Random();
        int floorIndex = random.nextInt(floors.size());
        Floor floor = floors.get(floorIndex);
        List<Room> rooms = floor.getRooms();
        int roomIndex = random.nextInt(rooms.size());
        return rooms.get(roomIndex);
    }



}
