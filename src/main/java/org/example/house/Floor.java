package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class Floor {
    @Getter
    private final int number;
    @Getter
    private final List<Room> rooms = new ArrayList<>();

    /**
     * Adds the room to the rooms list
     * @param room a room
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Adds a collection of rooms to the rooms list
     * @param rooms a collection of room
     */
    public void addAllRooms(Collection<Room> rooms) {
        this.rooms.addAll(rooms);
    }
}
