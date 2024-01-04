package org.example;

import org.example.house.Floor;
import org.example.house.House;
import org.example.house.room.Room;

import java.util.*;

public class Dispatcher {

    private static Dispatcher dispatcher;
    private Map<String, Room> roomMap;

    private Dispatcher() {
        roomMap = new HashMap<>();
    }

    public static Dispatcher instance() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public void addLocations(House house) {
        List<Room> rooms = house.getFloors().stream().map(Floor::getRooms).flatMap(Collection::stream).toList();
        for (Room room : rooms)
            roomMap.put(room.getId(), room);
    }

    public Room randomRoom() {
        Object[] rooms = roomMap.values().toArray();
        return (Room) rooms[new Random().nextInt(rooms.length)];
    }

    public List<Room> rooms() {
        return roomMap.values().stream().toList();
    }

}
