package org.example.creature;

import lombok.Getter;
import lombok.Setter;
import org.example.SmartHouse;
import org.example.Task;
import org.example.TaskSource;
import org.example.device.Device;
import org.example.device.devices.Fridge.Fridge;
import org.example.device.devices.Lamp.Lamp;
import org.example.house.Room;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@Getter
public abstract class Creature implements TaskSource {
    protected String name;
    protected Room currentRoom;
    protected Queue<Task> tasks;
    @Setter @Getter
    private boolean stayingInCurrentRoom;
    @Getter
    private boolean isHelpless;
    @Setter @Getter
    protected boolean isBusy = false;
    @Getter @Setter
    protected boolean isAsleep = false;
//    protected int busyCounter = 0;
//    protected Device occupiedDevice;


    public Creature(String name, Room currentRoom, boolean isHelpless) {
        this.name = name;
        this.currentRoom = currentRoom;
        currentRoom.addCreature(this);
        this.isHelpless = isHelpless;
        tasks = new LinkedList<>();
        System.out.println(getName() + " is in " + currentRoom.getId());
    }

    public void goToNewRoom() {
        if (stayingInCurrentRoom)
            return;

        Room newRoom = SmartHouse.instance().getRandomRoom();

        if (newRoom == currentRoom)
            return;


        changeRoom(newRoom);
    }

    public void changeRoom(Room newRoom) {
        if (stayingInCurrentRoom) // TODO: Do better?
            return;
//            throw new RuntimeException(getName() + " is busy right now, can't go anywhere");

        currentRoom.removeCreature(this);
        System.out.println(name + " left " + currentRoom.getId() + " " + currentRoom.getCreatures());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp + " is " + (lamp.isON() ? "ON" : "OFF"));
        }
        currentRoom = newRoom;
        currentRoom.addCreature(this);
        System.out.println(name + " entered " + currentRoom.getId() + " " + currentRoom.getCreatures());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp + " is " + (lamp.isON() ? "ON" : "OFF"));
        }
    }

    public void useRandomDevice() {
        Object[] devices = currentRoom.getDevices().stream().filter(device -> device.getClass() != Lamp.class && device.getClass() != Fridge.class).toArray();
        if (devices.length == 0)
            return;

        Device device = (Device) devices[new Random().nextInt(devices.length)];

//        occupiedDevice = device;

        if (!device.isON())
            device.on();
        device.update();
        System.out.println(getName() + " is using " + device.getId());
        if (!device.isAlwaysOn())
            device.off();
    }

    public void doSomething() {
        if (stayingInCurrentRoom)
            return;

        if (!tasks.isEmpty()) {
            processTask();
            return;
        }

//        busyCounter = new Random().nextInt(1, 4);

        switch (new Random().nextInt(10)) {
            case 1, 3, 5 -> useRandomDevice();
            case 0, 6 -> eat();
            case 2 -> askForHelp();
            case 7, 4 -> chill();
            case 8, 9 -> goToNewRoom();
        }
    }

    public abstract void processTask();

    protected void eat() {
        changeRoom(SmartHouse.instance().rooms().stream().filter(room -> room.hasDevice(Fridge.class)).findFirst().get());
        Fridge fridge = currentRoom.devicesByType(Fridge.class).get(0);
        System.out.println(getName() + " is eating");
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void askForHelp() {
        setStayingInCurrentRoom(true);
        SmartHouse.instance().addTask(this, Task.Type.HELP);
//        SmartHouse.instance().addTask(new Task(this, Task.Type.HELP));
        System.out.println(getName() + " is asking for help");
    }

    public void washDishes(Room room) {
        changeRoom(room);
        System.out.println(getName() + " is washing dishes");
    }

    public void cleanRoom(Room room) {
        changeRoom(room);
        System.out.println(getName() + " is cleaning the " + room.getId());
    }

    public void chill() {
        System.out.println(getName() + " is chilling on a couch");
    }

    @Override
    public String toString() {
        return getName();
    }

    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    public void wakeUp() {
        isAsleep = false;
        System.out.println(getName() + " is awake now. Good morning!");
    }

    public void sleep() {
        isAsleep = true;
        System.out.println(getName() + " is sleeping now.");
    }
}
