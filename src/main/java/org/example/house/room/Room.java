package org.example.house.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.device.devices.Lamp;
import org.example.location.Location;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Room {

    private String id;
    private Set<Creature> creatures = new HashSet<>();
    private Set<Device> devices = new HashSet<>();

    public Room(String id) {
        this.id = id;
    }

    public void onCreatureEnter() {
        if (creatures.size() == 1) {
            List<Device> lamps = devices.stream().filter(d -> d.getClass() == Lamp.class).toList();

        }
    }

    public void addCreature(Creature c) {
        creatures.add(c);
    }

    public void removeCreature(Creature c) {
        creatures.remove(c);
    }
}
