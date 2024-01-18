package org.example.events.observer;

import org.example.events.Event;
import org.example.events.EventType;

import java.util.*;

import static org.example.events.EventType.DAY;

public class EventManager {
    private Map<EventType, List<EventObserver>> listeners;
    private static EventManager INSTANCE;

    public EventManager() {
    }

    public static EventManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventManager();
            INSTANCE.listeners = new EnumMap<>(EventType.class);
        }
        return INSTANCE;
    }

    /**
     * Subscribes an {@link EventObserver} to the specified {@link EventType}.
     *
     * @param eventType      The type of event to subscribe to.
     * @param eventListener  The observer to be subscribed.
     */
    public void subscribe(EventType eventType, EventObserver eventListener) {
        if(INSTANCE.listeners.containsKey(eventType)) {
            INSTANCE.listeners.get(eventType).add(eventListener);
        } else {
            List<EventObserver> eventObserverList = new ArrayList<>();
            eventObserverList.add(eventListener);
            INSTANCE.listeners.put(eventType, eventObserverList);
        }
    }

    /**
     * Unsubscribes an {@link EventObserver} from the specified {@link EventType}.
     *
     * @param eventType      The type of event to unsubscribe from.
     * @param eventListener  The observer to be unsubscribed.
     */
    public void unsubscribe(EventType eventType, EventObserver eventListener) {
        if (INSTANCE.listeners.containsKey(eventType)) {
            INSTANCE.listeners.get(eventType).remove(eventListener);
        }
    }

    /**
     * Notifies the registered observers about the occurrence of a specific event.
     *
     * @param event The event to be notified.
     */
    public void notify(Event event) {
        if(event.getEventType() == DAY) {
            List<EventObserver> eventObserverList = INSTANCE.listeners.get(DAY);
            if(!eventObserverList.isEmpty()) {
                for(EventObserver eventObserver : eventObserverList) {
                    eventObserver.startingNewDay();
                }
            }
        }
        List<EventObserver> eventObserverList2 = listeners.get(event.getEventType());
        for (EventObserver eventObserver : eventObserverList2) {
            eventObserver.update(event);
        }

    }
}
