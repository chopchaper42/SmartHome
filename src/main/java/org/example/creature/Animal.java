package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.house.room.Room;

public class Animal extends Creature {
    public Animal(String name, Room currentRoom) {
        super(name, currentRoom, true);
    }

    @Override
    public void eat() {
//        goTo(kitchen);
        askForFood();
    }

    private void askForFood() {
        SmartHouse.instance().addTask(new Task(this, Task.Type.FEED));
    }
}
