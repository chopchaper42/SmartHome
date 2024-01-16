package org.example.events;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class for events
 */
@Getter
@Setter
public abstract class Event {
    protected EventType eventType;

}
