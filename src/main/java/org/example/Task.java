package org.example;

import lombok.Getter;
import org.example.creature.Creature;
import org.example.device.Device;

public class Task {
    public enum Type {
        REPAIR,
        HELP,
        FEED
    }

    @Getter
    private Device deviceSource;
    @Getter
    private Creature creatureSource;
    @Getter
    private Task.Type type;

    public Task(Device target, Task.Type taskType) {
        this.deviceSource = target;
        this.type = taskType;
    }

    public Task(Creature target, Task.Type taskType) {
        this.creatureSource = target;
        this.type = taskType;
    }
}
