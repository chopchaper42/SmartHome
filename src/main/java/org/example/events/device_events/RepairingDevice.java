package org.example.events.device_events;

import org.example.creature.people.Person;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

import java.util.logging.Logger;

/**
 * Class representing event of repairing device
 */
public class RepairingDevice extends Event {
    private static Logger logger = Logger.getLogger(RepairingDevice.class.getName());
    private final Device device;
    private final Person person;

    public RepairingDevice(Person person, Device device) {
        super();
        this.device = device;
        this.person = person;
        this.eventType = EventType.REPAIRING_DEVICE;
        logger.info(device.getNameOfDevice() + " is repairing by " + person.getName());
    }
    @Override
    public String toString() {
        return "The device " + device.getNameOfDevice() + " is repairing by " + person.getName() + "\n";
    }
}
