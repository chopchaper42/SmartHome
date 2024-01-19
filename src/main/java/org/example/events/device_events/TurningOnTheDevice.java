package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

import java.util.logging.Logger;

public class TurningOnTheDevice extends Event {
    private static Logger logger = Logger.getLogger(TurningOnTheDevice.class.getName());

    private final Person person;
    private final Device device;

    public TurningOnTheDevice(Person person, Device device) {
        super();
        this.person = person;
        this.device = device;
        this.eventType = EventType.TURNING_ON_THE_DEVICE;
        logger.info(device.getNameOfDevice() + " is turned on by " + person.getName());
    }

    @Override
    public String toString() {
        return "The device " + device.getNameOfDevice() + " is turning on by " + person.getName() + "\n";
    }
}
