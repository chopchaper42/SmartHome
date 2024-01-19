package org.example.house;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.creature.Creature;
import org.example.device.Device;
import org.example.house.confuguration.HouseConfigurationReader;
import org.example.house.floors.Floor;
import org.example.report.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class representing House - Singleton pattern (Lazy initialization?)
 */
@Data
@AllArgsConstructor
@Getter
@Setter
public class House {

    private static final Logger logger = Logger.getLogger(House.class.getName());
    private int days;
    public List<Device> devices;
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
            INSTANCE = house;
            house.floors = new ArrayList<>();
            house.creatures = new ArrayList<>();
            fullCreatureStrategies();
            HouseConfigurationReader houseConfigurationReader = new HouseConfigurationReader();
            if (houseConfigurationReader.loadJson(house, filename)) {
                logger.info("The House was created.");
            }

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

    public void addCreatures(Creature creature){ creatures.add(creature); }


}
