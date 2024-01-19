package org.example.events;

import org.example.events.observer.EventManager;

import java.util.logging.Logger;

/**
 * Class representing night event
 */
public class Night extends Event{

    private static Logger logger = Logger.getLogger(Night.class.getName());
    public Night() {
        super();
        this.eventType = EventType.NIGHT;
        EventManager.getInstance().notify(this);
        logger.info(" Night started. ");
    }

    @Override
    public String toString() {
        return "Night started \n";
    }


}
