package org.example.events.device_events;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;
import org.example.events.observer.EventManager;

import java.util.logging.Logger;

/**
 * Class representing event of breaking device by creature
 */
@Getter
@Setter
public class BreakingDevice extends Event {
    private static Logger logger = Logger.getLogger(BreakingDevice.class.getName());
    private final Device device;
    private final Creature creature;

    public BreakingDevice(Creature creature, Device device) {
        super();
        this.device = device;
        this.creature = creature;
        this.eventType = EventType.BREAKING_DEVICE;
        EventManager.getInstance().notify(this);
        logger.info(device.getNameOfDevice() + " is broken by " + creature.getName());
    }
}
