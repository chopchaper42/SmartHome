package org.example.house.confuguration;

import org.example.creature.creatures_factory.PeopleFactory;
import org.example.creature.creatures_factory.PetFactory;
import org.example.device.KitchenDeviceTypes;
import org.example.device.device_factory.*;

import java.io.IOException;

/**
 * Class for reading json-configuration file
 */
public class HouseConfigurationReader {
    private final ConstructionDeviceCreator constructionDeviceCreator = ConstructionDeviceCreator.getInstance();
    private final EntertainmentDeviceCreator entertainmentDeviceCreator = EntertainmentDeviceCreator.getInstance();
    private final KitchenDeviceCreator kitchenDeviceCreator = KitchenDeviceCreator.getInstance();
    private final SportDeviceCreator sportDeviceCreator = SportDeviceCreator.getInstance();
    private final PeopleFactory peopleFactory = PeopleFactory.getInstance();
    private final PetFactory petFactory = PetFactory.getInstance();

    /**
     *
     * @param fileName name of the configuration file
     */
    public void readConfiguration(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File configFile = new File(filePath);

        // Read the JSON file and parse it into a JsonNode
        JsonNode rootNode = objectMapper.readTree(configFile);

        // Process floors
        readFloors(rootNode);

        // Process people
        readPeople(rootNode);

        // Process pets
        readPets(rootNode);
    }

    public boolean readCreatures(){}

}
