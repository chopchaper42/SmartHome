package org.example.device;

public enum KitchenDeviceTypes {
    TEAPOD(DeviceTypes.KITCHEN_DEVICE),
    FRIDGE(DeviceTypes.KITCHEN_DEVICE),
    ELECTRIC_STOVE(DeviceTypes.KITCHEN_DEVICE),
    PET_FEEDER(DeviceTypes.KITCHEN_DEVICE);
    private final DeviceTypes type;

    KitchenDeviceTypes(DeviceTypes type) {
        this.type = type;
    }
}
