package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

public class TurningOnTheDevice extends Event {

    private final Person person;
    private final Device device;

    public TurningOnTheDevice(Person person, Device device) {
        this.person = person;
        this.device = device;
        this.eventType = EventType.TURNING_ON_THE_DEVICE;
    }
}
