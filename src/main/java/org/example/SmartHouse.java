package org.example;

import org.example.creature.Adult;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.room.Room;

import java.util.*;

public class SmartHouse {

    private static SmartHouse smartHouse;
    private Map<String, Room> roomMap;
    private List<Task> tasks = new LinkedList<>();
    private Set<Creature> creatures = new HashSet<>();

    private SmartHouse() {
        roomMap = new HashMap<>();
    }

    public static SmartHouse instance() {
        if (smartHouse == null) {
            smartHouse = new SmartHouse();
        }
        return smartHouse;
    }

    public void addLocations(House house) {
        List<Room> rooms = house.getFloors().stream().map(Floor::getRooms).flatMap(Collection::stream).toList();
        for (Room room : rooms)
            roomMap.put(room.getId(), room);
    }

    public void addCreatures(Collection<Creature> creatures) {
        this.creatures.addAll(creatures);
    }

    public Room randomRoom() {
        Object[] rooms = roomMap.values().toArray();
        return (Room) rooms[new Random().nextInt(rooms.length)];
    }

    public List<Room> rooms() {
        return roomMap.values().stream().toList();
    }

    public void addTask(Task task) { tasks.add(task); }
    public void assignTasks() {
        for (Task task : tasks) {
            getRandomAdult().addTask(task);
            tasks.remove(task);
        }
    }

    public Room getKitchen() {
        return roomMap.getOrDefault("Kitchen", null);
    }

    private Adult getRandomAdult() {
        List<Adult> adults = creatures.stream().filter(creature -> creature instanceof Adult).map(creature -> (Adult) creature).toList();
        return adults.get(new Random().nextInt(adults.size()));
    }

    public Room locateDevice(Device device) {
        return rooms().stream().filter(room -> room.getDevices().contains(device)).findFirst().get();
    }
}
