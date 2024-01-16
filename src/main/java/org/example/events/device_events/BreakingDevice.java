package org.example.events.device_events;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.EventType;

/**
 * Class representing event of breaking device by creature
 */
@Getter
@Setter
public class BreakingDevice extends Event {
    private final Device device;
    private final Creature creature;

    public BreakingDevice(Creature creature, Device device) {
        this.device = device;
        this.creature = creature;
        this.eventType = EventType.BREAKING_DEVICE;
    }
}
