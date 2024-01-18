package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.floors.Floor;
import org.example.report.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing House - Singleton pattern (Lazy initialization?)
 */
@Data
@AllArgsConstructor
@Getter
@Setter
public class House {
    private int days;
    public List<Creature> creatures;
    private List<Floor> floors;
    private Report reporter;
    private static House INSTANCE;

    private static List<String> personStrategies;
    private static List<String> animalStrategies;

    public House() {}

    /**
     *  Gets instance of existing House or creates new House - Singleton pattern
     * @return instance of house
     */
    public static House getInstance(String filename) {
        if (INSTANCE == null) {
            House house = new House();
            house.floors = new ArrayList<>();
            house.creatures = new ArrayList<>();
            fullCreatureStrategies();
        }
        return INSTANCE;
    }

    public static House getInstance() {
        return INSTANCE;
    }

    private static void fullCreatureStrategies() {
        personStrategies = new ArrayList<>();
        animalStrategies = new ArrayList<>();
        personStrategies.add("Hungry");
        personStrategies.add("Sporting");
        personStrategies.add("Relaxing");
        animalStrategies.add("Pet");
    }

    /**
     * Adds floor to the floor list of house
     * @param floor floor to add
     */
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public List<String> getPersonStrategies() {
        return personStrategies;
    }

    public List<String> getAnimalStrategies(){
        return animalStrategies;
    }


}
