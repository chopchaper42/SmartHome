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
    public void doSomething() {
        if (isWaiting())
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

    /**
     * Changes the current room to kitchen and asks for food
     */
    @Override
    protected void eat() {
        askForFood();
    }

    private void askForFood() {
        changeRoom(SmartHouse.instance().getKitchen());
        SmartHouse.instance().assignTask(this, Task.Type.FEED);
        setWaiting(true);
        System.out.println(getName() + " says: I wanna eat!");
    }

    private void helpCreature(Creature creature) {
        changeRoom(creature.currentRoom);
        System.out.println(getName() + " is helping " + creature.getName());
        creature.setWaiting(false);
    }
}
