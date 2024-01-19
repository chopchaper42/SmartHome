package org.example.events;

import lombok.Getter;
import lombok.Setter;
import org.example.report.EventReport;

/**
 * Abstract class for events
 */
@Getter
@Setter
public abstract class Event {
    protected EventType eventType;
    protected Event() {
        EventReport.getInstance().addEvent(this);
    }

}
