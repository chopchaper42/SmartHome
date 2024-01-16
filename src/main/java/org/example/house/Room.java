package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
//@AllArgsConstructor
public class Room {

    /**
     * {@link} list of devices in this room
     */
    protected  List<Device> devices = new ArrayList<>();

    /**
     * {@link} name of room
     */
    protected String roomName;

    /**
     * {@link} on what floor the room is
     */
    protected int numberOfFloor;
    protected List<Creature> creaturesInside = new ArrayList<>();

    public Room(String roomName) {
        this.roomName = roomName;
    }


}
