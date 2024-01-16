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


    /**
     * Returns the {@link KitchenDeviceTypes} based on its name.
     * The comparison of names is case-insensitive.
     *
     * @param name the name of the device for which to retrieve the type
     * @return the {@link KitchenDeviceTypes} representing the device type,
     *         or {@code null} if no device with the given name is found
     */
    public static KitchenDeviceTypes getTypeByName(String name) {
        for (KitchenDeviceTypes type : KitchenDeviceTypes.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
