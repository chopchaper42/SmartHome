package org.example.device.device_factory;

import org.example.creature.creatures_factory.PeopleFactory;
import org.example.device.Device;
import org.example.device.DeviceTypes;
import org.example.device.KitchenDeviceTypes;
import org.example.device.devices.entertainment.*;
import org.example.device.devices.kitchen.ElectricStove;
import org.example.device.devices.kitchen.Fridge;
import org.example.device.devices.kitchen.PetFeeder;
import org.example.device.devices.kitchen.Teapod;
import org.example.house.Room;

import static org.example.device.DeviceTypes.ENTERTAINMENT_DEVICE;
import static org.example.device.DeviceTypes.KITCHEN_DEVICE;

public class KitchenDeviceCreator extends DeviceFactory<KitchenDeviceTypes>{
    private static KitchenDeviceCreator instance = null;

    /**
     * Private singleton constructor
     */
    private KitchenDeviceCreator(){}

    /**
     * Method for getting Kitchen Device Creator instance - Singleton pattern
     * @return instance of Kitchen Device Creator
     */
    public static KitchenDeviceCreator getInstance() {
        if (instance == null) { instance = new KitchenDeviceCreator();}
        return instance;
    }

    @Override
    public Device createDevice(Room room, KitchenDeviceTypes concreteDevice){
            Device device = switch (concreteDevice) {
                case TEAPOD -> new Teapod(room);
                case FRIDGE -> new Fridge(room);
                case ELECTRIC_STOVE -> new ElectricStove(room);
                case PET_FEEDER -> new PetFeeder(room);
                default -> throw new IllegalArgumentException("Unknown Construction Device Type");
            };
        return device;
    }
}
