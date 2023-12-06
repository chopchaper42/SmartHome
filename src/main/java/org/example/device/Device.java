package org.example.device;

import org.example.device.device_factory.ConstructionDeviceCreator;
import org.example.house.Room;

public class Device {

    private final DeviceTypes type;
    private final Room currentRoom;
    private  String concreteDevice;


    //private currentState = new IdleState(this);

    private int electricity = 0;

    public Device(Room currentRoom, DeviceTypes type) {
        this.type = type;
        this.currentRoom = currentRoom;

    }


}
