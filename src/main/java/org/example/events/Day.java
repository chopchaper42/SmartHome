package org.example.events;

import org.example.events.observer.EventManager;

import java.util.logging.Logger;

/**
 * A class representing a day in the simulation of a house. Each object of this class initiates a new day.
 * It contains information about the ordinal number of the day in the simulation.
 */
public class Day extends Event {
    private static Logger logger = Logger.getLogger(Day.class.getName());
    private static int days = 0;
    private int numberOfDays;

    public Day() {
        super();
        this.eventType = EventType.DAY;
        days++;
        numberOfDays = days;
        logger.info("Day # " + numberOfDays + " started. ");
        EventManager.getInstance().notify(this);
    }
    @Override
    public String toString() {
        return "Day started \n";
    }
}
