package org.example.creature.people;

import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.room.Room;

public class Child extends Creature {

    double currentEnergy;
    int age;
    public Child(String name, String type, int maxEnergy, Room currentRoom) {
        super(name, maxEnergy, 100, currentRoom);
    }

    @Override
    public void makeSound(){
        System.out.println("AAAAAAAAAAAAAAAAA (っ-̶●̃益●̶̃)っ̲");
    }

    @Override
    public void useDevice(Device device) {
        //do later
        System.out.println("do later");
    }

    @Override
    public void sleep() {
        System.out.println(super.getName() + "is sleeping");
    }

    @Override
    public void eat() {
        //do later
        if (age >= 7) {
            //useDevice(fridge)
            System.out.println(super.getName() + "is eating food ");
            currentEnergy = super.getMaxEnergy() + 0.5;
        }
        else {
            //askAdultForSomething();
            System.out.println("Children before 7 years old can't use fridge. Asking adult for food.");
            currentEnergy = super.getMaxEnergy() - 1;
        }
    }

    //public void askAdultForSomething();

}
