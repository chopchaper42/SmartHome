package org.example.creature.animals;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.room.Room;

public class Cat extends Creature {


    double currentEnergy;
    public Cat(String name, String type, int maxEnergy, Room currentRoom) {
        super(name, maxEnergy, 100, currentRoom);
    }


    @Override
    public void makeSound(){
        System.out.println("Meow ≧◠ᴥ◠≦");
    }

    @Override
    public void useDevice(Device device){
        //do later
        System.out.println("Meow is damaging device ≧◠ᴥ◠≦");
        currentEnergy = super.getMaxEnergy() - 1;
    }


    @Override
    public void sleep() {
        System.out.println(super.getName() + "is sleeping ≧◠ᴥ◠≦");
        currentEnergy = super.getMaxEnergy() + 3;
    }

    @Override
    public void eat() {
        //do later
        //useDevice(petDevice)
        System.out.println(super.getName() + "is eating ≧◠ᴥ◠≦");
        currentEnergy = super.getMaxEnergy() + 1;
    }
}
