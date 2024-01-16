package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

/**
 * Class representing event of repairing device
 */
public class RepairingDevice extends Event {
    private final Device device;
    private final Person person;

    public RepairingDevice(Person person, Device device) {
        this.device = device;
        this.person = person;
        this.eventType = EventType.REPAIRING_DEVICE;
    }
}
