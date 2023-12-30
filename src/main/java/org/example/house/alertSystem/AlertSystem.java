package org.example.house.alertSystem;

import org.example.creature.Creature;

import java.util.List;

public class AlertSystem {
    List<Creature> subscribers;

    public void subscribe(Creature creature) { subscribers.add(creature); }
}
