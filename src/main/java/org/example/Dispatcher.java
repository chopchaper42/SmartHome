package org.example;

import org.example.house.room.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    public void addLocation(Room room) {
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
