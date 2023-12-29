package org.example.creature.people;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.Room;

public class Adult extends Creature {

    double currentEnergy;
    public Adult(String name, String type, double maxEnergy, Room currentRoom) {
        super(name, type, maxEnergy, currentRoom);
    }

    @Override
    public void makeSound() {
        System.out.println("Hi");
    }

    @Override
    public void useDevice(Device device) {
        //do later
    }

    @Override
    public Room getRoom() {
        //do later
        return null;
    }

    @Override
    public void sleep() {
        System.out.println(super.getName() + "is sleeping");
        currentEnergy = super.getMaxEnergy() + 2;
    }

    @Override
    public void eat() {
        //do later
        //useDevice(fridge)
        System.out.println(super.getName() + "is eating food ");
        currentEnergy = super.getMaxEnergy() + 2;
    }
}
