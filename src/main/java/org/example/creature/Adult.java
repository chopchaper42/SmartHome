package org.example.creature;

import org.example.SmartHouse;
import org.example.Task;
import org.example.device.Device;
import org.example.house.Room;

public class Adult extends Creature {
    public Adult(String name, Room currentRoom) {
        super(name, currentRoom, false);
    }

    @Override
    public void processTask() {
        Task task = tasks.poll();
        switch (task.getType()) {
            case FEED -> feedHelplessCreature(task.getCreatureSource());
            case REPAIR -> repairDevice(task.getDeviceSource());
            case HELP -> helpCreature(task.getCreatureSource());
            case CLEAN_ROOM -> cleanRoom(task.getRoomSource());
            case WASH_DISHES -> washDishes(task.getRoomSource());
        }
    }

    /**
     * Goes to the creature who asked for help and helps it
     * @param creature the creature who asked for help
     */
    private void helpCreature(Creature creature) {
        changeRoom(creature.currentRoom);
        System.out.println(getName() + " is helping " + creature.getName());
        creature.setStayingInCurrentRoom(false);
    }

    private void feedHelplessCreature(Creature creature) {
        changeRoom(creature.currentRoom);
        if (!currentRoom.getId().equals("Kitchen")) {
            Room kitchen = SmartHouse.instance().getKitchen();
            if (kitchen == null) {
                System.out.println("Oh no, there is no kitchen at the house! We all are going to starve to death!!!");
                return;
            }

            changeRoom(kitchen);
            creature.changeRoom(kitchen);
        }

        System.out.println(getName() + " is feeding " + creature.getName());

        creature.setStayingInCurrentRoom(false);
    }

    private void repairDevice(Device device) {
        changeRoom(SmartHouse.instance().locateDevice(device));
        System.out.println(getName() + " is repairing " + device.getId());
        device.repair();
        device.on();
    }
}
