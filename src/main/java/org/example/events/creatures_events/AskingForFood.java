package org.example.events.creatures_events;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.animals.Animal;
import org.example.events.Event;
import org.example.events.EventType;
import org.example.events.Night;
import org.example.events.observer.EventManager;
import org.example.events.observer.EventObserver;

import java.util.logging.Logger;

@Getter
@Setter public class AskingForFood extends Event {
    private static Logger logger = Logger.getLogger(AskingForFood.class.getName());
    private Animal animal;


    public AskingForFood(Animal animal) {
        super();
        this.animal = animal;
        this.eventType = EventType.PET_WANT_TO_EAT;
        EventManager.getInstance().notify(this);
        logger.info(animal.getName() + " asks for food.");
    }
}
