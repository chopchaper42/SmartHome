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

import java.util.*;

@Getter
public abstract class Creature implements TaskSource {
    protected String name;
    protected Room currentRoom;
    protected Queue<Task> tasks;
    @Setter @Getter
    private boolean isWaiting;
    @Getter
    private boolean isHelpless;
    @Setter @Getter
    protected boolean isBusy = false;
    @Getter @Setter
    protected boolean isAsleep = false;
    @Getter
    protected Map<String, Integer> usageJournal = new HashMap<>();


    /**
     * Creates a creature with the given name, currentRoom and whether it is helpless
     * @param name name of the creature
     * @param currentRoom current room
     * @param isHelpless is helpless
     */
    public Creature(String name, Room currentRoom, boolean isHelpless) {
        this.name = name;
        this.currentRoom = currentRoom;
        currentRoom.addCreature(this);
        this.isHelpless = isHelpless;
        tasks = new LinkedList<>();
        System.out.println(getName() + " is in " + currentRoom.getId());
    }

    /**
     * Processes tasks that creature has
     */
    public abstract void processTask();

    /**
     * Adds a task to the creature's task list
     * @param task
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Creature randomly chooses a room to go and changes the room
     */
    public void goToNewRoom() {
        if (isWaiting)
            return;

        Room newRoom;
        do {
            newRoom = SmartHouse.instance().getRandomRoom();
        } while (currentRoom == newRoom);

        changeRoom(newRoom);
    }

    /**
     * Changes the current room on the given one. Does nothing, if {@code stayingInCurrentRoom} is {@code true}
     * @param newRoom a room to change to
     */
    public void changeRoom(Room newRoom) {
        if (isWaiting)
            return;

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

    /**
     * Randomly chooses what creature will do. If it has task to do, it does it first.
     */
    public void doSomething() {
        if (isWaiting)
            return;

        if (!tasks.isEmpty()) {
            processTask();
            return;
        }

        switch (new Random().nextInt(10)) {
            case 1, 3, 5 -> useRandomDevice();
            case 0, 6 -> eat();
            case 2 -> askForHelp();
            case 7, 4 -> chill();
            case 8, 9 -> goToNewRoom();
        }
    }

    /**
     * @return whether the creature's task list isn't empty
     */
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    /**
     * Wakes up the creature
     */
    public void wakeUp() {
        isAsleep = false;
        System.out.println(getName() + " is awake now. Good morning!");
    }

    /**
     * Makes the creature sleep
     */
    public void sleep() {
        isAsleep = true;
        System.out.println(getName() + " is sleeping now.");
    }

    /**
     * Randomly chooses device in the current room and uses it.
     */
    protected void useRandomDevice() {
        Object[] devices = currentRoom.getDevices().stream().filter(device -> device.getClass() != Lamp.class && device.getClass() != Fridge.class).toArray();

        if (devices.length == 0)
            return;

        Device device = (Device) devices[new Random().nextInt(devices.length)];


        if (usageJournal.containsKey(device.getId()))
            usageJournal.put(device.getId(), usageJournal.get(device.getId()) + 1);
        else
            usageJournal.put(device.getId(), 1);

        if (!device.isON())
            device.on();

        device.update();
        System.out.println(getName() + " is using " + device.getId());
        if (!device.isAlwaysOn())
            device.off();
    }

    /**
     * Changes the current room for a kitchen and uses a fridge
     */
    protected void eat() {
        changeRoom(SmartHouse.instance().getRooms().stream().filter(room -> room.hasDevice(Fridge.class)).findFirst().get());
        Fridge fridge = currentRoom.devicesByType(Fridge.class).get(0);
        System.out.println(getName() + " is eating");
    }

    /**
     * Asks other creatures in the house for help
     */
    protected void askForHelp() {
        setWaiting(true);
        SmartHouse.instance().assignTask(this, Task.Type.HELP);
        System.out.println(getName() + " is asking for help");
    }

    /**
     * Washes the dishes
     * @param room
     */
    protected void washDishes(Room room) {
        changeRoom(room);
        System.out.println(getName() + " is washing dishes");
    }

    /**
     * Cleans the room
     * @param room
     */
    protected void cleanRoom(Room room) {
        changeRoom(room);
        System.out.println(getName() + " is cleaning the " + room.getId());
    }

    /**
     * Makes the creature rest
     */
    protected void chill() {
        System.out.println(getName() + " is chilling on a couch");
    }

    /**
     * @return the name of the creature
     */
    @Override
    public String toString() {
        return getName();
    }
}
