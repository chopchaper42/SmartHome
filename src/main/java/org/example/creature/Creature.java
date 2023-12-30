package org.example.creature;

import lombok.Getter;
import lombok.Setter;
import org.example.device.Device;
import org.example.house.room.Room;
import org.example.house.room.RoomNotFoundException;
import org.example.house.room.RoomType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public abstract class Creature {
    String name;
//    String type;
    int maxEnergy;
    int currentEnergy = 100;
    Room currentRoom;

    public Creature(String name, int maxEnergy, int currentEnergy, Room currentRoom) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
        this.currentRoom = currentRoom;
    }

    public Creature(String name, int maxEnergy, Room currentRoom) {
       this(name, maxEnergy, 100, currentRoom);
    }

    public abstract void makeSound();
    //void setStrategy(); ????
    public abstract void useDevice(Device device);
//    public abstract Room getRoom(); @Getter will do it
    public abstract void sleep();
    public abstract void eat();



    protected void navigateTo(RoomType room){
        Set<Room> visited = new HashSet<>();

        navigate(room, visited);

        if (currentRoom.getType() != room)
            System.out.println("Room " + room.name() + " not found");
    }

    private void navigate(RoomType room, Set<Room> visited) {
        if (currentRoom.getType() == room)
            return;

        List<Room> unvisited = currentRoom.getNearRooms().stream().filter(r -> !visited.contains(r)).toList();

        for (Room r : unvisited) {
            currentRoom = r;
            visited.add(r);
            navigateTo(room);
        }
    }
}
