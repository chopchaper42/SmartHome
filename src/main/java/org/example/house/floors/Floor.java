package org.example.house.floors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.house.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing rooms
 */
@Getter
@Setter
public class Floor {

    /**
     * {@link} number of level of the floor (first/second/...)
     */
    private int level;


    /**
     * {@link} rooms on this floor
     */
    private final List<Room> rooms;

    public Floor(int level, List<Room> rooms) {
        this.level = level;
        this.rooms = rooms;
        rooms = new ArrayList<>() {};
    }
}
