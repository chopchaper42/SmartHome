package org.example.device.device_factory;

import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.SportDeviceTypes;
import org.example.device.devices.entertainment.*;
import org.example.device.devices.sport.Orbitek;
import org.example.device.devices.sport.Running_Path;
import org.example.house.Room;

import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import static org.example.device.DeviceTypes.SPORT_DEVICE;

public class SportDeviceCreator extends DeviceFactory<SportDeviceTypes> {
    private static SportDeviceCreator instance = null;

    /**
     * Private singleton constructor
     */
    private SportDeviceCreator(){}

    /**
     * Method for getting Sport Device Creator instance - Singleton pattern
     * @return instance of Sport Device Creator
     */
    public static SportDeviceCreator getInstance() {
        if (instance == null) { instance = new SportDeviceCreator();}
        return instance;
    }
    @Override
    public Device createDevice(Room room, SportDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case RUNNING_PATH -> new Running_Path(room);
                case ORBITEK -> new Orbitek(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
            };
        return device;
    }
}
