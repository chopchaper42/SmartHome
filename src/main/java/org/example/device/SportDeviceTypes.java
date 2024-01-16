package org.example.device;

import java.util.Objects;

/**
 * Subtype of devices - Sport device
 */
public enum SportDeviceTypes {
    RUNNING_PATH(DeviceTypes.SPORT_DEVICE),
    ORBITEK(DeviceTypes.SPORT_DEVICE);

    private final DeviceTypes type;

    SportDeviceTypes(DeviceTypes type) {
        this.type = type;
    }

    /**
     * Returns the {@link SportDeviceTypes} based on its name.
     * The comparison of names is case-insensitive.
     *
     * @param name the name of the device for which to retrieve the type
     * @return the {@link SportDeviceTypes} representing the device type,
     *         or {@code null} if no device with the given name is found
     */
    public static SportDeviceTypes getTypeByName(String name) {
        for (SportDeviceTypes type : SportDeviceTypes.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
