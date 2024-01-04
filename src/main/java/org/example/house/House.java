package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.creature.Creature;
import org.example.report.Reporter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class House {
    private String name;
    private List<Floor> floors = new ArrayList<>();

    public House(String name) {
        this.name = name;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void addAllFloors(Collection<Floor> floors) {
        this.floors.addAll(floors);
    }
}
