package org.example.creature.people;

import org.example.Simulation;
import org.example.device.Device;
import org.example.events.Event;
import org.example.events.device_events.BreakingDevice;
import org.example.events.observer.EventManager;

import java.util.logging.Logger;

import static org.example.events.EventType.BREAKING_DEVICE;

/**
 * Class of Adult
 */
public class Adult extends Person {
    private static final Logger logger = Logger.getLogger(Adult.class.getName());
    private Device brokenDevice;
    private int timeForFindingManual = 0;
    private boolean isAdultLookingForManual = false;


    public Adult() {
        super();
        EventManager.getInstance().subscribe(BREAKING_DEVICE, this);
    }

    @Override
    public void update(Event event) {
        if (event.getEventType() == BREAKING_DEVICE) {
            BreakingDevice device = (BreakingDevice) event;
            logger.info("The person " + getName() + " started repairing device " + device.getDevice().getNameOfDevice());
            isAdultLookingForManual = true;
            brokenDevice = device.getDevice();

        }
    }


    /**
     * Implements the behavior for handling events in the context of an Adult person.
     */
    @Override
    public void everythingIsHappeningAsISaid() {
        if(brokenDevice != null) {
            if(isAdultLookingForManual) {
                increaseTimeAndCheck();
            }
        }
        else {
            strategy.everythingIsHappeningAsISaid(this);
        }
    }

    /**
     * Increases the time for finding a manual and checks whether the search time limit is reached.
     * If the limit is reached, stops searching, repairs the broken device, and resets the search time.
     */
    private void increaseTimeAndCheck() {
        timeForFindingManual++;
        if(timeForFindingManual > 2) {
            isAdultLookingForManual = false;
            if (brokenDevice != null) {
                brokenDevice.repair(this);
                brokenDevice = null;
            }
            timeForFindingManual = 0;
        }
    }



}
