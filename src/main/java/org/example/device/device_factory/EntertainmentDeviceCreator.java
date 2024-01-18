package org.example.device.device_factory;

import org.example.device.ConstructionDeviceTypes;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.devices.construction.AutomaticDoor;
import org.example.device.devices.construction.AutomaticWindow;
import org.example.device.devices.entertainment.*;
import org.example.house.Room;

import static org.example.device.DeviceTypes.CONSTRUCTION_DEVICE;
import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import org.example.device.EntertainmentDeviceTypes;

import java.util.ArrayList;
import java.util.List;

public class EntertainmentDeviceCreator extends DeviceFactory<EntertainmentDeviceTypes>{

    private static EntertainmentDeviceCreator instance = null;

    /**
     * List of all entertainment devices
     */
    private final List<EntertainmentDeviceInterface> entertainmentDeviceInterfaceList = new ArrayList<>();

    /**
     * Private singleton constructor
     */
    private EntertainmentDeviceCreator(){}

    /**
     * Method for getting Entertainment Device Creator instance - Singleton pattern
     * @return instance of Entertainment Device Creator
     */
    public static EntertainmentDeviceCreator getInstance() {
        if (instance == null) { instance = new EntertainmentDeviceCreator();}
        return instance;
    }

    @Override
    public Device createDevice(Room room, EntertainmentDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case TV -> new TV(room);
                case CD_PLAYER -> new CdPlayer(room);
                case COMPUTER -> new Computer(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
            };
            //add to room
            //add to list of all devices
            entertainmentDeviceInterfaceList.add((EntertainmentDeviceInterface) device);
        return device;
    }

    /**
     * Returns list of all entertainment devices
     * @return
     */
    public List<EntertainmentDeviceInterface> getEntertainmentDeviceInterfaceList() {
        return entertainmentDeviceInterfaceList;
    }
}
