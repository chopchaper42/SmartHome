package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.house.floors.Floor;
import org.example.report.Report;

import java.util.List;

/**
 * Class representing House - Singleton pattern (Lazy initialization?)
 */
@Data
@AllArgsConstructor
@Getter
@Setter
public class House {
    private HouseControlSystem controlSystem;
    public List<Creature> creatures;
    private List<Floor> floors;
    private Report reporter;
    private static House INSTANCE;

    public House() {}

    /**
     *  Gets instance of existing House or creates new House - Singleton pattern
     * @return instance of house
     */
    public static House getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new House();
        }
        return INSTANCE;
    }

    /**
     * Adds floor to the floor list of house
     * @param floor floor to add
     */
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

}
