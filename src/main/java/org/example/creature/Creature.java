package org.example.creature;

import lombok.Getter;
import lombok.Setter;
import org.example.SmartHouse;
import org.example.Task;
import org.example.device.Device;
import org.example.device.devices.Fridge.Fridge;
import org.example.device.devices.Lamp.Lamp;
import org.example.house.room.Room;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

@Getter
public class Creature {
    String name;
    Room currentRoom;
    Queue<Task> tasks;
    @Setter @Getter
    private boolean stayingInCurrentRoom;
    @Getter
    private boolean isHelpless;
    @Setter @Getter
    private boolean isBusy = false;

    public Creature(String name, Room currentRoom, boolean isHelpless) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.isHelpless = isHelpless;
        tasks = new PriorityQueue<>();
        System.out.println(getName() + " is in " + currentRoom.getId());
    }

    public void goToNewRoom() {
        if (stayingInCurrentRoom)
            return;

        Room newRoom = SmartHouse.instance().randomRoom();

        changeRoom(newRoom);
    }

    public void changeRoom(Room newRoom) {
        currentRoom.removeCreature(this);
        System.out.println(name + " left " + currentRoom.getId());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp + " is " + (lamp.isON() ? "ON" : "OFF"));
        }
        currentRoom = newRoom;
        currentRoom.addCreature(this);
        System.out.println(name + " entered " + currentRoom.getId());
        for (Lamp lamp : currentRoom.devicesByType(Lamp.class)) {
            System.out.println(lamp + " is " + (lamp.isON() ? "ON" : "OFF"));
        }
    }

    public void useRandomDevice() {
        Object[] devices = currentRoom.getDevices().stream().filter(device -> device.getClass() != Lamp.class && device.getClass() != Fridge.class).toArray();
        if (devices.length == 0)
            return;

        Device device = (Device) devices[new Random().nextInt(devices.length)];
        device.on();
        device.use();
        System.out.println(getName() + " is using " + device.getId());
        if (!device.isAlwaysOn())
            device.off();
    }

    public void eat() {
        currentRoom = SmartHouse.instance().rooms().stream().filter(room -> room.hasDevice(Fridge.class)).findFirst().get();
        Fridge fridge = currentRoom.devicesByType(Fridge.class).get(0);
        System.out.println(getName() + " is eating");
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void askForHelp() {
        stayingInCurrentRoom = true;
        SmartHouse.instance().addTask(new Task(this, Task.Type.HELP));
    }
}
