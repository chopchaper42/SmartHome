package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.Room;

public class Task {
    public enum Type {
        REPAIR,
        HELP,
        FEED,
        WASH_DISHES,
        CLEAN_ROOM
    }

    @Getter
    private Device deviceSource;
    @Getter
    private Creature creatureSource;
    @Getter
    private Room roomSource;
    @Getter @Setter
    private Creature target;
    @Getter
    private Task.Type type;

    public Task(TaskSource source, Task.Type taskType) {
        if (source instanceof Device)
            this.deviceSource = (Device) source;
        if (source instanceof Room)
            this.roomSource = (Room) source;
        if (source instanceof Creature)
            this.creatureSource = (Creature) source;

        this.type = taskType;
    }

}
