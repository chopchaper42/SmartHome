package org.example.events;

/**
 * Class representing night event
 */
public class Night extends Event{

    public Night() {
        super();
        this.eventType = EventType.NIGHT;
        //EventManager.getInstance().notifySubscribers(this)
    }
}
