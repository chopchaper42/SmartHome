package org.example.house.room_factory;

import org.example.creature.creatures_factory.PeopleFactory;
import org.example.house.Room;


import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating new rooms (factory method pattern)
 */
public class RoomFactory {

    private final List<Room> rooms = new ArrayList<>();
    public Room createRoom(RoomTypes roomName) {
        Room room = switch (roomName) {
            case BEDROOM -> new Room("Ložnice");
            case KITCHEN -> new Room("Kuchyně");
            case BATHROOM -> new Room("Koupelna");
            case CORRIDOR -> new Room("Koridor");
            default -> throw new IllegalArgumentException("Unknown Room Type");
        };
        rooms.add(room);
        return room;
    }
}
