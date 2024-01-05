package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.house.room.Room;

public class Child extends Creature {
    public Child(String name, Room currentRoom) {
        super(name, currentRoom, true);
    }

    @Override
    public void eat() {
        askForFood();
    }

    public void askForFood() {
        SmartHouse.instance().addTask(new Task(this, Task.Type.FEED));
        setStayingInCurrentRoom(true);
    }
}
