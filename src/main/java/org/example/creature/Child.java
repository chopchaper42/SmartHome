package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.house.Room;

import java.util.Random;

public class Child extends Creature {
    public Child(String name, Room currentRoom) {
        super(name, currentRoom, true);
    }

    @Override
    protected void eat() {
        askForFood();
    }

    @Override
    public void doSomething() {
        if (isStayingInCurrentRoom())
            return;

        if (!tasks.isEmpty()) {
            processTask();
            return;
        }

        switch(new Random().nextInt(8)) {
            case 0 -> askForFood();
            case 1 -> askForHelp();
            case 2 -> useRandomDevice();
            case 3, 4, 5 -> chill();
            default -> goToNewRoom();
        }
    }

    @Override
    public void processTask() {
        Task task = tasks.poll();
        switch (task.getType()) {
            case CLEAN_ROOM -> cleanRoom(task.getRoomSource());
            case WASH_DISHES -> washDishes(task.getRoomSource());
            case HELP -> helpCreature(task.getCreatureSource());
        }
    }

    public void askForFood() {
        changeRoom(SmartHouse.instance().getKitchen());
//        SmartHouse.instance().addTask(new Task(this, Task.Type.FEED));
        SmartHouse.instance().addTask(this, Task.Type.FEED);
        setStayingInCurrentRoom(true);
        System.out.println(getName() + " says: I wanna eat!");
    }

    private void helpCreature(Creature creature) {
        changeRoom(creature.currentRoom);
        System.out.println(getName() + " is helping " + creature.getName());
        creature.setStayingInCurrentRoom(false);
    }
}
