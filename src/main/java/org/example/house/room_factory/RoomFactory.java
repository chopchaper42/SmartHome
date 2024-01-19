package org.example.house.room_factory;

import org.example.creature.creatures_factory.PeopleFactory;
import org.example.house.Room;


import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating new rooms (factory method pattern)
 */
public class RoomFactory {
    static RoomFactory instance = null;

    /**
     * Private singleton constructor
     */
    private RoomFactory(){}

    /**
     * Method for getting Room Factory instance - Singleton pattern
     * @return instance of Room Factory
     */
    public static RoomFactory getInstance() {
        if (instance == null) { instance = new RoomFactory();}
        return instance;
    }

    private final List<Room> rooms = new ArrayList<>();
    public Room createRoom(String roomName) {
        Room room = switch (roomName) {
            case "Bedroom" -> new Room("Bedroom");
            case "Kitchen" -> new Room("Kitchen");
            case "Bathroom" -> new Room("Bathroom");
            case "Corridor" -> new Room("Corridor");
            default -> throw new IllegalArgumentException("Unknown Room Type");
        };
        rooms.add(room);
        return room;
    }

    /**
     * Find a room by name
     * @param roomName The name of the room to find
     * @return The found room or null if not found
     */
    public Room findRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getRoomName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }
}
