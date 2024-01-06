package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.house.Room;

import java.util.Random;

public class Animal extends Creature {
    public Animal(String name, Room currentRoom) {
        super(name, currentRoom, true);
    }

    @Override
    protected void eat() {
        changeRoom(SmartHouse.instance().getKitchen());
        setStayingInCurrentRoom(true);
        askForFood();
    }

    @Override
    public void doSomething() {
        if (isStayingInCurrentRoom())
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

    @Override
    public void chill() {
        System.out.println(getName() + " is napping on its bed");
    }

    private void askForFood() {
        setStayingInCurrentRoom(true);
        SmartHouse.instance().addTask(this, Task.Type.FEED);
        System.out.println(getName() + " says: Mwmouf");
    }
}
