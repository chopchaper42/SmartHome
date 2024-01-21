package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.house.Room;

import java.util.Random;

public class Animal extends Creature {
    public Animal(String name, Room currentRoom) {
        super(name, currentRoom, true);
    }

    /**
     * Randomly chooses what to do
     */
    @Override
    public void doSomething() {
        if (isWaiting())
            return;

        switch (new Random().nextInt(10)) {
            case 0 -> eat();
            case 1 -> askForHelp();
            case 3, 4 -> goToNewRoom();
            default -> chill();
        }
    }

    @Override
    public void processTask() {}

    /**
     * Changes the current room to kitchen, stays there and asks for food
     */
    @Override
    protected void eat() {
        changeRoom(SmartHouse.instance().getKitchen());
        setWaiting(true);
        askForFood();
    }

    /**
     * Naps on its bed
     */
    @Override
    protected void chill() {
        System.out.println(getName() + " is napping on its bed");
    }

    private void askForFood() {
        setWaiting(true);
        SmartHouse.instance().assignTask(this, Task.Type.FEED);
        System.out.println(getName() + " says: Mwmouf");
    }
}
