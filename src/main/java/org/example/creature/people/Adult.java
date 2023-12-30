package org.example.creature.people;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.room.Room;
import org.example.house.room.RoomNotFoundException;
import org.example.house.room.RoomType;

import java.util.concurrent.ExecutionException;

public class Adult extends Creature {

    public Adult(String name, /*String type, */int maxEnergy, Room currentRoom) {
        super(name, maxEnergy, currentRoom);
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
    public void sleep() {
        int energyGain = Math.min(getCurrentEnergy() + 50, getMaxEnergy());
        System.out.println(super.getName() + "is sleeping");
        setCurrentEnergy(energyGain);
    }

    @Override
    public void eat() {
        navigateTo(RoomType.KITCHEN);
//        useDevice(getCurrentRoom().getDevices().);
        System.out.println(super.getName() + "is eating food ");
//        currentEnergy = super.getMaxEnergy() + 2;
    }
}
