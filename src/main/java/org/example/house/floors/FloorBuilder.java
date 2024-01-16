package org.example.house.floors;


import lombok.Getter;
import lombok.Setter;
import org.example.house.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for building floors
 */
@Setter
@Getter
public class FloorBuilder {
    private int level;
    private List<Room> rooms = new ArrayList<>();

    /**
     * Adds room to the floor
     * @param room target room
     */
    public void addRoom(Room room) {
        rooms.add(room);
        room.setNumberOfFloor(level);
    }


    /**
     * Creates new floor
     * @return
     */
    public Floor build() {
        return new Floor(level, rooms);
    }

}
