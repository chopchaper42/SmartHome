package org.example.events;

/**
 * A class representing a day in the simulation of a house. Each object of this class initiates a new day.
 * It contains information about the ordinal number of the day in the simulation.
 */
public class Day extends Event {
    private static int days = 0;
    private int numberOfDays;

    public Day() {
        super();
        this.eventType = EventType.DAY;
        days++;
        numberOfDays = days;
        //EventManager.getInstance().notifySubscribers
    }
}
