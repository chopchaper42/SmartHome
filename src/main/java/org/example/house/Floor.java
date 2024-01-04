package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.house.room.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class Floor {
    @Getter
    private final int number;
    @Getter
    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addAllRooms(Collection<Room> rooms) {
        this.rooms.addAll(rooms);
    }
}
