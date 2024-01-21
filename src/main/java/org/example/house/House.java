package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.creature.Creature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class House {
    private String name;
    private List<Floor> floors = new ArrayList<>();

    /**
     * Creates a house with a given name
     * @param name
     */
    public House(String name) {
        this.name = name;
    }

    /**
     * Adds the floor to the floors list
     * @param floor the floor to add
     */
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    /**
     * Adds the collection of floors to the floors list
     * @param floors the collection of floors to add
     */
    public void addAllFloors(Collection<Floor> floors) {
        this.floors.addAll(floors);
    }
}
