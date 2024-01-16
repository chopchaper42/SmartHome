package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

/**
 * Class representing event of using device
 */
public class UsingDevice extends Event {
    private final Person person;
    private final Device device;

    public UsingDevice(Person person, Device device) {
        this.person = person;
        this.device = device;
        this.eventType = EventType.USING_DEVICE;
    }
}
