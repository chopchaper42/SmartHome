package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

import java.util.logging.Logger;

/**
 * Class representing event of using device
 */
public class UsingDevice extends Event {
    private static Logger logger = Logger.getLogger(UsingDevice.class.getName());
    private final Person person;
    private final Device device;

    public UsingDevice(Person person, Device device) {
        this.person = person;
        this.device = device;
        this.eventType = EventType.USING_DEVICE;
        logger.info(person.getName() + " is using " + device.getNameOfDevice());
    }

    @Override
    public String toString() {
        return "The device " + device.getNameOfDevice() + " is using by " + person.getName() + "\n";
    }
}
