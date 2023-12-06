package org.example.creature;

import lombok.AllArgsConstructor;
import org.example.device.Device;
import org.example.house.Room;

@AllArgsConstructor
public abstract class Creature {

    String name;
    String type;

    double maxEnergy;
    Room currentRoom;

    public abstract void makeSound();
    //void setStrategy(); ????
    public abstract void useDevice(Device device);
    public abstract Room getRoom();
    public abstract void sleep();
    public abstract void eat();

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    //***************************
}
