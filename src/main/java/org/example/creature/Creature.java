package org.example.creature;


import lombok.Getter;
import lombok.Setter;
import org.example.device.Device;
import org.example.house.Room;

/**
 * Class representing Creature (living object) in the house
 */
@Getter
@Setter
public abstract class Creature {

    protected Room currentRoom;
    protected Device currentDevice;
    protected CreaturesEnum creatureType;
    protected String name;
    protected int age;


//    protected Creature(){
//        EventManager.getInstance().subscibe(DAY, this);
//    }

    /**
     * Creature go to another room
     * @param room target room
     */
    public void goToAnotherRoom(Room room){
        room.getCreaturesInside().remove(this);
        room.getCreaturesInside().add(this);
        currentRoom = room;
    }

    public abstract void interactWithDevice(Device device);


    public void breakDevice(){}



}
