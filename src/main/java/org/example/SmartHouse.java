package org.example;

import org.example.creature.Animal;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.Floor;
import org.example.house.House;
import org.example.house.Room;
import org.example.house.strategy.DayStrategy;
import org.example.house.strategy.HouseStrategy;

import java.util.*;
import java.util.function.Predicate;

public class SmartHouse {

    private static SmartHouse smartHouse;
    private Map<String, Room> roomMap = new HashMap<>();;
    private Set<Creature> creatures = new HashSet<>();
    private HouseStrategy strategy;
    private SmartHouse() {
        strategy = new DayStrategy();
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

    public Room getRandomRoom() {
        Object[] rooms = roomMap.values().toArray();
        return (Room) rooms[new Random().nextInt(rooms.length)];
    }

    public List<Room> rooms() {
        return roomMap.values().stream().toList();
    }

    public void addTask(TaskSource source, Task.Type type) {
        Task task = new Task(source, type);
        assignTask(task);
    }

    public void assignTask(Task task) {
        Creature creature;

        if (task.getCreatureSource() != null) {
            List<Creature> crets = getCreatures(c -> c != task.getCreatureSource() && !c.isStayingInCurrentRoom());
            creature = crets.get(new Random().nextInt(crets.size()));
        }
        else {
            List<Creature> crets = getCreatures(c -> !c.isStayingInCurrentRoom());
            creature = crets.get(new Random().nextInt(crets.size()));
        }

        task.setTarget(creature);
        creature.addTask(task);
        EventManager.getInstance().addEvent(task);
    }

    public void generateTask() {
        switch (new Random().nextInt(2)) {
            case 0 -> assignTask(new Task(getRandomRoom(), Task.Type.CLEAN_ROOM));
            case 1 -> assignTask(new Task(getKitchen(), Task.Type.WASH_DISHES));
        }
    }

    public Room getKitchen() {
        return roomMap.getOrDefault("Kitchen", null);
    }

    private Creature getRandomPerson() {
        return creatures.stream().filter(c -> ! (c instanceof Animal)).toList().get(new Random().nextInt(creatures.size() -1));
    }


    public Room locateDevice(Device device) {
        return rooms().stream().filter(room -> room.getDevices().contains(device)).findFirst().get();
    }

    public List<Creature> getCreatures() {
        return creatures.stream().toList();
    }
    public List<Creature> getCreatures(Predicate<Creature> func) {
        return creatures.stream().filter(c -> !(c instanceof Animal)).filter(func).toList();
    }

    public void executeStrategy() {
        strategy.execute();
    }

    public void setStrategy(HouseStrategy strategy) {
        this.strategy = strategy;
        if (strategy instanceof DayStrategy) {
            for (Creature creature : creatures)
                creature.wakeUp();
        } else {
            for (Creature creature : getCreatures(Creature::hasTasks))
                creature.processTask();

            rooms().stream()
                    .map(Room::getDevices)
                    .flatMap(Collection::stream)
                    .forEach(device -> {
                        if (!device.isAlwaysOn())
                            device.off();
                    });

            for (Creature creature : creatures)
                creature.sleep();

        }

    }
}
