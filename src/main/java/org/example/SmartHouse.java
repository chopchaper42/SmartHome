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

    /**
     * Adds all locations from the given house
     * @param house the house to get locations from
     */
    public void addLocations(House house) {
        List<Room> rooms = house.getFloors().stream().map(Floor::getRooms).flatMap(Collection::stream).toList();
        for (Room room : rooms)
            roomMap.put(room.getId(), room);
    }

    /**
     * Adds creatures to the creatures list
     * @param creatures
     */
    public void addCreatures(Collection<Creature> creatures) {
        this.creatures.addAll(creatures);
    }

    /**
     * Returns a random room
     * @return a random room
     */
    public Room getRandomRoom() {
        Object[] rooms = roomMap.values().toArray();
        return (Room) rooms[new Random().nextInt(rooms.length)];
    }

    /**
     * Returns a list of rooms in the house
     * @return a list of rooms
     */
    public List<Room> getRooms() {
        return roomMap.values().stream().toList();
    }

    /**
     * Assigns task to a random creature
     * @param source task source
     * @param type task type
     */
    public void assignTask(TaskSource source, Task.Type type) {
        Task task = new Task(source, type);
        assignTaskToCreature(task);
    }

    /**
     * Assigns to clean a room or to wash dishes to a random creature
     */
    public void generateTask() {
        switch (new Random().nextInt(2)) {
            case 0 -> assignTaskToCreature(new Task(getRandomRoom(), Task.Type.CLEAN_ROOM));
            case 1 -> assignTaskToCreature(new Task(getKitchen(), Task.Type.WASH_DISHES));
        }
    }

    /**
     * Returns a kitchen
     * @return room with a name "Kitchen" or null
     */
    public Room getKitchen() {
        for (String s : roomMap.keySet())
            if (s.contains("Kitchen"))
                return roomMap.get(s);
        return null;
    }


    /**
     * Locates the device
     * @param device the device to locate
     * @return the room where device is
     */
    public Room locateDevice(Device device) {
        return getRooms().stream().filter(room -> room.getDevices().contains(device)).findFirst().get();
    }

    /**
     * Returns a list of creatures
     * @return a list of creatures
     */
    public List<Creature> getCreatures() {
        return creatures.stream().toList();
    }

    /**
     * Filters creatures list
     * @param func a filter
     * @return a filtered list
     */
    public List<Creature> getCreatures(Predicate<Creature> func) {
        return creatures.stream().filter(c -> !(c instanceof Animal)).filter(func).toList();
    }

    /**
     * Executes a house's strategy
     */
    public void executeStrategy() {
        strategy.execute();
    }

    /**
     * Sets a strategy
     * @param strategy
     */
    public void setStrategy(HouseStrategy strategy) {
        this.strategy = strategy;
        if (strategy instanceof DayStrategy) {
            for (Creature creature : creatures)
                creature.wakeUp();
        } else {
            for (Creature creature : getCreatures(Creature::hasTasks))
                creature.processTask();

            getRooms().stream()
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

    private void assignTaskToCreature(Task task) {
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

    private Creature getRandomPerson() {
        return creatures.stream().filter(c -> ! (c instanceof Animal)).toList().get(new Random().nextInt(creatures.size() -1));
    }
}
