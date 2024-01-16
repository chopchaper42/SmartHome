package org.example.device;

public enum EntertainmentDeviceTypes {
    TV(DeviceTypes.ENTERTAINMENT_DEVICE),
    MOBILE(DeviceTypes.ENTERTAINMENT_DEVICE),
    SMART_WATCH(DeviceTypes.ENTERTAINMENT_DEVICE),
    CD_PLAYER(DeviceTypes.ENTERTAINMENT_DEVICE),
    COMPUTER(DeviceTypes.ENTERTAINMENT_DEVICE);

    private final DeviceTypes type;

    EntertainmentDeviceTypes(DeviceTypes type) {
        this.type = type;
    }

    /**
     * Returns the {@link EntertainmentDeviceTypes} based on its name.
     * The comparison of names is case-insensitive.
     *
     * @param name the name of the device for which to retrieve the type
     * @return the {@link EntertainmentDeviceTypes} representing the device type,
     *         or {@code null} if no device with the given name is found
     */
    public static EntertainmentDeviceTypes getTypeByName(String name) {
        for (EntertainmentDeviceTypes type : EntertainmentDeviceTypes.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
